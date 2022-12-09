public class _5_Operators {
    public static void main(String[] args) {
        int a =5;
        a+=3;//this add the 3 to variable value stored in a
        System.out.println(a);
        System.out.println(34>5 && 45>42); // and operator return true if both are true
        System.out.println(34>5 || 45<42); // or operator return true if one is true
        int b =7;
        int c=b%2; //modulus operator give remainder
        System.out.println(c);
        float d=5.8f;
        float e=3.3f; //modulus operator return float values if the both are given float values dont forget f at last
        System.out.println(e);
        // precedance is order of evaluation of operators PEDMAS in decreasing order
        //if the precedance is same for teo operators then we use associativity which states left to right evalustion to all and right to left evaluation to * and / and for comparision operators
    }
}
