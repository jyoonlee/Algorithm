package com.ssafy.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2941 {
	static String[] list = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		
		for (String value : list)
			s = s.replace(value, " "); 

		System.out.println(s.length());
	}
}
