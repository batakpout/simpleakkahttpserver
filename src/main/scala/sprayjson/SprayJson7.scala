package sprayjson

import spray.json.DefaultJsonProtocol._
import spray.json._

object SprayJson7 extends App {

  case class DeviceCredentialParent(objectType: String, id: String)

  case class DeviceCredentialAdministrativeDomain(objectType: String, id: String, name: String)

  case class DeviceCredentialMediationServerGroup(objectType: String, id: String, name: String)

  case class PreviousHop(objectType: String, id: String, name: String)

  case class DeviceCredentials(dcParent: DeviceCredentialParent, dcAdminDomain: DeviceCredentialAdministrativeDomain,
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

  implicit val deviceCredentialParentFormat = new RootJsonFormat[DeviceCredentialParent] {
    def write(dcParent: DeviceCredentialParent): JsValue = {
      JsObject(
        "object-type" -> dcParent.objectType.toJson,
        "id" -> dcParent.id.toJson
      )
    }

    def read(value: JsValue): DeviceCredentialParent = {
      val fields = value.asJsObject.fields
      DeviceCredentialParent(fields("object-type").convertTo[String], fields("id").convertTo[String])
    }
  }

  implicit val deviceCredentialAdministrativeDomainFormat = new RootJsonFormat[DeviceCredentialAdministrativeDomain] {
    def write(deviceCredentialAdministrativeDomain: DeviceCredentialAdministrativeDomain): JsValue = {
      JsObject(
        "object-type" -> deviceCredentialAdministrativeDomain.objectType.toJson,
        "id" -> deviceCredentialAdministrativeDomain.id.toJson,
        "name" -> deviceCredentialAdministrativeDomain.name.toJson
      )
    }

    def read(value: JsValue): DeviceCredentialAdministrativeDomain = {
      val fields = value.asJsObject.fields
      DeviceCredentialAdministrativeDomain(fields("object-type").convertTo[String], fields("id").convertTo[String], fields("name").convertTo[String])
    }
  }

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

  implicit val deviceCredentialsFormat = new RootJsonFormat[DeviceCredentials] {
    def write(dc: DeviceCredentials): JsValue = {
      JsObject(
        "object-type" -> dc.objectType,
        "name" -> dc.name,
        "id" -> dc.id,
        "primary-ip" -> dc.primaryIp,
        "userid" -> dc.userId,
        "password" -> dc.password,
        "vendor-name" -> dc.vendorName,
        "product-name" -> dc.productName,
        "product-version" -> dc.productVersion,
        "profile" -> dc.profile,
        "office" -> dc.office,
        "location" -> dc.location,
        "chat-userid" -> dc.chatUserId,
        "chat-password" -> dc.chatPassword,
        "engineid" -> dc.engineId,
        "auth-password" -> dc.authPassword,
        "privacy-password" -> dc.privacyPassword,
        "application-monitors-template-id" -> dc.applicationMonitorsTemplateId,
        "network-element-template-id" -> dc.networkElementTemplateId,
        "node-action-template-id" -> dc.nodeActionTemplateId,
        "parent" -> dc.dcParent.toJson,
        "administrativeDomain" -> dc.dcAdminDomain.toJson,
        "primary-port" -> dc.primaryPort,
        "subtended-node" -> dc.subtendedNode,
        "mediation-server-group" -> dc.dcMediationServerGroup.toJson,
        "lastSynchronizationTimestamp" -> dc.lastSynchronizationTimestamp,
        "last-inventory-synchronization-timestamp" -> dc.lastInventorySynchronizationTimestamp,
        "protocol" -> dc.protocol,
        "connection-state" -> dc.connectionState,
        "device-type" -> dc.deviceType,
        "connection-type" -> dc.connectionType,
        "provisioned-state" -> dc.provisionedState,
        "security-level" -> dc.securityLevel,
        "auth-protocol" -> dc.authProtocol,
        "privacy-protocol" -> dc.privacyProtocol,
        "chat-required" -> dc.chatRequired,
        "crlf-required" -> dc.crlfRequired,
        "SSHuserid" -> dc.sSHuserid,
        "SSHpassword" -> dc.sSHpassword,
        "session" -> dc.session,
        "tenantName" -> dc.tenantName,
        "previous-hop" -> dc.previousHop.toJson,
        "bgp-as-identifier" -> dc.bgpAsIdentifier,
        "ospf-router-id" -> dc.ospfRouterId,
        "alternate-name" -> dc.alternateName,
        "xid" -> dc.xid,
        "availability-state" -> dc.availabilityState,
        "secondary-ip" -> dc.secondaryIp,
        "secondary-port" -> dc.secondaryPort,
        "longitude" -> dc.longitude,
        "latitude" -> dc.latitude,
        "description" -> dc.description,
        "craft" -> dc.craft,
        "availabilitystate-required" -> dc.availabilityStateRequired
      )
    }

    def read(value: JsValue): DeviceCredentials = {
      val fields = value.asJsObject.fields
      DeviceCredentials(fields("parent").convertTo[DeviceCredentialParent], fields("administrativeDomain").convertTo[DeviceCredentialAdministrativeDomain],
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
        fields("connection-typ").convertTo[String], fields("provisioned-state").convertTo[String], fields("security-level").convertTo[String], fields("auth-protocol").convertTo[String],
        fields("privacy-protocol").convertTo[String], fields("chat-required").convertTo[Boolean], fields("crlf-required").convertTo[Boolean], fields("SSHuserid").convertTo[String], fields("SSHpassword").convertTo[String],
        fields("session").convertTo[String], fields("tenantName").convertTo[String],, fields("bgp-as-identifier").convertTo[String], fields("ospf-router-id").convertTo[String],
        fields("alternate-name").convertTo[String], fields("xid").convertTo[String], fields("availability-state").convertTo[String], fields("secondary-ip").convertTo[String], fields("secondary-port").convertTo[String],
        fields("longitude").convertTo[Double], fields("latitude").convertTo[Double], fields("description").convertTo[String], fields("craft").convertTo[String],
        fields("availabilitystate-required").convertTo[Boolean])
    }
  }

  val json = """[{"object-type":"o1","name":"d1","parent":{"object-type":"subnetwork","id":"743ac2e3-150f-4eb0-b2e2-b8e19bcb7f1a"},"administrativeDomain":{"object-type":"administrative-domain","id":"743ac2e3-150f-4eb0-b2e2-b8e19bcb7f1a","name":"Default"},"mediation-server-group":{"object-type":"mediation-server-group","id":"743ac2e3-150f-4eb0-b2e2-b8e19bcb7f1a","name":"med"},"previous-hop":{"object-type":"network-element","id":"","name":""}}]"""
  println(json.parseJson.convertTo[List[DeviceCredentials]])

}