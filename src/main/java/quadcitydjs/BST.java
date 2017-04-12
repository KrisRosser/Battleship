/*maximum nodes per tree is n = 2^h - 1.
a full tree has used its maximum nodes.
a complete tree is where a branch has reached its maximum height. any full tree is by definition complete.
a balanced tree is subjective and might be something along the lines of no branch being having a height difference of more than one.

every tree has a structure component and an order component
Binart Search Tree (BST)
	binary structure (shape of tree)
	BST order property = Left <= Parent <= Right
	
adding and finding are both O(h) efficiency or O(log n). This is only true if tree is balanced.
	this is why balance is SOOOOO importance in trees.
	
the 3 ways we will "look" through a binary search tree are : preorder, in order, postorder
Pre = PLR
In = LPR
Post = LRP

     p
	/ \
   l   r

*/

public class BST<T extends Comparable<T>> {
    private class Node<E> {
        public E data;
        public Node<E> left;
        public Node<E> right;
        public Node(E e) { data = e; left = right = null; }
    }
    
    private Node<T> root;
    private int numNodes;
    
    public BST() {
        root = null;
        numNodes = 0;
    }
    
    private Node<T> add(Node<T> root, T elt) {
        Node<T> temp = new Node<>(elt);
        if(root == null) return temp;
        else if(temp.data.compareTo(root.data) > 0)
            root.right = add(root.right, elt);
        else 
            root.left = add(root.left, elt);
        return root;
    }
    
    public void add(T elt) {
        root = add(root, elt);
        numNodes++;
    }
    
    private String preorder(Node<T> root) {
        if(root == null) return "";
        else {
            String p = String.valueOf(root.data);
            String l = preorder(root.left);
            String r = preorder(root.right);
            return p + l + r;
        }
    }
    
    public String preorder() {
        return preorder(root);
    }
    
    private String postorder(Node<T> root) {
        if(root == null) return "";
        else {
            String p = String.valueOf(root.data);
            String l = postorder(root.left);
            String r = postorder(root.right);
            return l + r + p;
        }
    }
    
    public String postorder() {
        return postorder(root);
    }
    
    private String inorder(Node<T> root) {
        if(root == null) return "";
        else {
            String p = String.valueOf(root.data);
            String l = inorder(root.left);
            String r = inorder(root.right);
            return l + p + r;
        }
    }
    
    public String inorder() {
        return inorder(root);
    }
    public int size() { return numNodes; }
    
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        int[] nums = {8, 6, 7, 5, 3, 0, 9};
        for(int i = 0; i < nums.length; i++) {
            tree.add(nums[i]);
        }
        System.out.println(tree.size());
        System.out.println(tree.preorder());
        System.out.println(tree.inorder());
        System.out.println(tree.postorder());
    }
}







