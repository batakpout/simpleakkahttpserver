package sprayjson

object SprayJson1 extends App {

  case class SubClass(subkey1: String, subkey2: String)

  case class MainClass(key1: String, key2: SubClass)

  import spray.json._

  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val subclassFormat = jsonFormat2(SubClass)
    implicit val mainclassFormat = jsonFormat2(MainClass)
  }

  import MyJsonProtocol._

  val jsonstr =
    """
    {
      "key1" : "value1",
      "key2" : { "subkey1" : "subval1", "subkey2" : "subval2" }
    }
    """
  val jsonAst: JsValue = jsonstr.parseJson
  val gotit: MainClass = jsonAst.convertTo[MainClass]

  println(jsonAst)
  println(gotit)

  val jsonStr2 =
    """
      [
        {
         "key1" : "value1",
          "key2" : { "subkey1" : "subval1", "subkey2" : "subval2" }
        },
        {
          "key1" : "value10",
          "key2" : { "subkey1" : "subval10", "subkey2" : "subval20" }
        }
      ]
      """.stripMargin
  println("-------------------------")

  val jsonAst2: JsValue = jsonStr2.parseJson
  val gotit2: List[MainClass] = jsonAst2.convertTo[List[MainClass]]
  println(gotit2)

  println("=========================")
  val subCLass = SubClass("subkey1", "subkey2")
  val mainClass = MainClass("mainKey", subCLass)

  val jsonMainClass = mainClass.toJson.toString()
  println(jsonMainClass)

  println("*************************************")
  val subCLass1 = SubClass(subkey1 = "subkey1", subkey2 = "subkey2")
  val subCLass2 = SubClass("subkey1", "subkey2")

  val mainClass1 = MainClass(key1 = "mainKey1", key2 = subCLass1)
  val mainClass2 = MainClass("mainKey2", subCLass2)

  val mainClassList = List(mainClass1, mainClass2)

  println(mainClassList.toJson.prettyPrint)
}