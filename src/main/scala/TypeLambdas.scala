/**
  * Type Lambdas: https://dotty.epfl.ch/docs/reference/new-types/type-lambdas.html
  */
object TypeLambdas {

  type T[+X, Y] = Map[Y, X]

  type Tuple = [X] =>> (X, X)

  def test: Unit = {
    val `map`: T[String, Int] = Map(1 -> "1")
    println(`map`)

    val `tuple`: Tuple[String] = ("a", "b")
    println(`tuple`)
  }

}
