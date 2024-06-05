## ${Html} to ${Kotlin}

{{{ Horizontal

```css 2,5 <html> [html-css]
/* example.css */
.rect {
  width: 50px;
  height: 25px;
}
```

```html 4 <html> [html-html]
<!-- example.html -->
<div
   id="example"
   class="rect"
/>
```

}}}

{{{ Horizontal

```kotlin 0|3-6 <kotlin,fragment>
object AppStyleSheet 
  : StyleSheet() {
  val rect by style {
    width(50.px)
    height(50.px)
  }
}
```

```kotlin 0|3-5 <kotlin,fragment>
Div(attrs = {
  id("example")
  classes(
    AppStyleSheet.rect
  )
})
```

}}}
