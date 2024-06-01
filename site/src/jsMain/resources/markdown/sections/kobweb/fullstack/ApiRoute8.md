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

```kotlin <fragment> [api-backend]
// Backend

// 1: Parse the message?
```
