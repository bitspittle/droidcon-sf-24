import com.varabyte.kobweb.gradle.application.extensions.AppBlock.LegacyRouteRedirectStrategy
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import com.varabyte.kobwebx.gradle.markdown.MarkdownEntry
import kotlinx.html.script
import kotlinx.html.style
import kotlinx.html.unsafe

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "dev.bitspittle.droidconSf24"
version = "1.0-SNAPSHOT"

fun Project.getProjectBool(property: String): Boolean {
    return findProperty(property).toString() == "true"
}

kobweb {
    app {
        globals.put("show-slide-numbers", getProjectBool("slides.show.number").toString())
        index {
            description.set("Kobweb Presentation for Droidcon SF 2024")
            head.add {
                val revealJs = routePrefix.prependTo("/reveal.js")
                script { src = "$revealJs/dist/reveal.js" }
                style {
                    unsafe {
                        raw("@import url(\"$revealJs/dist/reveal.css\") layer(reveal);")
                        raw("@import url(\"$revealJs/dist/theme/night.css\") layer(reveal);")
                    }
                }
                script { src = "$revealJs/plugin/highlight/highlight.js" }
                style {
                    unsafe {
                        raw("@import url(\"$revealJs/plugin/highlight/monokai.css\") layer(highlightjs);")
                    }
                }
                script { src = "$revealJs/plugin/notes/notes.js" }
            }
        }
        export {
            // Current, the Kobweb Markdown plugin creates one page per markdown file; but for this site, we only use
            // them as slides under the index page. So just export the index page. (In a future version of Kobweb, the
            // Markdown plugin will be updated to allow generating non-pages).
            // See also: https://github.com/varabyte/kobweb/issues/301
            filter.set { this.route == "/" }
        }

        // Only legacy sites need this set. Sites built after 0.16.0 should default to DISALLOW.
        // See https://github.com/varabyte/kobweb#legacy-routes for more information.
        legacyRouteRedirectStrategy.set(LegacyRouteRedirectStrategy.DISALLOW)
    }
    markdown {
        defaultRoot.set(".components.layouts.SectionLayout")
        imports.add(".components.widgets.*")
        handlers {
            code.set { codeBlock ->
                // Add reveal.js attributes to our code block
                val text = "\"\"\"${codeBlock.literal.escapeTripleQuotedText()}\"\"\""
                val lang = codeBlock.info?.takeIf { it.isNotEmpty() }?.let { "\"${it.escapeSingleQuotedText()}\"" }
                "$group.components.widgets.Code($text, $lang)"
            }
        }

        fun MarkdownEntry.toSlideId(): String {
            return filePath.removePrefix("sections/").removeSuffix(".md")
        }

        val numericSuffix = Regex("(.*)(\\d+)$")

        process.set { markdownEntries ->
            val groupedById = markdownEntries.associateBy { entry -> entry.toSlideId() }
            val slidesPackage = "$group.components.sections"
            val slidesPath = "${slidesPackage.replace('.', '/')}/Slides.kt"

            val firstSlide = "Title"
            val lastSlide = "QandA"
            val followingMap = mutableMapOf<String, MutableList<String>>()
            val groupedSlides = mutableMapOf<String, MutableList<String>>()
            markdownEntries.forEach { entry ->
                val slideId = entry.toSlideId()
                val follows = entry.frontMatter["follows"]?.singleOrNull()
                if (follows == null) {
                    if (slideId !in listOf(firstSlide, lastSlide)) {
                        val match = numericSuffix.matchEntire(slideId)
                        if (match == null) {
                            logger.error("e: ${entry.filePath} needs to specify the slide it follows.")
                        } else {
                            val prefix = match.groupValues[1]
                            groupedSlides.getOrPut(prefix) { mutableListOf(prefix) }.add(slideId)
                        }
                    }
                } else {
                    // If a slide "subdir/b" and it says it follows "a" and "a" doesn't exist, check "subdir/a" as well
                    val potentialFollows = mutableListOf(follows)
                    if (slideId.contains("/") && !follows.contains("/")) {
                        potentialFollows.add("${slideId.substringBeforeLast("/")}/$follows")
                    }

                    val finalFollows = potentialFollows.firstOrNull { groupedById.containsKey(it) }
                    if (finalFollows == null) {
                        logger.error("e: ${entry.filePath} uses `follows` value \"$follows\" which does not match any markdown file.")
                    } else {
                        followingMap.getOrPut(finalFollows) { mutableListOf() }.add(slideId)
                    }
                }
            }

            val orderedSlides = mutableListOf<String>()
            run {
                val slidesToProcess = mutableListOf(firstSlide)
                while (slidesToProcess.isNotEmpty()) {
                    val currSlide = slidesToProcess.removeFirst()
                    orderedSlides.add(currSlide)
                    followingMap[currSlide].orEmpty().let { following ->
                        if (following.size > 1) {
                            logger.error("e: Multiple slides marked as following the same slide: $currSlide <- ${following.joinToString()}")
                        }
                        slidesToProcess.addAll(following)
                    }
                }
            }
            orderedSlides.add(lastSlide)

            // While working on slides, we often want to quickly see the last slide we worked on
            if (getProjectBool("slides.start.with.last.modified")) {
                orderedSlides.add(0, markdownEntries.maxBy { it.file.lastModified() }.toSlideId())
            }

            generateKotlin(slidesPath, buildString {
                appendLine(
                    """
                        // This file is generated. Modify the build script if you need to change it.
    
                        package $slidesPackage
    
                        import androidx.compose.runtime.*
                        import org.jetbrains.compose.web.dom.Section
                    """.trimIndent()
                )

                appendLine(
                    """
                        @Composable
                        fun Slides() {
                        """.trimIndent()
                    )

                orderedSlides.forEach { slidePath ->
                    val entry = groupedById.getValue(slidePath)
                    val slideId = entry.toSlideId()
                    if (groupedSlides.containsKey(slideId)) {
                        appendLine(
                            """
                            |   Section {
                        """.trimMargin()
                        )

                        groupedSlides.getValue(slideId).forEach { groupedSlideId ->
                            appendLine(
                                """
                            |       ${groupedById.getValue(groupedSlideId).fqn}()
                        """.trimMargin()
                            )
                        }

                        appendLine(
                            """
                            |   }
                        """.trimMargin()
                        )

                    } else {
                        appendLine(
                            """
                            |   ${entry.fqn}()
                        """.trimMargin()
                        )
                    }
                }

                appendLine(
                    """
                        }
                    """.trimIndent()
                    )
                })
        }
    }
}

kotlin {
    configAsKobwebApplication("droidcon-sf-24")

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
        }

        jsMain.dependencies {
            implementation(compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.silk.foundation)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
            // We use devNpm to pull down relevant reveal.js files locally. See `head.add` block above.
            implementation(devNpm("reveal.js", "5.1.0"))
        }
    }
}
