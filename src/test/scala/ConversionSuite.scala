import minitest._
import Conversion._

object ConverstionSuite extends SimpleTestSuite {
  test("convert") {
    assertEquals(convert(new IntWrapper(42)), new DoubleWrapper(42.0))
  }
}
