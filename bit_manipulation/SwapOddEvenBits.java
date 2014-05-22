package bit_manipulation;

//����һ���������Ʊ�ʾ����λ��ż��λ�����֣����һλ�͵ڶ�λ����������λ�͵���λ����
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
