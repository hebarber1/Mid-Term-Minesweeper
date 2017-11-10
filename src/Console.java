import java.util.ArrayList;
import java.util.Scanner;

//Herman
public class Console {

	// METHOD printMenu() will print the following choices to the console
		
	public static String chooseCell() {
		// 1-Choose cell
		Scanner sc = new Scanner(System.in);		
		String cellName = Validator.getString(sc, "Please choose a cell?");
			return cellName;	
		}
	
	public static String chooseAction() {
		Scanner sc = new Scanner(System.in);		
		String actionChosen = Validator.getString(sc, "Choose action F(Flag), Q(Question), or U(Uncover)");
			return actionChosen;	
	}
	
	public static String confirmAction(){
		
		// 3-Confirm Action
		Scanner sc = new Scanner(System.in);	
		Validator.getYOrN(sc, "Are you sure? (y/n)");
			return null ;
		
	}
	
	// 4-Clear Action	
	// 5-Quit

}
