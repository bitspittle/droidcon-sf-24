---
data-auto-animate:
---

## Modifier

```kotlin [code-escape-hatch]
Div(attrs = 
  Modifier
    .attrModifier {
      id("example")
    }
    .styleModifier {
      width(50.px)
      height(50.px)
    }
    .toAttrs()
) {
    Text("Hello!")
}
```

```kotlin 0|2-4 [code-final]
Div(attrs = Modifier
  .id("example")
  .width(50.px)
  .height(50.px)
  .toAttrs()
) {
    Text("Hello!")
}
```

{{{ SpeakerNotes

* Note that the Kobweb solution treats attributes and styles at the same level.
* There are very few attribute modifiers, in practice this has been fine
* You can use an `attrModifier` escape hatch if necessary
* We have begun work on an IntelliJ plugin which will help navigate occasional edge cases where this might matter

}}}
