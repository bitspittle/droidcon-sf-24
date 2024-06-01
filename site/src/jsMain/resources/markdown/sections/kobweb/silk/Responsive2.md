## Responsive

```kotlin [code]
val ResponsiveStyle = CssStyle {
    base { Modifier.backgroundColor(Colors.Red) }
    Breakpoint.SM { Modifier.backgroundColor(Colors.Yellow) }
    Breakpoint.MD { Modifier.backgroundColor(Colors.Green)  }
    Breakpoint.LG { Modifier.backgroundColor(Colors.Blue) }
}
```

{{{ ResponsivePreviews  }}}
