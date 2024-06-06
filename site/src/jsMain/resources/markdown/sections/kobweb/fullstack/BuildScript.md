---
follows: FullstackVsStatic
---

```kotlin 0|5,10-13 <hide-vertical-scrollbar>
// build.gradle.kts
kotlin {
    configAsKobwebApplication(
        "app",
        includeServer = true
    )

    sourceSets {
        jsMain.dependencies { /* ... */ }
        jvmMain.dependencies {
            compileOnly(libs.kobweb.api)
            /* ... */
        }
    }
}
```
