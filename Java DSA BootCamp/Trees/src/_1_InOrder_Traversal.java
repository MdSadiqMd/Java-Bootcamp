class Node {
    int data;
    Node left,right;
    public Node(int data){
        this.data=data;
        left=right=null;
    }
}
public class _1_InOrder_Traversal {
    Node root;
    _1_InOrder_Traversal(){
        root=null;
    }
    public void Traversal(Node node){
        if(node==null){
            return;
        }
        // 1. Traverse Left Sub-Tree
        Traversal(node.left);
        // 2. Print the Data
        System.out.println(node.data+" ");
        // 3. Traverse Right Sub-Tree
        Traversal(node.right);
    }
    public static void main(String[] args) {
        _1_InOrder_Traversal tree = new _1_InOrder_Traversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left.left = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.Traversal(tree.root);
        System.out.println(" ");
    }
}
