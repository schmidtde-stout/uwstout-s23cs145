import java.util.ArrayList;
import java.util.Scanner;

public class PassingParameters {

   public static void test(int byValue, ArrayList<String> list) {
      byValue = byValue + 123;
      list.add("World");
      System.out.printf("test, byValue = %d, list = %d\n", byValue, list.size());
   }
   
   public static int setRatingMinimum(Scanner scanner, int currentMinimumRating) {
   // Dont' do this:
      Scanner anotherScaner = new Scanner(System.in);
      
      String line = scanner.nextLine();
      if(scanner.hasNextInt()) {
      }
   }
 
   public static void main(String []args) {
      int byValue = 100;
      ArrayList<String> list = new ArrayList<String>();
      list.add("Hello");
      
      System.out.printf("Before, byValue = %d, list = %d\n", byValue, list.size());
      test(byValue, list);
      System.out.printf("After, byValue = %d, list = %d\n", byValue, list.size());
      list = null;
      System.out.printf("After, byValue = %d, list = %d\n", byValue, list.size());
      
      Scanner scanner = new Scanner(System.in);
      setRatingMinimum(scanner, 0);
   
   }



}