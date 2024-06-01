## Keyframes

```kotlin [code]
val AnimationSquashKeyframes = Keyframes {
    0.percent { squishLeft }
    10.percent { left }
    40.percent { right }
    50.percent { squishRight }
    60.percent { right }
    90.percent { left }
    100.percent { squishLeft }
}
```

{{{ Centered

{{{ SquashExample }}}

}}}
