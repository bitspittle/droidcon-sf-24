## <span data-id="title">Route overrides</span>

{{{ UrlBar("mysite.com/releases/[1.0.0]/screenshots", id = "url") }}}

```kotlin 0|2,4 <fragment> [code]
// com/mysite/pages/releases/_1_0_0/PackageMapping.kt
@file:PackageMapping("1.0.0")

package com.mysite.pages.releases._1_0_0

import com.varabyte.kobweb.core.PackageMapping
```

{{{ Folders(Modifier.classNames("fragment"))

* pages
  * releases 
    * _1_0_0
      * PackageMapping.kt
      * Screenshots.kt

}}}
