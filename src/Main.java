import java.util.Scanner;

/**
 * This is the game controller.
 * 
 * @author Yasmin
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;
		Cell selectedCell = new Cell();

		System.out.println("Welcome to Ti-Yas-Man Minesweeper!\n");

		while (keepGoing) {

			// Prompt the user to select from one of 3 levels.
			System.out.println("Select your level (1/2/3): ");
			System.out.println("1. Beginner ");
			System.out.println("2. Intermediate ");
			int level = Validator.getInt(scan, "3. Advanced ", 1, 3);

			// Create, generate, and display the board
			Board mineBoard = new Board(level);
			mineBoard.generateBoard();

			// Create the game engine
			GameEngine game = new GameEngine(mineBoard);

			// Prompt the user to enter a cell in the form A1
			String selectedCellName = Console.chooseCell();
			System.out.println("Selected cell " + selectedCellName);
			selectedCell = mineBoard.selectCell(selectedCellName);
			if (!selectedCell.getCellName().equals("error")) {

				// Prompt the user to enter an action for the cell
				String action = Console.chooseAction();
				System.out.println("Action: " + action);

				// Prompt the user to confirm their selection
				boolean proceed = Console.confirmAction();

				if (proceed) {
					// Call a method depending on the action selected
					if (action.equalsIgnoreCase("F")) {
						game.flagCell(selectedCell, "F");
					} else if (action.equalsIgnoreCase("Q")) {
						game.flagCell(selectedCell, "Q");
					} else {
						game.uncoverCell(selectedCell);
					}

					// Refresh the board after executing user action
					mineBoard.generateBoard();

					// Check if the user has won
					if (game.hasWon()) {
						System.out.println("Congratulations! You have won!");
						keepGoing = Validator.getYOrN(scan, "Would you like to keep playing (y/n)");
					}

				}
			}
		}
		System.out.println("Goodbye!");
		scan.close();
	}
}