## API routes

```kotlin <apibackend> [api-backend]
// Backend
@Api
suspend fun hello(ctx: ApiContext) {
    ctx.res.setBodyText("hello world")
}
```

```kotlin 0|1,8|0 <apifrontend> [api-frontend]
// Frontend
@Page
@Composable
fun FullstackPage() {
    var fetchedText by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        fetchedText =
            window.api.get("hello")
                .decodeToString()
    }
    
    Text(fetchedText)
}
```
