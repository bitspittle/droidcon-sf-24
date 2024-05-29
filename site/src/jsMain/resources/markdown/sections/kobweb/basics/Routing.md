---
follows: Modifier
data-auto-animate:
data-auto-animate-restart:
---

## Page

{{{ UrlBar("mysite.com/about", id = "url") }}}

```kotlin 0|3,5 [code]
// com/mysite/pages/About.kt

package com.mysite.pages

@Page
@Composable
fun AboutPage() {
    /* ... */
}
```
