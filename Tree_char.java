package misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree_char {
	
	/*The goal is to have a tree class that can store words on a in_depth search,the words will be from leftmost
	 * to rightmost sorted based on the ASCII value.I will make this tree using adjacency list.
	 */
	
	public static class node{
		
		
		public  String value;

		public node parent_node = null;
		
		public List<node> adj_list;
		
		
		node(String value){			
			
			//If value is upper case set to lower
			this.value = value;
			if(value != null && value != "" && Character.isUpperCase(this.to_char())){
				value = ""+Character.toLowerCase(this.to_char());
			}
			
			this.value = value;
			adj_list = new LinkedList<>();
			for(int i = 0;i < 25;i++){
				adj_list.add(null);
			}
		}
		
		public char to_char(){
			return value.toCharArray()[0];
		}
		
		public String toString(){
			return ""+value+" --> "+(int)this.to_char();
		}
		
	}
	
	public node root = new node("");
	
	
	Tree_char(){}
	
	public boolean add(String word){
		
		//each char will be represented by a node in different depths 
		
		
		node itr = root;
		for(int i = 0;i < word.length();i++){
			
			String str = word.substring(i,i+1); 
			int idx = (int)str.toCharArray()[0] - 97;
			
			//avoiding error
			if(idx < 0 || idx > 25){
				return false;
			}
			
			if(itr.adj_list.get(idx) != null){
				itr = itr.adj_list.get(idx);
				continue;
			}

			itr.adj_list.set(idx,new node(str));
			itr = itr.adj_list.get(idx);
		}
		itr = null;
		return true;
	}
	
	private void delete_subtree(node n){
		
		if(n != null){
			for(int i = 0;i < 25;i++){
				delete_subtree(n.adj_list.get(i));
			}
			n = null;
		}
		
	}
	
	public boolean remove(String letter,int depth){
		
		//remove a certain letter at a certain depth
		
		int idx = (int)letter.toCharArray()[0] - 97;
		
		int c = 0;
		node itr = root;
		while(c < depth && itr.adj_list.get(idx) == null){
			itr = itr.adj_list.get(idx);
			c++;
		}
		if(c != depth){
			return false;
		}
		
		//I will delete the subtree that starts form itr,i can just set the reference to this objects as null
		
		itr.parent_node.adj_list.set(idx,null);
		
		delete_subtree(itr);
		
		return true;
		
	}
	
	public boolean have_word(String word){
		
		node itr = root;
		
		int l = word.length();
		int c = 0;
		while(c < l){
			int idx = (int)word.substring(c,c+1).toCharArray()[0] - 97;
			itr = itr.adj_list.get(idx);
			if(itr == null) {
				break;
			}
			c++;
		}
		if(c != l){
			return false;
		}
		return true;
	}

	
}
