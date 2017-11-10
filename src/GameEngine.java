
//Game engine:
//1. Gets the cell entered by the user and performs the action selected
//2. Keeps track of the number of actual mines remaining
//3. Keeps track of the number of mine flags remaining
//4. Checks if the user has won (if they have uncovered all actual mines)

public class GameEngine {

	private int numOfMineFlagsRemaining; // number of actual mines minus mines flagged by the user
	private int numOfActualMinesRemaining; // number of actual mines on the board minus actual mines flagged
	private Board mineBoard;

	// Constructor for the game engine
	public GameEngine(Board board) {
		mineBoard = board;
		numOfMineFlagsRemaining = board.countHowManyMines(board.getBoard());
		numOfActualMinesRemaining = board.countHowManyMines(board.getBoard());
	}

	// Places or removes a flag (mine or question) on the cell selected by the user
	public void flagCell(Cell cellSelected, String typeOfFlag) {
		if (typeOfFlag == "F") {
			if (cellSelected.getFlag() == null) {
				cellSelected.setFlag(Flag.BOMB);
				cellSelected.setDisplay(" ⚑ ");
				numOfMineFlagsRemaining--;
			} else {
				cellSelected.setFlag(null);
				cellSelected.setDisplay("[ ]");
				numOfMineFlagsRemaining++;
			}
			// Checks if the cell flagged actually has a mine. If it does, decrease
			// remaining mines.
			if (cellSelected.isHasMine()) {
				numOfActualMinesRemaining--;
			}
		} else if (typeOfFlag == "Q") {
			if (cellSelected.getFlag() == null) {
				cellSelected.setFlag(Flag.QUESTION);
				cellSelected.setDisplay(" ? ");
			} else {
				cellSelected.setFlag(null);
				cellSelected.setDisplay("[ ]");
			}
		}
	}

	// This method is called when the user selects to uncover a cell. It checks the
	// cell and performs the applicable action
	public boolean uncoverCell(Cell cellSelected) {
		if (cellSelected.isHasMine()) {
			uncoverAllCells();
			System.out.println("\nGame over! \t Game over! \t Game over!");
			System.out.println("\nGame over! \t Game over! \t Game over!");
			return true;
		} else if (cellSelected.getNumberOfSurroundingMines() >= 1) {
			cellSelected.changeCover();
			if (cellSelected.getCovered() == false)
				cellSelected.setDisplay("" + cellSelected.getNumberOfSurroundingMines() + " ");
		} else if (cellSelected.getNumberOfSurroundingMines() == 0) {
			cellSelected.changeCover();
			if (cellSelected.getCovered() == false)
				cellSelected.setDisplay("");
		}
		return false;
	}

	// This method returns true if all the actual bombs have been flagged by the
	// user
	public boolean hasWon() {
		return numOfActualMinesRemaining == 0 && numOfMineFlagsRemaining == 0;
	}

	// Returns the number of mine flags remaining
	public int getBombFlagCount() {
		return numOfMineFlagsRemaining;
	}

	// This method will be called when the user clicks on a bomb and the game is
	// over. It will uncover the entire board
	public void uncoverAllCells() {
		mineBoard.revealMines(mineBoard.getBoard());
		mineBoard.revealNumberOfSurroundingMines(mineBoard.getBoard());
	}
}
