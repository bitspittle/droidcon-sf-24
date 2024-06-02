## CssStyle

{{{ Horizontal

```kotlin 0|2,6 [style]
val RectStyle = CssStyle {
    base {
        Modifier
            .width(50.px)
            .height(25.px)
    }
}
```

```kotlin 1,5 <fragment>
val RectStyle = CssStyle.base {
    Modifier
        .width(50.px)
        .height(25.px)
}
```

}}}
