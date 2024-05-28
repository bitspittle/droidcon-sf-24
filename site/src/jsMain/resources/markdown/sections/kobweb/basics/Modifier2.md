---
data-auto-animate:
---

## Modifier

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

```kotlin 0|2-9|10
Div(attrs = 
  Modifier
    .attrModifier {
      id("example")
    }
    .styleModifier {
      width(50.px)
      height(50.px)
    }
    .toAttrs()
) {
    Text("Hello!")
}
```
