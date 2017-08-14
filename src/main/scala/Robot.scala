case class Robot(x: Int, y: Int, orientation: Orientation, board: Board) {

  override def toString: String = s"$x, $y, $orientation"

  def left: Robot = orientation match {
    case NORTH => this.copy(orientation = WEST)
    case EAST  => this.copy(orientation = NORTH)
    case SOUTH => this.copy(orientation = EAST)
    case WEST  => this.copy(orientation = SOUTH)
  }

  def isOnBoard: Boolean =
    ((0 until board.width) contains x) && ((0 until board.height) contains y)
}

object Robot {
  def apply(x: Int,
            y: Int,
            orientation: Orientation,
            board: Board): Option[Robot] = {
    val robot = new Robot(x, y, orientation, board)
    if (robot.isOnBoard) Some(robot) else None
  }
}
