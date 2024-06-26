## Modifier

```kotlin <kobweb> [code-escape-hatch]
Div(attrs = 
  Modifier
    .attrsModifier {
      id("example")
    }
    .styleModifier {
      width(50.px)
      height(25.px)
    }
    .toAttrs()
)
```

```kotlin 0|2-4 <kobweb> [code-final]
Div(attrs = Modifier
  .id("example")
  .width(50.px)
  .height(25.px)
  .toAttrs()
)
```

{{{ SpeakerNotes

* Note that the Kobweb solution treats attributes and styles at the same level.
* There are very few attribute modifiers, in practice this has been fine
* You can use an `attrsModifier` escape hatch if necessary
* We have begun work on an IntelliJ plugin which will help navigate occasional edge cases where this might matter

}}}
