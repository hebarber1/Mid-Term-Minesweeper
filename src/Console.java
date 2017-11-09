import java.util.ArrayList;
import java.util.Scanner;

//Herman
public class Console {

	// METHOD printMenu() will print the following choices to the console
		
	public static void chooseCell() {
		// 1-Choose cell
		Scanner sc = new Scanner(System.in);
		Validator.getString(sc, "Please choose a cell?");
		String cellName = sc.next();
				
		}
	
	public static void chooseAction() {
		Scanner sc = new Scanner(System.in);
		Validator.getString(sc, "Choose action F(Flag), Q(Question), or U(Uncover)");
		String actionChosen = sc.next();
		
		
	}
	
	public static void confirmAction(){
		
		// 3-Confirm Action
		Scanner sc = new Scanner(System.in);	
		Validator.getYOrN(sc, "Are you sure? (y/n)");
		
	}
	
	// 4-Clear Action	
	// 5-Quit

}
