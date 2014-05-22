package other;
//不用加号实现加法
public class AddWithoutPlus {
	public static void main(String[] args) {
		int a = 127, b = 269;
		System.out.println(Add_no_arithm(a, b));
	}

	public static int Add_no_arithm(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return Add_no_arithm(sum, carry);
	}
}
