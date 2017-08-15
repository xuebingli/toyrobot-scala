class Robot(val x: Int,
            val y: Int,
            val orientation: Orientation,
            board: Board) {

  override def toString: String = s"$x, $y, $orientation"

  def copy(x: Int = x,
           y: Int = y,
           orientation: Orientation = orientation,
           board: Board = board): Robot =
    Robot(x, y, orientation, board) getOrElse this

  def move: Robot = orientation match {
    case NORTH => this.copy(y = y + 1)
    case EAST  => this.copy(x = x + 1)
    case SOUTH => this.copy(y = y - 1)
    case WEST  => this.copy(x = x - 1)
  }

  def left: Robot = orientation match {
    case NORTH => this.copy(orientation = WEST)
    case EAST  => this.copy(orientation = NORTH)
    case SOUTH => this.copy(orientation = EAST)
    case WEST  => this.copy(orientation = SOUTH)
  }

  def right: Robot = this.left.left.left

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
