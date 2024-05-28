---
data-auto-animate:
---

## Modifier

```kotlin 0
// Compose HTML
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

```kotlin 0 [code-final]
// Kobweb
Div(attrs = Modifier
  .id("example")
  .width(50.px)
  .height(50.px)
  .toAttrs()
) {
    Text("Hello!")
}
```
