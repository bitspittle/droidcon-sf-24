## <span data-id="title">Project organization</span>

{{{ Folders(Modifier.fillMaxWidth().padding(left = 5.cssRem).dataId("folders"))

* resources/public
  * images
    * buster.jpg

}}}

{{{ Horizontal

```kotlin 2-3 <fragment,fade-right> {data-fragment-index=1}
Img(
  src =
   "/images/buster.jpg",
  attrs =
    Modifier.fillMaxSize()
      .toAttrs()
)
```

{{{ Image("buster.jpg", Modifier.classNames("fragment", "fade-left")) }}}

}}}
