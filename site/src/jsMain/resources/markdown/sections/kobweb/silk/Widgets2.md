---
styles:
  - accented-subheaders
---

## Widgets

### Checkbox

```kotlin
var checked by remember { mutableStateOf(false) }

Checkbox(checked, onCheckedChange = { /* ... */ }) {
    Text("Check me!")
}
```

{{{ Centered(Modifier.margin(top=2.cssRem))

{{{ CheckboxExample(Modifier.scale(1.3)) }}}

}}}
