---
styles:
  - accented-subheaders
---

## Widgets

### Tooltip

```kotlin 2
Div(modifier.backgroundColor(Colors.Cyan).toAttrs())
Tooltip(ElementTarget.PreviousSibling, "Hello!!!")
```

{{{ Centered(Modifier.margin(top=2.cssRem))

{{{ TooltipExample(Modifier.fontSize(2.cssRem)) }}}

}}}
