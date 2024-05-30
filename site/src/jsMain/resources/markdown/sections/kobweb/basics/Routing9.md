---
data-auto-animate:
---

## <span data-id="title">Dynamic routes</span>

{{{ UrlBar("mysite.com/users/{user}/posts/{post}", id = "url") }}}

```kotlin 2 [user]
// com/mysite/pages/users/user/PackageMapping.kt
@file:PackageMapping("{user}")

package com.mysite.pages.users.user

import com.varabyte.kobweb.core.PackageMapping
```

```kotlin 4 [post]
// com/mysite/pages/users/user/posts/Post.kt
package com.mysite.pages.users.user.posts

@Page("{post}")
@Composable
fun PostPage() {
    /* ... */
}
```
