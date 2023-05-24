//Linear Search Means we Search Element by Element equating to the term need to be found
//Can be used in sorted or unsorted array
//But it's sucks if the Length of array is huge
import java.util.Scanner;
public class _1_Linear_Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length of 1D Array");
        int n=sc.nextInt();

        //1D Array
        System.out.println("Enter the Values of 1D Array");
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the element needed to be Searched");
        int k=sc.nextInt();
        int count=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==k){
                count=i;
                break;
            }
        }
        if(count==-1){
            System.out.println("Element is not present in the Array");
        }
        else{
            System.out.println("Element is present at Index "+count +"\n"+"Element is present in the place "+(count+1));
        }

        //2D Array
        /*System.out.println("Enter Number of Columns of 2D Array");
        int m=sc.nextInt();
        System.out.println("Enter Number to Be Searched from 2D Array");
        int l=sc.nextInt();
        int [][] arr1=new int[m][n];
        int row=-1;
        int column=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr1[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr1[i][j]==l){
                    return new int[] {i,j};
                }
            }
        }*/
    }
}
