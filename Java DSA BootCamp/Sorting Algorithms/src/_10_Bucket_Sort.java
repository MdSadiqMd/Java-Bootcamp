import java.util.*;
// The bucket Sort Algorithm is a part of internal working of hashmap
// In bucket sort we sort the buckets of the hashmap and push them into an array
// Here the length of the buckets array is equal to (int) * (The Largest Element in the Array to be sorted) * (Length of the array to be sorted)
// *** The bucket sort is applicable only when the elements are evenly distributed
public class _10_Bucket_Sort {
    static void bucketSort(float[] arr, int n) {
        if (n <= 0)
            return;

        // 1) Create n empty buckets
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<Float>();
        }

        // 2) Put array elements in different buckets ***(Hash Function)
        for (int i = 0; i < n; i++) {
            float idx = arr[i] * n;
            buckets[(int)idx].add(arr[i]);
        }

        // 3) Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
            System.out.println("bucket "+ i  +" --> "+buckets[i]);
        }
        System.out.println();

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = { (float)0.897, (float)0.565, (float)0.656, (float)0.1234, (float)0.665, (float)0.3434 };
        int n = arr.length;
        bucketSort(arr, n);
        System.out.print("Sorted array is ");
        for (float el : arr) {
            System.out.print(el + ",");
        }
    }
}
