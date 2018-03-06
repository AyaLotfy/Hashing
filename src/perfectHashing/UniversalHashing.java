package perfectHashing;

import java.util.Random;

public class UniversalHashing {

	private int sizeOfArray;
	private int bit32 = 32;
	Integer[][] hashMatrix;
	private Random r = new Random();
	Integer[][] x;
	Integer[][] HXMatrix;
	private String binary;

	/**
	 * 
	 * @param m
	 *            parameter m is size of hash table to store integers
	 */
	public UniversalHashing(int m) {
		sizeOfArray = m;
		randomMatrix(sizeOfArray);
	}

	/**
	 * to generate u*b random matrix of zeroes and ones.
	 */

	public Integer[][] randomMatrix(int m) {
		double y = Math.log(m) / Math.log(2);
		int b = round(y);
		hashMatrix = new Integer[b][bit32];
		for (int i = 0; i < hashMatrix.length; i++) {
			for (int j = 0; j < hashMatrix[0].length; j++) {
				hashMatrix[i][j] = r.nextInt(2);
			}
		}
		return hashMatrix;
	}

	/**
	 * if b is float close it to the nearest integer.
	 * 
	 * @param b
	 *            b = log(size of array(M)) base 2.
	 * @return
	 */

	private int round(double b) {
		int i = (int) b;
		double result = b - (double) i;
		if (result <= 0) {
			return i;
		} else {
			return i + 1;
		}
	}

	/**
	 * convert integer to binary and store it in array 32*1.
	 * 
	 * @param number
	 *            integer number to store it in hash table
	 * @return
	 */

	public Integer[][] XMatrix(int number) {
		binary = Integer.toBinaryString(number);
		x = new Integer[bit32][1];
		int j = binary.length();
		for (int i = 0; i < binary.length(); i++) {
			x[i][0] = Integer.parseInt(binary.substring(j - 1, j));
			j--;
		}
		return x;
	}

	/**
	 * matrix return the address of index of number in hash table.
	 * 
	 * @param hashFunction
	 *            u*b matrix
	 * @param xMatx
	 *            x matrix
	 * @return
	 */
	public int addressMatrix(Integer[][] hashFunction, Integer[][] xMatx) {

		HXMatrix = new Integer[hashFunction.length][xMatx[0].length];
		for (int i = 0; i < HXMatrix.length; i++) {
			for (int j = 0; j < hashFunction[0].length; j++) {
				for (int k = 0; k < xMatx[0].length; k++) {
					HXMatrix[i][0] += hashFunction[i][j] * xMatx[j][k];
				}
			}
			HXMatrix[i][0] = HXMatrix[i][0] % 2;
		}
		// return HXMatrix;
		return covertToDecimal(HXMatrix);
	}

	public int covertToDecimal(Integer[][] address) {
		String binAdd = "";
		for (int i = 0; i < address.length; i++) {
			binAdd = address[i][1] + binAdd;
		}
		int decimalValue = Integer.parseInt(binAdd, 2);

		return decimalValue;

	}

}
