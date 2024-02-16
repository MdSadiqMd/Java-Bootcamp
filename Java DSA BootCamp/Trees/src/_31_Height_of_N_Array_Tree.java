import java.util.LinkedList;
import java.util.List;

public class _31_Height_of_N_Array_Tree {
    public static class TreeNode{
        int data;
        List<TreeNode> children = new LinkedList<>();
        TreeNode(int data){
            this.data = data;
        }
    }
    public static int height(TreeNode root){
        if(root==null) return 0;
        int maxDepth=0;
        for(TreeNode node:root.children){
            if(node!=null) maxDepth=Math.max(maxDepth,height(node));
        }
        return 1+maxDepth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        root.children.add(new TreeNode(4));
        root.children.get(0).children.add(new TreeNode(5));
        root.children.get(0).children.add(new TreeNode(6));
        root.children.get(0).children.add(new TreeNode(7));
        root.children.get(1).children.add(new TreeNode(8));
        root.children.get(2).children.add(new TreeNode(9));
        root.children.get(2).children.add(new TreeNode(10));
        root.children.get(2).children.add(new TreeNode(11));
        System.out.println(height(root));
    }
}
