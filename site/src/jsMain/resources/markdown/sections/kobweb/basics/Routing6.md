## <span data-id="title">Route overrides</span>

{{{ UrlBar("mysite.com/acronyms/[HTML]", id = "url") }}}

```kotlin 0|1,5 <fragment> [code]
// com/mysite/acronyms/Html.kt

package com.mysite.pages

@Page("HTML")
@Composable
fun AboutPage() {
    /* ... */
}
```
