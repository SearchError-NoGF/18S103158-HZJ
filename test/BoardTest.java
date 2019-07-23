import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {
	// 测试其面对位置越界，位置无效等情况的表现
	@Test
	public void testPutPiece() {
		Board B = new Board(GameType.GO.getValue());
		Piece piece1 = new Piece("p1", 1);
		Piece piece2 = new Piece("p2", 1);
		piece1.setPosition(1, 1);
		piece2.setPosition(1000, 1000);
		assertTrue(B.putPiece(piece1));
		assertFalse(B.putPiece(piece1));
		assertFalse(B.putPiece(piece2));
	}

	@Test
	public void testRemovePiece() {
		Board B = new Board(GameType.GO.getValue());
		Player player1 = new Player();
		player1.setPlayerName("Tom");
		player1.setPlayerTurn(0);
		Piece piece1 = new Piece("p2", 1);
		Position pa = new Position(1, 1);
		Position pb = new Position(2, 2);
		piece1.setPosition(1, 1);
		B.putPiece(piece1);
		assertTrue(B.removePiece(player1, pa));
		assertFalse(B.removePiece(player1, pb));
	}

	@Test
	public void testMove() {
		Game game = new Game(GameType.CHESS.getValue());
		Board B = game.getGameBoard();
		Player player1 = new Player();
		player1.setPlayerName("Tom");
		player1.setPlayerTurn(0);
		Position pa = new Position(1, 1);
		Position pb = new Position(2, 2);
		Position pc = new Position(3, 3);
		Position pd = new Position(1000, 1000);
		assertTrue(B.move(player1, pa, pb));
		assertTrue(B.move(player1, pb, pc));
		assertFalse(B.move(player1, pa, pb));
		assertFalse(B.move(player1, pd, pb));

	}

	@Test
	public void testEat() {
		Game game = new Game(GameType.CHESS.getValue());
		Board B = game.getGameBoard();
		Player player1 = new Player();
		player1.setPlayerName("Tom");
		player1.setPlayerTurn(0);
		Position pa = new Position(4, 0);//King0
		Position pb = new Position(4, 7);//King1
		Position pc = new Position(3, 0);//Queen0
		Position pd = new Position(3, 7);//Queen1
		Position pe = new Position(999, 999);
		assertTrue(B.eat(player1, pa, pb));
		assertFalse(B.eat(player1, pb, pc));
		assertTrue(B.eat(player1, pb, pd));
		assertFalse(B.eat(player1, pd, pb));
		assertFalse(B.eat(player1, pe, pb));
	}
}
