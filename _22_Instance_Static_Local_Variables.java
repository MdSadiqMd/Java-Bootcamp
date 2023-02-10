class Test {
    int a=2;
    String name="Sadiq";
}
public class _22_Instance_Static_Local_Variables {
        public static void main(String[] args) {
            int num = 9;
            Test obj = new Test();
            Test obj1 = new Test();
            System.out.println(obj.a);
            System.out.println(obj.name);
            System.out.println(obj1.a);
            System.out.println(obj1.name);
        }
}