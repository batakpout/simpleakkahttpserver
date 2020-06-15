package sprayjson

object SprayJson5 extends App {
  /*case class Value(amt: Int)
  case class Item(name: String, count: Value)

  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val valueFormat = jsonFormat1(Value)
    implicit val itemFormat = jsonFormat22(Item)
  }

  import MyJsonProtocol._


  val json = Item("mary", Value(2)).toJson
  println(json)*/

  import spray.json.{DefaultJsonProtocol, JsBoolean, JsObject, JsString, JsValue, RootJsonFormat}

  case class Document(field1: String, field2: String, field3: String, field4: String, field5: String, field6: String,
                      field7: String, field8: String, field9: String, field10: String, field11: String, field12: String,
                      field13: String, field14: String, field15: String, field16: String, field17: String, field18: String,
                      field19: String, field20: String, field21: String, field22: String, field23: String, field24: String,
                      approved: Boolean)

  object DocumentProtocol extends DefaultJsonProtocol {

    implicit object DocumentFormat extends RootJsonFormat[Document] {
      override def write(obj: Document): JsValue = {
        JsObject(
          "field1" -> JsString(obj.field1),
          "field2" -> JsString(obj.field2),
          "field3" -> JsString(obj.field3),
          "field4" -> JsString(obj.field4),
          "field5" -> JsString(obj.field5),
          "field6" -> JsString(obj.field6),
          "field7" -> JsString(obj.field7),
          "field8" -> JsString(obj.field8),
          "field9" -> JsString(obj.field9),
          "field10" -> JsString(obj.field10),
          "field11" -> JsString(obj.field11),
          "field12" -> JsString(obj.field12),
          "field13" -> JsString(obj.field13),
          "field14" -> JsString(obj.field14),
          "field15" -> JsString(obj.field15),
          "field16" -> JsString(obj.field16),
          "field17" -> JsString(obj.field17),
          "field18" -> JsString(obj.field18),
          "field19" -> JsString(obj.field19),
          "field20" -> JsString(obj.field20),
          "field21" -> JsString(obj.field21),
          "field22" -> JsString(obj.field22),
          "field23" -> JsString(obj.field23),
          "field24" -> JsString(obj.field24),
          "approved" -> JsBoolean(obj.approved)
        )
      }

      def read(json: JsValue): Document = {
        val fields = json.asJsObject.fields
        Document(
          fields("field1").convertTo[String],
          fields("field2").convertTo[String],
          fields("field3").convertTo[String],
          fields("field4").convertTo[String],
          fields("field5").convertTo[String],
          fields("field6").convertTo[String],
          fields("field7").convertTo[String],
          fields("field8").convertTo[String],
          fields("field9").convertTo[String],
          fields("field10").convertTo[String],
          fields("field11").convertTo[String],
          fields("field12").convertTo[String],
          fields("field13").convertTo[String],
          fields("field14").convertTo[String],
          fields("field15").convertTo[String],
          fields("field16").convertTo[String],
          fields("field17").convertTo[String],
          fields("field18").convertTo[String],
          fields("field19").convertTo[String],
          fields("field20").convertTo[String],
          fields("field21").convertTo[String],
          fields("field22").convertTo[String],
          fields("field23").convertTo[String],
          fields("field24").convertTo[String],
          fields("approved").convertTo[Boolean]
        )
      }
    }

  }
}