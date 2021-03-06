package rotate;

import org.junit.Test;

/**
 * Rotate an array of n elements to the right by k steps.

	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	
	Note:
	Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
	
	[show hint]
	
	Related problem: Reverse Words in a String II
 * @author Haolin
 *
 */
public class RotateArray {
	
	public void solution(int[] nums, int k){
		// solution 1 like bubble
		if(k<0||nums.length<=0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
		
		for(int i=0;i<k;i++){
			for(int j=nums.length-1;j>0;j--){
				int tmp = nums[j];
				nums[j] = nums[j-1];
				nums[j-1] = tmp;
			}
		}
	}
	
	public void solution2(int[] nums, int k){
		k = k % nums.length;
		 
		if (nums == null || k < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
	 
		//length of first part
		int a = nums.length - k; 
	 
		reverse(nums, 0, a-1);
		reverse(nums, a, nums.length-1);
		reverse(nums, 0, nums.length-1);
	 
	}
	 
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}
			
		
		
	
	
	
	@Test
	public void test(){
		RotateArray  s = new RotateArray();
		int[] test = {1,2,3,4,5,6,7};
		s.solution2(test, 4);
		for(int i=0;i<test.length;i++){
			System.out.print(test[i]+",");
		}
		
	}
}
