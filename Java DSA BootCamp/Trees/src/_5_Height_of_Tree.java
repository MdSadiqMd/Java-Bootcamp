class Node4{
    int data;
    Node4 left,right;
    public Node4(int data){
        this.data=data;
        left=right=null;
    }
}
public class _5_Height_of_Tree {
    Node4 root;
    _5_Height_of_Tree(){
        root=null;
    }
    public int Height(Node4 root){
        if(root==null){
            return 0;
        }
        else{
            int lHeight=Height(root.left);
            int rHeight=Height(root.right);
            return Math.max(lHeight+1,rHeight+1);
        }
    }
    public static void main(String[] args) {
        _5_Height_of_Tree tree = new _5_Height_of_Tree();
        tree.root = new Node4(1);
        tree.root.left = new Node4(2);
        tree.root.right = new Node4(3);
        tree.root.left.left = new Node4(4);
        tree.root.right.left = new Node4(5);
        tree.root.right.right = new Node4(6);
        tree.root.right.left.left = new Node4(7);
        tree.root.right.left.right = new Node4(8);
        int result=tree.Height(tree.root);
        System.out.println(result);
    }
}
