import java.util.LinkedList;
import java.util.List;

public class _32_Diameter_of_N_Array_Tree {
    public static class TreeNode{
        int data;
        List<TreeNode> children = new LinkedList<TreeNode>();
        TreeNode(int data){
            this.data = data;
        }
    }
    public static int height(TreeNode root,int[] max){
        if(root==null) return 0;
        int h1=0,h2=0,h=0;
        for(TreeNode node:root.children){
            h=height(node,max);
            if(h>h1){
                h2=h1;
                h1=h;
            } else if(h>h2){
                h2=h;
            }
        }
        max[0]=Math.max(max[0],h1+h2);
        return 1+h1;
    }
    public static int diameter(TreeNode root){
        int[] max=new int[1];
        height(root,max);
        return max[0];
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
        System.out.println(diameter(root));
    }
}