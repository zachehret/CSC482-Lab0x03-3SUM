package edu.dsu.zehret.csc483.labs.three.tests;

import java.util.ArrayList;

public class BruteForce extends Test {

	public BruteForce(ArrayList<Integer> list) {
		super(list, "Brute Force");
	}

	@Override
	protected void run() {
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
