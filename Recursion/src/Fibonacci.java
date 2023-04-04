
public class Fibonacci {
	
    public static long fibonacciIterative(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be a positive number");
        }

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        long a = 0;
        long b = 1;
        long nthTerm = 0;

        int count = 0;
        for (int i = 3; i <= n; i++) {
        	count++;
            nthTerm = a + b;
            a = b;
            b = nthTerm;
        }
        System.out.println("Iterative took " + count);
        return nthTerm;
    }
    
    public static long fibonacciRecursive(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be a positive number");
        }

        /*
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        */
        return smarterFibonacci(n, 0, 1);
    }
    
    public static long smarterFibonacci(int n, long a, long b) {
    	if (n == 2) {
    		return b;
    	}
        recursiveCount++;
    	return smarterFibonacci(n - 1, b, a + b);
    }
    

    public static int recursiveCount = 0;
    
    
    
    
    
    public static void main(String[] args) {
        int n = 10; // You can change this value to test different terms
        long an = fibonacciIterative(n);
        System.out.println("The " + n + "th term of the Fibonacci sequence is (iterative): " + an);
        
        an = fibonacciRecursive(n);
        System.out.println("Recursive took " + recursiveCount);
        System.out.println("The " + n + "th term of the Fibonacci sequence is (recursive): " + an);
    }

	

}
