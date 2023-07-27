import java.util.Arrays;

public class _2_Max_Heap {
    private int[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public _2_Max_Heap() {
        this.heap = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public int deleteMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if (leftChild < size && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, 2 * heap.length);
        }
    }

    public static void main(String[] args) {
        _2_Max_Heap maxHeap = new _2_Max_Heap();
        maxHeap.insert(5);
        maxHeap.insert(7);
        maxHeap.insert(3);
        maxHeap.insert(10);
        maxHeap.insert(1);

        System.out.println("Max element: " + maxHeap.deleteMax());
        System.out.println("Max element: " + maxHeap.deleteMax());
    }
}

