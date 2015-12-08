import java.util.Scanner;

/* Java application having as its purpose to exercise the methods of the
** CalendarDateParsers class.  
**
** This program repeatedly prompts the user to enter a string until an
** empty string is entered.
**
** For each non-empty string read the program passes the string to each
** of the "parsing methods" of the class and the return values are printed.
**
** At most one of the methods will recognize and convert the given string
** yielding a valid result.
**
**
** Authors: R. McCloskey and P.M.J.
** Date: Sept. 30, 2015
*/

public class TestCalendarDateParsers {

   private static Scanner keyboard = new Scanner(System.in);
   private static final String yMMDD     = "   yMMDD           ";
   private static final String Month_d_y = "   Month_d,_y      ";
   private static final String d_Month_y = "   d_Month_y       ";
   private static final String m_d_y     = "   m/d/y           ";
   private static final String d_Mon_y   = "   d-Mon-y         ";
   private static final String y_m_d     = "   y-m-d           ";

   public static void main(String[] args) {
   
      String result;
      String input = getStringFromUser("Enter a date value:").trim();
      
      // Keep iterating as long as user enters a non-empty string.
      while (input.length() > 0) {
         //-------------------------------------------------------------------------------------
         System.out.println(yMMDD     + CalendarDateParsers.parse_yMMDD(input));
         System.out.println(Month_d_y + CalendarDateParsers.parse_Month_d_y(input));
         System.out.println(d_Month_y + CalendarDateParsers.parse_d_Month_y(input));
         System.out.println(m_d_y     + CalendarDateParsers.parse_m_d_y(input));
         System.out.println(d_Mon_y   + CalendarDateParsers.parse_d_Mon_y(input));
         System.out.println(y_m_d     + CalendarDateParsers.parse_y_m_d(input));
         //-------------------------------------------------------------------------------------
         input = getStringFromUser("\nEnter a date value:").trim();
      }
   }

   /* Prints the specified prompt and returns the user's response,
   ** as a String value.  
   */
   private static String getStringFromUser(String prompt) {
      System.out.print(prompt);
      return keyboard.nextLine(); 
   }
   
}
