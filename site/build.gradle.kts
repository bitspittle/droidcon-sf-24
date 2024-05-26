import com.varabyte.kobweb.gradle.application.extensions.AppBlock.LegacyRouteRedirectStrategy
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
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

kobweb {
    app {
        globals.put("show-slides", if (findProperty("reveal.show.slides").toString() == "true") "true" else "false")
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
