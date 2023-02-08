import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class WorldPop {

   public static void main(String [] args) throws IOException {
   
      // open file and setup the scanner
      FileInputStream fs = new FileInputStream("worldpop.txt");
      Scanner file = new Scanner(fs);
      
      // setup our accumulation variables and print a header
      long total = 0;
      long count = 0;
      System.out.printf("%40s|%12s|\n","Country Name", "Population");
      System.out.println("=".repeat(54));
      
      // while there are lines to read in the file
      while(file.hasNextLine()) {
         // read the line
         String line = file.nextLine();
         // setup another scanner to process (scan) the line
         Scanner input = new Scanner(line);
         String name = "";
         long population = 0;
         
         // while there are words in this individual line to read
         while(input.hasNext()) {
            // is the next word an integer (or long)
            if(input.hasNextLong()) {
               // yes it is an integer, it is the population, read it
               population = input.nextLong();
            }
            else {
               // not an integer, so it must be part of the country name
               name += " " + input.next();
            }
         }
         
         // output the country population
         System.out.printf("%40s|%12d|\n",name, population);
         
         // accumulate our world population totals
         total += population;
         count++;
      }
      
      // output the world population data
      System.out.println("=".repeat(54));
      System.out.printf("%40s|%12d|\n","World Population", total);
      System.out.printf("%40s|%12d|\n","Number of Countries", count);
      System.out.printf("%40s|%12d|\n","Country Average", total / count);
      fs.close();  
   
   
   }


}