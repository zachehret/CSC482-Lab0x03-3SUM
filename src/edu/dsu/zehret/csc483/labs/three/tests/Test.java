package edu.dsu.zehret.csc483.labs.three.tests;

import java.util.ArrayList;

public abstract class Test {
	long startTime = 0, endTime = 0, timeTaken = 0;
	boolean found = false;
	protected ArrayList<Integer> list = new ArrayList<Integer>();
	private String type = new String();
	public Test(ArrayList<Integer> list, String type) {
		this.list = list;
		this.type = type;
	}
	protected abstract void run();
	public void start() {
		System.out.println("Starting " + type + " test with " + list.size() + " items.");
		if(startTime == 0) {
			System.out.println("Test timer not started.");
		} else 
			this.run();
	}
	public long startTimer() {
		this.startTime = System.currentTimeMillis();
		return this.startTime;
	}
	public long endTimer() {
		this.timeTaken = System.currentTimeMillis() - this.startTime;
		this.startTime = 0;

		System.out.println(type + " completed. Took " + this.timeTaken + "ms. Found 3sum? " + this.found + "  out of " +  (list.size()) + " items.\n");
		return timeTaken;
	}
}
