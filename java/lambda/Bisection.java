/*
 * This software released freely into the public domain.  Anyone may copy,
 * modify, publish, use, compile, sell, or distribute this software, either
 * in source code form or as a compiled binary, for any purpose, commercial
 * or non-commercial, and by any means.  The software is provided "as is",
 * without warranty of any kind, express or implied.
 */


/**
 * Implements the bisection algorithm to solve an equation.
 */
public class Bisection
  {
    /**
     * Apply the bisection algorithm to solve an equation of the form
     * f(x) = 0, where f is continuous on an interval [a, b], and f(a)
     * and f(b) have opposite signs.  The algorithm returns a solution
     * x if either f(x) == 0.0 or x differs from a root by less than
     * the specified tolerance.
     * 
     * @param df implements the function f for the equation to solve
     * @param a  the lower bound of interval containing the solution
     * @param b  the upper bound of interval containing the solution
     * @param maxIterations the maximum number of iterations to attempt
     * @param tolerance the precision used to determine the approximate
     *     solution
     *
     * @return a value that differs from the root of f(x) = 0 by less
     *     than the specified tolerance
     *
     * @throws IllegalArgumentException if b < a or if df.f(a) and df.f(b)
     *     have the same sign (i.e., both positive or both negative)
     * @throws ArithmeticException if no solution is found after the
     *     specified maximum number of iterations
     */
    public static double solve(DoubleFunction df, double a, double b,
                               int maxIterations, double tolerance)
        throws IllegalArgumentException, ArithmeticException
      {
        if (b < a)
          {
            String message = "a must be <= b; a =" + a + ", b = " + b;
            throw new IllegalArgumentException(message);
          }
        else if (df.f(a)*df.f(b) > 0.0)
          {
            String message = "function values at " + a + " and " + b
                +  " should have opposite signs; df.f(" + a + ") = " + df.f(a)
                + ", df.f(" + b + ") = " + df.f(b);
            throw new IllegalArgumentException(message);
          }
          
        int    iterations = 1;
        double solution = (a + b)/2.0;

        while (iterations <= maxIterations)
          {
            if (df.f(solution) == 0.0 || (b - a)/2.0 < tolerance)
                return solution;      // approximate solution has been found
            else
              {                        // continue iteration
                if (df.f(a)*df.f(solution) > 0.0)
                    a = solution;
                else
                    b = solution;

                solution = (a + b) / 2.0;
                ++iterations;
              }
          }

        throw new ArithmeticException("Bisection Algorithm failed to converge");
      }
  }
