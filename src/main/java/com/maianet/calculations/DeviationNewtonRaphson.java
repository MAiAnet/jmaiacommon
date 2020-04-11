package com.maianet.calculations;

/**
 * Derivation from Newton's method. Newton's method is a method for finding a zero of a function f(x). 
 * Wikipedia: https://en.wikipedia.org/wiki/Nth_root_algorithm
 * @author Mattia Zuliani
 * @version 0.0.1
 */
public class DeviationNewtonRaphson {
    
    /**
         * Calcola da deviazione con il metodo di Newton-Raphson. Il metodo è ricorsivo.
         * @param a Base 
         * @param n n-th.
         * @param stima Valore della stima
         * @return 
         */
        public double deviation(double a, double n, double stima) {
            DeviationNewtonRaphson.Derivation dev = this.calculateValoreCalcolato(a, n, stima);
            if(dev.getDifferenza() == 0) {
                return dev.getStima();
            } else {
                return this.deviation(a, n, dev.getValoreCalcolato());
            }
        }
        
        /**
         * Derivazione dal metodo di Newton-Raphson
         * @param a Base
         * @param n Number
         * @param stima Stima 
         * @return 
         */
        private DeviationNewtonRaphson.Derivation calculateValoreCalcolato(double a, double n, double stima) {
            DeviationNewtonRaphson.Derivation deviation = new DeviationNewtonRaphson.Derivation();
            deviation.setStima(stima);
            
            double f1 = (n - 1) * stima;
            double f2 = (a)/(Math.pow(stima, (n - 1)));
            double result = (f1 + f2) / n;
            deviation.setValoreCalcolato(result);
            
            return deviation;
        }
        
        // <editor-fold defaultstate="collapsed" desc="Derivation">
    
        protected class Derivation {

            private double stima = 0;
            private double valoreCalcolato = 0;

            public Derivation() {}

            public Derivation(double stima, double valoreCalcolato) {
                this.stima = stima;
                this.valoreCalcolato = valoreCalcolato;
            }

            public double getStima() { return stima; }

            public double getValoreCalcolato() { return valoreCalcolato; }

            /**
             * Get difference between 'stima' - 'valoreCalcolato'.
             * @return 
             */
            public double getDifferenza() { 
                return (stima - valoreCalcolato); 
            }

            public void setStima(double stima) { this.stima = stima; }

            public void setValoreCalcolato(double valoreCalcolato) { this.valoreCalcolato = valoreCalcolato; }
        }

        // </editor-fold>
}
