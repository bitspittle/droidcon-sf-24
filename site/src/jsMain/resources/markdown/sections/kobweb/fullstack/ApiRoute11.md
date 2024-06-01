## API routes

```kotlin 7-10 [api-init]
// Backend

interface DataStore {
    fun addText(id: String, text: String)
}

@InitApi
fun initApi(ctx: InitApiContext) {
    ctx.data.add<DataStore>(DataStoreImpl())
}
```

```kotlin [api-backend]
// Backend

// val msg: ContactMeMessage = ...

ctx.data.getValue<DataStore>().addText(
    id = "${msg.lastName}, ${msg.firstName}",
    text = "${msg.subject}: ${msg.message}"
)
```
