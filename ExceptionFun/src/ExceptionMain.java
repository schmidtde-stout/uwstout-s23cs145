import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionMain {
	
	// example of using a checked exception by handling it in scope
	public static void readFile() {
		try {
			FileInputStream fs = new FileInputStream("path/to/file");
			Scanner input = new Scanner(fs);
			input.close();
			System.out.println(input.nextLine());
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file: " + ex.getMessage());
		}
	}

	// example of using a checked exception by deferring it to the calling scope
	public static void readFileThrows() throws FileNotFoundException {
		FileInputStream fs = new FileInputStream("");
		Scanner input = new Scanner(fs);
		System.out.println(input.nextLine());
		input.close();
	}
	
	// using a method that is throwing requires a rethrow or handling
	public static void callReadFileThrows() {
		// this requires either a throws or a try catch
		// readFileThrows();
	}

	// we can create our own exceptions, exceptions created and thrown
	// that are unchecked do not require a throws
	// ArithmeticException extends from RunTimeException (which is unchecked)
	public static double divide(double dividend, double divisor) {
		if (divisor == 0.0) {
			throw new ArithmeticException("Error, don't divide by zero");
		}
		return dividend / divisor;
	}
	
	public static double divideCustom(double dividend, double divisor) {
		if (divisor == 0.0) {
			throw new DivideByZeroException(dividend);
		}
		return dividend / divisor;
	}	
	
	// exceptions created and thrown that are checked (not extended from RunTimeException) 
	// again require the throws declaration
	public static double divideChecked(double dividend, double divisor) throws Exception {
		if (divisor == 0.0) {
			throw new Exception("");
		}
		return dividend / divisor;
	}
	
	
	public static void main(String[] args) throws Exception{
		
		/*
		// calling an exception without a throws is just like calling Scanner.nextInt with no try catch
		divide(5.0, 0.0);			
		
		// however calling our function that throws a Checked Exception must handle or rethrow (implicit or explicit) 
		try {
			divideChecked(5.0, 0.0);
		}
		catch(Exception ex) {
			if (ex.getMessage().length() > 0) {
				System.out.println("Error encountered: " + ex.getMessage());
			}
			else {
				// we might find this error is so bad that our code can't continue either
				// we can opt to re-throw if we want, but the same rules will apply
				// if its a checked exception we need a throws on the function declaration, e.g.
				throw ex;
			}
		}
		
		
		// however calling our function that throws a Checked Exception must handle or rethrow (implicit or explicit) 
		try {
			divideCustom(5.0, 0.0);
		}
		catch(DivideByZeroException ex) {
			System.out.println(ex.getDividend());

		}
		*/
		
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
			
		// exceptions can be chained, children must be listed earlier in the
		// catch chain otherwise it will be polymorphically handled by the parent (and Java will complain)
		} catch (InputMismatchException exception) {
			System.out.println("It looks like didn't input an integer: " + exception);
		} catch (NoSuchElementException  exception) {
			System.out.println("There doesn't seem to be any input: " + exception);
		} catch(IllegalStateException exception) {
			System.out.println("You closed Scanner to early!");
		}
		finally {
			// will execute 
			// 1 - after the catch() block of a caught exception
			// 2 - execute if NO exception caught/generated
			System.out.println("Running the finally!");
			
			// cleanup operations that are independent of the exception
		}

		in.close();

	}

}
