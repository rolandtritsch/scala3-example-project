import minitest._
import minitest.laws.Checkers
import ParameterUntupling._

object ParameterUntuplingSuite extends SimpleTestSuite with Checkers {
  test("zipIt") {
    assertEquals(zipIt(List("d", "o", "t", "t", "y")), List(("d",0), ("o",1), ("t",2), ("t",3), ("y",4)))
  }
}
