/*
We use heap to select an Element which satisfy a particular Criteria
The point of using heap is to search / Selecting an Element in an Array in O(logn) time complexity
Here we represent the Array in the Form of Complete Binary Tree calling it as Heap
where , representation
1. Parent - i
2. Left Child - 2*i+1
3. Right Child - 2*i

Min Heap : The top most Element (Node) is the Minimum Element in the Whole Array
Inserting --> Let assume we are Inserting an Element in the Heap tree then we will use Heapify method(upheapify) that will place the inserted Element in correct Position
         7
       /   \
      8     9
     / \   / \
   10  11 12  13
  /
14

to

         5
       /   \
      7     9
     / \   / \
   10  11 12  13
  / \
14   8
Deleting --> Let assume we are Deleting an Element in the Heap tree then we will use Heapify method that will place the Remaining Elements in correct Position
         5
       /   \
      7     9
     / \   / \
   10  11 12  13
  / \
14   8

to

         7
       /   \
      8     9
     / \   / \
   10  11 12  13
  /
14
Note : Heapify --> The process of rearranging the elements such that elements satisfy heap property is called Heapify
MaxHeap : The top most Element (Node) is the Largest Element in the Whole Array
 */
public class _1_Heap {
    public static void main(String[] args) {

    }
}
