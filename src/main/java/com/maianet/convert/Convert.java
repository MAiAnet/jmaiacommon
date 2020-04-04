package com.maianet.convert;

import com.maianet.extension.StringExtension;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Static methods to convert data. Microsoft .NET System.Convert (mscorlib.dll).
 * @author Mattia Zuliani
 * @version 0.0.1
 */
public class Convert {
    
    /**
     * Magic number to convert Date to days number.
     * MAGIC_DATE_TODATE = millisec * sec * min * hours = 86400000.
     */
    private static final long MAGIC_DATE_TODATE = 86400000L;
    
    /**
     * Magic number to convert Date to hours number.
     * MAGIC_DATE_TOHOURS = millisec * sec * min = 3600000.
     */
    private static final long MAGIC_DATE_TOHOURS = 3600000L;
    
    // <editor-fold defaultstate="collapsed" desc="toString">
    
    /**
     * Convert integer value in string.
     * @param value Integer value
     * @return Converted string.
     */
    public static String toString(int value) {
        return Integer.toString(value);
    }
    
    /**
     * Convert double value in string.
     * @param value Double value.
     * @return Converted string.
     */
    public static String toString(double value) {
        return Double.toString(value);
    }
    
    /**
     * Convert float value in string.
     * @param value Float value.
     * @return Converted string.
     */
    public static String toString(float value) {
        return Float.toString(value);
    }
    
    /**
     * Convert bool value in string.
     * @param value Boolean value.
     * @return Converted string.
     */
    public static String toString(boolean value) {
        return Boolean.toString(value);
    }
    
    /**
     * Convert long value in string.
     * @param value Long value.
     * @return Converted string.
     */
    public static String toString(long value) {
        return Long.toString(value);
    }
    
    /**
     * Convert Date value in string.
     * @param value Date value.
     * @return Converted string.
     */
    public static String toString(Date value) {
        return toString(value, null);
    }
    
    /**
     * Convert Date value in string with DateFormat.
     * @param value Date value.
     * @param format Date format. 
     * @return Converted string value.
     */
    public static String toString(Date value, DateFormat format) {
        if(value == null) {
            return new String();
        }
        
        if(format == null) {
            format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
        }
        
        return format.format(value);
    }
    
    /**
     * Convert Char value in string.
     * @param value Char value.
     * @return Converted string.
     */
    public static String toString(char value) {
        return String.valueOf(value);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="toBoolean">
    
    /**
     * Convert int value into boolean one.
     * @param value Integer value.
     * @return Return true if value == 0.
     */
    public static boolean toBoolean(int value) {
        return (value == 0);
    }
    
    /**
     * Convert double value into boolean one.
     * @param value Double value.
     * @return Return true if value == 0.
     */
    public static boolean toBoolean(double value) {
        return (value == 0);
    }
    
    /**
     * Convert float value into boolean one.
     * @param value Float value.
     * @return Return true if value == 0.
     */
    public static boolean toBoolean(float value) {
        return (value == 0);
    }
    
    /**
     * Convert string value into boolean one.
     * @param value String value.
     * @return Return boolean value.
     */
    public static boolean toBoolean(String value) {
        return Boolean.valueOf(value);
    }
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="toInteger">
    
    /**
     * Convert double value to integer one.
     * @param value Double value.
     * @return Return integer value.
     */
    public static int toInteger(double value) {
        return (int)value;
    }
    
    /**
     * Convert float value to ingeter one.
     * @param value Float value.
     * @return Return integer value.
     */
    public static int toInteger(float value) {
        return Float.floatToIntBits(value);
    }
    
    /**
     * Convert string value to integer one.
     * @param value String value.
     * @return Return integer value.
     */        
    public static int toInteger(String value) {
        return Integer.parseInt(value);
    }
    
    /**
     * Convert boolean value to integer one.
     * @param value Boolean value.
     * @return Return 0 if value == false.
     */
    public static int toInteger(boolean value) {
        return (value == false) ? 0 : 1;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="toDays">
    
    /**
     * Number of days from 1970-01-01.
     * @param value Date value. 
     * @return Number of days.
     */
    public static int toDays(Date value) {
        return (int)(value.getTime() / MAGIC_DATE_TODATE);
    }
    
    /**
     * Convert number of days into Date that starts from 1970-01-01. 
     * @param days Number of days.
     * @return Date value.
     */
    public static Date toDateFromDays(int days) {
        return new Date((long)(days * MAGIC_DATE_TODATE));
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="toHours">
    
    /**
     * Convert date into a number of hours.
     * @param value Date value.
     * @return Hours from 1970.1.1.
     */
    public static long toHours(Date value) {
        return (value.getTime() / MAGIC_DATE_TOHOURS);
    }
    
    /**
     * Convert number of hours into Date that starts from 1979-01-01.
     * @param hours Number of hours.
     * @return Date value.
     */
    public static Date toDateFromHours(long hours) {
        return new Date((long)(hours * MAGIC_DATE_TOHOURS));
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="toLong">
    
    /**
     * Convert double value in a long one.
     * @param value Double value.
     * @return Long value.
     */
    public static long toLong(double value) {
        return (long)value;
    }
    
    /**
     * Convert float value in a long one.
     * @param value Float value.
     * @return Long value.
     */
    public static long toLong(float value) {
        return (long)value;
    }
    
    /**
     * Convert integer value in a long value.
     * @param value Integer value.
     * @return Long value.
     */
    public static long toLong(int value) {
        return (long)value;
    }
    
    /**
     * Convert string value in a long value.
     * @param value String value.
     * @return Long value.
     */
    public static long toLong(String value) {
        return Long.parseLong(value);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="toDouble">
    
    /**
     * Convert long value in a double one.
     * @param value Long value.
     * @return Double value.
     */
    public static double toDouble(long value) {
        return (double)value;
    }
    
    /**
     * Convert float value in a double one.
     * @param value Float value.
     * @return Double value.
     */
    public static double toDouble(float value) {
        return (double)value;
    }
    
    /**
     * Convert int value in a double one.
     * @param value Integer value.
     * @return Double value.
     */
    public static double toDouble(int value) {
        return (double)value;
    }
    
    /**
     * Convert string value in a double one.
     * @param value String value.
     * @return Double value.
     */
    public static double toDouble(String value) {
        return Double.parseDouble(value);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="toFloat">
    
    /**
     * Convert long value in a float one.
     * @param value Long value.
     * @return Float value.
     */
    public static float toFloat(long value) {
        return (float)value;
    }
    
    /**
     * Convert double value in a float one.
     * @param value Double value.
     * @return Float value.
     */
    public static float toFloat(double value) {
        return (float)value;
    }
    
    /**
     * Convert int value in a float one.
     * @param value Integer value.
     * @return Float value.
     */
    public static float toFloat(int value) {
        return (float)value;
    }
    
    /**
     * Convert string value in a flaot one.
     * @param value String value.
     * @return Float value.
     */
    public static float toFloat(String value) {
        return Float.parseFloat(value);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="toDate">
    
    /**
     * Convert string value in date value with used format. 
     * @param value Date in format string.
     * @return Date value.
     */
    public static Date toDate(String value) {
        return toDate(value, null);
    }  
    
    /**
     * Convert string value in date value with used format. 
     * @param value Date in format string.
     * @param format Userd format.
     * @return Date value.
     */
    public static Date toDate(String value, DateFormat format) {
        
        // Check if string is null or empty.
        if(StringExtension.isEmptyOrNull(value)) {
            return null;
        }
        
        if(format == null) {
            format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        }
        
        try {
            return format.parse(value);
        } catch(ParseException ex) {
            return null;
        }
    }
    
    // </editor-fold>
}
