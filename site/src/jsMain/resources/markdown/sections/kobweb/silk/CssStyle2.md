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

```kotlin [div]
Div(
  Modifier
    .id("example")
    .width(50.px)
    .height(25.px)
    .toAttrs()
)
```
