package com.maianet.calculations;


/**
 * Mathematical operations
 * @author Mattia Zuliani
 * @version 0.0.1
 */
public class Math {
    
    /**
     * @see java.lang.Math.pow
     * @param base Base
     * @param exponent Exponent. 
     * @return base at exponent.
     */
    public static double pow(double base, double exponent) 
    {
        return java.lang.Math.pow(base, exponent);
    }
    
    /**
     * Squared elevation of the base.
     * @param base Base.
     * @return Return squared elevation.
     */
    public static double pow2(double base) 
    {
        return java.lang.Math.pow(base, 2);
    }
    
    /**
     * Elevation to the third of the base.
     * @param base Base.
     * @return Return third elevation.
     */
    public static double pow3(double base) 
    {
        return java.lang.Math.pow(base, 3);
    }
    
    /**
     * n-th root algorithm. Derivation from Newton's method.
     * URL: https://en.wikipedia.org/wiki/Nth_root_algorithm
     * @param a Base root.
     * @param n nth.
     * @return 
     */
    public static double sqrt(double a, double n) {
        DeviationNewtonRaphson dnr = new DeviationNewtonRaphson();
        return dnr.deviation(a, n, 1000);
    }
    
    /**
     * 2-th algorithm. Derivation from Newton's method.
     * @param a Base root.
     * @return 
     */
    public static double sqrt2(double a) {
        return sqrt(a, 2);
    }
    
    /**
     * 3-th algorithm. Derivation from Newton's method.
     * @param a Base root.
     * @return 
     */
    public static double sqrt3(double a) {
        return sqrt(a, 3);
    }
}
