---
data-auto-animate:
---

## API routes

```kotlin 0|4,10|6,8 [api-backend]
// Backend
@Api
fun postMessage(ctx: ApiContext) {
    if (ctx.req.method != HttpMethod.POST) return

    // 1: Parse the message?
    
    // 2: Save the message into a data store?

    ctx.res.status = 200
}
```
