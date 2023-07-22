class Node1{
    int data;
    Node1 left,right;
    public Node1(int data){
        this.data=data;
        left=right=null;
    }
}
public class _2_Pre_Order_Traversal {
    Node1 root;
    _2_Pre_Order_Traversal(){
        root=null;
    }
    public void Traversal(Node1 node){
        if(node==null){
            return;
        }
        // 1. Print the Data
        System.out.println(node.data+" ");
        // 2. Traverse Left Sub-Tree
        Traversal(node.left);
        // 3. Traverse Right Sub-Tree
        Traversal(node.right);
    }
    public static void main(String[] args) {
        _2_Pre_Order_Traversal tree = new _2_Pre_Order_Traversal();
        tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.right.left = new Node1(5);
        tree.root.right.right = new Node1(6);
        tree.root.right.left.left = new Node1(7);
        tree.root.right.left.right = new Node1(8);
        tree.Traversal(tree.root);
        System.out.println(" ");
    }
}
