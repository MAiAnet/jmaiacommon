package com.maianet.extension;

/**
 * Java extension of String class. Utility extension methods to work with strings.
 * @author Mattia Zuliani
 * @version 0.0.1
 */
public class StringExtension {
    
    /**
     * Return length of string. If it is null, the method will return 0.
     * @param value String value.
     * @return Length of string.
     */
    public static int length(String value) {
        if(isNotEmptyOfNull(value)) {
            return 0;
        }
        
        return value.length();
    }
    
    /**
     * Create a empty string.
     * @return Empty string.
     */
    public static String empty() {
        return new String();
    }
    
    /**
     * Check if the value string is null or if it is empty.
     * @param value String value.
     * @return True if string is null or empty.
     */
    public static boolean isEmptyOrNull(String value) {        
        // Check if value is null.
        if(value == null) {
            return true;
        }
        // Check if value is empty.        
        return value.trim().length() == 0;
    }
    
    /**
     * Check if 'value' string is empty.
     * @param value String to check.
     * @return Return true if string is empty.
     * @throws NullPointerException When 'value' is null.
     */
    public static boolean isEmpty(String value) throws NullPointerException {
        if(value == null) {
            throw new NullPointerException("'value' must not be null.");
        }
        
        // Check if value is empty.        
        return value.trim().length() == 0;
    }
    
    /**
     * Check if the values string is not null or if it is not empty.
     * @param value String value.
     * @return True if string is not null or empty.
     */
    public static boolean isNotEmptyOfNull(String value) {
        return !isEmptyOrNull(value);
    }
    
    /**
     * Check if two strings are equals. It is possible to manage how check the equals algoritms. 
     * In this case ignoreTrim is true and ignoreCase is false.
     * @param a String alfa
     * @param b String beta
     * @return True if both strings are equals.
     */
    public static boolean areEquals(String a, String b) {
        return areEquals(a, b, true, false);
    }
    
    /**
     * Check if two strings are equals. It is possible to manage how check the equals algoritms. 
     * @param a String alfa
     * @param b String beta
     * @param ignoreTrim If true, remove space at the begin and at the end of strings.
     * @param ignoreCase If true, it ignore case of both strings.
     * @return True if both strings are equals.
     */
    public static boolean areEquals(String a, String b, boolean ignoreTrim, boolean ignoreCase) {
        
        String alfa = a;
        String beta = b;
        
        // Check if alfa and beta are both null.
        if(alfa == null && beta == null) {
            return true;
        } 
        
        // Check if alfa and beta are both empty.
        if(isNotEmptyOfNull(alfa) && isEmptyOrNull(beta)) {
            return true;
        }
        
        if(ignoreTrim) {
            alfa = alfa.trim();
            beta = beta.trim();
        }
        
        if(ignoreCase) {
            alfa = alfa.toLowerCase();
            beta = beta.toLowerCase();
        }
        
        return alfa.equals(beta);
    }
    
}
