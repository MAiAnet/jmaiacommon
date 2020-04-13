package com.maianet.calculations;

/**
 *
 * @author mzuliani
 */
public class ComplexNumber {
    
        private double real = 0;
        private double image = 0;
     
        public ComplexNumber() { 
            this.real = 0;
            this.image = 0;
        }
        
        public ComplexNumber(double real, double image) {
            this.real = real;
            this.image = image;
        }

        public void setImage(double image) {
            this.image = image;
        }

        public void setReal(double real) {
            this.real = real;
        }

        public double getReal() {
            return real;
        }

        public double getImage() {
            return image;
        }
        
        /**
         * Get magnitude value of complex number.
         * @return return magnitude value.
         */
        public double getMagnitude() {
            double base = java.lang.Math.pow(this.real, 2) + java.lang.Math.pow(this.image, 2);
            return java.lang.Math.sqrt(base);
        } 
        
        /**
         * Get phase value of complex number.
         * @return Return phase value.
         */
        public double getPhase() {
            return java.lang.Math.atan(this.image / this.real);
        }

        /**
         * Init a Complex number from polar rappresentation
         * @param r Value 
         * @param radians Radiants
         * @return Return a complex number object.
         */
        public static ComplexNumber polar(double r, double radians) {
            return new ComplexNumber(r * java.lang.Math.cos(radians), r * java.lang.Math.sin(radians));
        }
        
        // <editor-fold defaultstate="collapsed" desc="Operations">

        /**
         * Sum of two complex numbers. 
         * @param a First complex number. 
         * @param b Second complex number.
         * @return Sum.
         */
        public static ComplexNumber sum(ComplexNumber a, ComplexNumber b) {
            ComplexNumber tmp = new ComplexNumber();
            tmp.setReal(a.getReal()+ b.getReal());
            tmp.setImage(a.getImage() + b.getImage());            
            return tmp;
        }
        
        /**
         * Difference of two complex number.
         * @param a Fisrt complex number.
         * @param b Second complex number.
         * @return Difference.
         */
        public static ComplexNumber diff(ComplexNumber a, ComplexNumber b) {
            ComplexNumber tmp = new ComplexNumber();
            tmp.setReal(a.getReal() - b.getReal());
            tmp.setImage(a.getImage() - b.getImage());
            return tmp;
        }
        
        /**
         * Moltiplication
         * @param a First complex number.
         * @param b Second complex number.
         * @return Moltiplication.
         */
        public static ComplexNumber multiplication(ComplexNumber a, ComplexNumber b) {
            ComplexNumber tmp = new ComplexNumber();
            tmp.setReal((a.getReal() * b.getReal()) - (a.getImage() * b.getImage()));
            tmp.setImage((a.getReal() * b.getImage()) + (a.getImage() * b.getReal()));
            return tmp;
        }
        
        // </editor-fold>
    
        @Override
        public String toString() {
            return String.format("[%d + j%d]", this.real, this.image);
        }
        
        
    }
