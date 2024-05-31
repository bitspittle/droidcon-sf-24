---
follows: ColorMode
data-auto-animate:
data-auto-animate-restart:
---

## Responsive

```kotlin [code]
val ResponsiveStyle = CssStyle {
    base { Modifier.backgroundColor(Colors.Red) }
    Breakpoint.SM { Modifier.backgroundColor(Colors.Yellow) }
    Breakpoint.MD { Modifier.backgroundColor(Colors.Green)  }
    Breakpoint.LG { Modifier.backgroundColor(Colors.Blue) }
}
```

{{{ AnimatedResponsiveExample(Modifier.dataId("responsive")) }}}
