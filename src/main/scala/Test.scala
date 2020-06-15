import generated.Address
import generated.`package`.defaultScope

import scala.xml.Elem

object Main extends App {

  case class RootInterface1(
                            objectType: String,
                            name: String,
                            id: String,
                            primaryIp: String,
                            userId: String,
                            password: String,
                            vendorName: String,
                            productName: String,
                            productVersion: String,
                            profile: String,
                            office: String,
                            location: String,
                            chatUserId: String,
                            chatPassword: String,
                            engineId: String,
                            authPassword: String,
                            privacyPassword: String,
                            applicationMonitorsTemplateId: String,
                            networkElementTemplateId: String,
                            nodeActionTemplateId: String
                          )

  case class PreviousHop(objectType: String, id: String, name: String)

  case class MediationServerGroup(objectType: String, id: String, name: String)

  case class AdministrativeDomain(
                                   objectType: String,
                                   id: String,
                                   name: String
                                 )

  case class Parent(
                     objectType: String,
                     id: String
                   )

  case class RootInterface2 (
  primaryPort: Int,
  subtendedNode: String,
  lastSynchronizationTimestamp: String,
  lastInventorySynchronizationTimestamp: String,
  protocol: String,
  connectionState: String,
  deviceType: String,
  connectionType: String,
  provisionedState: String,
  securityLevel: String,
  authProtocol: String,
  privacyProtocol: String,
  chatRequired: Boolean,
  crlfRequired: Boolean,
  SSHuserid: String,
  SSHpassword: String,
  session: String,
  tenantName: String,
  bgpAsIdentifier: String,
  ospfRouterId: String,
  alternateName: String,
  xid: String,
  availabilityState: String,
  secondaryIp: String,
  secondaryPort: String,
  longitude: Int,
  latitude: Int,
  description: String,
  craft: String,
  availabilityStateRequired: Boolean
  )



}