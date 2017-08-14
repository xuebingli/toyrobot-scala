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
    val robot = Robot(board.width - 1, -1, EAST, board)
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

  "A robot" should "report its x, y, and orientation" in new GameBoard {
    val robot = Robot(1, 2, EAST, board)
    assert(robot.get.toString === "1, 2, EAST")
  }

  "A robot facing NORTH" should "turn left to WEST" in new GameBoard {
    val robot = Robot(1, 1, NORTH, board)
    assert(robot.map(_.left).get.orientation == WEST)
  }

  "A robot facing EAST" should "turn left to NORTH" in new GameBoard {
    val robot = Robot(1, 1, EAST, board)
    assert(robot.map(_.left).get.orientation == NORTH)
  }

  "A robot facing SOUTH" should "turn left to EAST" in new GameBoard {
    val robot = Robot(1, 1, SOUTH, board)
    assert(robot.map(_.left).get.orientation == EAST)
  }

  "A robot facing WEST" should "turn left to SOUTH" in new GameBoard {
    val robot = Robot(1, 1, WEST, board)
    assert(robot.map(_.left).get.orientation == SOUTH)
  }
}
