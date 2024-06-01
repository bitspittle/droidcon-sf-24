## Modifier

```kotlin 2-5
Div(attrs = {
  id("example")
  style {
    width(50.px)
    height(25.px)
  }
})
```

```kotlin 0|2-9|10 [code-escape-hatch]
Div(attrs = 
  Modifier
    .attrModifier {
      id("example")
    }
    .styleModifier {
      width(50.px)
      height(25.px)
    }
    .toAttrs()
)
```
