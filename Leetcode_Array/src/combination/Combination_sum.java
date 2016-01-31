package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	The same repeated number may be chosen from C unlimited number of times.
	
	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 
	[7] 
	[2, 2, 3] 
 * @author Haolin
 *
 */
public class Combination_sum {
	 public List<List<Integer>> solution(int[] candidates, int target) {
		 	List<Integer> res = new ArrayList<Integer>();
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        Arrays.sort(candidates);
	        dfs(candidates,target,0,res,result);
	        return result;
	    }
	    
	    public void dfs(int[] nums, int target, int index, List<Integer> res, List<List<Integer>> result){
	        if(target<0) {return;}
	        if(target==0) {
	        	result.add(new ArrayList<Integer>(res)); // 一定要new一个新的item list 因为如果递归清除时，会将原有的res清空。直接add,只是加一个pointer，等清空后,result里也还是空的。
	        	return;
	        }
	       
	        for(int i=index;i<nums.length;i++){
	        	 res.add(nums[i]);
	        	 dfs(nums,target-nums[i],i,res,result);
	             res.remove(res.size()-1);
	        }
	 
	    }
	    
	    @Test
	    public void test(){
	    	Combination_sum demo = new Combination_sum();
	    	int[] nums = {1};
	    	System.out.print(demo.solution(nums, 2));
	    }
	    
}
