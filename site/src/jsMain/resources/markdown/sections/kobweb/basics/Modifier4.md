## Modifier

{{{ Horizontal

```kotlin <kobweb> [code-final]
// Kobweb
Div(attrs = Modifier
  .id("example")
  .width(50.px)
  .height(25.px)
  .toAttrs()
)
```

```kotlin <kotlin>
// Compose HTML
Div(attrs = {
    id("example")
    style {
        width(50.px)
        height(25.px)
    }
})
```

}}}
