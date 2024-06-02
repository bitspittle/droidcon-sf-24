## CssStyle

```kotlin 0|5,7|0 [style]
val SquareStyle = CssStyle.base {
    Modifier.size(50.px)
}

val RotatedSquareStyle = SquareStyle.extendedBy {
    Modifier.rotate(45.deg)
}
```

{{{ Centered

{{{ RotatedRectExample(Modifier.classNames("fragment")) }}}

}}}
