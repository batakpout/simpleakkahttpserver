package sprayjson

object NullTest extends App {

   val x = null

    val xx = Option(x).map(_.toString).getOrElse(1)
   println(xx)
}