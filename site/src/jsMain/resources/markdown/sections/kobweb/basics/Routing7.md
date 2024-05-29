## Instant routing

{{{ Horizontal

{{{ Folders(Modifier.fontSize(1.7.cssRem))

* pages
  * Index.kt
  * About.kt

}}}

```kotlin
// Index.kt
@Page
@Composable
fun HomePage() {
    Link("/about")
}
```

```kotlin
// About.kt
@Page
@Composable
fun AboutPage() {
    Text("About us")
}
```

}}}

<!-- TODO: Add animating example here -->

{{{ SpeakerNotes

* Mention that instant linking is an advantage AND disadvantage, based on your purpose

}}}
