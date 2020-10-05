package edu.dsu.zehret.csc483.labs.three;

import java.util.ArrayList;
import java.util.Random;

import edu.dsu.zehret.csc483.labs.three.tests.BruteForce;
import edu.dsu.zehret.csc483.labs.three.tests.Faster;
import edu.dsu.zehret.csc483.labs.three.tests.Fastest;
import edu.dsu.zehret.csc483.labs.three.tests.Test;

public class Main {
	

	public static void main(String[] args) {
		ArrayList<Test> tests = new ArrayList<Test>();
		for(int i = 14; i <= 18; i++) {
			tests.add(new BruteForce(generateList(-65565*16, 65565*16, 345, (int)Math.pow(2,i))));
		}
		for(int i = 14; i <= 18; i++) {
			tests.add(new Faster(generateList(-65565*16, 65565*16, 345, (int)Math.pow(2, i))));
		}
		for(int i = 14; i <= 18; i++) {
		//	tests.add(new Fastest(generateList(-65565*16, 65565*16, System.currentTimeMillis(), (int)Math.pow(2, i))));
		}

		System.out.println("Running tests...");
		for(int i = 0; i < tests.size(); i++) {
			tests.get(i).startTimer();
			tests.get(i).start();
			tests.get(i).endTimer();
		}
	}
	
	private static ArrayList<Integer> generateList(int min, int max, long seed, int count) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random ran = new Random(seed);
		for(int i = 0; i < count; i++) {
			list.add(ran.nextInt((max-min)+1)+min);
		}
		return list;
	}
}
