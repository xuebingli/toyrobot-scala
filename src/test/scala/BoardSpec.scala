import org.scalatest.FlatSpec

class BoardSpec extends FlatSpec {

  "A new board" should "default height to 5" in {
    val board = new Board()
    assert(board.height === 5)
  }

  "A new board" should "default width to 5" in {
    val board = new Board()
    assert(board.width === 5)
  }
}
