public class Recursion {
    //recursion is a function which calls itself

    static int sumrec(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n+ sumrec(n-1);
    }

    public static int main(String[] args) {
        int c=sumrec(5);
        System.out.println(c);
        return c;
    }
}

