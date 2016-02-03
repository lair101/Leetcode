package WordSearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearch {
	
	public Boolean solution(char[][] board, String word){
		int m = board.length;
		int n = board[0].length;
		boolean[][] visits = new boolean[m][n];
		for(int i=0;i<m;i++){
			for(int j =0; j<n;j++){
				if(dfs(board,word,visits,0,i,j))
					return true;
			}
		}
		return false;
		
	}
	
	
	public static boolean dfs(char[][] board, String word, boolean[][] visits, int index, int r, int c){
		if(index==word.length()) return true;
		if(r<0||c<0||r>=board.length||c>=board[0].length) return false;
		if(visits[r][c]) return false;
		if(board[r][c]!=word.charAt(index)) return false;
		visits[r][c] =true;
		
		boolean res=(dfs(board,word,visits,index+1,r+1,c)||dfs(board,word,visits,index+1,r-1,c)||dfs(board,word,visits,index+1,r,c+1)||dfs(board,word,visits,index+1,r,c-1));
		
		//set visits table back to false after one try
		visits[r][c] =false;
		
		return res;
	}
	
	@Test
	public void test(){
		char[][] table = {{'a','b','c'},{'d','e','f'},{'g','h','i'}};
		WordSearch s = new WordSearch();
		assertTrue(s.solution(table,"abcfedg"));
		assertFalse(s.solution(table,"abcefgh"));
	}
}
