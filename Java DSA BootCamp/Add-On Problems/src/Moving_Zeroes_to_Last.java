import java.util.Arrays;

public class Moving_Zeroes_to_Last {
    public static int[] MovingZeros(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]==0){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr={0,1,0,3,12};
        System.out.println(Arrays.toString(MovingZeros(arr)));
    }
}
