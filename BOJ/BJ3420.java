import java.io.*;
import java.util.*;

// Comparable
public class BJ3420 {

	static public class Client implements Comparable<Client> {
		int age;
		String name;

		@Override
		public int compareTo(Client o) {
			return this.age - o.age;
		}

		Client(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Client[] list = new Client[N];
		
		for(int i =0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			list[i] = new Client(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(list);
		
		for(Client value : list) {
			System.out.println(value.age + " " + value.name);
		}
		

	}
}
