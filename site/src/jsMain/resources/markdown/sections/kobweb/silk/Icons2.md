## Font Awesome

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
FaHeart()
Text("Kobweb")
```

{{{ Horizontal

${FaEye} ${FaHeart} ${Kobweb()}

}}}
