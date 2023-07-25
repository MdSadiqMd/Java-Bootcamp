/*
--> AVL - Adelson Velskii and Lamdis
--> It is a Self - Balancing BST which balances when the Balance of the tree changes when Node is Added to the Tree
--> In BST when the tree is long One-Direction Tree then the Time Complexity for searching an Element in Tree will be O(n) from O(log n)
--> *** If (Height of left Sub - Tree) - (Height of Right Sub - Tree) = 0 (or) 1 it's a Balanced Tree
 */
class Node22{
    int data;
    Node22 left,right;
    public Node22(int data){
        this.data=data;
        left=right=null;
    }
}
public class _23_AVL_Trees {
    Node22 root;
    _23_AVL_Trees(){
        root=null;
    }
    public void insert(Node22 node,int value){
        if(node==null){
            return;
        }else{
            if(value<root.data){
                insert(root.left,value);
            }
            else{
                insert(root.right,value);
            }
        }
    }
    public static void main(String[] args) {
        _23_AVL_Trees tree=new _23_AVL_Trees();
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 8);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 9);
    }
}
