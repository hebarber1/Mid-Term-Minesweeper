import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Tim
public class Board {
	// INSTANCE VARIABLES
	// 2D array representing the board
	private Cell[][] board;
	private int boardSize;

	// three different board sizes
	private final int SMALL_BOARD = 5;
	private final int MEDIUM_BOARD = 10;
	private final int LARGE_BOARD = 15;

	// percentage of board to have mines
	private final double minePercentage = .20;
	String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };

	public Board(int boardSize) {
		// System.out.println("Running Board constructor...");
		switch (boardSize) {
		case 1:
			// System.out.println("Case 1...");
			this.board = new Cell[SMALL_BOARD][SMALL_BOARD];
			this.boardSize = SMALL_BOARD * SMALL_BOARD;
			break;

		case 2:
			//System.out.println("Case 2...");
			this.board = new Cell[MEDIUM_BOARD][MEDIUM_BOARD];
			this.boardSize = MEDIUM_BOARD * MEDIUM_BOARD;
			break;

		case 3:
			this.board = new Cell[LARGE_BOARD][LARGE_BOARD];
			this.boardSize = LARGE_BOARD * LARGE_BOARD;
			break;

		}

	}

	public void fillArrayWithCells(Cell[][] board) {
	//	System.out.println("Running fillArrayWithCells...");

		for (int row = 0; row < this.board.length; row++) {
			for (int column = 0; column < this.board[row].length; column++) {
				board[row][column] = new Cell();
			}
		}
	}

	public void generateBoard() {
		//System.out.println("Running generateBoard()...");

		fillArrayWithCells(this.board);
		initializeCells();
		placeMines(generateMines(this.boardSize));
		setNumberOfSurroundingMines(this.board);
		//printBoard(this.board);

	}

	public ArrayList<Integer> generateMines(int boardsize) {
		int numberOfMines = (int) Math.ceil(this.minePercentage * boardSize);
		ArrayList<Integer> locationOfMines = new ArrayList<Integer>();
		boolean isNewMine = false;

		int random = (int) (Math.random() * boardsize + 1);
		// add first random number so Array isn't null and the while loop isn't skipped
		locationOfMines.add(random);

		while (locationOfMines.size() < numberOfMines) {
			random = (int) (Math.random() * boardsize + 1);

			for (Integer mine : locationOfMines) { // loop through locationOfMine list
				if (mine == random) { // if this random number has already been picked,
					isNewMine = false; // it is not new a mine
				} else {
					isNewMine = true; // it is a new mine
				}
			}

			if (isNewMine) { // if a new mine
				locationOfMines.add(random); // add to list
			}
		}

		//System.out.println("\nlocationOfMines.size = " + locationOfMines.size()); // print size of arraylist (number of
																					// mines created)
		return locationOfMines;
	}

	public int placeMines(ArrayList<Integer> listOfMines) {
	//	System.out.println("Running placeMines()..");

		// go through the list of mines
		for (Integer mine : listOfMines) {

			for (int row = 0; row < this.board.length; row++) {
				for (int column = 0; column < this.board[row].length; column++) {

					// if the cellNumber appears on the list place a mine
					if (this.board[row][column].getCellNumber() == mine) {
						this.board[row][column].setHasMine(true);
					}
				}
			}
		}

		return countHowManyMines(this.board);
	}

	/**
	 * will initialize cells with cellNumber, numberOfMines, and relative position
	 * on board
	 */
	public void initializeCells() {
		int cellNumber;

		//System.out.println("Running initializeCells()...");
		// set row, column, and cell number
		for (int row = 0; row < this.board.length; row++) {
			for (int column = 0; column < this.board[row].length; column++) {
				cellNumber = row * (this.board[row].length) + (column + 1);

				this.board[row][column].setRow(row);
				this.board[row][column].setColumn(column);
				this.board[row][column].setCellNumber(cellNumber);
				this.board[row][column].setCellName(alphabet[row] + (column + 1));

				if (row == 0) {
					this.board[row][column].setTopRow(true);
				}

				if (row == this.board.length - 1) {
					this.board[row][column].setBottomRow(true);
				}

				if (column == 0) {
					this.board[row][column].setLeftColumn(true);
				}

				if (column == this.board[this.board.length - 1].length) {
					this.board[row][column].setRightColumn(true);
				}
			}
		}

	}

	public void revealMines(Cell[][] board) {
		for (int row = 0; row < this.board.length; row++) {
			for (int column = 0; column < this.board[row].length; column++) {
				if (this.board[row][column].isHasMine() == true) {
					this.board[row][column].setDisplay("[Ò]");
				}

			}
		}
	}

	public void setNumberOfSurroundingMines(Cell[][] board) {
		//System.out.println("\n\nRunning setNumberOfSurroundingMines...");

		//
		// final String topLeftCorner = board[0][0].getCellName();
		// String topRightCorner = board[0][board[0].length].getCellName();
		// String bottomLeftCorner = board[board.length][0].getCellName();
		// String bottomRightCorner =
		// board[board.length][board[0].length].getCellName();
		//

		int numberOfMines = 0;

		for (int row = 1; row < board.length - 1; row++) {
			for (int column = 1; column < board[row].length - 1; column++) {

				if (this.board[row][column].isTopRow() && this.board[row][column].isLeftColumn()) {
	/*				System.out.println(this.board[row][column].getCellName());
					System.out.println("top left");*/
				} else if (this.board[row][column].isTopRow() && this.board[row][column].isRightColumn()) {
		/*			System.out.println(this.board[row][column].getCellName());
					System.out.println("top right");*/
				} else if (this.board[row][column].isBottomRow() && this.board[row][column].isLeftColumn()) {
	/*				System.out.println(this.board[row][column].getCellName());
					System.out.println("bottom left");*/
				} else if (this.board[row][column].isBottomRow() && this.board[row][column].isRightColumn()) {
					/*System.out.println(this.board[row][column].getCellName());
					System.out.println("bottom right");*/
				} else {

					// if cell location != top, count the 3 cells with mines below
					if (this.board[row][column].isTopRow() != true) {
					//	System.out.println("location != top..");
						if (this.board[row + 1][column - 1].isHasMine() == true)
							numberOfMines++;
						if (this.board[row + 1][column].isHasMine() == true)
							numberOfMines++;
						if (this.board[row + 1][column + 1].isHasMine() == true)
							numberOfMines++;
					//	System.out.println("Number of mines: " + numberOfMines);
					}

					// if cell location != bottom, count the 3 cells with mines above
					if (this.board[row][column].isBottomRow() != true) {
						if (this.board[row - 1][column - 1].isHasMine() == true)
							numberOfMines++;
						if (this.board[row - 1][column].isHasMine() == true)
							numberOfMines++;
						if (this.board[row - 1][column + 1].isHasMine() == true)
							numberOfMines++;
					}

					// if cell location != leftColumn, count the one cell to left
					if (this.board[row][column].isLeftColumn() != true) {
						if (this.board[row][column - 1].isHasMine() == true)
							numberOfMines++;
					}

					// if cell location != rightColumn, count the one cell to right
					if (this.board[row][column].isRightColumn() != true) {
						if (this.board[row][column + 1].isHasMine() == true)
							numberOfMines++;
					}

					this.board[row][column].setNumberOfSurroundingMines(numberOfMines);
					numberOfMines = 0;
				}
			}
		}
	}

	public void revealNumberOfSurroundingMines(Cell[][] board) {
		for (int row = 0; row < this.board.length; row++) {
			for (int column = 0; column < this.board[row].length; column++) {

				if (this.board[row][column].isHasMine() == false) {
					this.board[row][column]
							.setDisplay(String.format(" %d ", this.board[row][column].getNumberOfSurroundingMines()));
					if (this.board[row][column].getNumberOfSurroundingMines() == 0) {
						this.board[row][column].setDisplay("");
					}
				}

			}
		}
	}

	/**
	 * prints board with columns numbers and row letters so that cells can be
	 * referenced alpha-numerically ("B12", etc)
	 */
	public void printBoard(Cell[][] board) {
	//	System.out.println("\n\nRunning printBoard()...\n");
		String stringFormat = "%4s";

		// print column numbers
		System.out.println("\n");
		System.out.print("   ");
		for (int column = 0; column < board[0].length; column++) {
			System.out.print(String.format(stringFormat, (column + 1)));
		}

		// print rows with leading letter in two parts
		for (int row = 0; row < board.length; row++) {
			// first, print the row Letter
			System.out.print(String.format("\n" + stringFormat, alphabet[row]) + "|");
			// next, print cells
			for (int column = 0; column < board[row].length; column++) {
				System.out.print(String.format(stringFormat, board[row][column].getDisplay()));

			}
		}
		System.out.println("\n");
	}

	public int countHowManyMines(Cell[][] board) {
		int numberOfMines = 0;

		for (int row = 0; row < this.board.length; row++) {
			for (int column = 0; column < this.board[row].length; column++) {

				if (this.board[row][column].isHasMine() == true) {
					numberOfMines++;
				}
			}
		}

		return numberOfMines;
	}

	public Cell selectCell(String cellName) {
		Cell error = new Cell();
		error.setCellName("error");
		
		for (int row = 0; row < this.board.length; row++) {
			for (int column = 0; column < this.board[row].length; column++) {

				if (this.board[row][column].getCellName().equalsIgnoreCase(cellName)) {
					return this.board[row][column];
				}
			}
		}
		System.out.println(cellName + " not found! \n");
		return error;

	}

	public Cell[][] getBoard() {
		return board;
	}

	public void setBoard(Cell[][] board) {
		this.board = board;
	}

	/*public static void main(String[] args) {

		// Scanner scan = new Scanner(System.in);
		// boolean keepGoing = true;

		System.out.println("Welcome to Ti-Yas-Man Minesweeper!\n");

		Board mineBoard = new Board(3); // TOFIX Specify board size

		mineBoard.generateBoard();
		mineBoard.revealMines(mineBoard.board);
		mineBoard.printBoard(mineBoard.board);
		mineBoard.setNumberOfSurroundingMines(mineBoard.board);
		mineBoard.revealNumberOfSurroundingMines(mineBoard.board);
		mineBoard.printBoard(mineBoard.board);
		System.out.println("\n" + mineBoard.countHowManyMines(mineBoard.board));

	}*/
	// CONSTRUCTOR
	// Board constructor to initialize a board of the size specified by the user
	// The constructor will call a method to generate the mines and calculate
	// adjacent mines

	// METHOD generateBoard() - This method will randomly generate mines and place
	// them on the board. It will also calculate the
	// mines around each cell and update the board/cells

	// METHOD displayBoard() - Method to display the status of the board. When the
	// game starts the board is empty or covered

}
