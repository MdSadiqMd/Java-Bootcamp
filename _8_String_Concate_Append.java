/*

 */
public class _8_String_Concate_Append {
    public static void main(String[] args) {

        //Using Concatenation
        String s1 = "sadiq"; //will be in String constant pool
        String s2 = s1.concat("Md"); // will be in heap area and an copy with no reference pointer in string constant pool
        String s3 = new String("Mohammad");// will be in heap area and an copy with no reference pointer in string constant pool
        String s4 = new String("MD.sadiq");
        s4 = s4.concat("sadiq"); //here we have given s4=s4.concate.so we get the new string other ise we would have get the non concate string
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        //Using + Operator
        //Here every string will be present in string Constant pool area except the added ones
        String s5="Md";          //Stored in String Constant pool area
        String s6="Sadiq";       //Stored in String Constant pool area
        String s7="Mohammad";    //Stored in String Constant pool area
        String s8=s5+s6+s7;      //**Stored in Heap area
        System.out.println(s8);

        //String + Datatype
        //Any Data type + String = String Data type
        String str="Md"+100;
        System.out.println(str);
    }
}
