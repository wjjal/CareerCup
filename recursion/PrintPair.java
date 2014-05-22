package recursion;

import java.util.ArrayList;
import java.util.Scanner;

//对于整数n,输出所有合法的n对括号
//input；3
//output:()()(),()(()),(())(),((())),(()())
public class PrintPair {
	public static void main(String[] args) {
		System.out.print("Please input the number of pair:");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		PrintPair(n);
		s.close();
		int a[] = { 1 };
		int b[] = { 2, 3 };
		int c[] = { -3, 1, -1 };
		ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> aa = new ArrayList<Integer>();
		ArrayList<Integer> bb = new ArrayList<Integer>();
		ArrayList<Integer> cc = new ArrayList<Integer>();
		aa.add(1);
		bb.add(2);
		bb.add(3);
		cc.add(-3);
		cc.add(1);
		cc.add(-1);
		t.add(aa);
		t.add(bb);
		//t.add(cc);
		System.out.println(minimumTotal(t));
	}

	public static void PrintPair(int n) {
		char[] str = new char[n * 2];
		PrintPair(n, n, str, 0);
	}

	public static void PrintPair(int l, int r, char[] str, int count) {
		if (l < 0 || r < l)
			return;
		if (l == 0 && r == 0)
			System.out.println(str);
		else {
			if (l > 0) {
				str[count] = '(';
				PrintPair(l - 1, r, str, count + 1);
			}
			if (r > l) {
				str[count] = ')';
				PrintPair(l, r - 1, str, count + 1);
			}
		}
	}

	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int min = Integer.MAX_VALUE;
		int[] temp = new int[triangle.size()];
		temp[0] = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++) {
			ArrayList<Integer> now = triangle.get(i);
			int size = now.size();
			for (int j = size - 1; j >= 0; j--) {
				if (j == 0)
					temp[0] = temp[0] + now.get(0);
				else if (j == size - 1)
					temp[size - 1] = temp[size - 2] + now.get(size - 1);
				else
					temp[j] = Math.min(temp[j - 1], temp[j]) + now.get(j);
			}
		}
		for (int val : temp) {
			if (val < min)
				min = val;
		}
		return min;
	}
}
