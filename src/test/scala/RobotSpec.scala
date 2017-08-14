import org.scalatest.FlatSpec

class RobotSpec extends FlatSpec {

  trait GameBoard {
    val board = new Board()
  }

  "A new robot with negative x" should "not be defined" in new GameBoard {
    val robot = Robot(-1, board.height - 1, WEST, board)
    assert(!robot.isDefined)
  }

  "A new robot with too big x" should "not be defined" in new GameBoard {
    val robot = Robot(board.width, board.height - 1, NORTH, board)
    assert(!robot.isDefined)
  }

  "A new robot with negative y" should "not be defined" in new GameBoard {
    val robot = Robot(board.width - 1, - 1, EAST, board)
    assert(!robot.isDefined)
  }

  "A new robot with too big y" should "not be defined" in new GameBoard {
    val robot = Robot(board.width - 1, board.height, SOUTH, board)
    assert(!robot.isDefined)
  }

  "A new robot with appropriate x and y" should "be defined" in new GameBoard {
    val robot = Robot(board.width - 1, board.height - 1, NORTH, board)
    assert(robot.isDefined)
  }
}
