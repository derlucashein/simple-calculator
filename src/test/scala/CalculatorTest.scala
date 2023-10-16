import org.scalatest.flatspec.*
import org.scalatest.matchers.*



class CalculatorTest extends AnyFlatSpec with should.Matchers{

  def checkDoubleWithTolerance(left: Double, right: Double): org.scalatest.Assertion = {
    left shouldBe (right +- 0.001)
  }

  "A Calculator" should "add two doubles correctly" in {
    val calculator = new Calculator()
    val a: Double = 2.0
    val b: Double = 3.3

    checkDoubleWithTolerance(calculator.add(a,b), 5.3)
  }

  "A Calculator" should "subtract two doubles correctly" in {
    val calculator = new Calculator()
    val a: Double = 2.1
    val b: Double = 4.1

    checkDoubleWithTolerance(calculator.sub(a,b), -2.0)
  }

  "A Calculator" should "multiply two doubles correctly" in {
    val calculator = new Calculator()
    val a: Double = 3.1
    val b: Double = 5.1

    checkDoubleWithTolerance(calculator.mul(a,b), 15.81)
  }

  "A Calculator" should "divide two doubles correctly with b != 0" in {
    val calculator = new Calculator()
    val a: Double = 10.0
    val b: Double = 5.0

    val res: Option[Double] = calculator.div(a,b)

    res shouldBe (Some(2.0))
  }

  "A Calculator" should "divide two doubles correctly with b = 0" in {
    val calculator = new Calculator()
    val a: Double = 10.0
    val b: Double = 0.0

    val res: Option[Double] = calculator.div(a, b)

    res shouldBe (None)
  }

}
