package combination;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

	Ensure that numbers within the set are sorted in ascending order.
	
	
	Example 1:
	
	Input: k = 3, n = 7
	
	Output:
	
	[[1,2,4]]
	
	Example 2:
	
	Input: k = 3, n = 9
	
	Output:
	
	[[1,2,6], [1,3,5], [2,3,4]]
 * @author Haolin
 *
 */
public class Combination_sumII {
	public List<List<Integer>> solution(int k, int n){
		List<List<Integer>> result  = new ArrayList<List<Integer>>();
		List<Integer> res = new ArrayList<Integer>();
		dfs(result,res,n,k,1);
		return result;
		
	}
	
	public void dfs(List<List<Integer>> result, List<Integer> res, int target, int k, int index){
		if(target==0&&k==0) {
			result.add(new ArrayList<Integer>(res));
			return;
		}
		if(target<0||k==0) return;
		for(int i=index;i<=10-k;i++){
			res.add(i);
			dfs(result,res,target-i,k-1,i+1);
			res.remove(res.size()-1);
		}
	}
	
	@Test
	public void test(){
		Combination_sumII demo = new Combination_sumII();
    	System.out.print(demo.solution(8, 36));
	}
}
