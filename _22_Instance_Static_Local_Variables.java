//Local Variable - The Variable that declared inside main class
//Instance Variable - The Variable Declared Inside Class but not inside Main Method
//Static Variable - The variable which is declared by the static keyword is called static variable
class Test {
    int a=2;
    String name="Sadiq";
}
public class _22_Instance_Static_Local_Variables {
    int num=5; //Instance Variable --> if we not give any value then it will return null and this is created and destroyed with object
    static int num1=6; //Static Variable
        public static void main(String[] args) {
            //Here when we run the Local variable will be only will become as output if we remove the Local variable and "**** keep the instance as static" then the instance value will be output
            int num = 9; //Local Variable --> if we have not given any value it will return error
            Test obj = new Test();
            obj.a=6;
            Test obj1 = new Test();
            obj1.a=7;
            System.out.println(obj.a);
            System.out.println(obj1.a);
            //In static variable we don't need to give by pointer like obj.num1 compiler automatically give for static variable
            System.out.println(num1);
        }
}