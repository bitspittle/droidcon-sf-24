---
data-auto-animate:
---

## Modifier

```kotlin [code-final]
Div(attrs = Modifier
  .id("example")
  .width(50.px)
  .height(50.px)
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
