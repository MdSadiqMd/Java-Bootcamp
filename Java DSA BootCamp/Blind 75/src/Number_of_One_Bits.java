public class Number_of_One_Bits {
    static int hammingWeight(int n) { // In Bit Manipulation mostly see while loop uses to be greater than zero and then manipulate and see increment,AND,OR,Shifts
        int count=0;
        while(n>0){
            count+=n&1;
            n>>=1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }
}
