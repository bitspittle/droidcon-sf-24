---
follows: Routing
data-auto-animate:
data-auto-animate-restart:
---

## Page Context

{{{ UrlBar("mysite.com/", id = "url") }}}

```kotlin 4 [code]
@Page
@Composable
fun IndexPage() {
    val ctx = rememberPageContext()
    
    /* ... */
}
```
