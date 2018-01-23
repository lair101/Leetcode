package MissingRang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
		
	public  List<String> summaryTanges(int[] nums){
		  List<String> result = new ArrayList<String>();
			int start=0;
			int end = 0;
			if(nums.length==0) return result;
			while(end<nums.length){
					//find next in consecutive nums
					if(end<nums.length-1&&nums[end]+1==nums[end+1]){
						end++;
					}else{
					    if(start==end){
							//result
							result.add(nums[end]+"");
						}
						else{
							result.add(nums[start]+"->"+nums[end]);
						}
						end++;
						start=end;
					}
				}
			
			return result;
	}
	
	
	public static  void main(String Args[]){
		SummaryRange s = new SummaryRange();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/MissingRang/testdata.txt"));
			String SCurrentLine;
			while ((SCurrentLine = br.readLine()) != null) {
					s.test(SCurrentLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	public  void test(String s){
		String[] ary =s.split("");
		int[] testData = new int [ary.length];
		for(int i=1;i<ary.length;i++){
			testData[i] = Integer.parseInt(ary[i]);
		}
		System.out.println(summaryTanges(testData));
	}
}
