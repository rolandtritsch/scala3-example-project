/**
  * Trait Parameters: https://dotty.epfl.ch/docs/reference/other-new-features/trait-parameters.html
  */
object TraitParams {

  trait Base(val msg: String)
  class A extends Base("Hello")
  class B extends Base("Dotty!")

  // Union types only exist in Dotty, so there's no chance that this will accidentally be compiled with Scala 2
  def printMessages(msgs: (A | B)*) = msgs.map(_.msg).mkString(" ")

  def test: Unit = {
    println(printMessages(new A, new B))

    // Sanity check the classpath: this won't run if the dotty jar is not present.
    val x: Int => Int = z => z
    x(1)
  }

}
