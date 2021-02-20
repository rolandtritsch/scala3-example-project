import minitest._
import minitest.laws.Checkers
import Conversion._

object ConverstionSuite extends SimpleTestSuite with Checkers {
  test("convert") {
    check1((i: Int) => {
      convert(new IntWrapper(i)) == new DoubleWrapper(i.toDouble)
    })
  }

  test("useConversion") {
    assertEquals(useConversion, new DoubleWrapper(4.0))
  }
}
