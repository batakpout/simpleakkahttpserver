package sprayjson

import spray.json.DefaultJsonProtocol._
import spray.json.{JsObject, JsValue, RootJsonFormat, _}

object SprayJson8 extends App {

  case class DeviceCredentialParent(objectType: Option[String], id: Option[String])

  case class DeviceDetails(dcParent: Option[DeviceCredentialParent], name: Option[String])

  object DeviceCredentialParent {

    implicit val deviceCredentialParentFormat = new RootJsonFormat[DeviceCredentialParent] {
      def write(dcParent: DeviceCredentialParent): JsValue = {
        JsObject(
          "object-type" -> dcParent.objectType.toJson,
          "id" -> dcParent.id.toJson
        )
      }

      def read(value: JsValue): DeviceCredentialParent = {
        val fields = value.asJsObject.fields.toList.map { case (key, value) =>
          if(value == JsNull) (key -> None) else (key -> Some(value))
        }.toMap
        DeviceCredentialParent(fields("object-type").map(_.convertTo[String]), fields("id").map(_.convertTo[String]))
      }
    }

  }

  object DeviceDetails {

    implicit val deviceCredentialsFormat = new RootJsonFormat[DeviceDetails] {
      def write(dc: DeviceDetails): JsValue = {
        JsObject(
          "parent" -> dc.dcParent.toJson,
          "name" ->   dc.name.toJson
        )
      }

      def read(value: JsValue): DeviceDetails = {
        val fields = value.asJsObject.fields.toList.map { case (key, value) =>
          if(value == JsNull) (key -> None) else (key -> Some(value))
        }.toMap
        DeviceDetails(fields("parent").map(_.convertTo[DeviceCredentialParent]), fields("name").map(_.convertTo[String]))
      }

    }

  }

  val json = """{"parent":{"object-type":"abc","id":"11"},"name": null}"""
  val res: DeviceDetails = json.parseJson.convertTo[DeviceDetails]
 val x: JsValue = res.toJson
 println(res)

  println(x)

}