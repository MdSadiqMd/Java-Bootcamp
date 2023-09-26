import java.util.ArrayList;
import java.util.Collections;

/*
We use heap to select an Element which satisfy a particular Criteria
The point of using heap is to search / Selecting an Element in an Array in O(logn) time complexity
Here we represent the Array in the Form of Complete Binary Tree calling it as Heap
where , representation
1. Parent - i
2. Left Child - 2*i+1
3. Right Child - 2*i+2

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

Interview Question : Create the Max - Heap from the given unsorted array [1, 4, 2, 5, 3, 6]
the binary tree representation of given array is
        1
       / \
      4   2
     / \   \
    5   3   6
now to convert the given unsorted array into heap we should come from ***last leaf nodes and check whether the leaf nodes are satisfying the condition of heap wrt their parents and if not swap them
        6
       / \
      5   2
     / \   \
    4   3   1
Remember start from bottom
 */
public class _1_Heap {
    static class Heap<T extends Comparable<T>> {
        private ArrayList<T> list;

        public Heap() {
            list = new ArrayList<>();
        }

        private void swap(int first, int second) {
            T temp = list.get(first);
            list.set(first, list.get(second));
            list.set(second, temp);
        }

        public int parent(int index) {
            return (index - 1) / 2;
        }

        public int left(int index) {
            return 2 * index + 1;
        }

        public int right(int index) {
            return 2 * index + 2;
        }

        public void insert(T value) {
            list.add(value);
            upheap(list.size() - 1);
        }

        private void upheap(int index) {
            if (index == 0) {
                return;
            }
            int p = parent(index);
            if (list.get(index).compareTo(list.get(p)) > 0) {  // ***If <0 then it will become maxHeap
                swap(index, p);
                upheap(p);
            }
        }

        public T remove() throws Exception {
            if (list.isEmpty()) {
                throw new Exception("Can't Remove from an empty Heap");
            }
            T temp = list.get(0);
            T last = list.remove(list.size() - 1);
            if (!list.isEmpty()) {
                list.set(0, last);
                downheap(0);
            }
            return temp;
        }

        private void downheap(int index) {
            int max = index;
            int left = left(index);
            int right = right(index);
            if (left < list.size() && list.get(left).compareTo(list.get(max)) > 0) {
                max = left;
            }
            if (right < list.size() && list.get(right).compareTo(list.get(max)) > 0) {
                max = right;
            }
            if (max != index) {
                swap(max, index);
                downheap(max);
            }
        }

        public ArrayList<T> heapSort() throws Exception {
            ArrayList<T> sortedList = new ArrayList<>();
            while (!list.isEmpty()) {
                sortedList.add(remove());
            }
            // Reverse the sorted list in-place
            Collections.reverse(sortedList);
            return sortedList;
        }
    }

    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        System.out.println(heap.remove());

        // HeapSort --> Removing the Elements until the Linked List is Empty
        ArrayList<Integer> sortedList = heap.heapSort();
        System.out.println(sortedList);
    }
}