import java.util.Scanner;
public class TestMonthDaysMV2 {
   static Scanner keyboard = new Scanner(System.in);
   public static void main(String[] args) { 
      int answer;   
      do {
         int year = getIntFromUser("Enter a year number:");
         int month = getIntFromUser("Enter a month number:");
         answer = monthDays(month,year);
         System.out.println(answer);
      } while(answer != 0);
   }
   
   private static int monthDays(int monthNumber, int yearNumber) {
      int result = 0;
      if(monthNumber == 2) {
         result = 28;      } 
      else {
         if((monthNumber == 4) || (monthNumber == 6) || 
         (monthNumber == 9) || (monthNumber == 11) ) {
            result = 30;  
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
