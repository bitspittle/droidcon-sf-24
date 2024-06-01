---
data-auto-animate:
---

## API routes

```kotlin 0|7-10 [api-init]
// Backend

interface DataStore {
    fun addText(id: String, text: String)
}

@InitApi
fun initApi(ctx: InitApiContext) {
    ctx.data.add<DataStore>(DataStoreImpl())
}
```

```kotlin <fragment> [api-backend]
// Backend

// 2: Save the message into a data store?
```
