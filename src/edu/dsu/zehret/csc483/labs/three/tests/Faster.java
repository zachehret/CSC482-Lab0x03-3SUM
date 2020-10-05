package edu.dsu.zehret.csc483.labs.three.tests;

import java.util.ArrayList;
import java.util.Collections;

public class Faster extends Test {

	public Faster(ArrayList<Integer> list) {
		super(list, "Faster 3sum");
		//Sort list here
		
		Collections.sort(this.list);
	}
	
	@Override
	protected void run() {
		//If has zero and an inverse of a chosen number
		for(int a = 0; a < list.size(); a++) {
			int inverseIndex = Collections.binarySearch(this.list, -list.get(a));
			boolean hasInverse = inverseIndex < 0 ? false : true;
			int zeroIndex = Collections.binarySearch(this.list, 0);
			boolean hasZero = zeroIndex < 0 ? false : true;
			if(hasInverse) {
				if(hasZero) {
					//With a zero and inverse of the current value, a match is found. Return
					this.found = true;
					return;
				} else {
					//Inverse but no zero. There is no match here. Continue;
					continue;
				}
			} else {
				if(hasZero) {
					//No inverse, but zero. Complete the has zero method.
					for(int b = 0; b < list.size(); b++) {
						for(int c = 0; c < list.size(); c++) {
							if(list.get(b) + list.get(c) == 0) {
								this.found=true;
								return;
							}
						}
					}
					continue;
				} else {
					//No inverse, no zero. Try next index
					continue;
				}
			}
			
		}
		//The above method did not resolve. Try brute force.
		for(int a = 0; a < list.size(); a++) {
			for(int b = 0; b < list.size(); b++) {
				for(int c = 0; c < list.size(); c++) {
					int sum = list.get(a) + list.get(b) + list.get(c);
					if(sum == 0) {
						this.found=true;
						return;
						//System.out.println("Found 3sum : " + list.get(a) + " + " + list.get(b) + " + " + list.get(c) + " = 0");
					}
				}
			}
		}
	}
		
}