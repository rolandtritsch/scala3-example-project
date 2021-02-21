import minitest._
import minitest.laws.Checkers
import TraitParams._

object TraitParamsSuite extends SimpleTestSuite with Checkers {
  test("printMessages") {
    assertEquals(printMessages(new A, new B), "Hello Dotty!")
  }
}
