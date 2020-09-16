/*

import spray.json.{DefaultJsonProtocol, JsObject, JsString, JsValue, RootJsonFormat}
trait TempProtocol extends DefaultJsonProtocol with ImpersonateUriJsonProtocol {
  implicit object AggregatedUserFormat extends RootJsonFormat[AggregatedUser] {
    val aggregatedUserBaseFormat: RootJsonFormat[AggregatedUser] =
      jsonFormat(AggregatedUser.apply, "uri", "first_name", "last_name")
    override def read(json: JsValue): AggregatedUser =
      aggregatedUserBaseFormat.read(json)
    override def write(aggregatedUser: AggregatedUser): JsValue = {
      val json = aggregatedUserBaseFormat.write(aggregatedUser).asJsObject
      JsObject(json.fields + ("uuid" -> JsString(aggregatedUser.uuid.toString)))
    }
  }
  implicit object AggregatedAppFormat extends RootJsonFormat[AggregatedApp] {
    val aggregatedAppBaseFormat: RootJsonFormat[AggregatedApp] =
      jsonFormat(AggregatedApp.apply, "uri", "name")
    override def read(json: JsValue): AggregatedApp =
      aggregatedAppBaseFormat.read(json)
    override def write(aggregatedApp: AggregatedApp): JsValue = {
      aggregatedAppBaseFormat.write(aggregatedApp)
    }
  }
  implicit object AggregatedImpersonateFormat extends RootJsonFormat[AggregatedImpersonate] {
    override def write(obj: AggregatedImpersonate): JsValue = obj match {
      case i: AggregatedUser => AggregatedUserFormat.write(i)
      case i: AggregatedApp => AggregatedAppFormat.write(i)
    }
    override def read(json: JsValue): AggregatedImpersonate = {
      throw new NotImplementedError("AggregatedImpersonate is not supposed to be read from json")
    }
  }
  implicit object AggregatedImpersonateDetailsFormat extends RootJsonFormat[AggregatedImpersonateDetails] {
    override def write(obj: AggregatedImpersonateDetails): JsValue = {
      JsObject(obj.mdsolType -> (obj.aggregatedImpersonate match {
        case i: AggregatedUser => AggregatedUserFormat.write(i)
        case i: AggregatedApp => AggregatedAppFormat.write(i)
      })
      )
    }
    override def read(json: JsValue): AggregatedImpersonateDetails = {
      throw new NotImplementedError("AggregatedImpersonateDetails is not supposed to be read from json")
    }
  }
}
object ll extends App  with TempProtocol {
  import spray.json._
  //val userUri = UserUri(java.util.UUID.fromString("bc529533-5bb6-4245-ade9-1c9e08ab3e19"))
  val appUri = ApplicationUri(java.util.UUID.fromString("bc529533-5bb6-4245-ade9-1c9e08ab3e19"))
  val x: AggregatedImpersonateDetails = AggregatedImpersonateDetails("app", AggregatedApp(appUri, "appname"))
  println(x.toJson.prettyPrint)
}

sealed trait AggregatedImpersonate {
  val uri: ImpersonateUri
  def isResolved: Boolean
  def isUnresolved: Boolean
}
object AggregatedUser {
  def createUnresolved(uri: ImpersonateUri): AggregatedUser =
    AggregatedUser(uri, "", "")
}
case class AggregatedUser(override val uri: ImpersonateUri, first_name: String, last_name: String)
  extends AggregatedImpersonate {
  val uuid = uri.uuid
  override def isResolved: Boolean = this != AggregatedUser.createUnresolved(uri)
  override def isUnresolved: Boolean = !isResolved
}
object AggregatedApp {
  def createUnresolved(uri: ImpersonateUri): AggregatedApp =
    AggregatedApp(uri, "")
}
case class AggregatedApp(override val uri: ImpersonateUri, name: String)
  extends AggregatedImpersonate {
  override def isResolved: Boolean = this != AggregatedApp.createUnresolved(uri)
  override def isUnresolved: Boolean = !isResolved
}
case class AggregatedImpersonateDetails(mdsolType: String, aggregatedImpersonate: AggregatedImpersonate)
*/
