---
follows: FrontMatter
---

## Code

```text [code-md]
Today is ${.component.widgets.CurrentDay}.

{{{ .component.widgets.Clock }}}
```

Today is ${CurrentDay}.

{{{ Clock(Modifier.dataId("clock")) }}}
