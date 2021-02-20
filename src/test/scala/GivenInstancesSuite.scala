import minitest._
import GivenInstances._

import scala.util.Success

object GivenInstancesSuite extends SimpleTestSuite {
  test("summon") {
    assertEquals(summon[StringParser[Option[Int]]].parse("21"), Success(Some(21)))
    assertEquals(summon[StringParser[Option[Int]]].parse(""), Success(None))
    assert(summon[StringParser[Option[Int]]].parse("21a").isFailure)

    assertEquals(summon[StringParser[Option[Int]]](using StringParser.optionParser[Int]).parse("42"), Success(Some(42)))
  }
}
