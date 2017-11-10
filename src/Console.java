import java.util.ArrayList;
import java.util.Scanner;

/*
 * Validators for user input
 */
public class Console {


	public static String chooseCell() {
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
		Scanner sc = new Scanner(System.in);	
		boolean confirmation = Validator.getYOrN(sc, "\nAre you sure? (y/n) ");
		
			return confirmation ;
		
	}
}
