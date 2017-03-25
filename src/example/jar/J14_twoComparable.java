package example.jar;


/**
 * 分析比较器的排序原理
 *  二叉树排序的基本原理：将第一个内容作为根节点保存，如果后面的值比根节点的值小，
 *  则放在根节点的左子树，如果后面的值比根节点的值大则放在根节点的右子树
 *
 */
public class J14_twoComparable {
	public static void main(String[] args) {
		J14_twoComparable j14 = new J14_twoComparable();
		// 1.Integer为Comparable接口实例化
		j14.comparable01();
		// 2.基于Comparable接口实现的二叉树操作
		System.out.println("*****基于Comparable接口实现的二叉树操作********************");
		BinaryTree bt = new BinaryTree();
		bt.add(8);
		bt.add(3);
		bt.add(3);
		bt.add(10);
		bt.add(9);
		bt.add(1);
		bt.add(5);
		bt.add(5);
		System.out.println("排序的结果为:");
	
		bt.print();

	}

	/**
	 * 编写一个简单的二叉树排序的操作 此处为了简化代码，直接使用Integer，因为Integer类本身实现了Comparable接口
	 */
	public void comparable01() {
		System.out.println("*************Integer为Comparable接口实例化*****************");
		Comparable com = null;// 声明一个Comparable接口对象
		com = 30; // 通过Integer类为comparable实例化
//		System.out.println(com.compareTo(35));//-1
		System.out.println("内容为:" + com); // 实际上调用的是toString();
		// 直接输出Comparable接口对象实际上调用的是Integer类的toString()方法，此方法已被Integer类覆写了
	}

	public void comparable02() {
		System.out.println("*****************基于Comparable接口实现的二叉树操作*************************");
	}

}

// 用于说明“基于Comparable接口实现的二叉树操作”
class BinaryTree {
	class Node { // 声明一个节点类
		private Comparable data; // 保存具体的内容
		private Node left; // 保存左子树
		private Node right; // 保存右子树

		public void addNode(Node newNode) {
			// 要确定是放在左子树还是右子树
			if (newNode.data.compareTo(this.data) < 0) {
				if (this.left == null) { // 放在左子树
					this.left = newNode;
				} else {
					this.left.addNode(newNode);
				}

			}else{
//			if (newNode.data.compareTo(this.data) >= 0) {
				if (this.right == null) {
					this.right = newNode;
				} else {
					this.right.addNode(newNode);
				}
			}
		}
		public void printNode(){
			if(null!=this.left){
				this.left.printNode();
			}
			System.out.println(this.data+"\t");
			if(null!=this.right){
				this.right.printNode();
			}
		}

		public void printHelp(){
			
		}
		public String toString(){
			return this.data.toString();
		}

	};

	private Node root; // 根元素
	
	public void add(Comparable data) {
		Node newNode = new Node(); // 没传入一个新的内容就声明一个根节点
		newNode.data = data;
		if (root == null) {
			root = newNode;
		} else {
			root.addNode(newNode);// 确定节点是放在左子树还是右子树
		}

	}

	public void print() { // 输出节点
		this.root.printNode();
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
}

