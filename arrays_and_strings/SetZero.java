package arrays_and_strings;

//在一个NxN的矩阵中，如果有元素为0，则把该元素所在行和列都置为0

public class SetZero {

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3 }, { 0, 4, 0 }, { 9, 4, 7 } };
		setZeros(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void setZeros(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == 1 || column[j] == 1)
					matrix[i][j] = 0;
			}
		}
	}
}
