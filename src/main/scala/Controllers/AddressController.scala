package Controllers

import Entities.Employee
import akka.actor.ActorRef
import exceptions.{ErrorCodes, InvalidInputException}
import generated.Address
import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods.parse
import repositories.ImplEmployeeRepository

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}


abstract class AddressControllerComponent {

  def getAddressById(id: String): Future[Address]
  def insertAddress(address: Address): Future[Address]
}

object AddressController extends AddressControllerComponent {

  def getAddressById(id: String): Future[Address] = {
    //from db
    val address = Address("18th main", "btm", "bangalore")
    Future.successful(address)
  }

  def insertAddress(address: Address): Future[Address] = {
    // db insert call
    Future.successful(address)
  }

}
