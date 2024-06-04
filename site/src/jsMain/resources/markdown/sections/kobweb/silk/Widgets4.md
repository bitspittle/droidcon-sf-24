---
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

{{{ Centered(Modifier.margin(top=2.cssRem))

{{{ InputExample(Modifier.scale(1.3)) }}}

}}}
