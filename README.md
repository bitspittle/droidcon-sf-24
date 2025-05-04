Project deployed at<br>
https://bitspittle.github.io/droidcon-sf-24/

---

This is a [Kobweb project](https://github.com/varabyte/kobweb) backing a presentation I gave at Droidcon SF in June 2024.

It makes heavy use of the [`reveal.js` presentation framework](https://revealjs.com/), which is honestly some fantastic
software and worth checking out in its own right.

This presentation serves double duty -- as a guided introduction to a wide range of Kobweb features but also as an
actual Kobweb project that curious users can poke through to learn from.

Some potentially interesting things to look at...

* `build.gradle.kts` has a powerful `markdown.process` method which runs through all slides, inspects their frontmatter,
  and builds up a graph between all the slides, before finally writing all slides, ordered, into a generated
  `components/sections/Slides.kt` source file.
* All slides are markdown (showcasing the power of Markdown support in Kobweb); you can find them under
  `resources/markdown/sections/`.
* All sorts of random code can be found in `components/widgets`.
* `components/layout/SectionLayout.kt` is named so because reveal.js associates a slide per section. We also do some
  crazy stuff using frontmatter styles / behaviors that can optionally be specified in each slide's frontmatter, which
  really showcases its power.

> [!WARNING]
> Some of the code is very ugly as parts were written under a fair bit of time pressure. So treat it as more a curiosity
> than any strict sense of Kobweb best practices.

### Running

If you've cloned this project locally and would like to run it yourself, then run the following commands:

```bash
$ cd site
$ kobweb run
```

Once running, open [http://localhost:8080/droidcon-sf-24](http://localhost:8080/droidcon-sf-24) in your browser to see
the result.

### Configuring

There are a few features that you can configure, by opening up `gradle.properties` and changing their values.

```properties
# If true, label the current slide number in the bottom right corner.
# This makes it easier to jump to slides by shortcut,
# i.e. press `G` followed by the slide number you want to go to.
# The label is a little ugly but it is very useful for dev mode.
slides.show.number=false

# If true, every slide you visit will be saved into local storage and
# then restored on refresh. This makes it so you can keep seeing the
# same slide when Kobweb refreshes your screen.
slides.remember.last=false
```
