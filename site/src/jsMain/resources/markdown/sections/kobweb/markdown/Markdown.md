---
follows: Header
---

## Markdown

```kotlin 3,9
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
