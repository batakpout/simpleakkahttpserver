package rest

import Controllers.EmployeeControllerComponent
import akka.actor.ActorSystem
import akka.http.scaladsl.model.{HttpEntity, HttpResponse, MediaTypes, StatusCodes}
import akka.http.scaladsl.server.Directives
import akka.stream.ActorMaterializer
import org.json4s.jackson.JsonMethods._
import org.json4s.{DefaultFormats, Extraction}

import scala.concurrent.ExecutionContext.Implicits.global

class EmployeeRest(controller: EmployeeControllerComponent) extends Directives {

  implicit val system = ActorSystem.create("Test")
  implicit val materializer = ActorMaterializer()

  implicit val f = DefaultFormats

  val routes = path("employee") {
    post {
      headerValueByName("apiKey") { token =>
          entity(as[String]) { data =>
            complete {
              controller.insertEmployeeController(data).map { result =>
                HttpResponse(status = StatusCodes.OK, entity = HttpEntity(MediaTypes.`application/json`, compact(Extraction.decompose(result))))
              }
            }
          }
        }
      }
    }

}
