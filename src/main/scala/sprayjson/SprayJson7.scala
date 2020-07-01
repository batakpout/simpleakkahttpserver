package sprayjson

import spray.json.DefaultJsonProtocol._
import spray.json._

object SprayJson7 extends App {

  case class DeviceCredentialParent(objectType: Option[String], id: Option[String], name: Option[String])

  case class DeviceCredentialAdministrativeDomain(objectType: Option[String], name: Option[String])

  //case class DeviceCredentialMediationServerGroup(objectType: Option[String], id: Option[String], name: Option[String])

  case class PreviousHop(objectType: Option[String], id: Option[String], name: Option[String])

  case class DeviceDetails(dcParent: Option[DeviceCredentialParent], dcAdminDomain: Option[DeviceCredentialAdministrativeDomain],
                           dcMediationServerGroup: Option[DeviceCredentialParent],
                           previousHop: Option[PreviousHop], objectType: Option[String], name: Option[String], id: Option[String], primaryIp: Option[String], userId: Option[String], password: Option[String],
                           vendorName: Option[String], productName: Option[String], productVersion: Option[String], profile: Option[String], office: Option[String], location: Option[String],
                           chatUserId: Option[String], chatPassword: Option[String], engineId: Option[String],
                           applicationMonitorsTemplateId: Option[String], networkElementTemplateId: Option[String], nodeActionTemplateId: Option[String],
                           primaryPort: Option[Int], subtendedNode: Option[String],
                           lastInventorySynchronizationTimestamp: Option[String], protocol: Option[String], connectionState: Option[String], deviceType: Option[String],
                           connectionType: Option[String], provisionedState: Option[String], authProtocol: Option[String],
                           privacyProtocol: Option[String], chatRequired: Option[Boolean], crlfRequired: Option[Boolean], sSHuserid: Option[String], sSHpassword: Option[String],
                           session: Option[String], tenantName: Option[String], bgpAsIdentifier: Option[String], ospfRouterId: Option[String], alternateName: Option[String],
                           xid: Option[String], availabilityState: Option[String], secondaryIp: Option[String], secondaryPort: Option[String], longitude: Option[Double], latitude: Option[Double],
                           description: Option[String], craft: Option[String], availabilityStateRequired: Option[Boolean])

  object DeviceCredentialParent {

    implicit val deviceCredentialParentFormat = new RootJsonFormat[DeviceCredentialParent] {
      def write(dcParent: DeviceCredentialParent): JsValue = {
        JsObject(
          "object-type" -> dcParent.objectType.toJson,
          "id" -> dcParent.id.toJson,
          "name" -> dcParent.name.toJson
        )
      }

      def read(value: JsValue): DeviceCredentialParent = {
         val fields = value.asJsObject.fields.toList.map { case (key, value) =>
          if(value == JsNull) (key -> None) else (key -> Some(value))
        }.toMap
        DeviceCredentialParent(fields("object-type").map(_.convertTo[String]), fields("id").map(_.convertTo[String]), fields("name").map(_.convertTo[String]))
      }
    }

  }

  object DeviceCredentialAdministrativeDomain {
    implicit val deviceCredentialAdministrativeDomainFormat = new RootJsonFormat[DeviceCredentialAdministrativeDomain] {
      def write(deviceCredentialAdministrativeDomain: DeviceCredentialAdministrativeDomain): JsValue = {
        JsObject(
          "object-type" -> deviceCredentialAdministrativeDomain.objectType.toJson,
          "name" -> deviceCredentialAdministrativeDomain.name.toJson
        )
      }

      def read(value: JsValue): DeviceCredentialAdministrativeDomain = {
         val fields = value.asJsObject.fields.toList.map { case (key, value) =>
          if(value == JsNull) (key -> None) else (key -> Some(value))
        }.toMap
        DeviceCredentialAdministrativeDomain(fields("object-type").map(_.convertTo[String]), fields("name").map(_.convertTo[String]))
      }
    }
  }

 /* object DeviceCredentialMediationServerGroup {
    implicit val deviceCredentialMediationServerGroupFormat = new RootJsonFormat[DeviceCredentialMediationServerGroup] {
      def write(deviceCredentialMediationServerGroup: DeviceCredentialMediationServerGroup): JsValue = {
        JsObject(
          "object-type" -> deviceCredentialMediationServerGroup.objectType.toJson,
          "id" -> deviceCredentialMediationServerGroup.id.toJson,
          "name" -> deviceCredentialMediationServerGroup.name.toJson
        )
      }

      def read(value: JsValue): DeviceCredentialMediationServerGroup = {
         val fields = value.asJsObject.fields.toList.map { case (key, value) =>
          if(value == JsNull) (key -> None) else (key -> Some(value))
        }.toMap
        DeviceCredentialMediationServerGroup(fields("object-type").map(_.convertTo[String]), fields("id").map(_.convertTo[String]), fields("name").map(_.convertTo[String]))
      }
    }
  }*/

  object PreviousHop {
    implicit val previousHopFormat = new RootJsonFormat[PreviousHop] {
      def write(previousHop: PreviousHop): JsValue = {
        JsObject(
          "object-type" -> previousHop.objectType.toJson,
          "id" -> previousHop.id.toJson,
          "name" -> previousHop.name.toJson
        )
      }

      def read(value: JsValue): PreviousHop = {
         val fields = value.asJsObject.fields.toList.map { case (key, value) =>
          if(value == JsNull) (key -> None) else (key -> Some(value))
        }.toMap
        PreviousHop(fields("object-type").map(_.convertTo[String]), fields("id").map(_.convertTo[String]), fields("name").map(_.convertTo[String]))
      }
    }
  }

  object DeviceDetails {
    implicit val deviceCredentialsFormat = new RootJsonFormat[DeviceDetails] {
      def write(dc: DeviceDetails): JsValue = {
        JsObject(
          "parent" -> dc.dcParent.toJson,
          "administrativeDomain" -> dc.dcAdminDomain.toJson,
          "mediation-server-group" -> dc.dcMediationServerGroup.toJson,
          "previous-hop" -> dc.previousHop.toJson,
          "object-type" -> dc.objectType.toJson,
          "name" -> dc.name.toJson,
          "id" -> dc.id.toJson,
          "primary-ip" -> dc.primaryIp.toJson,
          "primary-port" -> dc.primaryPort.toJson,
          "protocol" -> dc.protocol.toJson,
          "session" -> dc.session.toJson,
          "userid" -> dc.userId.toJson,
          "SSHuserid" -> dc.sSHuserid.toJson,
          "password" -> dc.password.toJson,
          "SSHpassword" -> dc.sSHpassword.toJson,
          "connection-state" -> dc.connectionState.toJson,
          "vendor-name" -> dc.vendorName.toJson,
          "device-type" -> dc.deviceType.toJson,
          "product-name" -> dc.productName.toJson,
          "product-version" -> dc.productVersion.toJson,
          "profile" -> dc.profile.toJson,
          "connection-type" -> dc.connectionType.toJson,
          "office" -> dc.office.toJson,
          "location" -> dc.location.toJson,
          "xid" -> dc.xid.toJson,
          "availabilitystate-required" -> dc.availabilityStateRequired.toJson,
          "availability-state" -> dc.availabilityState.toJson,
          "secondary-ip" -> dc.secondaryIp.toJson,
          "secondary-port" -> dc.secondaryPort.toJson,
          "longitude" -> dc.longitude.toJson,
          "latitude" -> dc.latitude.toJson,
          "description" -> dc.description.toJson,
          "provisioned-state" -> dc.provisionedState.toJson,
          "chat-required" -> dc.chatRequired.toJson,
          "chat-userid" -> dc.chatUserId.toJson,
          "chat-password" -> dc.chatPassword.toJson,
          "crlf-required" -> dc.crlfRequired.toJson,
          "craft" -> dc.craft.toJson,
          "subtended-node" -> dc.subtendedNode.toJson,
          "last-inventory-synchronization-timestamp" -> dc.lastInventorySynchronizationTimestamp.toJson,
          "network-element-template-id" -> dc.networkElementTemplateId.toJson,
          "application-monitors-template-id" -> dc.applicationMonitorsTemplateId.toJson,
          "engineid" -> dc.engineId.toJson,
          "auth-protocol" -> dc.authProtocol.toJson,
          "privacy-protocol" -> dc.privacyProtocol.toJson,
          "tenantName" -> dc.tenantName.toJson,
          "alternate-name" -> dc.alternateName.toJson,
          "bgp-as-identifier" -> dc.bgpAsIdentifier.toJson,
          "ospf-router-id" -> dc.ospfRouterId.toJson,
          "node-action-template-id" -> dc.nodeActionTemplateId.toJson

        )
      }

      def read(value: JsValue): DeviceDetails = {

         val fields = value.asJsObject.fields.toList.map { case (key, value) =>
          if(value == JsNull) (key -> None) else (key -> Some(value))
        }.toMap
        DeviceDetails(fields("parent").map(_.convertTo[DeviceCredentialParent]), fields("administrativeDomain").map(_.convertTo[DeviceCredentialAdministrativeDomain]),
          fields("mediation-server-group").map(_.convertTo[DeviceCredentialParent]), fields("previous-hop").map(_.convertTo[PreviousHop]), fields("object-type").map(_.convertTo[String]),
          fields("name").map(_.convertTo[String]), fields("id").map(_.convertTo[String]), fields("primary-ip").map(_.convertTo[String]),
          fields("userid").map(_.convertTo[String]), fields("password").map(_.convertTo[String]), fields("vendor-name").map(_.convertTo[String]), fields("product-name").map(_.convertTo[String]), fields("product-version").map(_.convertTo[String]),
          fields("profile").map(_.convertTo[String]), fields("office").map(_.convertTo[String]), fields("location").map(_.convertTo[String]), fields("chat-userid").map(_.convertTo[String]), fields("chat-password").map(_.convertTo[String]),
          fields("engineid").map(_.convertTo[String]), fields("application-monitors-template-id").map(_.convertTo[String]),
          fields("network-element-template-id").map(_.convertTo[String]),
          fields("node-action-template-id").map(_.convertTo[String]),
          fields("primary-port").map(_.convertTo[Int]),
          fields("subtended-node").map(_.convertTo[String]), fields("last-inventory-synchronization-timestamp").map(_.convertTo[String]),
          fields("protocol").map(_.convertTo[String]), fields("connection-state").map(_.convertTo[String]), fields("device-type").map(_.convertTo[String]),
          fields("connection-type").map(_.convertTo[String]), fields("provisioned-state").map(_.convertTo[String]), fields("auth-protocol").map(_.convertTo[String]),
          fields("privacy-protocol").map(_.convertTo[String]), fields("chat-required").map(_.convertTo[Boolean]), fields("crlf-required").map(_.convertTo[Boolean]), fields("SSHuserid").map(_.convertTo[String]), Some(""),
          fields("session").map(_.convertTo[String]), fields("tenantName").map(_.convertTo[String]), fields("bgp-as-identifier").map(_.convertTo[String]), fields("ospf-router-id").map(_.convertTo[String]),
          fields("alternate-name").map(_.convertTo[String]), fields("xid").map(_.convertTo[String]), fields("availability-state").map(_.convertTo[String]), fields("secondary-ip").map(_.convertTo[String]), fields("secondary-port").map(_.convertTo[String]),
          fields("longitude").map(_.convertTo[Double]), fields("latitude").map(_.convertTo[Double]), fields("description").map(_.convertTo[String]), fields("craft").map(_.convertTo[String]),
          fields("availabilitystate-required").map(_.convertTo[Boolean]))
      }
    }
  }

  import DeviceDetails._

  val json = """[{"name":"Do not delete","id":"a0cca2f5-185d-4d68-b929-918df30020dc","primary-ip":"10.10.10.10","primary-port":443,"protocol":"Tl1","session":"Telnet","userid":null,"SSHuserid":null,"password":null,"SSHpassword":null,"connection-state":"Unknown","vendor-name":null,"device-type":"Unknown","product-name":null,"product-version":null,"profile":null,"connection-type":"Direct","office":null,"location":null,"xid":null,"availabilitystate-required":false,"availability-state":"Available","secondary-ip":null,"secondary-port":null,"longitude":0,"latitude":0,"description":null,"provisioned-state":"Managed","chat-required":false,"chat-userid":null,"chat-password":null,"crlf-required":false,"craft":null,"subtended-node":null,"mediation-server-group":{"id":"f4557090-46a1-4dcf-acf5-e6ae0ae1cff0","name":"med","object-type":"mediation-server-group"},"last-inventory-synchronization-timestamp":null,"network-element-template-id":"070ebf2c-8a1d-4df0-8070-f9acb79a7786","application-monitors-template-id":"c9f3a00d-11f7-43dc-8a3c-2c871f538e21","engineid":"","auth-protocol":null,"privacy-protocol":null,"tenantName":null,"previous-hop":{"id":null,"name":null,"object-type":"network-element"},"alternate-name":"","bgp-as-identifier":null,"ospf-router-id":null,"node-action-template-id":"be100ea8-1e63-4441-aee1-a16af92753c4","parent":{"name":"test_discovery","id":"1f0158d8-c50c-4ec0-b1d1-7216721a2115","object-type":"subnetwork"},"administrativeDomain":{"name":"Default","object-type":"administrative-domain"},"object-type":"network-element"}]"""
  val x: List[DeviceDetails] = json.parseJson.convertTo[List[DeviceDetails]]

  println(x)
  val res: List[DeviceDetails] = x.map
  { x =>
    x.copy(sSHuserid = Some("root"), sSHpassword = Some("123paswword"))
  }

  println(res.toJson)
}


//}