package sprayjson

import spray.json._

object SprayJson2A extends App {
  case class Address(street: String, city: String)
  case class Person(firstName: String, lastName: String, address: Address)

  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val addressFormat = jsonFormat2(Address)
    implicit val personFormat = jsonFormat3(Person)
  }

  import MyJsonProtocol._
  val a = Address("btm", "bangalore")
  val p: Person = Person("aamir", "fayaz", a)

  println(p.toJson.prettyPrint)

  val personJson = """{"address":{"city":"bangalore","street":"btm"},"firstName":"aamir","lastName":"fayaz"}""".stripMargin
  println(personJson.parseJson.convertTo[Person])
}

object SprayJson2B extends App {
  case class Address(street: String, city: String)
  case class Person(firstName: String, lastName: String, address: Address)

  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val addressFormat = jsonFormat2(Address)
    implicit val personFormat = jsonFormat3(Person)
  }

  import MyJsonProtocol._
  val a1 = Address("btm", "bangalore")
  val a2 = Address("andheri", "mumbai")

  val p1: Person = Person("aamir", "fayaz", a1)
  val p2: Person = Person("zahid", "gul", a2)

  val personList = List(p1, p2)

  println(personList.toJson.prettyPrint)

  val personJson = """{"address":{"city":"bangalore","street":"btm"},"firstName":"aamir","lastName":"fayaz"}""".stripMargin
  println(personJson.parseJson.convertTo[Person])

  println("-" * 30)
  val personJsonList = """[{"address":{"city":"bangalore","street":"btm"},"firstName":"aamir","lastName":"fayaz"},{"address":{"city":"mumbai","street":"andheri"},"firstName":"zahid","lastName":"gul"}]""".stripMargin
  println(personJsonList.parseJson.convertTo[List[Person]])
}