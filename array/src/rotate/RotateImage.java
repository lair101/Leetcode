package rotate;

import org.junit.Test;

/**
 * You are given an n x n 2D matrix representing an image.

	Rotate the image by 90 degrees (clockwise).
	
	Follow up:
	Could you do this in-place?
 * @author Haolin
 *
 */
public class RotateImage {
	
	//先延对角线交换， 再延x轴交换
	public void solution(int[][] matrix){
		int len =matrix.length;
		for(int i=0;i<len/2;i++){
			for(int j=0;j<(len+1)/2;j++){
			swap(matrix[i][j],matrix[len-1-i][len-1-j]);
			swap(matrix[len-1-i][j],matrix[i][len-1-j]);
			}
		}
		
//		for(int i=0; i<len;i++){
//			for(int j=0; j<len/2;j++){
//				swap(matrix[i][j],matrix[i][j+len-1]);
//			}
//		}
	}
	
	
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}
	public static void swap(int A, int B){
		int tmp = A;
		A = B;
		B =tmp;
	}
	
	@Test
	public void test(){
		int[][] m ={{1,2},{3,4}};
		RotateImage  t = new RotateImage();
		t.solution(m);
		for(int i=0;i<m.length; i++){
			System.out.println();
			for(int j =0; j<m.length; j++){
				 System.out.print(m[i][j]);
			}
		}
	}

}
