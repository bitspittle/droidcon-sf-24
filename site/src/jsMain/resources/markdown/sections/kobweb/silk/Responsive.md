---
follows: ColorMode
behaviors:
  - auto-progress-fragments 1100
---

## Responsive

```kotlin 2|3|4|5|0 [code]
val ResponsiveStyle = CssStyle {
    base { Modifier.backgroundColor(Colors.Red) }
    Breakpoint.SM { Modifier.backgroundColor(Colors.Yellow) }
    Breakpoint.MD { Modifier.backgroundColor(Colors.Green)  }
    Breakpoint.LG { Modifier.backgroundColor(Colors.Blue) }
}
```

{{{ AnimatedResponsiveExample(Modifier.dataId("responsive")) }}}
