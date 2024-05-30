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
  verticalAlignment = Alignment.CenterVertically
) {
  BlueBox()
  PurpleBox()
  GreenBox()  
}
```

{{{ Centered

{{{ BoxesInRow(Modifier.dataId("demo")) }}}

}}}
