---
follows: Markdown
data-auto-animate:
data-auto-animate-restart:
---

## Front Matter

```text [frontmatter]
---
root: .components.layout.ArticleLayout
author: BitSpittle
tags:
  - Web Dev
  - Tech
  - Kotlin
---
```

```kotlin 0|4|5-8 <fragment>
@Composable
fun ArticleLayout(content: @Composable () -> Unit) {
    val ctx = rememberPageContext()
    val markdown = ctx.markdown!!
    val author = 
        markdown.frontMatter.getValue("author").single()
    val tags =
        markdown.frontMatter.getValue("tags")
    /* ... */
}
```
