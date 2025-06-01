package pieces;

public class Space {
	public int x;
	public int y;
	public int num;
	public SuperPiece piece;
	
	public Space(int i, int color) {
		num = i;
		setPiece(color);
	}
	
	public void setPiece(int color) {
		switch (num) {
		case 1:
			piece = new Pawn();
			piece.color = color;
			piece.loadPieceImage("pawn");
			break;
		}
	}
}
