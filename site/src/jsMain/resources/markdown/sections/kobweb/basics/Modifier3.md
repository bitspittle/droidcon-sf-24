---
data-auto-animate:
---

## Modifier

```kotlin [code-escape-hatch]
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

```kotlin 0|2-4|0
Div(attrs = Modifier
  .id("example")
  .width(50.px)
  .height(50.px)
  .toAttrs()
) {
    Text("Hello!")
}
```
