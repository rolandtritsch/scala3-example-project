import minitest._
import minitest.laws.Checkers
import StructuralTypes._

object StructuralTypesSuite extends SimpleTestSuite with Checkers {
  test("good access") {
    assertEquals(person.age, 42)
  }

  test("bad access") {
    intercept[NoSuchElementException] {
      invalidPerson.age
    }
    assert(true)
  }
}
