/*
For Inversion it should satisfy:
1. i < j
2. arr[i] > arr[j]
 */
public class _6_Count_Number_of_inversions {
    // By Using Merge Sort (Optimized)
    public static int inversionCount(int[] arr, int l, int h) {
        int count = 0;
        if (l < h) {
            int mid = l + (h - l) / 2;
            count += inversionCount(arr, l, mid);
            count += inversionCount(arr, mid + 1, h);

            count = count + mergeProcedure(arr, l, mid, h);
        }
        return count;
    }

    public static int mergeProcedure(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        int i, j, k;

        for (i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        for (j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        i = 0;
        j = 0;
        k = l;
        int count = 0; // New variable to count inversions during merging

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += (mid - i + 1); // Increment count when there's an inversion
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }

        return count; // Return the count of inversions in this merge
    }

    //By Using just Counting (Brute Force)
    /*public static int inversionCount(int[] arr,int n){
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    count=count+1;
                }
            }
        }
        return count;
    }*/

    public static void main(String[] args) {
        int[] arr = { 70, 50, 60, 10, 20, 30, 80, 15 };
        int n = arr.length;
        int count = inversionCount(arr, 0, n - 1);
        System.out.println(count);
    }
}

