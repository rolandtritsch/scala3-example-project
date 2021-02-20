import minitest._
import minitest.laws.Checkers
import PatternMatching._

object PatternMatchingSuite extends SimpleTestSuite with Checkers {
  test("evenString") {
    check1((s: String) => {
      evenString(s) == (s.length % 2 == 0)
    })
  }
}
