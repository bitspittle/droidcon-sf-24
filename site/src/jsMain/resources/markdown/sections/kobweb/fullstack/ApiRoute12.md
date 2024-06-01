## API routes

```kotlin 1-4|6-9|11-14|16 [api-backend]
// Backend
@Api
fun contactMe(ctx: ApiContext) {
    if (ctx.req.method != HttpMethod.POST) return

    val msg: ContactMeMessage =
        Json.decodeFromString(
            ctx.req.body!!.decodeToString()
        )

    ctx.data.getValue<DataStore>().addText(
        id = "${msg.lastName}, ${msg.firstName}",
        text = "${msg.subject}: ${msg.message}"
    )

    ctx.res.status = 200
}
```
