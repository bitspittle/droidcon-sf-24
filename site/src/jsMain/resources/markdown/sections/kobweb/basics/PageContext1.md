## Page Context

{{{ UrlBar("mysite.com/", id = "url") }}}

```kotlin 1,4 [code]
@Page
@Composable
fun IndexPage() {
    val ctx = rememberPageContext()
    
    /* ... */
}
```
