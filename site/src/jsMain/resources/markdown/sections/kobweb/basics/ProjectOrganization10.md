## <span data-id="title">Project organization</span>

{{{ Folders(Modifier.fillMaxWidth().padding(left = 5.cssRem).dataId("folders"))

* resources
  * public
    * images
      * ${KobwebText("buster.jpg")}

}}}

{{{ Horizontal

```kotlin <fragment,fade-right> {data-fragment-index=1}
Img(
  src =
   "/images/buster.jpg"
)
```

{{{ Image("buster.jpg", Modifier.classNames("fragment", "fade-left").attr("data-fragment-index", "1")) }}}

}}}
