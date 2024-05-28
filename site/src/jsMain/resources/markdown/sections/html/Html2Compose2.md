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

```kotlin|0|2|3-6|0
Div(attrs = {
  attr("id", "example")
  style {
    property("width", 50.px)
    property("height, 25.px)
  }
}) {
    Text("Hello!")
}
```
