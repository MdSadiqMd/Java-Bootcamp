/*
Let's take an example of an array [1,2,3,4,5,6]. Find the sum of elements from index two to five the time complexity in worst-Case is O(n)
To optimize this to O(logn) we use segment trees
*** We use segment trees when we need to find sum,avg,max,min,product,*Updating Values at Indexes... in arrays from some indexes

 The Representation of the Dividing of the Indexes in form of Segment Trees
                [0-5]
               /     \
          [0-2]       [3-5]
          /   \        /   \
      [0-1]   [2]    [3-4] [5]
      /   \    |     /   \   |
    [0]   [1] [2]  [3]  [4] [5]

Let us say we need sum between 2 and 4
1. Start at the root node `[0-5]`.
2. Since the range `[2-4]` intersects with both `[0-2]` and `[3-5]`, we need to consider both child nodes.
3. Move to node `[0-2]` (left child).
4. Since the range `[2-4]` is fully contained within `[0-2]`, we move down to its child node `[0-1]`.
5. The range `[2-4]` doesn't intersect with `[0-1]`, but it does intersect with node `[2]`. So, we consider node `[2]` as well.
6. We add the values associated with nodes `[2]` and `[3-4]`.

Sum between indexes 2 and 4 = Value at node `[2]` + Value at node `[3-4]`

Now, let's look at the values associated with these nodes:
- Value at node `[2]` represents the sum of elements `[2]`, which is `5`.
- Value at node `[3-4]` represents the sum of elements `[3, 4]`, which is `7 + 9 = 16`.
Sum between indexes 2 and 4 = 5 + 16 = `21`
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
