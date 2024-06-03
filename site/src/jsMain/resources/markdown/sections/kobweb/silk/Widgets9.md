---
styles:
  - accented-subheaders
---

## Widgets

### Using `Modifier`

```kotlin 0|3,9|0
Button(
    onClick = { /* ... */ },
    Modifier.boxShadow(
        BoxShadow.of(
            blurRadius = 6.px,
            spreadRadius = 3.px,
            color = Colors.Yellow
        )
    )
) {
    Text("Click me")
}
```

{{{ ShadowedButtonExample(Modifier.classNames("fragment")) }}}
