//Conversion from Object type to Primitive Type
/*
a)Using xxxvalue() from Wrapper Class
b)By using Auto - UnBoxing Mechanism --> Here we assign wrapper class reference variable to primitive variable here conversions takes automatically after assigning
 */

//Conversions from Primitive Type to Object type
/*
c)By Using Parameterized Constructor From wrapper Classes
d)Using xxxvalueOf() from Wrapper Class
e)Using Auto - Boxing Method --> It will assign primitive Variable directly to Wrapper Class Reference Variable
 */
public class _64_Wrapper_Class_Conversions {
    //a)
    /*public static void main(String[] args) {
        Integer in=new Integer(10);
        int i=in.intValue(); //assigning to wrapper method
        System.out.println(in+" "+i);
    }*/

    //b)
    /*public static void main(String[] args) {
        Integer in=new Integer(10); //here it's deprecated suggesting there is an alternative available
        int i=in; //assigning to wrapper class
        System.out.println(in+" "+i);
    }*/

    //c)
    /*public static void main(String[] args) {
        int i=10;
        Integer in=new Integer(i);
        System.out.println(in+" "+i);
    }*/

    //d)
    /*public static void main(String[] args) {
        int i=10;
        Integer in=Integer.valueOf(i); //assigning to wrapper method
        System.out.println(in+" "+i);
    }*/

    //e)
    public static void main(String[] args) {
        int i=10;
        Integer in=i;//assigning to Wrapper Class
        System.out.println(i+ " "+in);
    }
}
