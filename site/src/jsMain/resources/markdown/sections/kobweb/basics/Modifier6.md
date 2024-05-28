---
---

## Modifier Chaining

```kotlin
private val SIZE_MODIFIER = Modifier.size(50.px)
private val SPACING_MODIFIER =
    Modifier.margin(10.px).padding(20.px)

private val COMBINED_MODIFIER =
    SIZE_MODIFIER.then(SPACING_MODIFIER)
```
