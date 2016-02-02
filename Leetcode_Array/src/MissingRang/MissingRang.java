package MissingRang;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MissingRang {
	/***
	 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
		For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
	 * @param args
	
	 *这道题其实不难，但是就是要考虑清楚各种情况。根据题意，[lower, upper]一定是包含这个array所有元素的，不会存在不包含甚至没有交集的情况。只是要特别考虑一下A[0]和lower的关系， 以及A[N]与upper的关系，它们所以存在的情况：

	1. lower == A[0] && upper == A[N]
	
	2. lower < A[0] && upper == A[N]
	
	3. lower == A[0] && upper > A[N]
	
	4. lower < A[0] && upper > A[N]
	
	整体来说，需要考虑如下所有case：
	
	1. 为空，lower 与 upper 之间关系。
	
	2. lower 与 A[0]  之间关系
	
	3. A[i]~A[i+1]  之间关系
	
	4 A[A.length-1] 与 upper 之间关系
	 */
	
	public List<String> solution(int[] A,int lower, int upper){
		 ArrayList<String> res = new ArrayList<String>();
		 if(A.length==0){
			 if(lower!=upper){
				 res.add(lower+"->"+upper);
			 }
			 else{
				 res.add(lower+"");
			 }
			 return res;
		 }
		 if(lower<A[0]){
			 if(lower==A[0]-1){
				 res.add(lower+"");
			 }else{
				 res.add(lower+"->"+upper);
			 }
		 }
		 for(int i=0;i<A.length-1;i++){
			 if(A[i+1]-A[i]>2){
				 res.add((A[i]+1)+"->"+(A[i+1]-1));
			 }
			 else if (A[i+1] - A[i] == 2) {
	               res.add((A[i]+1)+"");
	         }
	         else continue;
		 }
		 if(upper>A[A.length-1]){
			 if(upper-A[A.length-1]>2){
				 res.add((A[A.length-1]+1)+"->"+upper);
			 }
			 else{
				 res.add((upper-1)+"");
			 }
		 }

		 return res;
	}
	
	@Test
	 public void test() {
        int[] nums = new int[]{0, 1, 3, 50, 75};
        List<String> result = solution(nums, 0, 99);
        for (String s : result) {
            System.out.println(s);
        }
    }

}
