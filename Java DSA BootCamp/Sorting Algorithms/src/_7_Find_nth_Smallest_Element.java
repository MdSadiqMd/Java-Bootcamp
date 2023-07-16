public class _7_Find_nth_Smallest_Element {
    public static int selectionProcedure(int[] arr, int l, int h, int k) {
        int m = partition(arr, l, h);
        if (m == k - 1) {
            return arr[m];
        } else if (m < k - 1) {
            return selectionProcedure(arr, m + 1, h, k);
        } else {
            return selectionProcedure(arr, l, m - 1, k);
        }
    }

    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l;
        for (int j = l + 1; j <= h; j++) {
            if (arr[j] <= pivot) {
                i = i + 1;
                // swap(arr[i], arr[j])
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[l];
        arr[l] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 90, 10, 34, 89, 98, 13 };
        int n = arr.length;
        int k = 3;

        int result = selectionProcedure(arr, 0, n - 1, k);

        System.out.println(result);
    }
}
