case object Test {
  override def toString = "Test renamed"
}

println(Test)

case class TestCase() {
  def name = "hello"
}
println(TestCase)