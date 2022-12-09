public class _6_Increment_operators {
    public static void main(String[] args) {
        int a1= 50;
        System.out.println(a1++);//here if a++ then the value will be assigned to a variable and if we print second time it will print increment one
        System.out.println(a1);//here the increment value will print in upper line the value will be assign to variable
        int a2=60;
        System.out.println(++a2);// here in ++a the value will be increment and they will get assigned and print
        System.out.println(a2);// here the step is unnessecary as the value assigned and increment in upper one
        char ch='a';
        System.out.println(++ch);//in chracter ++ch and ch++ act as same the ASCII value will get increment
        System.out.println(ch++);
        char ch2 ='B';//increment of chracters in this if we not keep char data type it will return an different value
        char ch3 = (char)(ch2+8);//should keep char in brackets
        System.out.println(ch3);
        char ch4 ='B';
        char ch5 = (char)(ch4-1);// here A will print as decrement
        System.out.println(ch5);
        char ch6 ='B';
        char ch7 = (char)(ch6-8);//** :: colon will print as per ASCII values
        System.out.println(ch7);
    }
}
