sealed trait Orientation
case object NORTH extends Orientation
case object EAST extends Orientation
case object SOUTH extends Orientation
case object WEST extends Orientation

object Orientation {
  def fromString(s: String): Orientation = s match {
    case "NORTH" => NORTH
    case "EAST"  => EAST
    case "SOUTH" => SOUTH
    case "WEST"  => WEST
  }
}
