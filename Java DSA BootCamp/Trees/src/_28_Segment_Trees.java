/*
Let's take an example of an array [1,2,3,4,5,6]. Find the sum of elements from index two to five the time complexity in worst-Case is O(n)
To optimize this to O(logn) we use segment trees.
*** Segment trees are Binary Trees (No Duplicates and present in Order)
*** We use segment trees when we need to find sum,avg,max,min,product,*Updating Values at Indexes... in arrays from some indexes

 The Representation of the Dividing of the Indexes in form of Segment Trees
                [0-5]
               /     \
          [0-2]       [3-5]
          /   \        /   \
      [0-1]   [2]    [3-4] [5]
      /   \    |     /   \   |
    [0]   [1] [2]  [3]  [4] [5]

--> Let us say we need sum between 2 and 4
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

--> Let us say we need to update Index 3 with 7
*** The Update will not only update the selected "Node" in Segment tree it updates all nodes to the top as sum will be updated
1. Start at the root node `[0-5]`.
2. The update affects index 3, which falls under the `[3-5]` segment. Move to node `[3-5]`.
3. Within the `[3-5]` segment, index 3 corresponds to node `[3]`. Update the value of node `[3]` to 7.
4. Update the parents of node `[3]` accordingly. In this case, you only need to update the value at node `[3-4]` since it also covers index 3.
After update:
                [0-5]
               /     \
          [0-2]       [3-5]
          /   \        /   \
      [0-1]   [2]    [3-4] [5]
      /   \    |     /   \   |
    [0]   [1] [2]  [7]  [4] [5]
The segment tree efficiently maintains the updated values and allows you to keep track of the changes in the array while still being able to perform range queries efficiently.
 */
class Node23 {
    int data;
    int startInterval;
    int endInterval;
    Node23 left, right;
    public Node23(int startInterval, int endInterval, int data) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.data = data;
        left = right = null;
    }
}

public class _28_Segment_Trees {
    Node23 root;

    _28_Segment_Trees() {
        root = null;
    }

    // Function to build a segment tree
    Node23 buildSegmentTree(int[] arr, int start, int end) {
        if (start == end) {
            return new Node23(start, end, arr[start]);
        }

        int mid = (start + end) / 2;
        Node23 leftChild = buildSegmentTree(arr, start, mid);
        Node23 rightChild = buildSegmentTree(arr, mid + 1, end);

        Node23 parentNode = new Node23(start, end, leftChild.data + rightChild.data);
        parentNode.left = leftChild;
        parentNode.right = rightChild;

        return parentNode;
    }

    // Code for Finding sum from  a to b Index Using Segment Trees
    int Sum(Node23 node, int queryStart, int queryEnd) {
        // If the node's interval is completely outside the query range
        if (node.endInterval < queryStart || node.startInterval > queryEnd) {
            return 0;
        }

        // If the node's interval is completely inside the query range
        if (node.startInterval >= queryStart && node.endInterval <= queryEnd) {
            return node.data;
        }

        // Otherwise, we need to check both left and right children
        int mid = (node.startInterval + node.endInterval) / 2;
        int leftSum = Sum(node.left, queryStart, queryEnd);
        int rightSum = Sum(node.right, queryStart, queryEnd);

        return leftSum + rightSum;
    }

    // Function to update a value at a specific index
    public static void updateValueAtIndex(Node23 currentNode, int index, int newValue) {
        if (currentNode.startInterval == index && currentNode.endInterval == index) {
            currentNode.data = newValue;
            return;
        }

        int mid = (currentNode.startInterval + currentNode.endInterval) / 2;

        if (index <= mid) {
            updateValueAtIndex(currentNode.left, index, newValue);
        } else {
            updateValueAtIndex(currentNode.right, index, newValue);
        }

        currentNode.data = currentNode.left.data + currentNode.right.data;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        _28_Segment_Trees segmentTree = new _28_Segment_Trees();
        segmentTree.root = segmentTree.buildSegmentTree(arr, 0, arr.length - 1);

        // Calculate the sum from index 2 to index 4
        int queryStart = 2;
        int queryEnd = 4;
        int sum = segmentTree.Sum(segmentTree.root, queryStart, queryEnd);
        System.out.println("Sum between index " + queryStart + " and " + queryEnd + ": " + sum);

        // Updating Value at Particular Index --> *** This will update the whole upward values
        updateValueAtIndex(segmentTree.root,3,7);
    }
}