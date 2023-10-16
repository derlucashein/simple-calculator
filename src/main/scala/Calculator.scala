class Calculator {
  def add(a: Double, b: Double): Double = a + b
  def sub(a: Double, b: Double): Double = a-b
  def mul(a: Double, b: Double): Double = a*b
  def div(a: Double, b: Double): Option[Double] =
    b match
      case 0 => None
      case bb => Some(a / bb)

  def calc(op: String, a: Double, b: Double): Option[Double] =
    op match
      case "+" => Some(add(a,b))
      case "-" => Some(sub(a,b))
      case "*" => Some(mul(a,b))
      case "/" => div(a,b)
      case _ => None
}