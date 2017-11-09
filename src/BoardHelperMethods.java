/**
 * This class has some methods that can be used when making changes to the
 * board.
 * 
 * @author hbm1
 *
 */
public class BoardHelperMethods {

	// Detects number of mines around a selected cell.

	public int numMines(Board display) {
		for (int x = 1; x < display.length - 2; x++) { // Cycles thru the entire visible display.

			for (int y = 1; y < display.length - 2; y++) {
				if (cell[x][y].equals(empty) == true) {
					int numberOfSurroundingMines = 0; // Var for counting mines.
					for (int i = (x - 1); i <= (x + 1); i++) {
						for (int j = (y - 1); j <= (y + 1); j++) {
							if (cell[i][j].hasMine == true)
								numberOfSurroundingMines++; // Incrememnts numberOfSurroundingMines var when a mine is
															// detected.
						}
					}
					cell[x][y] = " " + numberOfSurroundingMines + " ";
				}
			}
		}
	}

	// Takes user's selected coordinates and adjusts the board.
	public void turn(int x, int y){
	    if(cell[x][y].equals(unknown) == true){           //If the spot hasn't been selected, it is cleared.
	      isDone = false;
	      display[x][y] = empty;
	      cell[x][y] = empty;
	    }else if(cell[x][y].equals(mine) == true){        //If the user selects a mine.
	      isDone = true;                                   //Game is done.
	      isWin = false;                                   //User doesn't win.
	      System.out.println("You've lost!");
	    }else if(cell[x][y].equals(empty) == true && cell[x][y].equals(empty)){
	      isDone = false;
	      System.out.println("This cell has been cleared!");
	    }

	// Determines if a player has cleared all safe Cells.
	public void isVictory() {
		int cell = 0; // Var for the number of uncleared tiles in the array.
		for (int i = 0; i < display.length; i++) {
			for (int j = 0; j < display[0].length; j++) {
				if (display[i][j].equals(unknown) == true)
					cell++; // If there are uncleared tiles, var is incremented.
			}
		}
		if (cell != 0)
			isWin = false; // If there are still uncleared Cells, player hasn't won.
		else {
			isWin = true;
			isDone = true;
		}
	}

	// Determines if the game is finished.
	public Boolean getDone() {
		return isDone;
	}

	// Determines if a player won.
	public Boolean getWin() {
		return isWin;
	}

	// Displays location of mines at end of game.
	public void onEnd() {
		printGame(display);
	}

}
