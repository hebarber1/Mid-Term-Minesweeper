
//This is the cell object, representing a cell in the game board.


public class Cell {

	private boolean covered;  //Whether the cell is covered or not
	private String display;  // What the cell is displaying to the console
	private Flag flag; //Enum indicating if the cell has a bomb or question mark
	private int numberOfSurroundingMines; //number of mines around this cell from 0-8
	private int row;
	private int column;
	private int cellNumber;
	
	
	

	// constructor
	public Cell() {

		covered = true;
		display = "[ ]";
	}
	
	public void setNumberOfSurroundingMines(int numOfMines) {
		numberOfSurroundingMines = numOfMines;
	}
	
	public int getNumberOfSurroundingMines() {
		return numberOfSurroundingMines;
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

	// to string


}
