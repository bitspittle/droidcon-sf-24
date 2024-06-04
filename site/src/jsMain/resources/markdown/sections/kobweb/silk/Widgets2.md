---
styles:
  - accented-subheaders
---

## Widgets

### Checkbox and Switch

```kotlin
var checked by remember { mutableStateOf(false) }

Checkbox(checked, onCheckedChange = { checked = it }) {
    Text("Check me!")
}

Switch(checked, onCheckedChange = { checked = it })
```

{{{ Horizontal(Modifier.margin(top=2.cssRem))

{{{ CheckboxExample(Modifier.scale(1.3)) }}}

{{{ SwitchExample(Modifier.scale(1.3)) }}}

}}}
