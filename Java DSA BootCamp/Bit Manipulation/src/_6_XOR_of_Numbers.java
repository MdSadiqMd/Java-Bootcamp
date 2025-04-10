public class _6_XOR_of_Numbers {
    public static int xor(int n){
        return switch(n%4){
            case 1->1;
            case 2->n+1;
            case 3->0;
            default->n;
        };
    }
    public static int xorRange(int n,int m){
        return xor(n-1)^xor(m);
    }
    public static void main(String[] args) {
        int n=10,m=15;
        System.out.println(xor(n));
        System.out.println(xorRange(n,m));
    }
}
