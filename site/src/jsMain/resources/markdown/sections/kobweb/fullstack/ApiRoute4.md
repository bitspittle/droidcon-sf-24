---
data-auto-animate:
---

## API routes

```kotlin [api-backend]
// Backend
@Api
suspend fun echo(ctx: ApiContext) {
    val msg = ctx.req.params.getValue("message")
    ctx.res.setBodyText(msg)
}
```

```kotlin 8 [api-frontend]
// Frontend
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
