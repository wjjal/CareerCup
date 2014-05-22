package bit_manipulation;

public class BitSwapRequired {
	public static void main(String[] args) {
		int a = 31, b = 14;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(BitSwapRequired(a, b));
	}

	public static int BitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c >>= 1) {
			count += c & 1;
		}
		return count;
	}
}
