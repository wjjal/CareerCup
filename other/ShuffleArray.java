package other;

//Ï´ÅÆËã·¨
public class ShuffleArray {
	public static void main(String[] args) {
		int array[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ShuffleArray(array);
		for (int i : array)
			System.out.print(i + " ");
	}

	public static void ShuffleArray(int[] array) {
		int len = array.length;
		for (int i = len - 1; i > 0; i--) {
			int index = (int) (Math.random() * i);
			array[i] ^= array[index];
			array[index] ^= array[i];
			array[i] ^= array[index];
		}
	}

	public static <T> void ShuffleArray(T[] array) {
		int len = array.length;
		for (int i = len - 1; i > 0; i--) {
			int index = (int) (Math.random() * i);
			Swap(array, index, i);
		}
	}

	public static <T> void Swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
