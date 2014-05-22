package arrays_and_strings;

import java.util.Scanner;

public class RemoveDepuliateChar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the number of input strings:");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Please input the string:");
			String str = sc.next();
			System.out.println("The output string:");
			Remove1(str);
			System.out.println();
			Remove2(str);
			System.out.println();
		}
		sc.close();
	}

	static void Remove1(String str) {
		boolean record[] = new boolean[26];
		char input[] = str.toCharArray();
		for (char c : input) {
			if (!record[c - 'a']) {
				record[c - 'a'] = true;
				System.out.print(c);
			}
		}
	}

	static void Remove2(String str) {
		char cs[] = str.toCharArray();
		int len = cs.length;
		int p = 0;
		for (int i = 0; i < len; i++) {
			if (cs[i] != '\0') {
				cs[p++] = cs[i];
				for (int j = i + 1; j < len; j++) {
					if (cs[j] == cs[i])
						cs[j] = '\0';
				}
			}
		}
		int i = 0;
		while (i < len && cs[i] != '\0') {
			System.out.print(cs[i]);
			i++;
		}
	}
}
