---
styles:
  - accented-subheaders
---

## Widgets

### Switch

```kotlin
var checked by remember { mutableStateOf(false) }

Switch(checked, onCheckedChange = { /* ... */ })
```

{{{ Centered

{{{ SwitchExample(Modifier.scale(1.3)) }}}

}}}
