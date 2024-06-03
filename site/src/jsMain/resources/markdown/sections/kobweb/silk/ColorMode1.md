## ColorMode

```kotlin 0|1,3,6|0
var colorMode by ColorMode.currentState
Button(
    onClick = { colorMode = colorMode.opposite },
    Modifier.borderRadius(50.percent).padding(0.px)
) {
    if (colorMode.isLight) FaSun() else FaMoon()
}
```

{{{ Centered(Modifier.classNames("fragment"))

{{{ ColorModeButton }}}

}}}
