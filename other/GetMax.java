package other;

//��ʹ�ñȽϷ���if-else���ʵ�ַ��������ϴ�ֵ�Ĺ���

public class GetMax {
	public static void main(String[] args) {
		int a = 5, b = 10;
		System.out.println(GetMax(a, b));
	}

	public static int GetMax(int a, int b) {
		int c = a - b;
		int k = (c >> 31) & 1;
		return a - k * c;
	}
}
