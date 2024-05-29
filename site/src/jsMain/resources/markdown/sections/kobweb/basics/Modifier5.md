---
data-auto-animate:
---

## Modifier

```kotlin 0 [code-final]
Div(attrs = Modifier
  .id("example")
  .width(50.px)
  .height(25.px)
  .toAttrs()
) {
    Text("Hello!")
}
```

```html
<div
   id="example"
   style="width:50px;height:25px"
>
  Hello!
</div>
```
