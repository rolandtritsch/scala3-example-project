import minitest._
import minitest.laws.Checkers
import UnionTypes._

object UnionTypesSuite extends SimpleTestSuite with Checkers {

  test("safeDivide - Success") {
    assertEquals(safeDivide(4, 2), Success(2.0))
  }

  test("safeDivide - Fail") {
    assertEquals(safeDivide(4, 0), DivisionByZero("DivisionByZeroException"))
  }
}
