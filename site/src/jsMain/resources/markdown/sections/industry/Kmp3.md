---
data-transition: "fade-in slide-out"
styles:
  - horizontal
---

```kotlin
plugins {
    kotlin("multiplatform")
}

kotlin {
    android()
    js()
    jvm()
}
```

{{{ Folders
* src
  * commonMain
  * androidMain
  * jsMain
  * jvmMain

}}}
