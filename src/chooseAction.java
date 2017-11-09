import java.util.ArrayList;
import java.util.Scanner;


public class chooseAction {

	// 2-Choose action - F(Flag), Q(Question), U(Uncover)
	
	public static void chooseAction() {
		Scanner sc = new Scanner(System.in);
		Validator.getString(sc, "Choose action F(Flag), Q(Question), or U(Uncover)");
		String actionChosen = sc.next();
	}
}
