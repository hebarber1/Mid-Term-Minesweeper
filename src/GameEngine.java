//Game engine:
//1. Gets the cell entered by the user and performs the action selected
//2. Keeps track of the number of bombs uncovered
//3. Checks if the user has won (uncovered all actual bombs)

public class GameEngine {

	private int bombFlagCount; // number of bombs flagged by the user
	private int actualBombsRemaining; // number of actual bombs on the board minus actual bombs flagged
	private Board board;

	// Constructor for the game engine
	public GameEngine(int level) {
		board = new Board(level);
		bombFlagCount = board.countHowManyMines();
		actualBombsRemaining = board.countHowManyMines();
	}

	// Places a flag (bomb or question) on the cell selected by the user
	public void flagCell(Cell cellSelected, String typeOfFlag) {
		if (typeOfFlag == "F") {
			cellSelected.setFlag(Flag.BOMB);
			bombFlagCount--;

			// Check if the cell actually has a bomb. If it does, decrease remaining bombs.
			if (cellSelected.hasMine()) {
				actualBombsRemaining--;
			}
		} else if (typeOfFlag == "Q") {
			cellSelected.setFlag(Flag.QUESTION);
		}
	}

	// This method is called when the user selects to uncover a cell. It checks the
	// cell and performs
	// the corresponding actions
	public void uncoverCell(Cell cellSelected) {
		if (cellSelected.hasMine()) {
			System.out.println("Game over!");
			// call method to uncover the entire board
			// call method to redisplay the board
		} else if (cellSelected.getNumberOfSurroundingMines() >= 1) {
			cellSelected.changeCover(); // if cell has a number of mines, it uncovers only that cell
			// call method to redisplay the board
		} else if (cellSelected.getNumberOfSurroundingMines() == 0) {
			// call method to uncover all the applicable cells (surrounding empty and
			// numbered)
		}
	}

	// This method returns true if all the actual bombs have been flagged by the
	// user
	public boolean hasWon() {
		return actualBombsRemaining == 0;
	}

	// This method will be called when the user uncovers an empty cell to determine
	// what surrounding
	// cells need to be uncovered
	public void determineCellsToUncover() {

	}
}
