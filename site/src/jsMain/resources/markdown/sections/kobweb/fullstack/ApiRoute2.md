## API routes

{{{ Folders(Modifier.padding(topBottom = 2.cssRem)) 

* jvmMain
  * api 

}}}

```kotlin <fragment,apibackend> [api-backend]
// jvmMain/com/mysite/api/hello.kt
@Api
suspend fun hello(ctx: ApiContext) {
    ctx.res.setBodyText("hello world")
}
```
