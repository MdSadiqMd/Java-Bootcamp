//here in class Calc we have two methods of same name of add this is called method overloading
//if we give two arguments then first one will execute
// if we give three arguments it will execute second one
class Calc{
    public int add(int n1, int n2)
    {
        int result=n1+n2;
        return result;
    }
    public int add(int n1, int n2 ,int n3)
    {
        int result=n1+n2+n3;
        return result;
    }
}
public class _28_Method_Overloading {
    public static void main(String[] args) {
        Calc obj = new Calc();
        int result=obj.add(4,3);
        //int result=obj.add(4,3,2);
        System.out.println(result);
    }
}
