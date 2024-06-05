## CssStyle

{{{ Horizontal

```kotlin 0|0|2,6 [left]
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
