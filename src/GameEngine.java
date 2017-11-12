
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
				cellSelected.setDisplay(" ! ");
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
			System.out.println("\tGame over! \t Game over! \t Game over!");
			System.out.println("\t\tGame over! \t Game over! \t Game over!");
			return true;

		} else if (cellSelected.getNumberOfSurroundingMines() >= 1) {
			cellSelected.changeCover();
			if (cellSelected.getCovered() == false)
				cellSelected.setDisplay("" + cellSelected.getNumberOfSurroundingMines() + " ");

		} else if (cellSelected.getNumberOfSurroundingMines() == 0) {
			cellSelected.changeCover();
			if (cellSelected.getCovered() == false)
				cellSelected.setDisplay("");
			zeroMineActionAllDirections(cellSelected, mineBoard.getBoard());

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

	public void zeroMinesActionRight(Cell cell, Cell[][] board) {
		System.out.println("\nZeroMinesActionRight method...");

		int row = cell.getRow();
		int nextRow = row;
		int col = cell.getCol();
		int nextCol = col + 1;
		

		boolean isOnEdge = cell.isBottomRow() | cell.isTopRow() | cell.isLeftColumn() | cell.isRightColumn();
		/*boolean isNextOnEdge = nextCell.isBottomRow() | nextCell.isTopRow() | nextCell.isLeftColumn()
				| nextCell.isRightColumn();
*/
		// int counter = 0;

		// go right
		if (cell.getNumberOfSurroundingMines() > 0) {
			System.out.println("greater than 0 loop");
			cell.setCovered(false);
			cell.setDisplay("" + cell.getNumberOfSurroundingMines() + " ");
		} else if (isOnEdge) {
			System.out.println("is on edge loop");
			cell.setCovered(false);
			cell.setDisplay("");
		} else if (nextRow < board.length || nextCol < board[row].length) {
			System.out.println("calling recursive loop");
			System.out.println("row : " + row + " col : " + col);
			Cell nextCell = board[nextRow][nextCol];
			cell.setCovered(false);
			cell.setDisplay("");
			zeroMinesActionRight(nextCell, board);
		}

	}

	public void zeroMinesActionLeft(Cell cell, Cell[][] board) {
		System.out.println("\nZeroMinesActionLeft method...");

		int row = cell.getRow();
		int nextRow = row;
		int col = cell.getCol();
		int nextCol = col - 1;
		//Cell nextCell = board[nextRow][nextCol];

		boolean isOnEdge = cell.isBottomRow() | cell.isTopRow() | cell.isLeftColumn() | cell.isRightColumn();
		/*boolean isNextOnEdge = nextCell.isBottomRow() | nextCell.isTopRow() | nextCell.isLeftColumn()
				| nextCell.isRightColumn();
		*/
		System.out.println("Is current cell on edge?" + isOnEdge);

		// go right
		if (cell.getNumberOfSurroundingMines() > 0) {
			System.out.println("greater than 0 loop");
			cell.setCovered(false);
			cell.setDisplay("" + cell.getNumberOfSurroundingMines() + " ");
		} else if (isOnEdge) {
			System.out.println("is on edge loop");
			cell.setCovered(false);
			cell.setDisplay("");
		}  else if (nextRow < board.length || nextCol < board[row].length) {
			System.out.println("calling recursive loop");
			System.out.println("row : " + row + " col : " + col);
			Cell nextCell = board[nextRow][nextCol];
			cell.setCovered(false);
			cell.setDisplay("");
			zeroMinesActionLeft(nextCell, board);
		}
	}

	public void zeroMinesActionDown(Cell cell, Cell[][] board) {
		System.out.println("\nZeroMinesActionDown method...");

		int row = cell.getRow();
		int nextRow = row + 1;
		int col = cell.getCol();
		int nextCol = col;
		

		boolean isOnEdge = cell.isBottomRow() | cell.isTopRow() | cell.isLeftColumn() | cell.isRightColumn();
		/*boolean isNextOnEdge = nextCell.isBottomRow() | nextCell.isTopRow() | nextCell.isLeftColumn()
				| nextCell.isRightColumn();
*/
		if (cell.getNumberOfSurroundingMines() > 0) {
			System.out.println("greater than 0 loop");
			cell.setCovered(false);
			cell.setDisplay("" + cell.getNumberOfSurroundingMines() + " ");
		} else if (isOnEdge) {
			System.out.println("is on edge loop");
			cell.setCovered(false);
			cell.setDisplay("");
		}  else if (nextRow < board.length && nextCol < board[row].length && nextRow >= 0 && nextCol >= 0) {
			System.out.println("calling recursive loop");
			System.out.println("row : " + row + " col : " + col);
			Cell nextCell = board[nextRow][nextCol];
			cell.setCovered(false);
			cell.setDisplay("");
			zeroMinesActionDown(nextCell, board);
		}
	}

	public void zeroMinesActionUp(Cell cell, Cell[][] board) {
		System.out.println("\nZeroMinesActionUp method...");
		
		int row = cell.getRow();
		int nextRow = row - 1;
		int col = cell.getCol();
		int nextCol = col;

		System.out.println(cell.getCellName() + " row: " + row + " column: " + col);

		
		boolean isOnEdge = cell.isBottomRow() | cell.isTopRow() | cell.isLeftColumn() | cell.isRightColumn();
		/*boolean isNextOnEdge = nextCell.isBottomRow() | nextCell.isTopRow() | nextCell.isLeftColumn()
				| nextCell.isRightColumn();
		*/
		System.out.println("Is current cell on edge? " + isOnEdge);

		if (cell.getNumberOfSurroundingMines() > 0) {
			System.out.println("greater than 0 loop");
			cell.setCovered(false);
			cell.setDisplay("" + cell.getNumberOfSurroundingMines() + " ");
		} else if (isOnEdge) {
			System.out.println("is on edge loop");
			cell.setCovered(false);
			cell.setDisplay("");
		}  else if (nextRow < board.length && nextCol < board[row].length && nextRow >= 0 && nextCol >= 0) {
			System.out.println("calling recursive loop");
			System.out.println("row : " + row + " col : " + col);
			Cell nextCell = board[nextRow][nextCol];
			cell.setCovered(false);
			cell.setDisplay("");
			zeroMinesActionUp(nextCell, board);
		}
	}

	public void zeroMinesActionUpLeft(Cell cell, Cell[][] board) {
		System.out.println("\nZeroMinesActionUpLeft method...");

		int row = cell.getRow();
		int nextRow = row - 1;
		int col = cell.getCol();
		int nextCol = col - 1;
//		Cell nextCell = board[nextRow][nextCol];

		boolean isOnEdge = cell.isBottomRow() | cell.isTopRow() | cell.isLeftColumn() | cell.isRightColumn();
		/*boolean isNextOnEdge = nextCell.isBottomRow() | nextCell.isTopRow() | nextCell.isLeftColumn()
				| nextCell.isRightColumn();
*/
		if (cell.getNumberOfSurroundingMines() > 0) {
			System.out.println("greater than 0 loop");
			cell.setCovered(false);
			cell.setDisplay("" + cell.getNumberOfSurroundingMines() + " ");
		} else if (isOnEdge) {
			System.out.println("is on edge loop");
			cell.setCovered(false);
			cell.setDisplay("");
		} else if (nextRow < board.length || nextCol < board[row].length){
			System.out.println("calling recursive loop");
			System.out.println("row : " + row + " col : " + col);
			Cell nextCell = board[nextRow][nextCol];
			cell.setCovered(false);
			cell.setDisplay("");
			zeroMinesActionUpLeft(nextCell, board);
		}
	}

	public void zeroMinesActionUpRight(Cell cell, Cell[][] board) {
		System.out.println("\nZeroMinesActionUpRight method...");

		int row = cell.getRow();
		int nextRow = row - 1;
		int col = cell.getCol();
		int nextCol = col + 1;
//		Cell nextCell = board[nextRow][nextCol];

		boolean isOnEdge = cell.isBottomRow() | cell.isTopRow() | cell.isLeftColumn() | cell.isRightColumn();
	/*	boolean isNextOnEdge = nextCell.isBottomRow() | nextCell.isTopRow() | nextCell.isLeftColumn()
				| nextCell.isRightColumn();*/

		if (cell.getNumberOfSurroundingMines() > 0) {
			System.out.println("greater than 0 loop");
			cell.setCovered(false);
			cell.setDisplay("" + cell.getNumberOfSurroundingMines() + " ");
		} else if (isOnEdge) {
			System.out.println("is on edge loop");
			cell.setCovered(false);
			cell.setDisplay("");
		}  else if (nextRow < board.length || nextCol < board[row].length) {
			System.out.println("calling recursive loop");
			System.out.println("row : " + row + " col : " + col);
			Cell nextCell = board[nextRow][nextCol];
			cell.setCovered(false);
			cell.setDisplay("");
			zeroMinesActionUpRight(nextCell, board);
			//zeroMineActionAllDirections(nextCell, board);
		}
	}

	public void zeroMinesActionDownLeft(Cell cell, Cell[][] board) {
		System.out.println("\nZeroMinesActionDownLeft method...");

		int row = cell.getRow();
		int nextRow = row + 1;
		int col = cell.getCol();
		int nextCol = col - 1;
//		Cell nextCell = board[nextRow][nextCol];

		boolean isOnEdge = cell.isBottomRow() | cell.isTopRow() | cell.isLeftColumn() | cell.isRightColumn();
	/*	boolean isNextOnEdge = nextCell.isBottomRow() | nextCell.isTopRow() | nextCell.isLeftColumn()
				| nextCell.isRightColumn();
*/
		if (cell.getNumberOfSurroundingMines() > 0) {
			System.out.println("greater than 0 loop");
			cell.setCovered(false);
			cell.setDisplay("" + cell.getNumberOfSurroundingMines() + " ");
		} else if (isOnEdge) {
			System.out.println("is on edge loop");
			cell.setCovered(false);
			cell.setDisplay("");
		} else if (nextRow < board.length || nextCol < board[row].length) {
			System.out.println("calling recursive loop");
			System.out.println("row : " + row + " col : " + col);
			Cell nextCell = board[nextRow][nextCol];
			cell.setCovered(false);
			cell.setDisplay("");
			zeroMinesActionDownLeft(nextCell, board);
			//zeroMineActionAllDirections(nextCell, board);
		}
	}

	public void zeroMinesActionDownRight(Cell cell, Cell[][] board) {
		System.out.println("\nZeroMinesActionDownRight method...");

		int row = cell.getRow();
		int nextRow = row + 1;
		int col = cell.getCol();
		int nextCol = col + 1;
//		Cell nextCell = board[nextRow][nextCol];

		boolean isOnEdge = cell.isBottomRow() | cell.isTopRow() | cell.isLeftColumn() | cell.isRightColumn();
		/*boolean isNextOnEdge = nextCell.isBottomRow() | nextCell.isTopRow() | nextCell.isLeftColumn()
				| nextCell.isRightColumn();*/

		if (cell.getNumberOfSurroundingMines() > 0) {
			System.out.println("greater than 0 loop");
			cell.setCovered(false);
			cell.setDisplay("" + cell.getNumberOfSurroundingMines() + " ");
		} else if (isOnEdge) {
			System.out.println("is on edge loop");
			cell.setCovered(false);
			cell.setDisplay("");
		} else if (nextRow < board.length || nextCol < board[row].length) {
			System.out.println("calling recursive loop");
			System.out.println("row : " + row + " col : " + col);
			Cell nextCell = board[nextRow][nextCol];
			cell.setCovered(false);
			cell.setDisplay("");
			zeroMinesActionDownRight(nextCell, board);
			//zeroMineActionAllDirections(nextCell, board);
		}
	}
	
	public void zeroMineActionAllDirections (Cell cell, Cell[][] board) {
		zeroMinesActionUp(cell, board);
		zeroMinesActionDown(cell, board);
		zeroMinesActionRight(cell, board);
		zeroMinesActionLeft(cell, board);
		zeroMinesActionUpLeft(cell, board);
		zeroMinesActionUpRight(cell, board);
		zeroMinesActionDownLeft(cell, board);
		zeroMinesActionDownRight(cell, board);
	}

}
