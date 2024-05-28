---
data-auto-animate:
---

{{{ Horizontal

```css
/* example.css */
.rect {
  width: 50px;
  height: 25px;
}
```

```html
<!-- example.html -->
<div
   id="example"
   class="rect"
>
  Hello!
</div>
```

}}}

{{{ Horizontal

```kotlin|0|3-6|0
object AppStyleSheet 
  : StyleSheet() {
  val rect by style {
    width(50.px)
    height(50.px)
  }
}
```

```kotlin|0|3-5|0
Div(attrs = {
  id("example")
  classes(
    AppStyleSheet.rect
  )
}) {
  Text("Hello!")
}
```

}}}
