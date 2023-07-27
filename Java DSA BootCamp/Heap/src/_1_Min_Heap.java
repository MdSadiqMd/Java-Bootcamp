import java.util.Arrays;

public class _1_Min_Heap {
    private int[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public _1_Min_Heap() {
        heap = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public void delete(int value) {
        int index = findIndex(value);
        if (index != -1) {
            swap(index, size - 1);
            size--;
            heapifyDown(index);
        }
    }

    private int findIndex(int value) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index] < heap[parent]) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, size * 2);
        }
    }

    // Helper method to print the heap
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        _1_Min_Heap heap = new _1_Min_Heap();
        heap.insert(5);
        heap.insert(7);
        heap.insert(3);
        heap.insert(10);
        heap.insert(1);

        heap.printHeap(); // Output: [1, 3, 5, 10, 7]

        heap.delete(5);
        heap.printHeap(); // Output: [1, 3, 7, 10]
    }
}

