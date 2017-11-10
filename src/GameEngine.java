import java.util.Scanner;

//Game engine:
//1. Gets the cell entered by the user and performs the action selected
//2. Keeps track of the number of bombs uncovered
//3. Checks if the user has won (uncovered all actual bombs)

public class GameEngine {

	private int numOfMineFlagsRemaining; // number of actual mines minus mines flagged by the user
	private int numOfActualMinesRemaining; // number of actual mines on the board minus actual mines flagged
	private Board mineBoard;
	private Scanner scan;

	// Constructor for the game engine
	public GameEngine(Board board) {
		mineBoard = board;
		numOfMineFlagsRemaining = board.countHowManyMines(board.getBoard()); // TODO: countHowManyMines()
		numOfActualMinesRemaining = board.countHowManyMines(board.getBoard()); // TODO: countHowManyMines()
		scan = new Scanner(System.in);
	}

	// Places a flag (bomb or question) on the cell selected by the user
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

			// Check if the cell actually has a bomb. If it does, decrease remaining bombs.
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
			// mineBoard.printBoard(mineBoard.getBoard());
			System.out.println("\nGame over! \t Game over! \t Game over!");

			return true;
		} else if (cellSelected.getNumberOfSurroundingMines() >= 1) {
			cellSelected.changeCover(); // if cell has a number of mines, it uncovers only that cell
			if (cellSelected.getCovered() == false)
				cellSelected.setDisplay("" + cellSelected.getNumberOfSurroundingMines() + " ");
		} else if (cellSelected.getNumberOfSurroundingMines() == 0) {
			cellSelected.changeCover();
			if (cellSelected.getCovered() == false)
				cellSelected.setDisplay("");
			uncoverSurroundingCells();
		}
		return false;
	}

	// This method returns true if all the actual bombs have been flagged by the
	// user
	public boolean hasWon() {
		return numOfActualMinesRemaining == 0 && numOfMineFlagsRemaining == 0;
	}

	public int getBombFlagCount() {
		return numOfMineFlagsRemaining;
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
		mineBoard.revealMines(mineBoard.getBoard());
		mineBoard.revealNumberOfSurroundingMines(mineBoard.getBoard());

	}
}
