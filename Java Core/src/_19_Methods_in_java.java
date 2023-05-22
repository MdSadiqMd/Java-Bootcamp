public class _19_Methods_in_java {
    //methods in java are function
    //here if a same logic is using in different parts of the program then use function that decrease complexity and work of the program
    //syntax of creating a method or function
    //datatype name(parameters){
    // }
    //we cant change an array using methods, but we can make a copy
    //***method overloading - we can have functions of same name but should have different parameters
    //Parameters the variables in function brackets
    //arguments are the ones we call in at last like logic(2,3) here 2,3 are arguments
    static int logic(int x,int y){ //here we write static as we are calling the static class
                                   //if we write void in place of int then it will return nothing
        int z;
        if(x>y){
            z=x+y;
        }
        else{
            z=(x+y)*2;
        }
        return z; //here it will return the value
        //System.out.println(z);  --> Here it will give error as after the return statement the method will end
    }

    static void ChangeName(String Name1){
        Name1="Md.Sadiq";
    }

    public static void main(String[] args) {
        int a=7;
        int b=6;
        int c;
        c=logic(a,b); //here the a and b values go into x and y respectively
        int a1=2;
        int b1=3;
        int c1;
        c1=logic(a1,b1); //here the syntax of upper automatically takes place
        System.out.println(c);
        System.out.println(c1);

        String Name="Sadiq";
        ChangeName(Name);
        System.out.println(Name); // Even After we get Name as Sadiq Only because Name and Name1 point to the same object but when one is changed other create a separate object ,and it doesn't change
    }
}
