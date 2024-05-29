---
data-auto-animate:
---

## <span data-id="title">Project organization</span>

```kotlin 1,2,7,9
import com.mysite.components.sections.NavHeader
import com.mysite.components.sections.Footer

@Composable
fun PageLayout(content: @Composable () -> Unit) {
  Column {
    NavHeader()
    content()
    Footer()  
  }
}
```

```kotlin 1,2,7-9
import com.mysite.components.layouts.PageLayout
import com.mysite.components.widgets.VisitorCounter

@Page
@Composable
fun IndexPage() {
  PageLayout {
    VisitorCounter()
  }    
}
```
