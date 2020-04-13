package com.maianet.calculations;

/**
 * See: https://en.wikipedia.org/wiki/Fourier_transform
 * @author Mattia Zuliani
 * @version 0.0.1
 */
public class FourierTransform {
    
    public FourierTransform() { }
    
    /**
     * Discrete Fourier Transform
     * @param x Array of Complex values.
     * @return Return a Fourier Transform array.
     */
    public ComplexNumber[] dft(ComplexNumber[] x) {                
        int N = x.length;        
        ComplexNumber[] X = new ComplexNumber[N];
        for (int k = 0; k < N; k++) {
            for (int n = 0; n < N; n++) {
                ComplexNumber tmp = ComplexNumber.polar(1, -2 * java.lang.Math.PI * n * k / N);                    
                tmp = ComplexNumber.multiplication(tmp, x[n]);                    
                X[k] = tmp;
            }
        }

        return X;
    } 
    
    /**
     * Fast Fourier Transform
     * @param x Array of Complex values.
     * @return Return a Fourier Transform array.
     */
    public ComplexNumber[] fft(ComplexNumber[] x) {
        int N = x.length;
        ComplexNumber[] X = new ComplexNumber[N];
        ComplexNumber[] d, D, e, E;
        
        if (N == 1) {
            X[0] = x[0];
            return X;
        }

        int k;
        e = new ComplexNumber[N / 2];
        d = new ComplexNumber[N / 2];

        for (k = 0; k < N / 2; k++) {
            e[k] = x[2 * k];
            d[k] = x[2 * k + 1];
        }

        D = fft(d);
        E = fft(e);

        for (k = 0; k < N / 2; k++) {
            ComplexNumber temp = ComplexNumber.polar(1, -2 * java.lang.Math.PI * k / N);
            D[k] = ComplexNumber.multiplication(D[k], temp);
        }

        for (k = 0; k < N / 2; k++) {
            X[k] = ComplexNumber.sum(E[k], D[k]);
            X[k + N / 2] = ComplexNumber.diff(E[k], D[k]);
        }

        return X;
    }
}
