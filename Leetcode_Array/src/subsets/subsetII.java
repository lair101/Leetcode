package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If nums = [1,2,2], a solution is:
	
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
 * @author Haolin
 *
 */
public class subsetII {
	
	public List<List<Integer>> solution(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> res = new ArrayList<Integer>();
		result.add(new ArrayList<Integer>());
		int len = nums.length;
		for(int i=1; i< len; i++){
			dfs(result,res,i,nums,1);
		}
		return  result;
	}
	
	public void dfs(List<List<Integer>> result, List<Integer> res, int len, int[] nums, int index){
		if(len==0&&!result.contains(res)){
			result.add(new ArrayList<Integer>(res));
		}
		for(int i=index;i<nums.length;i++){
			res.add(nums[i]);
			dfs(result,res,len-1,nums,i+1);
			res.remove(res.size()-1);
		}
	}
}
