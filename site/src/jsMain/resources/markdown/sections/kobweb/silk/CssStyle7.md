## CssStyle

```kotlin 0|1,7|0
val ColoredSquareStyle = CssStyle.base {
    Modifier
        .size(50.px)
        .backgroundColor(Colors.Orange)
}

val RotatedSquareStyle = SquareStyle.extendedByBase {
    Modifier
        .rotate(45.deg)
        .backgroundColor(Colors.Cyan)
}
```

```kotlin <fragment>
Box(ColoredSquareStyle.toModifier())
Box(RotatedSquareStyle.toModifier())
```

{{{ Centered

{{{ RotatedRectExample(Modifier.classNames("fragment")) }}}

}}}
