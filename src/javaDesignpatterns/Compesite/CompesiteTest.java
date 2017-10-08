package javaDesignpatterns.Compesite;

/*
 * 组合模式
 * 创建树
 * */
public class CompesiteTest {
	public static void main(String[] args) {
		Tree tree=new Tree("A");
		
		TreeNode node1=new TreeNode("B");
		TreeNode node2=new TreeNode("C");
		
		tree.root.add(node1);
		tree.root.add(node2);
		
		
	}
}
