## Page Context

{{{ UrlBar("mysite.com/watch?v=F5B-CxJTKlg", id = "url") }}}

```kotlin 4,6 [code]
@Page
@Composable
fun WatchPage() {
    val ctx = rememberPageContext()
    
    val videoId = ctx.route.params.getValue("v").toInt()
    
    /* ... */
}
```
