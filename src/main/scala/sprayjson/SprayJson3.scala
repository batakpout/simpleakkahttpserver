package sprayjson

import spray.json.DefaultJsonProtocol._
import spray.json._

object SprayJson1 extends App {

  val source = """{ "some": "JSON source" }"""
  val jsonAst1: JsValue = source.parseJson // or JsonParser(source)
   println(jsonAst1)

  val jsonAst2 = List(1, 2, 3).toJson
  print(jsonAst2)
}

object SprayJson2 extends App {

  import spray.json.DefaultJsonProtocol._
  import spray.json._

  case class Address(street: String, city: String)
  case class Person(firstName: String, lastName: String, address: Address)

  implicit val personJsonFormat = new RootJsonFormat[Person] {
    def write(person: Person): JsValue = {
      JsObject(
        "first_name" -> person.firstName.toJson,
        "last_name" -> person.lastName.toJson
      )
    }

    def read(value: JsValue): Person = ???
  }

  implicit val addressJsonFormat = new RootJsonFormat[Address] {
    def write(address: Address): JsValue = {
      JsObject(
        "street" -> address.street.toJson,
        "city" -> address.city.toJson,
      )
    }

    def read(value: JsValue): Address = ???
  }

  val davidBowie = Person(firstName = "David", lastName = "Bowie", Address("btm", "Bangalore"))
  val iggyPop = Person(firstName = "Iggy", lastName = "Pop", Address("Electronic city", "Mumbai"))
  val res = List(davidBowie, iggyPop).toJson
  println(res)
}