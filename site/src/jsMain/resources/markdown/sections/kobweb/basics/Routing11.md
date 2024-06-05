## <span data-id="title">Dynamic routes</span>

{{{ UrlBar("mysite.com/users/[{user}]/posts/[{post}]", id = "url") }}}

```kotlin 2,4 [user]
// com/mysite/pages/users/user/PackageMapping.kt
@file:PackageMapping("{}")

package com.mysite.pages.users.user

import com.varabyte.kobweb.core.PackageMapping
```

```kotlin 1,4 [post]
// com/mysite/pages/users/user/posts/Post.kt
package com.mysite.pages.users.user.posts

@Page("{}")
@Composable
fun PostPage() {
    /* ... */
}
```
