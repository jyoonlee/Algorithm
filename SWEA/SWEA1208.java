package com.ssafy.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// flatten
public class SWEA1208 {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringBuilder res = new StringBuilder();

      for (int test_case = 1; test_case <= 10; test_case++) {

         List<Integer> list = new ArrayList<>();
         int N = Integer.parseInt(br.readLine());

         StringTokenizer st = new StringTokenizer(br.readLine());

         while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
         }

         for (int j = 0; j < N; j++) {
            
        	// 최소값 최대값
            int maxIndex = list.indexOf(Collections.max(list));
            int minIndex = list.indexOf(Collections.min(list));
            
            // 최소값 최대값 인덱스에 값 더하기
            list.set(maxIndex, list.get(maxIndex) - 1);
            list.set(minIndex, list.get(minIndex) + 1);
         }

         res.append("#").append(test_case).append(" ").append(Collections.max(list) - Collections.min(list)).append("\n");
      }
      System.out.println(res);
   }
}