---
styles:
  - accented-subheaders
---

## Widgets

### TextInput

```kotlin
var text by remember { mutableStateOf("") }

TextInput(
    text,
    placeholder = "type here",
    onTextChanged = { text = it }
)
```

{{{ Centered(Modifier.margin(top=2.cssRem))

{{{ InputExample(Modifier.scale(1.3)) }}}

}}}

{{{ SpeakerNotes

* Compose HTML has an Input class, but it can be tricky to use, with controlled and uncontrolled modes.
* TextInput is common, which is why I'm showcasing it here; but we support other input types too, like numeric,
  date, etc.

}}}
