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

```kotlin
// Compose HTML
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
