package com.maianet.calculations;

import com.maianet.calculations.entities.WeightAverageEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


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
    
    /**
     * Sum of all numbers into input array.
     * @param numbers Number to sum.
     * @return Sum.
     * @throws NullPointerException 
     */
    public static double sum(double[] numbers) throws NullPointerException {
        if(numbers == null) {
            throw new NullPointerException("Argument 'numbers' is null.");
        }
        double sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        
        return sum;
    }
    
    /**
     * Arithmetic average.
     * @param numbers Array of numbers.
     * @return Return arithmetic average.
     * @throws NullPointerException if input array object is null.
     * @throws ArithmeticException If input array length is 0.
     */
    public static double arithmeticAverage(double[] numbers) throws NullPointerException, ArithmeticException {
        if(numbers == null) {
            throw new NullPointerException("Argument 'numbers' is null.");
        } 
        
        if(numbers.length == 0) {
            throw new ArithmeticException("The number array 'numbers' must not be 0.");
        }
        
        double sum = sum(numbers);
        return (sum/numbers.length);
    }
    
    /**
     * Weighted average.
     * @param waes List of values with weight.
     * @return
     * @throws IllegalArgumentException If one or more weight valus are not 0&#60;=x&#60;=1 or, if the weight sum is not 1.
     */
    public static double weightedAverage(WeightAverageEntity[] waes) throws IllegalArgumentException {
        
        // Check if all Weights are between 0 <= x <= 1.
        // Check if weight sum is 1.
        double weightSum = 0;
        for(WeightAverageEntity wae : waes) {
            if(!(wae.getWeight() <= 1 && wae.getWeight() >= 0)) {
                throw new IllegalArgumentException("All weight values must be 0 <= x <= 1.");
            }
            
            weightSum += wae.getWeight();
        }
        
        if(weightSum != 1) {
            throw new IllegalArgumentException("Ths weight sum is not 1.");
        }
        
        // Calc.
        double sum = 0;
        for (WeightAverageEntity wae : waes) {
            sum += wae.getValue() * wae.getWeight();
        }
        
        return sum;
    }
        
    /**
     * Standard Deviation -> σ = sqrt [(Σ((X-μ)^2))/(N)].
     * @param numbers Array of numbers.
     * @return Standard deviation.
     * @throws NullPointerException if input array object is null.
     * @throws ArithmeticException If input array length is 0.
     */
    public static double standardDeviation(double[] numbers) throws NullPointerException, ArithmeticException {
        if(numbers == null) {
            throw new NullPointerException("Argument 'numbers' is null.");
        } 
        
        if(numbers.length == 0) {
            throw new ArithmeticException("The number array 'numbers' must not be 0.");
        }
        
        double aritmeticAverage = arithmeticAverage(numbers);
        double N = numbers.length;
        
        double sum = 0;
        for(double number : numbers) {
            double diff = number - aritmeticAverage;
            double exp = pow2(diff);
            sum += exp;
        }
        
        double A = sum / N;
        return sqrt2(A);
    }
    
    /**
     * Standard error = σ/sqrt(n)
     * @param numbers
     * @return Standard error.
     * @throws NullPointerException if input array object is null.
     * @throws ArithmeticException If input array length is 0.
     */
    public static double standardAgerageError(double[] numbers) throws NullPointerException, ArithmeticException {
        if(numbers == null) {
            throw new NullPointerException("Argument 'numbers' is null.");
        } 
        
        if(numbers.length == 0) {
            throw new ArithmeticException("The number array 'numbers' must not be 0.");
        }
       
        double dev = standardDeviation(numbers);
        double N = numbers.length;
        
        return dev / (sqrt2(N));
    }
}
