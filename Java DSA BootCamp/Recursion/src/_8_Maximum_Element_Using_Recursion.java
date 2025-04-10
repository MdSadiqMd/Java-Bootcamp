import java.util.Scanner;
public class _8_Maximum_Element_Using_Recursion {
    public static int MaximumElement(int[] arr,int n,int index){
        if(index == n - 1) {
            return arr[n - 1];
        }
        return Math.max(arr[index], MaximumElement(arr, n,index + 1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length of Array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the Array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(MaximumElement(arr, n,0));
    }
}
