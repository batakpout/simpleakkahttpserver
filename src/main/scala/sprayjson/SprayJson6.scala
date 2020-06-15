package sprayjson

object SprayJson6 extends App {

  import spray.json.DefaultJsonProtocol._
  import spray.json._

  case class Address(street: String, city: String)
  case class Person(firstName: String, lastName: String, address: Address)

  implicit val addressJsonFormat = new RootJsonFormat[Address] {
    def write(address: Address): JsValue = {
      JsObject(
        "street" -> address.street.toJson,
        "city" -> address.city.toJson
      )
    }

    def read(value: JsValue): Address = {
      val fields = value.asJsObject.fields
      Address(fields("street").convertTo[String], fields("city").convertTo[String])

    }
  }

  implicit val personJsonFormat = new RootJsonFormat[Person] {
    def write(person: Person): JsValue = {
      JsObject(
        "first_name" -> person.firstName.toJson,
        "last_name" -> person.lastName.toJson,
        "real_address" -> person.address.toJson
      )
    }

    def read(value: JsValue): Person = {
      val fields = value.asJsObject.fields
      Person(fields("first_name").convertTo[String], fields("last_name").convertTo[String], fields("real_address").convertTo[Address])

    }
  }



  val davidBowie = Person(firstName = "David", lastName = "Bowie", Address("btm", "Bangalore"))
  val res = List(davidBowie).toJson
  println(res)

  val json = """[{"first_name":"aamir","last_name":"fayaz","real_address":{"street":"btm","city":"bangalore"}}]"""

  println(json.parseJson.convertTo[List[Person]])


}