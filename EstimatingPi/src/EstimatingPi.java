import java.util.Random;

public class EstimatingPi {

	public static void main(String[] args) {
		
		final int DARTS = 100000;
		int hits = 0;
		
		for(int i = 0; i < DARTS; i++) {
			Random random = new Random();
			double x = random.nextDouble(-1, 1);
			double y = random.nextDouble(-1, 1);
			double r = Math.sqrt(x * x + y * y);
			if (r <= 1) {
				hits += 1;
			}
		}
		
		double pi = 4 * ((double) hits) / DARTS;

		System.out.println("Estimate for PI is " + pi);
		
		

	}

}
