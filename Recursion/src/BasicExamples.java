
public class BasicExamples {

	public static void printCountdown(int n) {
		System.out.println(n);
		if (n == 0) {
			return;
		}
		else {
		//if (n > 0) {
			printCountdown(n-1);
		}
		System.out.println(n);
	}
	
	public static int factorialIterative(int n) {
		int result = 1;
		for(int i = n; i > 1; i--) {
			result = result * i;
		}
		return result;
	}
	
	public static int factorialRecursive(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorialRecursive(n-1);
	}
	
	
	public static void main(String [] args) {
		System.out.println(factorialIterative(5));
		System.out.println(factorialRecursive(5));
	}
	
	
	
}
