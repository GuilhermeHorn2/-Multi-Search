package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class main_misc {
	
	
	public static final int MAX = 1_000_000;
	
	
	
	public static void main(String[] args) {
	
	
	List<String> T = new ArrayList<>(Arrays.asList("aa","horn","aab","ak"));	
	
	String b = "aabbcc";
	
	System.out.println(multi_search(T,b));

	
		
		
	}
	private static List<Boolean> multi_search(List<String> T,String b){
		
		//I will return a list of booleans if idx i is true it means that T.get(i) is in b.
		
		//If i use a tree i can decrease the time complexity from  something like O(n^3) to O(n^2)
		
		Tree_char t = new Tree_char();
		
		int l = b.length();
		
		for(int i = 0;i < l;i++){

			for(int j = i+1;j < l;j++){
				t.add(b.substring(i,j));
			}
			
		}
		
		List<Boolean> on_b = new ArrayList<>();
		
		for(int i = 0;i < T.size();i++){
			
			if(t.have_word(T.get(i))){
				on_b.add(true);
			}
			else {
				on_b.add(false);
			}
		}
		
		return on_b;
	}
	
	

}
