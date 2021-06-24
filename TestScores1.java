package com.green;

import java.util.Scanner;

public class TestScores1 {
	static int num;
	static String name;
	static int kor, eng, mat;
	static int tot, avg;
	static char grade;

	public static void input() {
		Scanner in = new Scanner(System.in);

		System.out.println("num, name, Korean, English, Math :");

		String line = in.nextLine();

		String[] datas = line.split(",");
		num = Integer.parseInt(datas[0]);
		name = datas[1];
		kor = Integer.parseInt(datas[2]);
		eng = Integer.parseInt(datas[3]);
		mat = Integer.parseInt(datas[4]);

	}

	public static void process() {
		char[] g = { 'F', 'F', 'F', 'F', 'F', 'F', 'D', 'C', 'B', 'A', 'A'
//			 0   10  20  30  40  50  60 70  80  90  100 - score
		};
		tot = kor + eng + mat;
		avg = tot / 3;
		grade = g[avg / 10];
	}

	public static void output() {
		System.out.println("num name   Korean  English  Math  Total  Average Grade");
		System.out.printf("%d %-7s    %3d    %3d     %3d     %3d     %3d   %2c \n", num, name, kor, eng, mat, tot, avg,
				grade);
	}

	public static void main(String[] args) {

		input();
		process();
		output();
	}

}
