
public class DivideByZeroException extends ArithmeticException {
	private double dividend;
	
	public DivideByZeroException(double dividend) {
		super("Divide by zero error");
		this.dividend = dividend;
		
	}
	
	public double getDividend() {
		return dividend;
	}

}
