## ${Html} to ${Kotlin}

```html <html>
<!-- example.html -->
<div
   id="example"
   style="width:50px;height:25px"
/>
```

```kotlin 0|2|3-6|0 <kotlin>
Div(attrs = {
  attr("id", "example")
  style {
    property("width", 50.px)
    property("height", 25.px)
  }
})
```
