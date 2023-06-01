import java.util.*;
/*
Return the square root of the entered number , if not perfect square return the floor / Lower Bound value
Here ,we make an array of number of elements of length of same of the element
Now, we declare length of high is n/2 as the square root of any number is less than it's half value
and will search the number in the reduced bracket of 0 to n/2
If the element is not found we will return the lower bound (n/2) --> ex: if 15 --> 3 its the last mid-value we get
 */
public class _4_Square_Root {
    public static int BinarySearch(int n){
      int result = 0;
      int low=0,high=n/2; // here we give the high=n/2 as the square root of any number is less than it's half value
      while(low<=high){
          int mid=low+(high-low)/2;
          int mid2=mid*mid;
          if(mid2==n) {
              return mid;
          } else if (mid2<n) {
              result =mid;
              low=mid+1;
          } else {
              high=mid-1;
          }
      }
      return result;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Number : ");
        int n=sc.nextInt();

        System.out.println("Enter the Values of Array : ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int result=BinarySearch(n);
        System.out.println("The Square Root is :"+result);
    }
}
