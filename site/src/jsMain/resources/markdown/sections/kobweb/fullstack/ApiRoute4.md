## API routes

```kotlin <apibackend> [api-backend]
// Backend
@Api
suspend fun hello(ctx: ApiContext) {
    if (ctx.req.method != HttpMethod.GET) return

    // NOTE: Sets `ctx.res.status = 200`
    ctx.res.setBodyText("hello world") 
}
```
