import scala.sys.process._
import akka.actor._

/*class RunModel {
  val actorSystem = ActorSystem("ActorSystem")
  val actor = actorSystem.actorOf(Props[RunModelActor], "RunModelActor")
  actor ! RUNMODEL
}*/

class RunModelActor extends Actor {
  def receive = {
    case RUNMODEL => {
      runModel
    }
  }

  def runModel = {

    println("=====================From runModel Method========================")
    val userName = "zettasys"
    val password = "password"
    val projectId = "475"
    val jobId = "63f6c9e4-21ac-4823-a469-98e0cae8f6a1"
    val ngrams = "80"
    val scriptFileName = s"runzettasense.sh"
    val runModelScript = "/var/lib/zettasense/" + scriptFileName

    val command = s"bash $runModelScript $userName $password $projectId $jobId $ngrams"

    println("Running from akka-http server command:==> " + command)
    command.!!

    println("========================Done Running runModel Command=======================")

  }
}

case object RUNMODEL