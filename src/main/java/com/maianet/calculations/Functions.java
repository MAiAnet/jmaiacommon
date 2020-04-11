package com.maianet.calculations;

/**
 * Math static functions to operate in fast way. 
 * @author Mattia Zuliani
 * @version 0.0.1
 */
public class Functions {
    
    /**
     * Sum all numbers into input string.
     * Improved By : mohit kumar 29, iskra, nidhi_biet, AnkitRai01, princiraj1992
     * @param str Input strings.
     * @return Sum of numper write into input string.
     */
    public static int sumNumbersInString(String str) 
    {
        // A temporary string  
        String temp = ""; 
        
        // holds sum of all numbers present in the string  
        int sum = 0;  
      
        // read each character in input string  
        for(int i = 0; i < str.length(); i++)  
        {  
            char ch = str.charAt(i); 
              
            // if current character is a digit  
            if (Character.isDigit(ch))  
                temp += ch;  
      
            // if current character is an alphabet  
            else
            {  
                // increment sum by number found earlier  
                // (if any)  
                sum += Integer.parseInt(temp);  
      
                // reset temporary string to empty  
                temp = "0";  
            }  
        }  
      
        // atoi(temp.c_str()) takes care of trailing  
        // numbers  
        return sum + Integer.parseInt(temp);  
    }
}
