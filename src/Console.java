import java.util.ArrayList;
import java.util.Scanner;

//Herman
public class Console {

	// METHOD printMenu() will print the following choices to the console
		
	public static String chooseCell() {
		// 1-Choose cell
		Scanner sc = new Scanner(System.in);		
		String cellName = Validator.getString(sc, "\nPlease choose a cell: (row/column, i.e. 'A1') ");
			return cellName;	
		}
	
	public static String chooseAction() {
		Scanner sc = new Scanner(System.in);		
		String actionChosen = Validator.getChar(sc, "\nChoose action F(flag as mine), Q(flag as Question), or U(Uncover)","F","Q","U" );
			return actionChosen;	
	}
	
	public static boolean confirmAction(){
		
		// 3-Confirm Action
		Scanner sc = new Scanner(System.in);	
		boolean confirmation = Validator.getYOrN(sc, "\nAre you sure? (y/n) ");
		
			return confirmation ;
		
	}
	
	// 4-Clear Action	
	// 5-Quit

}
