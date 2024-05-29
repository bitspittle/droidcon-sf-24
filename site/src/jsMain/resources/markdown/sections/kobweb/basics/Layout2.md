---
data-auto-animate:
---

## Layout

```kotlin 0|4|6|0
Row(
  Modifier
    .padding(10.px)
    .gap(20.px)
    .backgroundColor(Colors.Cyan),
  contentAlignment = Alignment.Center
) {
  BlueBox()
  PinkBox()
  GreenBox()  
}
```

{{{ Centered

{{{ BoxesInRow(Modifier.dataId("demo")) }}}

}}}
