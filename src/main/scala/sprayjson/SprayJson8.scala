package sprayjson

import spray.json.DefaultJsonProtocol._
import spray.json.{JsObject, JsValue, RootJsonFormat, _}

object SprayJson8 extends App {

  case class DeviceCredentialParent(objectType: Option[String] = None, id: Option[String] = None)

  case class DeviceDetails(dcParent: Option[DeviceCredentialParent] = None, name: Option[String] = None)

  object DeviceCredentialParent {

    implicit val deviceCredentialParentFormat = new RootJsonFormat[DeviceCredentialParent] {
      def write(dcParent: DeviceCredentialParent): JsValue = {
        JsObject(
          "object-type" -> dcParent.objectType.toJson,
          "id" -> dcParent.id.toJson
        )
      }

      def read(value: JsValue): DeviceCredentialParent = {
        val fields = value.asJsObject.fields/*.toList.map { case (key, value) =>
          if(value == JsNull) (key -> None) else (key -> Some(value))
        }.toMap*/
        DeviceCredentialParent(fields("object-type").convertTo[Option[String]], fields("id").convertTo[Option[String]])
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
        val fields = value.asJsObject.fields/*.toList.map { case (key, value) =>
          if(value == JsNull) (key -> None) else (key -> Some(value))
        }.toMap*/
        DeviceDetails(fields("parent").convertTo[Option[DeviceCredentialParent]], fields("name").convertTo[Option[String]])
      }

    }

  }

  val json = """{"parent":{"object-type":"","id":"11"},"name": null}"""
  val res: DeviceDetails = json.parseJson.convertTo[DeviceDetails]
 val x: JsValue = res.toJson
 println(res)

  println(x)

}