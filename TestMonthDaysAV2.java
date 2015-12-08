import java.util.Scanner;
public class TestMonthDaysAV2{
   static Scanner keyboard = new Scanner(System.in);
   public static void main(String[] args) {    
      int monthNumber;
      do {
         monthNumber = getIntFromUser("enter a month number:");
         System.out.println(monthDays(monthNumber));
      } while(monthNumber > 0);
   
   }
   
   
   static private int monthDays(int month) {
      int result = 0;
      if((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
         result = 30;
      } 
      else {
         if(month == 2) {
            result = 28;
         } 
         else {
            result = 31;
         }
      }
      return result;
   }
   
   /* Displays the specified string (i.e., 'prompt', which is intended to be
   ** a prompt to the user) and then reads and returns the user's response,
   ** which is expected to be a whole number.  (If the user enters input that
   ** is not formatted in a way that it can be recognized as a whole number,
   ** an exception is thrown.)
   */
   private static int getIntFromUser(String prompt) {
      System.out.print(prompt);    // Prompt user to enter input value
      return keyboard.nextInt();   // Read and return user's response
   }
}
