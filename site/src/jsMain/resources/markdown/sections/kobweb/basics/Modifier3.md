---
data-auto-animate:
---

## Modifier

```kotlin
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

```kotlin
Div(attrs = Modifier
  .id("example")
  .width(50.px)
  .height(50.px)
  .toAttrs()
) {
    Text("Hello!")
}
```
