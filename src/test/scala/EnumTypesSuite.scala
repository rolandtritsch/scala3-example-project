import minitest._
import EnumTypes._

object EnumTypesSuite extends SimpleTestSuite {
  test("calculateEarthWeightOnPlanets") {
    val expected = List(37.775761520093525, 90.49990998410455, 100.0, 37.873718403712886, 253.05575254957407, 106.60155388115666, 90.51271993894251, 113.83280724696579)
    assertEquals(calculateEarthWeightOnPlanets(100), expected)
  }
}
