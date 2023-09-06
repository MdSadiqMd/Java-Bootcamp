public class Checking_Duplicate {
    public static boolean Checking(int[] arr,int k){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,1};
        int k=1;
        System.out.println(Checking(arr,k));
    }
}
