/*
Let's take an example of an array [1,2,3,4,5,6]. Find the sum of elements from index two to five the time complexity in worst-Case is O(n)
To optimize this to O(logn) we use segment trees
*** We use segment trees when we need to find sum,avg,max,min,product,... in arrays from some indexes

 The Representation of the Dividing of the Indexes in form of Segment Trees
                [0-5]
               /     \
          [0-2]       [3-5]
          /   \        /   \
      [0-1]   [2]    [3-4] [5]
      /   \    |     /   \   |
    [0]   [1] [2]  [3]  [4] [5]

 */
class Node23{
    int data;
    Node23 left,right;
    public Node23(int data){
        this.data=data;
        left=right=null;
    }
}
public class _28_Segment_Trees {
    Node23 root;
    _28_Segment_Trees(){
        root=null;
    }
    public static void main(String[] args) {

    }
}
