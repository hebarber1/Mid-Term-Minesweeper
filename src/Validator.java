import java.util.ArrayList;
import java.util.Scanner;

public class Validator
{
    public static String getString(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.next();  // read user entry
        sc.nextLine();  // discard any other data entered on the line
        return s;
    }
    
    public static String getChar(Scanner sc, String prompt, String string1, String string2) {
		String i = null;
		boolean isValid = false;
		String string = null;

		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNext()) {
				string = sc.next();
				if (string.length() == 1 && (string.equalsIgnoreCase(string1) || string.equalsIgnoreCase(string2))) {
					i = string;
					isValid = true;
				} else {
					System.out.println("Invalid choice. Try again.\n");
				}
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static String getChar(Scanner sc, String prompt, String string1, String string2, String string3) {
		String i = null;
		boolean isValid = false;
		String string = null;

		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNext()) {
				string = sc.next();
				if (string.length() == 1 && (string.equalsIgnoreCase(string1) || string.equalsIgnoreCase(string2) || string.equalsIgnoreCase(string3))) {
					i = string;
					isValid = true;
				} else {
					System.out.println("Invalid choice. Try again.\n");
				}
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

    public static int getInt(Scanner sc, String prompt)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt,
    int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(sc, prompt);
            if (i < min)
                System.out.println(
                    "Error! Number must be " + min + " or greater.");
            else if (i > max)
                System.out.println(
                    "Error! Number must be " + max + " or less.");
            else
                isValid = true;
        }
        return i;
    }

    public static double getDouble(Scanner sc, String prompt)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(Scanner sc, String prompt,
    double min, double max)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            d = getDouble(sc, prompt);
            if (d < min)
                System.out.println(
                    "Error! Number must be " + min + " or greater.");
            else if (d > max)
                System.out.println(
                    "Error! Number must be " + max + " or less.");
            else
                isValid = true;
        }
        return d;
    }

	/**
	 * Gets a string, validates that it's y/n, then returns true or false. This is
	 * useful when prompting the user to enter yes/no.
	 * 
	 * @param sc
	 *            scanner
	 * @param prompt
	 *            prompt to display to the user
	 * @return true for yes and false for no
	 */
	public static boolean getYOrN(Scanner sc, String prompt) {
		ArrayList<String> validOptions = new ArrayList<>();
		validOptions.add("y");
		validOptions.add("n");
		validOptions.add("Y");
		validOptions.add("N");

		System.out.print(prompt);
		String s = sc.next(); // read user entry

		while (!validOptions.contains(s)) {
			System.out.println(
					"You must enter one of the following options: " + validOptions.toString() + ". Please try again.");
			s = sc.next();
		}

		sc.nextLine(); // discard any other data entered on the line

		return s.equalsIgnoreCase("y");
	}
}