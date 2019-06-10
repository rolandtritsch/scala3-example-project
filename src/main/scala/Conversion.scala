import scala.language.implicitConversions

/**
  *  Conversions: http://dotty.epfl.ch/docs/reference/contextual/conversions.html
  */
object Conversion {

  case class IntWrapper(a: Int) extends AnyVal
  case class DoubleWrapper(b: Double) extends AnyVal

  def convert[T, U](x: T) given (converter: Conversion[T, U]): U = converter(x)

  delegate IntWrapperToDoubleWrapper for Conversion[IntWrapper, DoubleWrapper] = new Conversion[IntWrapper, DoubleWrapper] {
    override def apply(i: IntWrapper): DoubleWrapper = new DoubleWrapper(i.a.toDouble)
  }

  def useConversion given (f: Conversion[IntWrapper, DoubleWrapper]) = {
    val y: IntWrapper = new IntWrapper(4)
    val x: DoubleWrapper = y
    x
  }

  /* Not working anymore.
    def useConversion(implicit f: A => B) = {
      val y: A = ...
      val x: B = a    // error under Dotty
    }
   */

  def test: Unit = {
    println(useConversion)
    println(convert(new IntWrapper(42)))
  }



}
