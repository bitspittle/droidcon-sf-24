---
layout: center
behaviors:
  - auto-progress-fragments 400
---


## Instant routing

{{{ Horizontal

{{{ Folders(Modifier.fontSize(1.7.cssRem).classNames("fragment", "fade-down"))

* pages
  * Index.kt
  * About.kt

}}}

```kotlin <fragment>
// Index.kt
@Page
@Composable
fun HomePage() {
    Link("/about")
}
```

```kotlin <fragment>
// About.kt
@Page
@Composable
fun AboutPage() {
    Text("About us")
}
```

}}}

{{{ SpeakerNotes

* Mention that instant linking is an advantage AND disadvantage, based on your purpose

}}}
