---
data-auto-animate:
---

## API routes

{{{ Folders

* jvmMain
  * api 

}}}

```kotlin <fragment> [api-backend]
@Api
fun hello(ctx: ApiContext) {
    ctx.res.setBodyText("hello world")
}
```
