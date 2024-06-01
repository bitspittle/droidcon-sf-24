---
follows: FullstackVsStatic
---

## API routes

```kotlin 0|5,10
// build.gradle.kts
kotlin {
    configAsKobwebApplication(
        "app",
        includeServer = true
    )

    sourceSets {
        jsMain.dependencies { /* ... */ }
        jvmMain.dependencies { /* ... */ }
    }
}
```
