public class _15_printing_inverse_right_angle_traiangle {
    public static void main(String[] args) {
        int n=4;
        for (int i=n;i>0;i--){
            for(int j=0;j<i;j++){
                System.out.println("*");
            }
            System.out.print("\n");
        }
    }
}
