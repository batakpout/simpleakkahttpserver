 package generated

trait Addressable {
  def name: String
  def street: String
  def city: String
}


case class Address(name: String,
  street: String,
  city: String) extends Addressable
      


case class USAddress(name: String,
  street: String,
  city: String,
  state: String,
  zip: BigInt) extends Addressable
      

