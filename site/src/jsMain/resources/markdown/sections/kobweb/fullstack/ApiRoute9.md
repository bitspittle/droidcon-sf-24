## API routes

```kotlin [api-common]
// Common
@Serializable
class ContactMeMessage(
    val firstName: String,
    val lastName: String,
    val subject: String,
    val message: String,
)
```

```kotlin [api-backend]
// Backend

val msg: ContactMeMessage =
    Json.decodeFromString(
        ctx.req.body!!.decodeToString()
    )
```
