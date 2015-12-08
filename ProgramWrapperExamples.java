import java.util.Scanner;
public class ProgramWrapperExamples {

   private static Scanner keyboard = new Scanner(System.in);
   public static void main(String[] args) {
   
      String input = getStringFromUser("Enter:").trim();
      // Keep iterating as long as user enters a non-empty string.
      while (input.length() > 0) {
         //-------------------------------------------------------------------------------------
         if(isUnsignedIntNumeral(input)) {
            int number = Integer.parseInt(input);          //Wrapper class method
            System.out.println("The number is " + number);
         } 
         else {
            System.out.println("Invalid int");
         }
         //-------------------------------------------------------------------------------------
         input = getStringFromUser("\nEnter:").trim();
      }
   }
   
   private static boolean isUnsignedIntNumeral(String s) {
      boolean result = true;
      int i = 0;
      while(result && (i < s.length())) {
         /*
         if((s.charAt(i)=='0') || (s.charAt(i)=='1') || (s.charAt(i) == '2') ||
            (s.charAt(i)=='3') || (s.charAt(i)=='4') || (s.charAt(i) == '5') ||
            (s.charAt(i)=='6') || (s.charAt(i)=='7') || (s.charAt(i) == '8') ||
            (s.charAt(i)=='9') )  { 
         */   
         if(Character.isDigit(s.charAt(i))) {             //Wrapper class method
            i = i + 1;
         } 
         else {
            result = false;
         }
      }
      return result;
   }

   /* Prints the specified prompt and returns the user's response,
   ** as a String value.  
   */
   private static String getStringFromUser(String prompt) {
      System.out.print(prompt);
      return keyboard.nextLine(); 
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
