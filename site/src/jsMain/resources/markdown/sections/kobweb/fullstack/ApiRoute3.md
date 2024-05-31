---
data-auto-animate:
---

## API routes

```kotlin [api-backend]
@Api
fun hello(ctx: ApiContext) {
    ctx.res.setBodyText("hello world")
}
```

```kotlin 0|7 [api-frontend]
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
