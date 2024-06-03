## CssStyle

{{{ Horizontal

```css 1 [css]
/* example.css */
.rect {
  width: 50px;
  height: 25px;
}
```

```html 1 [html]
<!-- example.html -->
<div
   id="example"
   class="rect"
/>
```

}}}

{{{ Horizontal

```kotlin 0 [style]
val RectStyle = CssStyle {
    base {
        Modifier
            .width(50.px)
            .height(25.px)
    }
}
```

```kotlin 0|2 [div]
Div(
   RectStyle.toModifier()
     .id("example")
     .toAttrs()
)
```

}}}
