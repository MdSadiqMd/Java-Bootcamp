class Node5{
    int data;
    Node5 left,right;
    public Node5(int data){
       this.data=data;
       left=right=null;
    }
}
public class _6_Symmetric_Tree {
    Node5 root;
    _6_Symmetric_Tree(){
        root=null;
    }
    public Boolean Symmetry(Node5 left, Node5 right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.data != right.data) {
            return false;
        } else {
            // Check if the left subtree's left child is a mirror image of the right subtree's right child,
            // and the left subtree's right child is a mirror image of the right subtree's left child.
            return Symmetry(left.left, right.right) && Symmetry(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        _6_Symmetric_Tree tree=new _6_Symmetric_Tree();
        tree.root = new Node5(1);
        tree.root.left = new Node5(2);
        tree.root.right = new Node5(3);
        tree.root.left.left = new Node5(4);
        tree.root.right.left = new Node5(5);
        tree.root.right.right = new Node5(6);
        tree.root.right.left.left = new Node5(7);
        tree.root.right.left.right = new Node5(8);
        Boolean result=tree.Symmetry(tree.root,tree.root);
        System.out.println(result);
    }
}
