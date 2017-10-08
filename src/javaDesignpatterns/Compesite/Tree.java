package javaDesignpatterns.Compesite;

public class Tree {
	public TreeNode root;
	
	public Tree(String name){
		this.root=new TreeNode(name);
	}
	
	public TreeNode getRoot(){
		return this.root;
	}
	
	public void setRoot(TreeNode root){
		this.root=root;
	}
	
	
}
