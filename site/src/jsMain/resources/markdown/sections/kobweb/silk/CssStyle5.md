## CssStyle

```kotlin 0|8-10 [style]
val HoverStyle = CssStyle {
    base {
        Modifier
            .size(50.px)
            .backgroundColor(Colors.Cyan)
    }

    hover {
        Modifier.backgroundColor(Colors.Orange)
    }
}
```

{{{ Centered

{{{ HoverExample() }}}

}}}
