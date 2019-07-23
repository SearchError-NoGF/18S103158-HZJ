import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

//对游戏类进行测试，主要测试用户添加和棋子的添加和删除
public class GameTest {

	public Game gametest =new Game(GameType.GO.getValue());


	@Test
	public void testGetterSetter() {
		gametest.setNames("p1", "p2");
		assertEquals("p1", gametest.getPlayerA().getPlayerName());
		assertEquals("p2", gametest.getPlayerB().getPlayerName());
	}
	@Test
	public void testaddnewPiece() {
		gametest.setNames("p1", "p2");
		Piece testPiece1=new Piece("black",0);
		Piece testPiece2=new Piece("black",0);
		Piece testPiece3=new Piece("white",1);
		Position P1 =new Position(1,1);
		Position P2 =new Position(2,2);
		Position P3 =new Position(3,3);
		gametest.addnewPiece(gametest.getPlayerA(), testPiece1, P1);
		gametest.addnewPiece(gametest.getPlayerA(), testPiece2, P2);
		gametest.addnewPiece(gametest.getPlayerB(), testPiece3, P3);
		assertTrue(gametest.getGameBoard().getBoardSet().contains(testPiece1));
		assertTrue(gametest.getGameBoard().getBoardSet().contains(testPiece2));
		assertTrue(gametest.getGameBoard().getBoardSet().contains(testPiece3));
	}
	@Test
	public void removePiece() {
		gametest.setNames("p1", "p2");
		Piece testPiece1=new Piece("black",0);
		Piece testPiece2=new Piece("black",0);
		Piece testPiece3=new Piece("white",1);
		Position P1 =new Position(1,1);
		Position P2 =new Position(2,2);
		Position P3 =new Position(3,3);
		gametest.addnewPiece(gametest.getPlayerA(), testPiece1, P1);
		gametest.addnewPiece(gametest.getPlayerA(), testPiece2, P2);
		gametest.addnewPiece(gametest.getPlayerB(), testPiece3, P3);
		assertTrue(gametest.getGameBoard().getBoardSet().contains(testPiece1));
		assertTrue(gametest.getGameBoard().getBoardSet().contains(testPiece2));
		assertTrue(gametest.getGameBoard().getBoardSet().contains(testPiece3));

		gametest.removePiece(gametest.getPlayerA(), P1);
		assertTrue(gametest.getGameBoard().getBoardSet().contains(testPiece1));

		gametest.removePiece(gametest.getPlayerB(), P1);
		assertFalse(gametest.getGameBoard().getBoardSet().contains(testPiece1));
	}

}
