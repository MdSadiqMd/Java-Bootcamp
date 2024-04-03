import java.util.Arrays;

public class _4_Single_Number_II {
    public static int search(int[] arr){
        int count,ans=0;
        for(int i=0;i<=31;i++){
            count=0;
            for(int j=0;j<=arr.length-1;j++){
                if((arr[j]&(1<<i))!=0) count++;
            }
            if(count%3==1) ans=ans|(1<<i);
        }
        return ans;
    }
    public static int searchOptimized(int[] arr){
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i+=3){
            if(arr[i]!=arr[i+1]) return arr[i];
        }
        return arr[arr.length-1];
    }
    public static void main(String[] args) {
        int[] arr={5,5,5,6,4,4,4};
        System.out.println(search(arr));
        System.out.println(searchOptimized(arr));
    }
}
