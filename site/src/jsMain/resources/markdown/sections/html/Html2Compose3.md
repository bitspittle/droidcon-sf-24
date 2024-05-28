---
data-auto-animate:
---

```html
<!-- example.html -->
<div
   id="example"
   style="width:50px;height:25px"
>
  Hello!
</div>
```

```kotlin
Div(attrs = {
  id("example")
  style {
    width(50.px)
    height(25.px)
  }
}) {
    Text("Hello!")
}
```
