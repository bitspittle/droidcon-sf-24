## API routes

```kotlin 0|4-6|2,7-13|0 <hide-vertical-scrollbar,apifrontend> [api-frontend]
// Frontend
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
}) { Text("Send Message") }
```
