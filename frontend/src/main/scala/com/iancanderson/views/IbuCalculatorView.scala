package com.iancanderson.views

import io.udash._
import org.scalajs.dom.Element

import com.iancanderson.IbuCalculatorState
import com.iancanderson.shared.{Gravity, HopAddition}

object IbuCalculatorViewPresenter extends DefaultViewPresenterFactory[IbuCalculatorState.type](() => {
  import com.iancanderson.Context._

  val model = Property[String]
  new IbuCalculatorView(model)
})

class IbuCalculatorView(model: Property[String]) extends View {
  import scalatags.JsDom.all._

  private val content = div(
    TextInput.debounced(model, placeholder := "Type something..."),
    p("Alpha Acid: ", bind(model))
  )

  override def getTemplate: Modifier = content
  override def renderChild(view: View): Unit = {}
}
