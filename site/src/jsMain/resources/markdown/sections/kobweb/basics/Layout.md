---
follows: PageContext
---

## Box

```kotlin 0|1,4,7,10|5|0 [code]
Box(
  Modifier
    .size(100.px)
    .backgroundColor(Colors.Cyan),
  contentAlignment = Alignment.Center
) {
  Box(
    Modifier
      .size(50.px)
      .backgroundColor(Colors.Blue)
  )
}
```

{{{ Centered

{{{ BoxInBox(Modifier.dataId("demo")) }}}

}}}

{{{ SpeakerNotes

* backgroundColor is DIFFERENT from background (Kobweb != Jetpack Compose)

}}}
