import cats.effect.std.Console
import cats.effect.{IO, IOApp}

def program: IO[Unit] =

  val calculator = new Calculator()

  def printToUser(s: String): IO[Unit] = Console[IO].println(s)

  def readLine: IO[String] = Console[IO].readLine

  def evaluate(op: String, a: String, b: String): Option[Double] =
    for
      aa <- a.toDoubleOption
      bb <- b.toDoubleOption
      result <- calculator.calc(op, aa, bb)
    yield(result)

  def calcResult(op: String, a: String, b: String): IO[Unit] =
    evaluate(op, a, b) match
      case Some(x) => printToUser(s"Result $x")
      case _ => printToUser("Error")

  def loop: IO[Unit] =
    for
      _ <- printToUser("Enter first number:")
      a <- readLine
      _ <- printToUser("Enter second number:")
      b <- readLine
      _ <- printToUser("Enter operator:")
      op <- readLine
      _ <- calcResult(op, a, b)
    yield()

  loop


object Main extends IOApp.Simple {
  val run: IO[Unit] = program
}