## ${Html} to ${Kotlin}

```html <html>
<!-- example.html -->
<div
   id="example"
   style="width:50px;height:25px"
/>
```

```kotlin 2,4-5 <kotlin>
Div(attrs = {
  id("example")
  style {
    width(50.px)
    height(25.px)
  }
})
```
