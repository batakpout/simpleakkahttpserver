import generated.Address
import generated.`package`.defaultScope

import scala.xml.Elem
object Main extends App {
  /*Example showing conversion of scala case classes to XML*/
  val addressXML: Elem =
    <shipTo xmlns="http://www.example.com/IPO">
      <name>Foo</name>
      <street>1537 Paper Street</street>
      <city>Wilmington</city>
    </shipTo>
  val parsedAddress = scalaxb.fromXML[Address](addressXML)
  println(s"Rendered XML case class is :: ${parsedAddress}")

  /*Example showing conversion of scala case classes to XML*/
  val newAddress = Address(
    name = "221B",
    street = "Bakers Street",
    city = "London"
  )
  val renderedXML = scalaxb.toXML[Address](newAddress, "ShippedTo", defaultScope)
  println(s"Generated XML is :: ${renderedXML}")
}