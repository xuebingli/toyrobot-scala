class Robot(val x: Int,
            val y: Int,
            val orientation: Orientation,
            board: Board) {

  def report: Unit = println(s"$x, $y, $orientation")

  def move: Robot = orientation match {
    case NORTH => copy(y = y + 1)
    case EAST  => copy(x = x + 1)
    case SOUTH => copy(y = y - 1)
    case WEST  => copy(x = x - 1)
  }

  def left: Robot = orientation match {
    case NORTH => copy(orientation = WEST)
    case EAST  => copy(orientation = NORTH)
    case SOUTH => copy(orientation = EAST)
    case WEST  => copy(orientation = SOUTH)
  }

  def right: Robot = this.left.left.left

  private def copy(x: Int = x,
                   y: Int = y,
                   orientation: Orientation = orientation,
                   board: Board = board): Robot =
    Robot(x, y, orientation, board) getOrElse this

  private def isOnBoard: Boolean = {
    ((0 until board.width) contains x) && ((0 until board.height) contains y)
  }
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
