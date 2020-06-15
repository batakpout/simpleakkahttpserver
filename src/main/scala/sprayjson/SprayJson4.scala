import spray.json.DefaultJsonProtocol
import sprayjson.SprayJson2A.MyJsonProtocol.{jsonFormat2, jsonFormat3}
import sprayjson.SprayJson2A.{Address, Person, personJson}

object SprayJson4 extends App {
  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val personFormat = jsonFormat3(Person)
  }
  import spray.json._

  import MyJsonProtocol._
  case class Person(deviceId: String, userName: String, password: String)
  val json = """{"deviceId":"1","userName":"user11","password":"passw"}"""
  println(json.parseJson.convertTo[Person])}