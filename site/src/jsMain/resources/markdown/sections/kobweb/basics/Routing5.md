---
data-auto-animate:
---

## <span data-id="title">Route overrides</span>

{{{ UrlBar("mysite.com/patch-notes/1.0.0", id = "url") }}}

```kotlin 0|1,5 [code]
// com/mysite/pages/patchNotes/1_0_0.kt

package com.mysite.pages

@Page("1.0.0")
@Composable
fun AboutPage() {
    /* ... */
}
```
