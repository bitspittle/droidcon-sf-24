---
follows: Header
---

## Markdown

```kotlin
// build.gradle.kts
plugins {
    alias(libs.plugins.kobwebx.markdown)
}

kotlin {
    sourceSets {
        jsMain.dependencies {
            implementation(libs.kobwebx.markdown)
        }
    }
}
```
