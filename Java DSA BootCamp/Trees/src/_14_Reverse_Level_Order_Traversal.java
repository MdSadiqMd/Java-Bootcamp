import java.util.*;

class Node13{
    int data;
    Node13 left,right;
    public Node13(int data){
        this.data=data;
        left=right=null;
    }
}
public class _14_Reverse_Level_Order_Traversal {
    Node13 root;
    _14_Reverse_Level_Order_Traversal(){
        root=null;
    }
    public List<List<Integer>> levelOrder(Node13 root){
        List<List<Integer>> levels=new ArrayList<>();
        if(root==null){
            return levels;
        }
        Queue<Node13> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = levelSize; i >0; i--) {
                Node13 node = queue.remove();
                currentLevel.add(node.data);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels.add(currentLevel);
        }
        Collections.reverse(levels);
        return levels;
    }
    public static void main(String[] args) {
         _14_Reverse_Level_Order_Traversal tree=new _14_Reverse_Level_Order_Traversal();
        tree.root = new Node13(1);
        tree.root.left = new Node13(2);
        tree.root.right = new Node13(3);
        tree.root.left.left = new Node13(4);
        tree.root.right.left = new Node13(5);
        tree.root.right.right = new Node13(6);
        tree.root.right.left.left = new Node13(7);
        tree.root.right.left.right = new Node13(8);

        List<List<Integer>> result = tree.levelOrder(tree.root);
        System.out.println(result);
    }
}
