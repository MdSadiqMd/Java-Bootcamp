//we don't write n*(n+1)/2 because the index start with 0 when we find summation in arrays
//Now if the value of n is very large we can get Array overflow problem then take a number between (1,n) and subtract the that with all elements in array this case the size of values of array will decrease and later on add the subtracted value to answer
public class _1_1D_Array {
    public static void main(String[] args) {
        System.out.println("Printing elements in an Array");
        int[] marks={1,2,3,4,5};
        for(int i=0;i<=marks.length-1;i++){
            System.out.print(marks[i]+" ");
        }
        System.out.println(" ");

        System.out.println("Palindrome or Not");
        int n=marks.length-1;
        for (int i=0;i<(n/2);i++){
            if(marks[i]==marks[n-i-1]){
                System.out.println("Palindrome");
            }
            else{
                System.out.println("Not Palindrome");
            }
        }

        System.out.println("Reversal In Array"); //Here we are swapping first element with last element
        for(int i=0;i<(n/2);i++){
            int temp=marks[i];
            marks[i]=marks[n-i-1];
            marks[n-i-1]=temp;
        }
        for(int i=0;i<=marks.length-1;i++){
            System.out.print(marks[i]+" ");
        }
        System.out.println(" ");

        System.out.println("Missing Number in array");
        //arr={1,2,3,5} --> o/p:4
        //we use sum of n numbers logic to solve the problem
        //Now if the value of n is very large we can get Array overflow problem then take a number between (1,n) and subtract the that with all elements in array this case the size of values of array will decrease and later on add the subtracted value to answer
        int[] marks1={1,2,3,5,6};
        n=marks1.length;
        int a=(n+1)*(n+2)/2; // ********we don't write n*(n+1)/2 because the index start with 0
        int sum=0;
        for(int i=0;i<=marks.length-1;i++){
            sum+=marks1[i];
        }
        int b=a-sum;
        System.out.println(b);
        //write code for if N numbers are missing and the array start from some N number
        /*int[] marks2={4,5,7,9};//o/p:6,8
        for(int i=marks2[0];i<=marks2[marks2.length-1];i.append()){

        }*/
        System.out.println("Duplicate Number in an Array");
        int[] marks2={1,1,2,3,4,4,5};
        int n1=marks2.length;
        for(int i=0;i<n1;i++){
            for(int j=i+1;j<n1;j++){
                if(marks2[i]==marks2[j]){
                    System.out.println("Duplicate Element:"+marks2[i]);
                }
            }
        }
    }
}
