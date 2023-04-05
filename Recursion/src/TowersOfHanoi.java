public class TowersOfHanoi {


    /**
     * A recursive function that solves the Towers of Hanoi problem and prints the steps.
     *
     * @param n         The number of disks to move.
     * @param source    The source rod where the disks are initially placed.
     * @param target    The target rod where the disks should be moved to.
     * @param auxiliary The auxiliary rod used as a temporary holding place for disks.
     */
    public static void hanoi(int n, char source, char target, char auxiliary) {
        // Base case: If there is only one disk, print the move from source to target.
        if (n == 1) {
        	totalMoves++;
            System.out.println("Move disk 1 from " + source + " to " + target);
        } else {
            // Recursive case:
            
            // Step 1: Move the top n-1 disks (pile) from the source rod to the auxiliary rod,
            // using the target rod as a temporary placeholder.
            hanoi(n - 1, source, auxiliary, target);
            
            // Step 2: Move the nth disk from the source rod to the target rod.
        	totalMoves++;
            System.out.println("Move disk " + n + " from " + source + " to " + target);
            
            // Step 3: Move the n-1 (pile) disks from the auxiliary rod to the target rod,
            // using the source rod as a temporary placeholder.
            hanoi(n - 1, auxiliary, target, source);
        }
    }
    
    
    public static long totalMoves = 0;
    
    public static void main(String[] args) {
        int n = 6; // Number of disks. Change this value to experiment with different numbers of disks.
        
        // Call the hanoi() function to solve the problem and print the steps.
        // Pass the number of disks 'n', source rod 'A', auxiliary rod 'B', and target rod 'C'.
        hanoi(n, 'A', 'C', 'B');
        
        System.out.println("It took a total of " + totalMoves + " moves.");
    }
}
