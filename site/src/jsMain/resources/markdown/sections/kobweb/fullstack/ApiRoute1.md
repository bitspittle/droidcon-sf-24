## API routes

```kotlin 0|5,10-13
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
