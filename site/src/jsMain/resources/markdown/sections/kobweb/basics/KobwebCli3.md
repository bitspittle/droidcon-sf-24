---
behaviors:
  - auto-fragment LI
  - auto-progress-fragments 50
---

## Project structure

{{{ Folders(Modifier.fontSize(1.2.cssRem).textAlign(TextAlign.Center))

* build.gradle.kts
* gradle/libs.versions.toml
* site
  * build.gradle.kts 
  * src
    * jsMain
      * components
        * layouts
          * MarkdownLayout.kt
          * PageLayout.kt
        * sections
          * Footer.kt
          * NavHeader.kt
        * widgets
          * IconButton.kt
      * pages
        * Index.kt
      * AppEntry.kt
    * resources
      * markdown/About.md
      * public/favicon.ico

}}}

{{{ SpeakerNotes

* No index.html in sight!
* Gradle build scripts set up for you

}}}
