---
styles:
  - accented-subheaders
---

## Icons

### Font Awesome

```kotlin 5
// build.gradle.kts
kotlin {
  sourceSets {
    jsMain.dependencies {
      implementation(libs.silk.icons.fa)
    }
  }
}
```

```kotlin
FaEye()
FaHeart(style = IconStyle.FILLED)
Text("Kobweb")
```

${FaEye} <span style="color:red">${FaHeart(style = FaIconStyle.FILLED)}</span> ${Kobweb()}
