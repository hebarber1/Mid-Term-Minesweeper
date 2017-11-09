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
		final int BEG_BOARD = 5;
		final int INT_BOARD = 10;
		final int ADV_BOARD = 15;
		boolean keepGoing = true;

		System.out.println("Welcome to Ti-Yas-Man Minesweeper!\n");

		while (keepGoing) {

			// Prompt the user to select from one of 3 levels.
			System.out.println("Select your level (1/2/3): ");
			System.out.println("1. Beginner ");
			System.out.println("2. Intermediate ");
			int level = Validator.getInt(scan, "3. Advanced ", 1, 3);

			// Determine the board size according to level selected by the user.
			int boardSize = 0;

			if (level == 1) {
				boardSize = BEG_BOARD;
			} else if (level == 2) {
				boardSize = INT_BOARD;
			} else {
				boardSize = ADV_BOARD;
			}

			System.out.println("The size of the board will be: " + boardSize + "\n"); // TOFIX Get rid of this line

			// Create the board
			Board mineBoard = new Board(); // TOFIX Specify board size

			// Call Board.generateBoard()

			// Call Board.displayBoard() (returns an empty board at this point)

			// Call Console.printMenu() to display menu to the user

			// Process menu number selected by the user
			int menuNumber = Validator.getInt(scan, "Enter menu number: ", 1, 5);
			switch (menuNumber) {
			case 1:
				// get and store the cell entered by the user in the format A1 where
				// A represents the row and 1 represents the column.
				break;
			case 2:
				// get and store the action entered by the user F, Q, U. F=Flag,
				// Q=Question, U=Uncover.
				break;
			case 3:
				// this means the user wants to play their move. Call methods
				// Board.Update() and Board.DisplayBoard().
				break;
			case 4:
				// this means the user wants to select a new cell. Clear the stored
				// cell and action and go to Option 1.
				break;
			case 5:
				keepGoing = false;
				break;
			default:
				break;
			}
		}

		System.out.println("Goodbye!");
		scan.close();
	}
}