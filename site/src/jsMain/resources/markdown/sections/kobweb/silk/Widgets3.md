---
data-auto-animate:
styles:
  - accented-subheaders
---

## Widgets

### Input

```kotlin
var text by remember { mutableStateOf("") }

TextInput(
    text,
    placeholder = "type here",
    onTextChanged = { text = it }
)
```

{{{ Centered

{{{ InputExample(Modifier.scale(1.3)) }}}

}}}
