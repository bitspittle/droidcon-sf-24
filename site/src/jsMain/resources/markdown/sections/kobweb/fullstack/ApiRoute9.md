## API routes

```kotlin <apicommon> [api-common]
// Common
@Serializable
class ContactMeMessage(
    val firstName: String,
    val lastName: String,
    val subject: String,
    val message: String,
)
```

```kotlin 0|5-8|0 <apibackend> [api-backend]
// Backend
@Api
suspend fun contactMe(ctx: ApiContext) {
    val msg: ContactMeMessage =
        Json.decodeFromString(
            ctx.req.body!!.decodeToString()
        )
}
```
