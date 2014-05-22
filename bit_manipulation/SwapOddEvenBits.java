package bit_manipulation;

//交换一个数二进制表示奇数位和偶数位的数字，如第一位和第二位交换，第三位和第四位交换
public class SwapOddEvenBits {
	public static void main(String[] args) {
		int x = 42;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(SwapOddEvenBits(x)));
	}

	public static int SwapOddEvenBits(int x) {
		return (((x & (0xaaaaaaaa)) >> 1) | ((x & (0x55555555)) << 1));
	}
}
