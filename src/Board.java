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

	Board(int boardSize) {
		System.out.println("Running Board constructor...");
		switch (boardSize) {
		case 1:
			System.out.println("Case 1...");
			this.board = new Cell[SMALL_BOARD][SMALL_BOARD];
			printBoard(this.board);
			this.boardSize = SMALL_BOARD * SMALL_BOARD;
			break;

		case 2:
			this.board = new Cell[MEDIUM_BOARD][MEDIUM_BOARD];
			this.boardSize = MEDIUM_BOARD * MEDIUM_BOARD;
			break;

		case 3:
			this.board = new Cell[LARGE_BOARD][LARGE_BOARD];
			this.boardSize = LARGE_BOARD * LARGE_BOARD;
			break;

		}

	}

	public void generateBoard() {

		placeMines(generateMines(this.boardSize));
		initializeCells();
		printBoard(this.board);

	}

	public ArrayList<Integer> generateMines(int boardsize) {
		int numberOfMines = (int) Math.ceil(this.minePercentage * boardSize);
		ArrayList<Integer> locationOfMines = new ArrayList<Integer>();
		boolean isNewMine = false;

		while (locationOfMines.size() < numberOfMines) {
			int random = (int) (Math.random() * numberOfMines + 1);

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

		System.out.println(locationOfMines.size()); // print size of arraylist (number of mines created)
		return locationOfMines;
	}

	public int placeMines(ArrayList<Integer> listOfMines) {
		System.out.println("Running placeMines()..");
		for (Integer mine : listOfMines) {

			for (int row = 0; row < this.board.length; row++) {
				for (int column = 0; column < this.board[row].length; column++) {

					if (this.board[row][column].getCellNumber() == mine) {
						this.board[row][column].hasMine = true;
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

		// set row, column, and cell number
		for (int row = 0; row < this.board.length; row++) {
			for (int column = 0; column < this.board[row].length; column++) {

				this.board[row][column].setRow(row);
				this.board[row][column].setColumn(column);
				this.board[row][column].setCellNumber((row + 1) * (column + 1));

				if (row == 0) {
					this.board[row][column].isTopRow = true;
				}

				if (row == this.board.length - 1) {
					this.board[row][column].isBottom = true;
				}

				if (column == 0) {
					this.board[row][column].isLeftColumn = true;
				}

				if (column == this.board[this.board.length - 1].length) {
					this.board[row][column].isRightColumn = true;
				}
			}
		}

	}

	/**
	 * prints board with columns numbers and row letters so that cells can be
	 * referenced alpha-numerically ("B12", etc)
	 */
	public void printBoard(Cell[][] board ) {
		System.out.println("Running printBoard()...");
		String format1 = "%5s";

		// print column numbers
		for (int column = 0; column < board[0].length; column++) {
			System.out.print(String.format(format1, (column + 1)));
		}

		// print rows with leading letter
		for (int row = 0; row < board.length; row++) {
			// print the row Letter
			System.out.print(String.format("%5s", alphabet[row]));
			// print cells
			for (int column = 0; column < board[row].length; column++) {
				System.out.print(String.format("%5s", board[row][column].getDisplay()));

			}
		}
	}

	public int countHowManyMines(Cell[][] board) {
		int numberOfMines = 0;

		for (int row = 0; row < this.board.length; row++) {
			for (int column = 0; column < this.board[row].length; column++) {

				if (this.board[row][column].hasMine = true) {
					numberOfMines++;
				}
			}

		}

		return numberOfMines;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;

		System.out.println("Welcome to Ti-Yas-Man Minesweeper!\n");

		Board mineBoard = new Board(1); // TOFIX Specify board size

		mineBoard.generateBoard();
		mineBoard.printBoard(mineBoard.board);

	}
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
