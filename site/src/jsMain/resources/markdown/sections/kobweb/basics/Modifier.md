---
follows: KobwebRun
data-auto-animate:
data-auto-animate-restart:
---

## Modifier

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
    height(50.px)
  }
}) {
    Text("Hello!")
}
```
