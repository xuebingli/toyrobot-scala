import scala.io.Source.fromFile
import java.io.{FileNotFoundException, IOException}

object Toyrobot extends App {
  def parsePlaceCommand(command: String): (Int, Int, Orientation) = {
    val Array(x, y, orientation) = command.split(" ").last.split(",")
    return (x.toInt, y.toInt, Orientation.fromString(orientation))
  }

  if (args.length == 1) {
    val board = new Board()
    val filename = args(0)
    try {
      val lines = fromFile(filename).getLines.toList
      lines.foldLeft(None: Option[Robot]) { (robot, command) =>
        command match {
          case c if c == "REPORT" => robot.map(_.report)
          case c if c == "MOVE"   => robot.map(_.move)
          case c if c == "LEFT"   => robot.map(_.left)
          case c if c == "RIGHT"  => robot.map(_.right)
          case c if c.startsWith("PLACE") =>
            val (x, y, orientation) = parsePlaceCommand(c)
            val newRobot = Robot(x, y, orientation, board)
            if (newRobot.nonEmpty) newRobot else robot
        }
      }
    } catch {
      case _: FileNotFoundException => println(s"File not found at $filename")
      case e: IOException           => println(s"IOException $e")
    }
  } else {
    println("Usage: Toyrobot instructions.txt")
    println("Usage: sbt \"run instructions.txt\"")
  }
}
