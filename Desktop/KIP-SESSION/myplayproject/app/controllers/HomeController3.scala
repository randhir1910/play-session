package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import scala.concurrent.Future

@Singleton
class HomeController3 @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index3: Action[AnyContent] = Action.async { implicit request =>
    Future.successful(Ok(views.html.index3()))
  }
}
