## API routes

```kotlin <apibackend> [api-backend]
// Backend
@Api
suspend fun contactMe(ctx: ApiContext) {
    // 1: Parse the message?
}
```

```kotlin <fragment,apicommon> [api-common]
// Common
@Serializable
class ContactMeMessage(
    val firstName: String,
    val lastName: String,
    val subject: String,
    val message: String,
)
```
