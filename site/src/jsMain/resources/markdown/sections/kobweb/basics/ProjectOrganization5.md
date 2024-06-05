## <span data-id="title">Project organization</span>

```kotlin 0|5,8,11|1,2,7,9|5
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

```kotlin 0|1,6,8 <fragment>
import com.mysite.components.layouts.PageLayout

@Page
@Composable
fun IndexPage() {
  PageLayout {
    /* ... */
  }    
}
```
