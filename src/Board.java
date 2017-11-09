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

	Board(int boardSize){
	this.boardSize = boardSize;
	
	switch(boardSize) {
	case 1:
		this.board = new Cell [SMALL_BOARD][SMALL_BOARD];
		break;
	case 2:
		this.board = new Cell [MEDIUM_BOARD][MEDIUM_BOARD];
		break;
	case 3:
		this.board = new Cell [LARGE_BOARD][LARGE_BOARD];
		break;
		
	}
		
	})

private void generateBoard() {
	generateMines(this.boardsize);

	placeMines(int[] listOfMines);

}

private ArrayList<Integers> generateMines(int boardsize) {
	int numberOfMines = this.minePercentage * boardSize * boardSize;
	ArrayList<Integers> locationOfMines = new ArrayList<Integers>();
	boolean isNewMine = false;
	
	while( locationOfMines.size() < numberOfMines ) {
		int random = (int) (Math.random()* numberOfMines + 1);
		
		for(mines: locationOfMines) { // loop through locationOfMine list 
			if( mine == random) { // if this random number has already been picked
				isNewMine = false;  // is not new mine
			} else {
				isNewMine = true; // is a new mine
			}
		}
		
		if(isNewMine) { //if a new mine 
			locationOfMines.add(random); // add to list
		}	
	}
	
	return locationOfMines;
	}

private void placeMines(ArrayList<Integers> listOfMines) {
	for 

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
