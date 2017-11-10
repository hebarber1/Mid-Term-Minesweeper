//Game engine:
//1. Gets the cell entered by the user and performs the action selected
//2. Keeps track of the number of bombs uncovered
//3. Checks if the user has won (uncovered all actual bombs)

public class GameEngine {

	private int bombFlagCount; // number of bombs flagged by the user
	private int actualBombsRemaining; // number of actual bombs on the board minus actual bombs flagged
	private Board mineBoard;

	// Constructor for the game engine
	public GameEngine(Board board) {
		mineBoard = board;
		bombFlagCount = 0; // TODO: countHowManyMines()
		actualBombsRemaining = 0; // TODO: countHowManyMines()
	}

	// Places a flag (bomb or question) on the cell selected by the user
	public void flagCell(Cell cellSelected, String typeOfFlag) {
		if (typeOfFlag == "F") {
			cellSelected.setFlag(Flag.BOMB);
			cellSelected.setDisplay("*");
			bombFlagCount--;

			// Check if the cell actually has a bomb. If it does, decrease remaining bombs.
			if (cellSelected.isHasMine()) {
				actualBombsRemaining--;
			}
		} else if (typeOfFlag == "Q") {
			cellSelected.setFlag(Flag.QUESTION);
			cellSelected.setDisplay("?");
		}
	}

	// This method is called when the user selects to uncover a cell. It checks the
	// cell and performs the applicable action
	public void uncoverCell(Cell cellSelected) {
		if (cellSelected.isHasMine()) {
			System.out.println("Game over!");
			uncoverAllCells();
		} else if (cellSelected.getNumberOfSurroundingMines() >= 1) {
			cellSelected.changeCover(); // if cell has a number of mines, it uncovers only that cell
		} else if (cellSelected.getNumberOfSurroundingMines() == 0) {
			uncoverSurroundingCells();
		}
	}

	// This method returns true if all the actual bombs have been flagged by the
	// user
	public boolean hasWon() {
		return actualBombsRemaining == 0;
	}

	// This method will be called when the user uncovers an empty cell to determine
	// what surrounding cells need to be uncovered
	// TODO Need method to get cell from board
	public void uncoverSurroundingCells() {

	}

	// This method will be called when the user clicks on a bomb and the game is
	// over
	// It will uncover the entire board
	// TODO Need method to get cell from board
	public void uncoverAllCells() {

	}
}
