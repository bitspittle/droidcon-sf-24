---
follows: CssStyle
data-auto-animate:
data-auto-animate-restart:
---

## ColorMode

```kotlin 1,3,7
var colorMode by ColorMode.currentState
Button(
    onClick = { colorMode = colorMode.opposite },
    Modifier.borderRadius(50.percent).padding(0.px)
) {
    // Includes support for Font Awesome icons
    if (colorMode.isLight) FaSun() else FaMoon()
}
```

{{{ Centered

{{{ ColorModeBox }}}

}}}