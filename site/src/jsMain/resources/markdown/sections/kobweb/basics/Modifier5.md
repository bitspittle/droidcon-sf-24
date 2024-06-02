---
data-auto-animate-restart:
---

## Modifier Chaining

```kotlin 1,3,6
val SizeModifier =
    Modifier.size(50.px)
val SpacingModifier =
    Modifier.margin(10.px).padding(20.px)

val CombinedModifier = SizeModifier.then(SpacingModifier)
```

{{{ SpeakerNotes

* Modifiers are totally immutable and safe to share! 

}}}
