## API routes

```kotlin 1 <apibackend> [api-init]
// Backend

interface DataStore {
    fun addText(id: String, text: String)
}

@InitApi
fun initApi(ctx: InitApiContext) {
    ctx.data.add<DataStore>(DataStoreImpl())
}
```

```kotlin 6 <apibackend> [api-backend]
// Backend
@Api
suspend fun contactMe(ctx: ApiContext) {
    val msg: ContactMeMessage
    
    ctx.data.getValue<DataStore>().addText(
        id = "${msg.lastName}, ${msg.firstName}",
        text = "${msg.subject}: ${msg.message}"
    )
}
```
