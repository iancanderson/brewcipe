package com.iancanderson.views

import io.udash._
import com.iancanderson.RootState
import org.scalajs.dom.Element
import scalatags.JsDom.tags2.main
import com.iancanderson.views.components.{Footer, Header}
import com.iancanderson.styles.{DemoStyles, GlobalStyles}
import scalacss.ScalatagsCss._

object RootViewPresenter extends DefaultViewPresenterFactory[RootState.type](() => new RootView)

class RootView extends View {
  import com.iancanderson.Context._
  import scalatags.JsDom.all._

  private val child: Element = div().render

  private val content = div(
    Header.getTemplate,
    main(GlobalStyles.main)(
      div(GlobalStyles.body)(
        h1("brewcipe"),
        child
      )
    )
,Footer.getTemplate
  )

  override def getTemplate: Modifier = content

  override def renderChild(view: View): Unit = {
    import io.udash.wrappers.jquery._
    jQ(child).children().remove()
    view.getTemplate.applyTo(child)
  }
}