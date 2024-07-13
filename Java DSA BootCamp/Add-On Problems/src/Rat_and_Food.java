public class Rat_and_Food {
    public static void main(String[] args) {
        int r=7,units=2,n=8,sum=0,i=0;
        int[] arr={2,8,3,5,7,4,1,2};
        int food=r*units;
        while(i<arr.length){
            sum+=arr[i];
            if(sum>food){
                System.out.println(i+1);
                break;
            }
            i++;
        }
        if(sum<food) System.out.println(0);
    }
}
