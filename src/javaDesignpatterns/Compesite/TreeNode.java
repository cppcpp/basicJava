package javaDesignpatterns.Compesite;

import java.util.Enumeration;
import java.util.Vector;

import javax.print.attribute.standard.RequestingUserName;

public class TreeNode {
	private String name;
	private TreeNode parent;
	private Vector<TreeNode> children=new Vector<>();
	
	public TreeNode(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	//添加子节点
	public void add(TreeNode node){
		children.add(node);
	}
	
	//删除子节点
	public void remove(TreeNode node){
		children.remove(node);
	}
	
	//得到孩子节点
	public Enumeration<TreeNode> getChildrens(){
		return this.children.elements();
	}
}
