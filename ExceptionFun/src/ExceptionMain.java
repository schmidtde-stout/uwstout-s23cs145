import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your age: ");
		
		// in.close(); if scanner is closed too early, it generates IllegalStateException
		
		try {
			int age = in.nextInt();
			if (age < 30) {
				System.out.print(age + "? You're alright.");
			} else {
				System.out.println(age + "? You cannot be trusted!");
			}
		} catch (InputMismatchException exception) {
			System.out.println("It looks like didn't input an integer: " + exception);
		} catch(IllegalStateException exception) {
			System.out.println("You closed Scanner to early!");
		}

		in.close();

	}

}
