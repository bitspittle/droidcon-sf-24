## API routes

```kotlin 0|6-12 [api-frontend]
val scope = rememberCoroutineScope()
Button(onClick = {
    val msg = ContactMeMessage(
        firstName, lastName, subject, message
    )
    scope.launch {
        window.api.post(
            "contact-me",
            body = Json.encodeToString(msg)
                .encodeToByteArray()
        )
    }
}) {
    Text("Send Message")
}
```
