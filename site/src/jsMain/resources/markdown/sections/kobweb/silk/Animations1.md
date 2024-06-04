---
data-auto-animate-restart:
---

## Transitions

```kotlin 0|5|4,9|0 [code]
val ChangeOnHoverStyle = CssStyle {
  base {
    Modifier
      .backgroundColor(Colors.Cyan)
      .transition(Transition.of("background-color", 200.ms))
  }

  hover {
    Modifier.backgroundColor(Colors.Orange)
  }
}
```

{{{ Centered(Modifier.classNames("fragment"))

{{{ TransitionExample }}}

}}}
