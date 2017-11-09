/**
 * 
 */

/**
 * @author hbm1
 *
 */
public void Cell {
	
	//Detects number of mines around a selected cell.

	    for(int x = 1; x < display.length - 2; x++){     //Cycles thru the entire visible display.
	      for(int y = 1; y < display.length - 2; y++){
	        if(field[x][y].equals(empty) == true){
	          int numberOfSurroundingMines = 0;                              //Var for counting mines.
	          for(int i = (x - 1); i <= (x + 1); i++){
	            for(int j = (y - 1); j <= (y + 1); j++){
	              if(field[i][j].equals(mine) == true)
	                numberOfSurroundingMines++;                              //Incrememnts numberOfSurroundingMines var when a mine is detected.
	            }
	          }
	          display[x][y] = " " + numberOfSurroundingMines + " ";
	        }
	      }
	    }
	  }
	  
	  //Takes user's selected coordinates and adjusts the board.
	  public void turn(int x, int y){
	    if(field[x][y].equals(unknown) == true){           //If the spot hasn't been selected, it is cleared.
	      isDone = false;
	      display[x][y] = empty;
	      field[x][y] = empty;
	    }else if(field[x][y].equals(mine) == true){        //If the user selects a mine.
	      isDone = true;                                   //Game is done.
	      isWin = false;                                   //User doesn't win.
	      System.out.println("You've lost!");
	    }else if(display[x][y].equals(empty) == true && field[x][y].equals(empty)){
	      isDone = false;
	      System.out.println("This cell has been cleared!");
	    }
	  
	  
	  //Determines if a player has cleared all safe Cells.
	  public void isVictory(){
	    int tile = 0;                                      //Var for the number of uncleared tiles in the array.
	    for(int i = 0; i < field.length; i++){
	      for(int j = 0; j < field[0].length; j++){
	        if(field[i][j].equals(unknown) == true)
	          tile++;                                      //If there are uncleared tiles, var is incremented.
	      }
	    }
	    if(tile != 0)
	      isWin = false;  //If there are still uncleared Cells, player hasn't won.
	    else{
	      isWin = true;
	      isDone = true;
	    }
	  }
	  
	  //Determines if the game is finished.
	  public Boolean getDone(){
	    return isDone;
	  }
	  
	  //Determines if a player won.
	  public Boolean getWin(){
	    return isWin;
	  }
	  
	  //Displays location of mines at end of game.
	  public void onEnd(){
	    printGame(field);
	  }
	  
	}
	


