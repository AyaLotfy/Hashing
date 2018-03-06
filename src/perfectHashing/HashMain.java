package perfectHashing;

public class HashMain {

	public static void main(String[] args) {
//		System.out.println("1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2");
//		int m = 4;
//		UniversalHashing h = new UniversalHashing(m);
//		System.out.println("first matrix");
//		printArray(h.hashMatrix);
//		h.XMatrix(1);
//		System.out.println("second matrix");
//		printArray1(h.x);
//		h.addressMatrix(h.hashMatrix, h.x);
//		System.out.println();
//		System.out.println("result matrix");
//		printArray1(h.HXMatrix);

	}

	public static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printArray1(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
	}
}
