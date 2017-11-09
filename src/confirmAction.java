import java.util.Scanner;


public class confirmAction {
	
	public static void confirmAction(){
		
		// 3-Confirm Action
		Scanner sc = new Scanner(System.in);	
		Validator.getYOrN(sc, "Are you sure? (y/n)");
		
	}
	
	

}
