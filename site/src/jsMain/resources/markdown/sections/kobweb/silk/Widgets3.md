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

{{{ Centered(Modifier.margin(top=2.cssRem))

{{{ SwitchExample(Modifier.scale(1.3)) }}}

}}}
