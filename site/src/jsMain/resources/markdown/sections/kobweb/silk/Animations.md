---
follows: Responsive
---

## Transitions

```kotlin [code]
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

{{{ Centered

{{{ TransitionExample }}}

}}}
