---
follows: Code
---

## `markdown.process`

```kotlin 0|5|6-11|8-10|0
// build.gradle.kts

kobweb {
  markdown {
    process.set { markdownEntries ->
      generateMarkdown("markdown/listing.md", buildString {
        appendLine("# Listing")
        markdownEntries.forEach { entry ->
          appendLine("* [${entry.filePath}](${entry.route})")
        }
      })
    }
  }
}
```

```markdown <fragment>
# Listing

* [posts/droidcon.md](/posts/droidcon)
* [posts/kobweb.md](/posts/kobweb)
```

{{{ SpeakerNotes

* You can reference frontmatter inside the markdown entries

}}}
