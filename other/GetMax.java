package other;

//不使用比较符和if-else语句实现返回两数较大值的功能

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
