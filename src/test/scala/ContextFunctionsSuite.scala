import minitest._
import ContextFunctions._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.language.postfixOps

object ContextFunctionsSuite extends SimpleTestSuite {
  import ExecutionContext.Implicits.global

  test("context - asyncSum") {
    val result = Await.result(context.asyncSum(3, 4), 10 seconds)
    assertEquals(result, 7)
  }
 
  test("context - asyncMul") {
    val result = Await.result(context.asyncMult(3, 4), 10 seconds)
    assertEquals(result, 12)
  }

  test("parse - sumStrings") {
    val result = parse.sumStrings("3", "4").get
    assertEquals(result, 7)
  }

  test("parse - sumStrings (bad)") {
    val result = parse.sumStrings("3", "a")
    assert(result.isFailure)
  }
}
