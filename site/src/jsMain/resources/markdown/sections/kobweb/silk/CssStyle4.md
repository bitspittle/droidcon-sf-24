## CssStyle

{{{ Horizontal

```css 1 <html> [css]
/* example.css */
.rect {
  width: 50px;
  height: 25px;
}
```

```html 1 <html> [html]
<!-- example.html -->
<div
   id="example"
   class="rect"
/>
```

}}}

{{{ Horizontal

```kotlin 2-3 <kobweb> [left]
val RectStyle = CssStyle(
  extraModifier =
    Modifier.id("example")  
) {
    base {
        Modifier
            .width(50.px)
            .height(25.px)
    }
}
```

```kotlin 2 <kobweb> [right]
Div(
   RectStyle.toAttrs()
)
```

}}}
