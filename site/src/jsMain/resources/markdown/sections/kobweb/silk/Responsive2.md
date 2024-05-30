---
data-auto-animate:
---

## Responsive

```kotlin
val ResponsiveStyle = CssStyle {
    base {
        Modifier.backgroundColor(Colors.Red)
    }
    
    Breakpoint.MD {
        Modifier.backgroundColor(Colors.Green)
    }

    Breakpoint.LG {
        Modifier.backgroundColor(Colors.Blue)
    }
}
```

{{{ ResponsivePreviews  }}}
