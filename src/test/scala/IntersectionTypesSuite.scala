import minitest._
import minitest.laws.Checkers
import IntersectionTypes._

object IntersectionTypesSuite extends SimpleTestSuite with Checkers {
  test("euclideanDistance") {
    val p1: P = Point(3, 4)
    val p2: PP = Point(6, 8)

    assertEquals(euclideanDistance(p1, p2), 5.0)
  }
}
