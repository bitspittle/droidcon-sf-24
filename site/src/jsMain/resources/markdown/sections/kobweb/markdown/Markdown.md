---
follows: Header
data-auto-animate:
data-auto-animate-restart:
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
