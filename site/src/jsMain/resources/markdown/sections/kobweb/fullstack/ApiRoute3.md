---
data-auto-animate:
---

## API routes

```kotlin [api-backend]
// Backend
@Api
suspend fun hello(ctx: ApiContext) {
    ctx.res.setBodyText("hello world")
}
```

```kotlin 0|8 [api-frontend]
// Frontend
@Page
@Composable
fun FullstackPage() {
    var fetchedText by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        fetchedText =
            window.api.get()
                .decodeToString()
    }
    
    Text(fetchedText)
}
```
