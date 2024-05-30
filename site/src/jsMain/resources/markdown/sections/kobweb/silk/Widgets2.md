---
data-auto-animate:
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

{{{ Centered

{{{ CheckboxExample(Modifier.scale(1.3)) }}}

}}}
