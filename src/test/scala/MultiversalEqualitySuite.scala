import minitest._
import minitest.laws.Checkers
import MultiversalEquality._

import scala.language.strictEquality

object MultiversalEqualitySuite extends SimpleTestSuite with Checkers {
  test("Int - String") {
    given CanEqual[Int, String] = CanEqual.derived
    check1((i: Int) => {
      i != i.toString
    })
  }

  test("Int - Double") {
    check1((i: Int) => {
      i == i.toDouble
    })
  }

  test("List - Vector") {
    check1((l: List[Int]) => l == l.toVector)
  }

  test("A - B") {
    class A(a: Int)
    class B(b: Int)

    val a = new A(4)
    val b = new B(4)

    given CanEqual[A, B] = CanEqual.derived
    given CanEqual[B, A] = CanEqual.derived

    assert(a != b)
    assert(b != a)
  }
}
