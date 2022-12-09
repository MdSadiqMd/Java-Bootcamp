public class _13_Break_and_Continue {
    public static void main(String[] args) {
        for (int i=1;i<=10;i++){
            System.out.println(i);
            if(i==9){
                System.out.println("it sucks");
                break;
            }
            else{
                System.out.println("continue");
                continue;
            }
        }
    }
}
