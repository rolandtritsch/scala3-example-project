import minitest._
import minitest.laws.Checkers
import GivenInstances._

import scala.util.Success

object GivenInstancesSuite extends SimpleTestSuite with Checkers {
  test("summon - empty string") {
    assertEquals(summon[StringParser[Option[Int]]].parse(""), Success(None))
  }

  test("summon - good integer") {
    check1((i: Int) => summon[StringParser[Option[Int]]].parse(s"${i}") == Success(Some(i)))
  }

  test("summon - bad integer") {
    check2((i: Int, s: String) => summon[StringParser[Option[Int]]].parse(s"${i}${s}x").isFailure)
  }

  test("summon - good integer (with custom parser)") {
    check1((x: Int) => summon[StringParser[Option[Int]]](using StringParser.optionParser[Int]).parse("42") == Success(Some(42)))
  }
}
