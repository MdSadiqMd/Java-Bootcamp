//Method Overloading or Function Overloading Means Classes with same Name but different Arguments
//Where the compiler will decide which function to as per input given by the User
//Here in class Calc we have two methods of same name of add this is called method overloading
class Calc {
    public int add(int n1, int n2) {
        int result = n1 + n2;
        return result;
    }

    public int add(int n1, int n2, int n3) {
        int result = n1 + n2 + n3;
        return result;
    }
//here if we want to add double numbers then this is syntax
    public double add(double n1, double n2) {
        double result = n1 + n2 ;
        return result;
    }
}
public class _37_Method_Overloading {
    public static void main(String[] args) {
        Calc obj = new Calc();
        //int result=obj.add(4,3);
        //int result=obj.add(4,3,2);
        double result=obj.add(4,3); //-->here even we specify the data type we get the output as there is only one double method in Calc class
        System.out.println(result);
    }
}
