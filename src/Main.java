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
			Console.chooseCell(); // TODO Needs to return the cell, get rid of sc.next()
			// TODO Need to convert cell from A1 to 0,0
			// TODO Need a method in the Board that returns a specific cell from the board
			// using row/col

			// TODELETE
			Cell cell = new Cell();

			cell.setColumn(0);
			cell.setRow(0);
			cell.setNumberOfSurroundingMines(1);
			cell.setDisplay("1");

			Cell cell2 = new Cell();
			cell2.setColumn(1);
			cell2.setRow(0);
			cell2.setHasMine(true);

			// Prompt the user to enter an action for the cell
			Console.chooseAction(); // TODO Needs to return the action, get rid of sc.next
			String userAction = "U"; // DELETE

			// Prompt the user to confirm their selection
			Console.confirmAction(); // TODO Needs to return user input
			String confirmation = "y"; // DELETE

			if (confirmation.equalsIgnoreCase("y")) {
				// Call a method depending on the action selected
				if (userAction.equals("F")) {
					game.flagCell(cell, "F");
				} else if (userAction.equals("Q")) {
					game.flagCell(cell, "Q");
				} else {
					game.uncoverCell(cell);
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

		System.out.println("Goodbye!");
		scan.close();
	}
}