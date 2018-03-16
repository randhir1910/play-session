//package controllers
//
//import javax.inject._
//
//import play.api.data.Forms._
//import play.api.data._
//import play.api.i18n.I18nSupport
//import play.api.mvc._
//
///**
//  * This controller creates an `Action` to handle HTTP requests to the
//  * application's home page.
//  */
//
//case class Login(id: Int, email: String)
//
//@Singleton
//class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {
//
//  implicit val messages = cc.messagesApi
//
//  //  val user1 = Users(1, "randhir", 1000);
//  //  val user2 = Users(2, "ravi", 3000);
//
//  val userForm = Form(mapping(
//    "id" -> number,
//    "email" -> email
//  )(Login.apply)(Login.unapply))
//
//  /**
//    * Create an Action to render an HTML page.
//    *
//    * The configuration in the `routes` file means that this method
//    * will be called when the application receives a `GET` request with
//    * a path of `/`.
//    */
//  def index() = Action { implicit request: Request[AnyContent] =>
//    Ok(views.html.index(userForm))
//  }
//
//  //  def index() = Action { implicit request: Request[AnyContent] =>
//  //    Ok(views.html.index(userForm))
//  //  }
//
//  //  def greet = Action {
//  //    request =>
//  //      //Ok(s"Hello ")
//  //      Redirect(routes.HomeController.index())
//  //  }
//
//
//  def submit() = Action { implicit request =>
//    userForm.bindFromRequest.fold(
//      formWithErrors => BadRequest,
//      {
//        user =>
//          Redirect(routes.HomeController.redirect()).withSession("id" -> user.id.toString, "email" -> user.email)
//              .flashing("success" -> "success")
//      }
//    )
//  }
//
//  def redirect() = Action { implicit request =>
//    Ok(views.html.user())
//  }
//}
