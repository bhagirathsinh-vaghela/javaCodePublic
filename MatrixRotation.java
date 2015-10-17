import java.io.*;
import java.util.*;

class MatrixRotation {
	public static void main (String args[]) throws IOException {
		int[][] a = {{11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}, {26, 27, 28, 29, 30}, {31, 32, 33, 34, 35}};
		printMatrix(a);
		rotate(a);
		System.out.println();
		printMatrix(a);
	}

	public static void rotate(int[][] mat) {
		int n = mat.length;
		int temp;
		for(int i = 0; i < n/2; i++) {
			int first = i;
			int last = (n - 1) - first;
			for(int j = first; j < last; j++) {
				//Save top
				temp = mat[first][j];
				//left -> top
				mat[first][j] = mat[(n-1)-j][first];
				//bottom -> left
				mat[(n-1)-j][first] = mat[last][(n-1)-j];
				//right -> bottom
				mat[last][(n-1)-j] = mat[j][last];
				//temp -> right
				mat[j][last] = temp;
			}
		}
	}

	public static void printMatrix(int[][] mat) {
		for(int[] i : mat) {
			for(int j : i) {
				System.out.print(j + " ");				
			}
			System.out.println();
		}
	}
}