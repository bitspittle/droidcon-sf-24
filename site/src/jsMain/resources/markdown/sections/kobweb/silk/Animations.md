---
follows: Responsive
data-auto-animate:
---

## Transitions

```kotlin [code]
val ChangeOnHoverStyle = CssStyle {
  base {
    Modifier
      .backgroundColor(Colors.Cyan)
      .transition(CSSTransition("background-color", 200.ms))
  }

  hover {
    Modifier.backgroundColor(Colors.Orange)
  }
}
```

{{{ Centered

{{{ TransitionExample }}}

}}}
