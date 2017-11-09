//Game engine:
//1. Gets the cell entered by the user and performs the action selected
//2. Keeps track of the number of bombs uncovered

public class GameEngine {

	private int bombFlagCount; // number of bombs remaining

	// Constructor for the game engine
	public GameEngine() {
		bombFlagCount = 0;
	}

	// Executes an action on the cell selected by the user
	public void playCell(Cell cellSelected, String action) {
		if (action == "F") {
			cellSelected.setFlag(Flag.BOMB);
		} else if (action == "Q") {
			cellSelected.setFlag(Flag.QUESTION);
		} else { // Option U which means Uncover cell
			cellSelected.changeCover();
		}
	}

}
