package com.recursive;

public class Fibonaci {
	
	public int alFibonaci(int i) {
		if (i == 0) return 0;
		if (i == 1) return 1;
		return alFibonaci(i - 1) + alFibonaci(i - 2);
	} 
}
