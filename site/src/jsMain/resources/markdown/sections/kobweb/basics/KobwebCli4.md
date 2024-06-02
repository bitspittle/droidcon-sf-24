---
data-auto-animate-restart:
---

## Kobweb Configuration

```yaml 3,6|9-15 <hide-vertical-scrollbar>
# .kobweb/conf.yaml
site:
  title: "App"

server:
  port: 8080

  files:
    dev:
      contentRoot: "build/processedResources/js/main/public"
      script: "build/dist/js/developmentExecutable/app.js"
      api: "build/libs/app.jar"
    prod:
      script: "build/dist/js/productionExecutable/app.js"
      siteRoot: ".kobweb/site"
```
