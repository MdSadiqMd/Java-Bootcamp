import java.util.Arrays;
public class Chocolate {
    public static int[] sort(int[ ] a){
       if(a.length==1){
           return a;
       }
       int[] arr=new int [a.length];
       int n=0;
       for (int number:a){
           if (number!=0){
               arr[n]=number;
               n++;
           }
       }
       return arr;
    }
    public static void main(String[] args) {
        int[] i =new int[] {4,5,0,1,0,0,5};
        System.out.println(Arrays.toString(sort(i)));
    }
}
