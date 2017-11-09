
//This is the cell object, representing a cell in the game board.


public class Cell {

	private boolean covered;  //Whether the cell is covered or not
	private String display;  // What the cell is displaying to the console
	private Flag flag; //Enum indicating if the cell has a bomb or question mark
	private int numberOfSurroundingMines; //number of mines around this cell from 0-8
	private int row; // number that represents the row the cell is in, it's 0 based
	private int col; // number that represens the col the cell is in, it's 0 based
	private int cellNumber; // cell number on the board, so if the board is 5 x 5, the last cell is 25
	
	// constructor
	public Cell() {
		covered = true;
		display = "[ ]";
		flag = null;
		numberOfSurroundingMines = 0;
		row = 0;
		col = 0;
		cellNumber = 0;
	}

	// Use this method to change whether the cell is covered or not
	public void changeCover() {
		covered = ! covered;
	}

	// Use this method to check if a cell is covered
	public boolean isCovered() {
		return covered;
	}

	// Gets what is currently displayed on the cell
	public String getDisplay() {
		return display;
	}

	//Sets what should be displayed on the cell
	public void setDisplay(String newDisplay) {
		display = newDisplay;
	}

	// Sets the flag to bomb or question mark
	public void setFlag(Flag newFlag) {
		flag = newFlag;
	}

	// returns the current flag on the cell, null if it hasn't been flagged
	public Flag getFlag() {
		return flag;
	}

	// sets the number of mines surrounding this cell
	public void setNumberOfSurroundingMines(int numOfMines) {
		numberOfSurroundingMines = numOfMines;
	}

	// gets the number of mines surrounding this cell
	public int getNumberOfSurroundingMines() {
		return numberOfSurroundingMines;
	}

	// sets the row where this cell is
	public void setRow(int rowNumber) {
		row = rowNumber;
	}

	// gets the row where this cell is
	public int getRow() {
		return row;
	}

	// sets the column where this cell is
	public void setColumn(int colNumber) {
		col = colNumber;
	}

	// gets the column where this cell is
	public int getColumn() {
		return col;
	}

	// sets the cell number (position on the board)
	public void setCellNumber(int cellNum) {
		cellNumber = cellNum;
	}

	// gets the cell number
	public int getCellNumber() {
		return cellNumber;
	}

	@Override
	public String toString() {
		return "Cell [covered=" + covered + ", display=" + display + ", flag=" + flag + ", numberOfSurroundingMines="
				+ numberOfSurroundingMines + ", row=" + row + ", col=" + col + ", cellNumber=" + cellNumber + "]";
	}
}
