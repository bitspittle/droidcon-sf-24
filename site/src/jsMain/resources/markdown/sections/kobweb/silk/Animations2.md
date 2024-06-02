---
data-auto-animate-restart:
---

## Keyframes

```kotlin [code]
val SpinningKeyframes = Keyframes {
    // from { Modifier.rotate(0.deg) }
    to { Modifier.rotate(360.deg) }
}

Modifier
    .animation(
        SpinningKeyframes.toAnimation(
            10.s,
            AnimationTimingFunction.Linear,
            iterationCount = AnimationIterationCount.Infinite,
        )
    )
```

{{{ Centered

{{{ SpinningExample }}}

}}}
