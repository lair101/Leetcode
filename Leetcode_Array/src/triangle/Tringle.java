package triangle;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/***
 * 
 * Given a nums, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

		For example, given the following nums
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

	Note:
	Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the nums.
	 * 
 * @author x172821
 *
 */
public class Tringle {
	
	public int solution(List<List<Integer>> nums){
//		 	int res=0;
//	        int lvl=nums.size();
//	        if (lvl==0) return 0;
//	        if (lvl==1) return nums.get(0).get(0);
//	        for(int i=lvl-1;i>=0;i--){
//	            res=Collections.min(nums.get(i))+res;
//	        }
//	        return res;
		
		//above just simply add the min of each layer up. need chose n and n+1 two sub elements.
		//dfs
        if(nums.size()==1)
            return nums.get(0).get(0);
            
        int[] dp = new int[nums.size()];
    
        //initial by last row 
        for (int i = 0; i < nums.get(nums.size() - 1).size(); i++) {
            dp[i] = nums.get(nums.size() - 1).get(i);
        }
     
        // iterate from last second row
        for (int i = nums.size() - 2; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + nums.get(i).get(j);
            }
        }
 
        	return dp[0];
	
	}
	

	
	@Test
	public void test() {
		Tringle s = new Tringle();
		List<List<Integer>> data = new ArrayList<List<Integer>>();
		List<Integer> d1 = new ArrayList<Integer>();
		List<Integer> d2 = new ArrayList<Integer>();
		d1.add(1);
		d2.add(2);
		d2.add(3);
		data.add(d1);
		data.add(d2);
		System.out.println(s.solution(data));
	} 

}
