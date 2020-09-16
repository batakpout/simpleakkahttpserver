package rest

import Controllers.{AddressControllerComponent, EmployeeControllerComponent}
import akka.actor.ActorSystem
import akka.http.scaladsl.model.{HttpEntity, HttpResponse, MediaTypes, StatusCodes}
import akka.http.scaladsl.server.Directives
import akka.stream.ActorMaterializer
import generated.Address
import generated.`package`.defaultScope
import org.json4s.jackson.JsonMethods._
import org.json4s.{DefaultFormats, Extraction}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.xml.Elem

class AddressRest(controller: AddressControllerComponent) extends Directives {

  implicit val system = ActorSystem.create("Test")
  implicit val materializer = ActorMaterializer()

  implicit val f = DefaultFormats

  val routes = path("address") {
    post {
      entity(as[String]) { data =>
        complete {
          controller.insertAddress(AddressParser.xmlToAddress(data)).map { result =>
            HttpResponse(status = StatusCodes.OK, entity = HttpEntity(contentType = MediaTypes.`application/xml`, string = AddressParser.parseToXML(result)))
          }
        }
      }
    } ~ get {
      parameter("use_old".?) { useOld =>
       if(useOld.isDefined) println("value ==> " + useOld.get) else println("Not value")
      complete {
          controller.getAddressById("1").map { result =>
            HttpResponse(status = StatusCodes.OK, entity = HttpEntity(MediaTypes.`application/xml`, AddressParser.parseToXML(result)))
          }
        }
      }

    }

  }
}

object AddressParser {
  def parseToXML(address: Address) = {
    scalaxb.toXML[Address](address, "address", defaultScope).toString()
  }

  def xmlToAddress(xmlString: String) = {
    val elem: Elem = scala.xml.XML.loadString(xmlString)
    scalaxb.fromXML[Address](elem)
  }
}


