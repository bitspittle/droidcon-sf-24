---
styles:
  - accented-subheaders
---

## Icons

### Material Design

```kotlin 5
// build.gradle.kts
kotlin {
  sourceSets {
    jsMain.dependencies {
      implementation(libs.silk.icons.mdi)
    }
  }
}
```

```kotlin <fragment>
MdiVisibility(style = IconStyle.OUTLINED)
MdiFavorite()
Text("Kobweb")
```

<span class="fragment">${MdiVisibility(Modifier.fontSize(2.5.cssRem), style = MdiIconStyle.OUTLINED)} <span style="color:red">${MdiFavorite(Modifier.fontSize(2.5.cssRem))}</span> ${Kobweb}</span>
