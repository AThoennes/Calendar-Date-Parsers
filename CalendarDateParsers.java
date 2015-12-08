/* Java class that presents a collection of static methods, each of which is
** capable of converting a calendar date expressed by a string of a particular
** form into an equivalent calendar date value expressed in the form YYYYMMDD.
** 
** The following forms are supported:
**
**   ID           Form         Examples
** ---------    ----------    ----------------------------------------------------------------
** Month_d_y    Month_d,_y    December 25, 1978  July 4, 1776    June 06,1942    April 01, 123
** d_Month y    d_Month_y     25 December 1978   4 July 1776     06 June 1942    01 April 123 (ALEX)
** m_d_y        m/d/y         12/25/1978         7/4/1776        06/06/1944      04/01/123    
** d_Mon_y      d-Mon-y       25-Dec-1878        4-Jul-1776      06-Jun-1944     01-Apr-123   
** y_m_d        y-m-d         1978-12-25         1776-7-4        1944-06-06      123-04-01    (ALEX)
** yMMDD        yMMDD         19781225           17760704        19440606        1230401     
**
** YYYYMMDD     YYYYMMDD      19781225           17760704        19440606        01230401
**
** Note the following in the above forms:
**    - y, m and d each represent numerals with one or more digits, allowing for leading zeroes
**    - each Y, M and D represents exactly one digit
**    - Mon represents one of the three character abbreviations for a month name
**    - Month represents the full name of a month
**
** Authors: R. McCloskey and P.M.J. 
** Date: Oct. 14, 2015
*
* By: Alex Thoennes
* October 22, 2015
*/

public class CalendarDateParsers {

   public static String INVALID_RESULT = "00000000";

   private static char SPACE = ' ';
   private static char DASH = '-';
   private static char SLASH = '/';
   private static char COMMA = ',';
   private static int  MONTHS_IN_YEAR = 12;
   
   //Constants used to define month names
   private static final String JANUARY = "January";
   private static final String FEBRUARY = "February";
   private static final String MARCH = "March";
   private static final String APRIL = "April";
   private static final String MAY = "May";
   private static final String JUNE = "June";
   private static final String JULY = "July";
   private static final String AUGUST = "August";
   private static final String SEPTEMBER = "September";
   private static final String OCTOBER = "October";
   private static final String NOVEMBER = "November";
   private static final String DECEMBER = "December";

   /* Given a calendar date as described by a string in Month_d_y form,
   ** returns the same date as described in the YYYYMMDD form.
   ** If the given string is not in the required form, or if the
   ** calendar date it describes is not semantically valid (e.g., April 31
   ** of some year), the value returned is INVALID_RESULT (as defined above).
   **
   ** Examples:  "April 13, 1962" maps to "19620413"
   **            "December 7,1856" maps to "18561207" 
   */
   public static String parse_Month_d_y(String dateStr) {
      String result = INVALID_RESULT;
      return result; //Stub!!!
   }

   /* Given a calendar date as described by a string in d_Month_y form,
   ** returns the same date as described in the YYYYMMDD form.
   ** If the given string is not in the required form, or if the
   ** calendar date it describes is not semantically valid (e.g., April 31
   ** of some year), the value returned is INVALID_RESULT (as defined above).
   **
   ** Examples:  "15 April 2013" maps to "20130415"
   **            "8 March 896" maps to "08960308" 
   **            "5 November 10213" maps to "00000000"
   */
   public static String parse_d_Month_y(String dateStr) {
      String result = INVALID_RESULT;
      for (int i = 0; i < dateStr.length(); i++)
      {
    	  if (dateStr.charAt(i) == SPACE)
    	  {
    		  //set the strings as substrings of dateStr
		      String yearStr = dateStr.substring(dateStr.lastIndexOf(SPACE)+1);
		      String monthStr = dateStr.substring(dateStr.indexOf(SPACE)+1,dateStr.lastIndexOf(SPACE));
		      String dayStr = dateStr.substring(0, dateStr.indexOf(SPACE));
		      
		      //convert strings to numbers
		      int month = numberOfMonth(monthStr);
		      Integer day = Integer.valueOf(dayStr);
		      Integer year = Integer.valueOf(yearStr);
		      
		      //check to make sure everything is valid
		      if (isValidMonthDayYear(month,day,year))
		      {
		    	  monthStr = Integer.toString(numberOfMonth(monthStr));
			      yearStr = addZeroToYear(yearStr);
			      monthStr = addZeroToMonth(monthStr);
			      dayStr = addZeroToDay(dayStr);
			      
			      //put it all together
			      result = yearStr+monthStr+dayStr;
			  }
		      break;
	      }
      }     
      return result; 
   }

   /* Given a calendar date as described by a string in m_d_y form,
   ** returns the same date as described in the YYYYMMDD form.
   ** If the given string is not in the required form, or if the
   ** calendar date it describes is not semantically valid (e.g., April 31
   ** of some year), the value returned is INVALID_RESULT (as defined above).
   **
   ** Examples:  "04/15/2013" maps to "20130415"
   **            "4/8/896" maps to "08960408" 
   **            "11/5/213" maps to "2131105"
   */
   public static String parse_m_d_y(String dateStr) {
      String result = INVALID_RESULT;
      return result; //Stub!!!
   }

   /* Given a calendar date as described by a string in d_Mon_y form,
   ** returns the same date as described in the YYYYMMDD form.
   ** If the given string is not in the required form, or if the
   ** calendar date it describes is not semantically valid (e.g., April 31
   ** of some year), the value returned is INVALID_RESULT (as defined above).
   **
   ** Examples:  "13-Apr-1962" maps to "19620413"
   **            "7-Dec-1856" maps to "18561207" 
   */
   public static String parse_d_Mon_y(String dateStr) {
      String result = INVALID_RESULT;
      return result; //Stub!!!
   }

   /* Given a calendar date as described by a string in y-m-d form,
   ** returns the same date as described in the YYYYMMDD form.
   ** If the given string is not in the required form, or if the
   ** calendar date it describes is not semantically valid (e.g., April 31
   ** of some year), the value returned is INVALID_RESULT (as defined above).
   **
   ** Examples:  "1978-11-05" maps to "19781105"
   **            "2013-3-7" maps to "20130307"
   */
   public static String parse_y_m_d(String dateStr) {
      String result = INVALID_RESULT;
      
      for (int i = 0; i < dateStr.length(); i++)
      {
    	  if (dateStr.charAt(i) == DASH)
		  {
		      String yearStr = dateStr.substring(0,dateStr.indexOf(DASH));
		      String monthStr = dateStr.substring(dateStr.indexOf(DASH)+1, dateStr.lastIndexOf(DASH));
		      String dayStr = dateStr.substring(dateStr.lastIndexOf(DASH)+1);
		      
		      int month = numberOfMonth(monthStr);
		      Integer day = Integer.valueOf(dayStr);
		      Integer year = Integer.valueOf(yearStr);
		      
		      if (isValidMonthDayYear(month,day,year))
		      {
		    	  monthStr = addZeroToMonth(monthStr);
			      dayStr = addZeroToDay(dayStr);
			      
			      result = yearStr+monthStr+dayStr;
			   }
		      break;
	      }
      }
      return result;
   }

   /* Given a calendar date as described by a string in yMMDD form,
   ** returns the same date as described in the YYYYMMDD form.
   ** If the given string is not in the required form, or if the
   ** calendar date it describes is not semantically valid (e.g., April 31
   ** of some year), the value returned is INVALID_RESULT (as defined above).
   **
   ** Examples:  "19781105" maps to "19781105"
   **            "5470317" maps to "05470317"
   */
   public static String parse_yMMDD(String dateStr) {  
      String result = INVALID_RESULT;
      int length = dateStr.length();
      if(dateStr.length() >= 5) {
         // Isolate the individual parts
         String yearStr = dateStr.substring(0,(length-4));
         String monthStr = dateStr.substring((length-4),(length-2));
         String dayStr = dateStr.substring((length-2),length);
         // Make sure each part is a number
         if (isUnsignedIntNumeral(yearStr) && 
             isUnsignedIntNumeral(monthStr) &&
             isUnsignedIntNumeral(dayStr)) { 
            // The given calendar date string is syntactically valid!
            // Determine the integers corresponding to year, month, and day
            int year = Integer.parseInt(yearStr);
            int month = Integer.parseInt(monthStr);
            int day = Integer.parseInt(dayStr);
            // Determine that each part is semantically valid
            if (isValidMonthDayYear(month, day, year)) {
               // The date is semantically valid, so compute the YYYY, MM, and DD
               // substrings to be concatenated to obtain the result.
               String yStr = intToNumeral(year, 4);
               String mStr = intToNumeral(month, 2);
               String dStr = intToNumeral(day, 2);
               result = yStr + mStr + dStr;
            }
         }
      }
      return result;
   }

// -------------------------------------------------------------------------------------
// P r i v a t e   M e t h o d s
// -------------------------------------------------------------------------------------

   /* Returns true if the given integer values for month, day, and year describe a valid 
   ** calendar date, and false otherwise.  To be valid, the month must be in the range 
   ** 1..MONTHS_IN_YEAR and the day must be in the range 1..monthDays(m,y) and the year 
   ** must be in the range 1..9999.
   */
   private static boolean isValidMonthDayYear(int month, int day, int year) {
	  boolean isValidDate = false;
	  if (month <= MONTHS_IN_YEAR && month > 0)
	  {
		  if (day <= monthDays(month,year) && day > 0)
		  {
			  if (year <= 9999 && year > 0)
			  {
				  isValidDate = true;
			  }
		  }
	  }
	  else
	  {
		  isValidDate = false;
	  }
	  return isValidDate;
   }

   /* Given a string, returns true if it has the form of an unsigned decimal 
   ** integer numeral, and false otherwise.  Specifically, such a numeral is a
   ** nonempty string of digit characters.  
   ** (The digit characters are '0', '1', ..., '9'.)
   */
   private static boolean isUnsignedIntNumeral(String str) {
      boolean result = true;
      if (str.length() == 0) { 
         result = false;
      }
      else {
         for (int i=0; i != str.length() && result; i = i+1) {
            if (!Character.isDigit(str.charAt(i))) { 
               result = false;
            }
         }
      }
      return result;
   }

   /* Given a month number (1 is Jan, 2 is Feb, etc.) and a year, returns 
   ** the number of days in that month of that year.
   ** precondition: 0 < month <= MONTHS_IN_YEAR 
   */
   private static int monthDays(int month, int year) {
      int result;
      if (month == 2) {          // February
         if (isLeapYear(year)) { 
            result = 29; 
         }
         else { 
            result = 28; 
         }
      }
      else if (month == 4 || month == 6 || month == 9 || month == 11) {
         // April, June, September, or November
         result = 30;
      }
      else {   // month is one of 1, 3, 5, 7, 8, 10, or 12 (a 31-day month)
         result = 31;
      }
      return result;
   }

   /* Returns true if the given year is a leap year, false otherwise.
   ** A year is a leap year if it is divisible by 400, or if it is
   ** divisible by 4 but not by 100.
   */
   private static boolean isLeapYear(int year) {
	  boolean result = false;
	  if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
	  {
		  result = true;
	  }
	  else {
		  result = false;
	  }
      return result;
   }

   /* Returns a decimal numeral of at least the specified length (numDigits)
   ** that corresponds to the specified integer value (k), assumed to be
   ** nonnegative.  Leading zeros are used to pad the result up to the 
   ** desired length.
   ** Examples: k = 14 and numDigits = 3 results in "014" being returned.
   **           k = 3 and numDigits = 5 results in "00003" being returned.
   **           k = 2456 and numDigits = 2 results in "2456" being returned.
   */
   private static String intToNumeral(int k, int numDigits) {
      String result = Integer.toString(k);
      // Stub!!! (leading zeroes may need to be prepended)
      return result;
   }
   
   /* Returns true if and only if the given string is one of the twelve
   ** abbreviations for a month.
   */
   private static boolean isValidMon(String s) {
      return true;  //Stub!!! 
   }

   /* Returns the month number corresponding to the abbreviation for the month
   ** whose abbreviation is equivalent to the given string.  If the string does
   ** not match any of the twelve abbreviations then zero is returned.
   */
   private static int numberOfMon(String s) {
	   int result = 0;
	   return result; //Stub!!!
   }

   /* Returns true if and only if the given string is one of the twelve
   ** names for a month.
   */
   private static boolean isValidMonth(String s) {
	  boolean isValidMonth = true;
	  if (s.equalsIgnoreCase(JANUARY))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(FEBRUARY))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(MARCH))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(APRIL))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(MAY))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(JUNE))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(JULY))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(AUGUST))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(SEPTEMBER))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(OCTOBER))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(NOVEMBER))
	  {
		  isValidMonth = true;
	  }
	  else if (s.equalsIgnoreCase(DECEMBER))
	  {
		  isValidMonth = true;
	  }
	  return isValidMonth;
	  /*if (numberOfMonth(s) >= 1 && numberOfMonth(s) <= 12)
	  {
		  isValidMonth = true;
	  }
	  else 
	  {
		  isValidMonth = false;
	  }
      return isValidMonth;*/
   }

   /* Returns the month number corresponding to the month name that is equivalent to 
   ** the given string.  If the string does not match any of the twelve month names
   ** then zero is returned.
   */
   private static int numberOfMonth(String s) {
      int monthNum = 0;
    	  if (s.equalsIgnoreCase(JANUARY) || s.equals("1"))
    	  {
    		  monthNum = 1;
    	  }
    	  else if (s.equalsIgnoreCase(FEBRUARY) || s.equals("2"))
    	  {
    		  monthNum = 2;
    	  }
    	  else if (s.equalsIgnoreCase(MARCH) || s.equals("3"))
    	  {
    		  monthNum = 3;
    	  }
    	  else if (s.equalsIgnoreCase(APRIL) || s.equals("4"))
    	  {
    		  monthNum = 4;
    	  }
    	  else if (s.equalsIgnoreCase(MAY) || s.equals("5"))
    	  {
    		  monthNum = 5;
    	  }
    	  else if (s.equalsIgnoreCase(JUNE) || s.equals("6"))
    	  {
    		  monthNum = 6;
    	  }
    	  else if (s.equalsIgnoreCase(JULY) || s.equals("7"))
    	  {
    		  monthNum = 7;
    	  }
    	  else if (s.equalsIgnoreCase(AUGUST) || s.equals("8"))
    	  {
    		  monthNum = 8;
    	  }
    	  else if (s.equalsIgnoreCase(SEPTEMBER) || s.equals("9"))
    	  {
    		  monthNum = 9;
    	  }
    	  else if (s.equalsIgnoreCase(OCTOBER) || s.equals("10"))
    	  {
    		  monthNum = 10;
    	  }
    	  else if (s.equalsIgnoreCase(NOVEMBER) || s.equals("11"))
    	  {
    		  monthNum = 11;
    	  }
    	  else if (s.equalsIgnoreCase(DECEMBER) || s.equals("12"))
    	  {
    		  monthNum = 12;
    	  }
      return monthNum;
   }
   
   
   /*
    * This method adds a 0 to the
    * front of the month is the month
    * number is less than 10
    */
   private static String addZeroToMonth(String s)
   {
	   int month = numberOfMonth(s);
	   if (month < 10)
	   {
	 	  s = "0" + s;
	   }
	   return s;
   }
   
   /*
    * This method adds a 0 to the
    * front of the day is the day
    * number is less than 10
    */
   private static String addZeroToDay(String s)
   {
	   Integer day = Integer.valueOf(s);
	   if (day < 10 && !s.startsWith("0"))
	   {
		   s = "0" + s;
	   }
	   return s;
   }
   
   /*
    * This method adds a 0 to the
    * front of the year is the year
    * length is less than 4
    */
   private static String addZeroToYear(String s)
   {
	   if (s.length() < 4)
	   {
		   s = "0" + s;
	   }
	   return s;
   }
}
