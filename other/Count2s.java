package other;

//计算0到n中出现多少个2.
//f(513) = 5*f(99)+f(13)+100
//f(213) = 2*f(99)+f(13)+13+1
public class Count2s {
	public static void main(String[] args) {
		int n = 513;
		System.out.println(Count2sR(n));
		System.out.println(Count2sI(n));
	}

	public static int Count2sR(int n) {
		if (n == 0)
			return 0;
		int pow = 1;
		while (10 * pow < n)
			pow *= 10;
		int first = n / pow;
		int remainder = n % pow;
		int nTwosFirst = 0;
		if (first > 2)
			nTwosFirst = pow;
		else if (first == 2)
			nTwosFirst = remainder + 1;
		int nTwosOther = first * Count2sR(pow - 1) + Count2sR(remainder);
		return nTwosFirst + nTwosOther;
	}

	public static int Count2sI(int n) {
		int countof2s = 0, digit = 0;
		int j = n, seendigits = 0, position = 0, pow10_pos = 1;
		while (j > 0) {
			digit = j % 10;
			int pow10_posMinus1 = pow10_pos / 10;
			countof2s += digit * position * pow10_posMinus1;
			if (digit == 2)
				countof2s += seendigits + 1;
			else if (digit > 2)
				countof2s += pow10_pos;
			seendigits = seendigits + pow10_pos * digit;
			pow10_pos *= 10;
			position++;
			j = j / 10;
		}
		return countof2s;
	}
}
