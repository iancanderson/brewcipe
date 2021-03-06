package com.iancanderson.views

import io.udash._
import com.iancanderson._
import org.scalajs.dom.Element
import com.iancanderson.styles.{DemoStyles, GlobalStyles}
import scalacss.ScalatagsCss._

object IndexViewPresenter extends DefaultViewPresenterFactory[IndexState.type](() => new IndexView)

class IndexView extends View {
  import com.iancanderson.Context._
  import scalatags.JsDom.all._

  private val content = div(
    h2("Thank you for choosing Udash! Take a look at following demo pages:"),
    ul(DemoStyles.stepsList)(
      li(a(DemoStyles.underlineLinkBlack, href := BindingDemoState().url)("Binding demo")),
      li(a(DemoStyles.underlineLinkBlack, href := BindingDemoState("From index").url)("Binding demo with URL argument")),
      li(a(DemoStyles.underlineLinkBlack, href := RPCDemoState.url)("RPC demo")),
      li(a(DemoStyles.underlineLinkBlack, href := DemoStylesState.url)("ScalaCSS demo view")),
      li(a(DemoStyles.underlineLinkBlack, href := IbuCalculatorState.url)("IBU Calculator view"))
    ),
    h3("Read more"),
    ul(
      li(
        a(DemoStyles.underlineLinkBlack, href := "http://udash.io/", target := "_blank")("Visit Udash Homepage.")
      ),
      li(
        a(DemoStyles.underlineLinkBlack, href := "http://guide.udash.io/", target := "_blank")("Read more in Udash Guide.")
      ),
      li(
        a(DemoStyles.underlineLinkBlack, href := "https://www.scala-js.org/", target := "_blank")("Read more about Scala.js.")
      ),
      li(
        a(DemoStyles.underlineLinkBlack, href := "https://japgolly.github.io/scalacss/book/", target := "_blank")("Read more about ScalaCSS")
      ),
      li(
        a(DemoStyles.underlineLinkBlack, href := "http://www.lihaoyi.com/scalatags/", target := "_blank")("Read more about ScalaTags")
      )
    )
  )

  override def getTemplate: Modifier = content

  override def renderChild(view: View): Unit = {}
}
