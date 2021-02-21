import minitest._
import minitest.laws.Checkers
import TypeLambdas._

object TypeLambdasSuite extends SimpleTestSuite with Checkers {
  test("map") {
    val `map`: T[String, Int] = Map(1 -> "1")
    assertEquals(`map`, Map(1 -> "1"))
  }
    
  test("tuple") {
    val `tuple`: Tuple[String] = ("a", "b")
    assertEquals(`tuple`, ("a", "b"))
  }
}
