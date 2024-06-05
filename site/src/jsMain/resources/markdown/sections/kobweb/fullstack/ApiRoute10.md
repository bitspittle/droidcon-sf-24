## API routes

```kotlin <apibackend> [api-backend]
// Backend
@Api
suspend fun contactMe(ctx: ApiContext) {
    // 2: Write message into a data store
}
```

```kotlin 0|1,7-10 <fragment,apibackend> [api-init]
// Backend

interface DataStore {
    fun addText(id: String, text: String)
}

@InitApi
fun initApi(ctx: InitApiContext) {
    ctx.data.add<DataStore>(DataStoreImpl())
}
```
