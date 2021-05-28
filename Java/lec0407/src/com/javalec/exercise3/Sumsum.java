package com.javalec.exercise3;

public class Sumsum {
	
	int tagetNum = 0;

	public Sumsum(int tagetNum) {
		super();
		this.tagetNum = tagetNum;
	}
	
	public int run() {
		int taget = tagetNum;
		int result = 0;
		
		while(taget > 0) {
			result +=  taget%10;
			taget /= 10;
		}
		
		return result;
	}

}
