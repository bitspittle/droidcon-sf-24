## ColorMode

```kotlin 0|5|0
val ColorBoxStyle = CssStyle.base {
    Modifier
        .size(50.px)
        .backgroundColor(
            if (colorMode.isDark) {
                Colors.Pink
            } else {
                Colors.DarkRed
            }
        )
}
```

{{{ Centered

{{{ ColorModeButtonAndBox }}}

}}}
