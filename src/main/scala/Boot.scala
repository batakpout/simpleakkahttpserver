import Actors.{ActorSystemContainer, GeneralActors}
import Controllers.{AddressController, EmployeeController}
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.{Route, RouteConcatenation}
import akka.stream.ActorMaterializer
import rest.{AddressRest, EmployeeRest, QueryParamSegmentRest}

import scala.concurrent.ExecutionContext.Implicits.global

trait RestService extends RouteConcatenation with CORSSupport with GeneralActors {
  override val contextRoot: String = "datafoundry"
  val routes: Route = allRoutes

  override implicit def system: ActorSystem = ActorSystemContainer.system

  def allRoutes: Route = {
    val availableRoutes = new EmployeeRest(EmployeeController).routes ~ new AddressRest(AddressController).routes ~ new QueryParamSegmentRest(EmployeeController).routes
    availableRoutes
  }

}

trait RestEndCollection extends RestService {
  val availableRoutes: Route = cors(routes)
}

object Boot extends App with RestEndCollection {
  implicit val materializer = ActorMaterializer()

  val r = Http().bindAndHandle(availableRoutes, interface = "0.0.0.0", port = 9070)
  r.map { x => println("Successfully Bound to " + x.localAddress) }.recover { case _ => println("Failed to Bind ") }
  Thread.sleep(5000)
}