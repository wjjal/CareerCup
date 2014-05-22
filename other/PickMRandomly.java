package other;

//从n个数中选取m个数

public class PickMRandomly {
	public static void main(String[] args) {
		int m = 3;
		int count[] = new int[10]; 
		for (int i = 0; i < 10000; i++) {
			int array[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			PickMRandomly(array, count,m);
		}
		for(int i :count){
			System.out.print(i+" ");
		}
	}

	public static void PickMRandomly(int[] array, int[] count,int m) {
		int n = array.length;
		if (n < m)
			return;
		for (int i = n - 1; i > n - 1 - m; i--) {
			int index = (int) (Math.random() * (i+1));
			count[array[index]]++;
			//System.out.print(array[index] + " ");
			array[index] = array[i];
		}
	}
}
