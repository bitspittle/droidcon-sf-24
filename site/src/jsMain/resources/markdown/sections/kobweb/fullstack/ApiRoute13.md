## API routes

```kotlin 0|3-5|6-12 <hide-vertical-scrollbar> [api-frontend]
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
