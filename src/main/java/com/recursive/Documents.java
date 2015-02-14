package com.recursive;

import org.apache.commons.math3.stat.StatUtils;

public class Documents {
	
	/** warring */
	public int fibonaciToRecursice(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;
		return fibonaciToRecursice(i - 1) + fibonaciToRecursice(i - 2);
	}
	
	/**best*/
	public double calFibonaci(int n) {
		
		double[] fibonaci = new double[n];
		if (n == 0) {
			fibonaci[0] = 0;
			return 0;
		}
		if (n == 1) {
			fibonaci[1] = 1;
			return 1;
		}
		
		for (int i = 2; i < n - 1; i++) {
			fibonaci[i] = fibonaci[i - 1] + fibonaci[i - 2];
		}
		
		double total = StatUtils.sum(fibonaci);
		return total;
	}
	
	public int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return factorial(n - 1) * n;
	}
}
