import minitest._
import minitest.laws.Checkers
import ContextFunctions._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.language.postfixOps

object ContextFunctionsSuite extends SimpleTestSuite with Checkers {
  import ExecutionContext.Implicits.global

  test("context - asyncSum") {
    check2((x: Int, y: Int) => {
      Await.result(context.asyncSum(x, y), 10 seconds) == x + y
    })
  }
 
  test("context - asyncMult") {
    check2((x: Int, y: Int) => {
      Await.result(context.asyncMult(x, y), 10 seconds) == x * y
    })
  }

  test("parse - sumStrings") {
    check2((x: Int, y: Int) => {
      parse.sumStrings(x.toString, y.toString).get == x + y
    })
  }
 
  test("parse - sumStrings (bad)") {
    check2((i: Int, s: String) => {
      parse.sumStrings(i.toString, s).isFailure
    })
  }
}
