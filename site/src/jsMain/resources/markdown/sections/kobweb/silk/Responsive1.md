---
behaviors:
  - auto-progress-fragments 200
---

## Responsive

```kotlin 0|1|2|3|4|5|2-5 [code]
val ResponsiveStyle = CssStyle {
    base { Modifier.backgroundColor(Colors.Red) }
    Breakpoint.SM { Modifier.backgroundColor(Colors.Yellow) }
    Breakpoint.MD { Modifier.backgroundColor(Colors.Green) }
    Breakpoint.LG { Modifier.backgroundColor(Colors.Blue) }
}
```

{{{ AnimatedResponsiveExample(Modifier.dataId("responsive")) }}}
