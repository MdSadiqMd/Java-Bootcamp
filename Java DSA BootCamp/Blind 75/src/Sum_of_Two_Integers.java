public class Sum_of_Two_Integers {
    static int add(int a,int b) { // Think of Carry and check if the number is greater than zero/not equal to zero see in bit manipulation problems the while loop is mostly there
        while(b!=0){
            int carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(add(3,4));
    }
}
