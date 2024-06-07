---
data-background-image: images/cobweb2-dark.jpg
imports:
  - .utilities.heavyTextShadow
  - com.varabyte.kobweb.compose.foundation.layout.Box
  - org.jetbrains.compose.web.css.Position
styles:
  - outlined-headers
---

{{{ Box(Modifier.height(10.cssRem)) }}}

# ${KobwebText("Thank You")}

{{{ Div(Modifier.heavyTextShadow(10.px).textAlign(TextAlign.Left))

{{{ Box(Modifier.height(13.cssRem)) }}}

${FaGithub} https://github.com/varabyte/kobweb<br>
${FaLinkedin} https://www.linkedin.com/in/hermandave/

}}}
