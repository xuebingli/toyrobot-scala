class Robot(val x: Int,
            val y: Int,
            val orientation: Orientation,
            board: Board) {

  override def toString: String = s"$x, $y, $orientation"

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
