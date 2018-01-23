package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If nums = [1,2,3], a solution is:
	
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 * @author x172821
 *
 */
public class subset {
	public List<List<Integer>> solution(int[] nums){
		  List<List<Integer>> result = new ArrayList<List<Integer>>();
	        List<Integer> res = new ArrayList<Integer>();
	        int len = nums.length;
	        if(len==0) return result;
	        Arrays.sort(nums);
	        result.add(new ArrayList<Integer>());
	        for(int elements=1;elements<=len;elements++){
	            dfs(result,res,elements,nums,0);
	        }
	        return result;
	    }
	    
	public void dfs(List<List<Integer>> result, List<Integer> res, int k, int[] nums, int index){
	        if(k==0){
	            result.add(new ArrayList<Integer>(res));
	            return;
	        }
	        for(int i=index; i<nums.length; i++){
	            res.add(nums[i]);
	            dfs(result,res,k-1,nums,i+1);
	            res.remove(res.size()-1);
	         }
	        
	 }
	
	//normal dfs can solve it but time exceed when the data is large
	@Test
	public void test(){
		subset s = new subset();
		int[] nums ={1,2,3,4,5,6,7,8,9,0};
		System.out.println(s.solution(nums));
	}
}
