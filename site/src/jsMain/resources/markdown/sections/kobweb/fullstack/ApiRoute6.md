## API routes

```kotlin 0|6|8 <apibackend> [api-backend]
// Backend
@Api
suspend fun contactMe(ctx: ApiContext) {
    if (ctx.req.method != HttpMethod.POST) return

    // 1: Read data from request
    
    // 2: Write message into a data store

    ctx.res.status = 200
}
```
