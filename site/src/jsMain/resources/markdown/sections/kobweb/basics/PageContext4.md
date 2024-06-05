## Page Context

{{{ UrlBar("mysite.com/users/[{user}]/posts/[{post}]", id = "url") }}}

```kotlin 4,6,7 [code]
@Page("{}")
@Composable
fun PostPage() {
    val ctx = rememberPageContext()
    
    val userName = ctx.route.params.getValue("user").toInt()
    val postId = ctx.route.params.getValue("post").toInt()
    
    /* ... */
}
```
