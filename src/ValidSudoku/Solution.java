package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String args[]){
		char[][] board = new char[9][9];
		Solution sol = new Solution();
		board[0] = "..5.....6".toCharArray();
		board[1] = "....14...".toCharArray();
		board[2] = ".........".toCharArray();
		board[3] = ".....92..".toCharArray();
		board[4] = "5....2...".toCharArray();
		board[5] = ".......3.".toCharArray();
		board[6] = "...54....".toCharArray();
		board[7] = "3.....42.".toCharArray();
		board[8] = "...27.6..".toCharArray();
		System.out.println(sol.isValidSudoku(board));
	}
	public boolean isValidSudoku(char[][] board) {
		boolean out = true;
		char temp;
	    for(int i=0; i<9; i++){
	    	Set<Character> s = new HashSet<Character>();
	    	for(int j=0; j<9; j++){	     
	    		temp = board[i][j];
	    		if(temp != '.'){
	    			if((s.contains(board[i][j]) && board[i][j]!= '.')|| (board[i][j] > '0'+9 && board[i][j]!= '.') || (board[i][j] <= '0' && board[i][j]!= '.')){
	    				out = false;
	    				return out;
	    			}
	    			else{
	    				s.add(temp);
	    			}
	    		}
	    	}
	    }
	    for(int i=0; i<9; i++){
	    	Set<Character> s = new HashSet<Character>();
	    	for(int j=0; j<9; j++){	   
	    		temp = board[j][i];
	    		if(temp != '.'){			
	    			if(s.contains(temp) || (temp > '0'+9) || (temp <= '0')){
	    				out = false;
	    				return out;
	    			}
	    			else{
	    				s.add(temp);
	    			}
	    		}
	    	}
	    }
	    for(int i=0; i<9; i++){
	    	Set<Character> s = new HashSet<Character>();
	    	for(int j=0; j<9; j++){	        		
	    		temp =  board[(i/3)*3+j/3][((i%3)*3)+j%3];
	    		if(temp!= '.'){	    			
	    			if(s.contains(temp)|| (temp > '0'+9) || (temp <= '0')){
	    				out = false;
	    				return out;
	    			}
	    			else{
	    				s.add(temp);
	    			}
	    		}
	    	}
	    }
	    return out;
	}
}
