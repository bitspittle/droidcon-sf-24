---
data-auto-animate:
---

## API routes

{{{ Folders

* jvmMain
  * api 

}}}

```kotlin <fragment> [api-backend]
// jvmMain/com/mysite/api/hello.kt
@Api
suspend fun hello(ctx: ApiContext) {
    ctx.res.setBodyText("hello world")
}
```