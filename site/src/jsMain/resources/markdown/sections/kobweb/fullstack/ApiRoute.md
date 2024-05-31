---
follows: FullstackVsStatic
data-auto-animate:
data-auto-animate-restart:
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
