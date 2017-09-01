package com.iancanderson.views

import io.udash._
import com.iancanderson.BindingDemoState
import org.scalajs.dom.Element
import com.iancanderson.styles.DemoStyles
import scalacss.ScalatagsCss._

case class BindingDemoViewPresenter(urlArg: String) extends DefaultViewPresenterFactory[BindingDemoState](() => {
  import com.iancanderson.Context._

  val model = Property[String](urlArg)
  new BindingDemoView(model)
})

class BindingDemoView(model: Property[String]) extends View {
  import scalatags.JsDom.all._

  private val content = div(
    h2(
      "You can find this demo source code in: ",
      i("com.iancanderson.views.BindingDemoView")
    ),
    h3("Example"),
    TextInput.debounced(model, placeholder := "Type something..."),
    p("You typed: ", bind(model)),
    h3("Read more"),
    a(DemoStyles.underlineLinkBlack)(href := "http://guide.udash.io/#/frontend/bindings", target := "_blank")("Read more in Udash Guide.")
  )

  override def getTemplate: Modifier = content

  override def renderChild(view: View): Unit = {}
}