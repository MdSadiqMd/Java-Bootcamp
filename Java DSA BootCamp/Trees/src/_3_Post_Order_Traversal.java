class Node2 {
    int data;
    Node2 left,right;
    public Node2(int data){
        this.data=data;
        left=right=null;
    }
}
public class _3_Post_Order_Traversal {
    Node2 root;
    _3_Post_Order_Traversal(){
        root=null;
    }
    public void Traversal(Node2 node){
        if(node==null){
            return;
        }
        // 1. Traverse Left Sub-Tree
        Traversal(node.left);
        // 2. Traverse Right Sub-Tree
        Traversal(node.right);
        // 3. Print the Data
        System.out.println(node.data+" ");
    }
    public static void main(String[] args) {
        _3_Post_Order_Traversal tree = new _3_Post_Order_Traversal();
        tree.root = new Node2(1);
        tree.root.left = new Node2(2);
        tree.root.right = new Node2(3);
        tree.root.left.left = new Node2(4);
        tree.root.right.left = new Node2(5);
        tree.root.right.right = new Node2(6);
        tree.root.right.left.left = new Node2(7);
        tree.root.right.left.right = new Node2(8);
        tree.Traversal(tree.root);
        System.out.println(" ");
    }
}
