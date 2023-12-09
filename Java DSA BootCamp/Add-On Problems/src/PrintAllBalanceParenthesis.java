public class PrintAllBalanceParenthesis {
    public void balanceParams(char[] arr,int n,int i,int open,int close){
        if(i==arr.length){
            System.out.println(arr[i]);
        }
        if(open<close){
            arr[i]='(';
            balanceParams(arr,n,i+1,open+1,close);
        }
        if(close<open){
            arr[i]=')';
            balanceParams(arr,n,i+1,close,open+1);
        }
    }
    public static void main(String[] args) {

    }
}
