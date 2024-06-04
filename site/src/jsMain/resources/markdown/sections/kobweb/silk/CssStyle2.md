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

```kotlin <kobweb> [div]
Div(
  Modifier
    .id("example")
    .width(50.px)
    .height(25.px)
    .toAttrs()
)
```
