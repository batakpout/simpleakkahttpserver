package rest

import Controllers.EmployeeControllerComponent
import akka.actor.ActorSystem
import akka.http.scaladsl.model.{HttpEntity, HttpResponse, MediaTypes, StatusCodes}
import akka.http.scaladsl.server.Directives
import akka.stream.ActorMaterializer
import org.json4s.jackson.JsonMethods._
import org.json4s.{DefaultFormats, Extraction}

import scala.concurrent.ExecutionContext.Implicits.global

class QueryParamSegmentRest(controller: EmployeeControllerComponent) extends Directives {

  implicit val system = ActorSystem.create("Test")
  implicit val materializer = ActorMaterializer()

  implicit val f = DefaultFormats

  val routes = pathPrefix("query") {
    path("d1") {
      post {
        headerValueByName("apiKey") { token =>
          //extract(_.request.uri.query) { params =>
          // val x = params.toList //comes as list of tuples
          // parameters('value1.as[String], 'value2.as[String]) { (key, value) =>
          entity(as[String]) { data =>
            complete {
              controller.insertEmployeeController(data).map { result =>
                HttpResponse(status = StatusCodes.OK, entity = HttpEntity(contentType = MediaTypes.`application/json`, string = compact(Extraction.decompose(result))))
              }
            }
          }
        }
      } ~ get {
        complete {
          controller.getAllEmployees().map { result =>
            HttpResponse(status = StatusCodes.OK, entity = HttpEntity(MediaTypes.`application/json`, compact(Extraction.decompose(result))))
          }
        }

      }
    } ~ path("d2" / """\w+""".r) { matched =>
      val regexString: String = matched
      get {
        complete {
          controller.getAllEmployees().map { result =>
            HttpResponse(status = StatusCodes.OK, entity = HttpEntity(MediaTypes.`application/json`, compact(Extraction.decompose(result))))
          }
        }

      }
    } ~ path("d3" / Segment) { segment =>
      val segmentPassed: String = segment
      println("segment passed: " + segment)
      get {
        complete {
          controller.getAllEmployees().map { result =>
            HttpResponse(status = StatusCodes.OK, entity = HttpEntity(MediaTypes.`application/json`, compact(Extraction.decompose(result))))
          }
        }

      }
    }
  }
}

