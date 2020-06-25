package sprayjson

import spray.json.DefaultJsonProtocol._
import spray.json._

object Backup extends App {

  case class DeviceCredentialParent(objectType: String, id: String, name: String)

  case class DeviceCredentialAdministrativeDomain(objectType: String, name: String)

  case class DeviceCredentialMediationServerGroup(objectType: String, id: String, name: String)

  case class PreviousHop(objectType: String, id: String, name: String)

  case class DeviceDetails(dcParent: DeviceCredentialParent, dcAdminDomain: DeviceCredentialAdministrativeDomain,
                           dcMediationServerGroup: DeviceCredentialMediationServerGroup,
                           previousHop: PreviousHop, objectType: String, name: String, id: String, primaryIp: String, userId: String, password: String,
                           vendorName: String, productName: String, productVersion: String, profile: String, office: String, location: String,
                           chatUserId: String, chatPassword: String, engineId: String, authPassword: String, privacyPassword: String,
                           applicationMonitorsTemplateId: String, networkElementTemplateId: String, nodeActionTemplateId: String,
                           primaryPort: Int, subtendedNode: String, lastSynchronizationTimestamp: String,
                           lastInventorySynchronizationTimestamp: String, protocol: String, connectionState: String, deviceType: String,
                           connectionType: String, provisionedState: String, securityLevel: String, authProtocol: String,
                           privacyProtocol: String, chatRequired: Boolean, crlfRequired: Boolean, sSHuserid: String, sSHpassword: String,
                           session: String, tenantName: String, bgpAsIdentifier: String, ospfRouterId: String, alternateName: String,
                           xid: String, availabilityState: String, secondaryIp: String, secondaryPort: String, longitude: Double, latitude: Double,
                           description: String, craft: String, availabilityStateRequired: Boolean)

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
        val fields = value.asJsObject.fields
        DeviceCredentialParent(fields("object-type").convertTo[String], fields("id").convertTo[String], fields("name").convertTo[String])
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
        val fields = value.asJsObject.fields
        DeviceCredentialAdministrativeDomain(fields("object-type").convertTo[String], fields("name").convertTo[String])
      }
    }
  }

  object DeviceCredentialMediationServerGroup {
    implicit val deviceCredentialMediationServerGroupFormat = new RootJsonFormat[DeviceCredentialMediationServerGroup] {
      def write(deviceCredentialMediationServerGroup: DeviceCredentialMediationServerGroup): JsValue = {
        JsObject(
          "object-type" -> deviceCredentialMediationServerGroup.objectType.toJson,
          "id" -> deviceCredentialMediationServerGroup.id.toJson,
          "name" -> deviceCredentialMediationServerGroup.name.toJson
        )
      }

      def read(value: JsValue): DeviceCredentialMediationServerGroup = {
        val fields = value.asJsObject.fields
        DeviceCredentialMediationServerGroup(fields("object-type").convertTo[String], fields("id").convertTo[String], fields("name").convertTo[String])
      }
    }
  }

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
        val fields = value.asJsObject.fields
        PreviousHop(fields("object-type").convertTo[String], fields("id").convertTo[String], fields("name").convertTo[String])
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
          "userid" -> dc.userId.toJson,
          "password" -> dc.password.toJson,
          "vendor-name" -> dc.vendorName.toJson,
          "product-name" -> dc.productName.toJson,
          "product-version" -> dc.productVersion.toJson,
          "profile" -> dc.profile.toJson,
          "office" -> dc.office.toJson,
          "location" -> dc.location.toJson,
          "chat-userid" -> dc.chatUserId.toJson,
          "chat-password" -> dc.chatPassword.toJson,
          "engineid" -> dc.engineId.toJson,
          "auth-password" -> dc.authPassword.toJson,
          "privacy-password" -> dc.privacyPassword.toJson,
          "application-monitors-template-id" -> dc.applicationMonitorsTemplateId.toJson,
          "network-element-template-id" -> dc.networkElementTemplateId.toJson,
          "node-action-template-id" -> dc.nodeActionTemplateId.toJson,
          "primary-port" -> dc.primaryPort.toJson,
          "subtended-node" -> dc.subtendedNode.toJson,
          "lastSynchronizationTimestamp" -> dc.lastSynchronizationTimestamp.toJson,
          "last-inventory-synchronization-timestamp" -> dc.lastInventorySynchronizationTimestamp.toJson,
          "protocol" -> dc.protocol.toJson,
          "connection-state" -> dc.connectionState.toJson,
          "device-type" -> dc.deviceType.toJson,
          "connection-type" -> dc.connectionType.toJson,
          "provisioned-state" -> dc.provisionedState.toJson,
          "security-level" -> dc.securityLevel.toJson,
          "auth-protocol" -> dc.authProtocol.toJson,
          "privacy-protocol" -> dc.privacyProtocol.toJson,
          "chat-required" -> dc.chatRequired.toJson,
          "crlf-required" -> dc.crlfRequired.toJson,
          "SSHuserid" -> dc.sSHuserid.toJson,
          "SSHpassword" -> dc.sSHpassword.toJson,
          "session" -> dc.session.toJson,
          "tenantName" -> dc.tenantName.toJson,
          "bgp-as-identifier" -> dc.bgpAsIdentifier.toJson,
          "ospf-router-id" -> dc.ospfRouterId.toJson,
          "alternate-name" -> dc.alternateName.toJson,
          "xid" -> dc.xid.toJson,
          "availability-state" -> dc.availabilityState.toJson,
          "secondary-ip" -> dc.secondaryIp.toJson,
          "secondary-port" -> dc.secondaryPort.toJson,
          "longitude" -> dc.longitude.toJson,
          "latitude" -> dc.latitude.toJson,
          "description" -> dc.description.toJson,
          "craft" -> dc.craft.toJson,
          "availabilitystate-required" -> dc.availabilityStateRequired.toJson
        )
      }

      def read(value: JsValue): DeviceDetails = {
        val fields = value.asJsObject.fields
        DeviceDetails(fields("parent").convertTo[DeviceCredentialParent], fields("administrativeDomain").convertTo[DeviceCredentialAdministrativeDomain],
          fields("mediation-server-group").convertTo[DeviceCredentialMediationServerGroup], fields("previous-hop").convertTo[PreviousHop], fields("object-type").convertTo[String],
          fields("name").convertTo[String], fields("id").convertTo[String], fields("primary-ip").convertTo[String],
          fields("userid").convertTo[String], fields("password").convertTo[String], fields("vendor-name").convertTo[String], fields("product-name").convertTo[String], fields("product-version").convertTo[String],
          fields("profile").convertTo[String], fields("office").convertTo[String], fields("location").convertTo[String], fields("chat-userid").convertTo[String], fields("chat-password").convertTo[String],
          fields("engineid").convertTo[String], fields("auth-password").convertTo[String], fields("privacy-password").convertTo[String], fields("application-monitors-template-id").convertTo[String],
          fields("network-element-template-id").convertTo[String],
          fields("node-action-template-id").convertTo[String],
          fields("primary-port").convertTo[Int],
          fields("subtended-node").convertTo[String],
          fields("lastSynchronizationTimestamp").convertTo[String], fields("last-inventory-synchronization-timestamp").convertTo[String],
          fields("protocol").convertTo[String], fields("connection-state").convertTo[String], fields("device-type").convertTo[String],
          fields("connection-type").convertTo[String], fields("provisioned-state").convertTo[String], fields("security-level").convertTo[String], fields("auth-protocol").convertTo[String],
          fields("privacy-protocol").convertTo[String], fields("chat-required").convertTo[Boolean], fields("crlf-required").convertTo[Boolean], fields("SSHuserid").convertTo[String], fields("SSHpassword").convertTo[String],
          fields("session").convertTo[String], fields("tenantName").convertTo[String], fields("bgp-as-identifier").convertTo[String], fields("ospf-router-id").convertTo[String],
          fields("alternate-name").convertTo[String], fields("xid").convertTo[String], fields("availability-state").convertTo[String], fields("secondary-ip").convertTo[String], fields("secondary-port").convertTo[String],
          fields("longitude").convertTo[Double], fields("latitude").convertTo[Double], fields("description").convertTo[String], fields("craft").convertTo[String],
          fields("availabilitystate-required").convertTo[Boolean])
      }
    }
  }

  import DeviceDetails._
  val json = """[{"object-type":"network-element","name":"FTPRSDEA01M","id":"f103fb11-20a1-4217-8e77-32b761bf9225","primary-ip":"192.168.1.47","userid":"","password":"","vendor-name":"Nicira, Inc.","product-name":"Open vSwitch","product-version":"2.3.1-git4750c96","profile":"open-vswitch","office":"","location":"","chat-userid":"","chat-password":"","engineid":"","auth-password":"","privacy-password":"","application-monitors-template-id":"e30bd3ae-9764-484e-aaee-bf8471d55616","network-element-template-id":"c3869363-9d01-491f-b727-8969d489cefa","node-action-template-id":"5a3efef8-b0fb-4b7b-a2db-2e3742fe6c90","parent":{"object-type":"subnetwork","id":"743ac2e3-150f-4eb0-b2e2-b8e19bcb7f1a"},"administrativeDomain":{"object-type":"administrative-domain","id":"743ac2e3-150f-4eb0-b2e2-b8e19bcb7f1a","name":"Default"},"primary-port":80,"subtended-node":"","mediation-server-group":{"object-type":"mediation-server-group","id":"743ac2e3-150f-4eb0-b2e2-b8e19bcb7f1a","name":"med"},"lastSynchronizationTimestamp":"Thu July 21 16:26:09 IST 2016","last-inventory-synchronization-timestamp":"Thu July 21 16:26:09 IST 2016","protocol":"None","connection-state":"None","device-type":"Cloud Host","connection-type":"Passive","provisioned-state":"Managed","security-level":"","auth-protocol":"","privacy-protocol":"","chat-required":false,"crlf-required":false,"SSHuserid":"","SSHpassword":"","session":"","tenantName":"","previous-hop":{"object-type":"network-element","id":"","name":""},"bgp-as-identifier":"","ospf-router-id":"","alternate-name":"","xid":"","availability-state":"Available","secondary-ip":"null","secondary-port":"null","longitude":0,"latitude":0,"description":"newDes","craft":"null","availabilitystate-required":true}]"""
  val x: List[DeviceDetails] = json.parseJson.convertTo[List[DeviceDetails]]
  println(x)
  val res: List[DeviceDetails] = x.map { x =>
    x.copy(sSHuserid = "root", sSHpassword = "123paswword")
  }


  println(res.toJson)
}



//}
/*
 "auth-password" -> dc.authPassword.toJson,
          "privacy-password" -> dc.privacyPassword.toJson,
          "lastSynchronizationTimestamp" -> dc.lastSynchronizationTimestamp.toJson,
          "security-level" -> dc.securityLevel.toJson,


 //was comming earlier
 */