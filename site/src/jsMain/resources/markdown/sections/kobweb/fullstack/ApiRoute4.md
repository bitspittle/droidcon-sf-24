---
data-auto-animate:
---

## API routes

```kotlin [api-backend]
@Api
fun echo(ctx: ApiContext) {
    val msg = ctx.req.params.getValue("message")
    ctx.res.setBodyText(msg)
}
```

```kotlin 7 [api-frontend]
@Page
@Composable
fun FullstackPage() {
    var echoedText by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        echoedText =
            window.api.get("echo?message=hello")
                .decodeToString()
    }
    
    Text(echoedText)
}
```
