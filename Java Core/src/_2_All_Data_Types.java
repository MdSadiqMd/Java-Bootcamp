import java.util.Scanner;
public class _2_All_Data_Types {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        byte age = 34;
        int age2 = 56;
        short age3 = 87; //these three have some range will lie in it
        long age4 = 23457653786978L; //here we need to write capital L at last to specify it is long
        char ch = 'a'; //here need to write character in quotations
        float f=345.545f; //here we need to write f at last to specify it is a float value otherwise it will become double
        double d1=345.45D; //here we need to write capital D at last to specify it is a double value
        System.out.println(age);
        String str="sadiq"; //in string S is capital
        System.out.println(str);
        //Type Conversion
        System.out.println("Type Conversion");//In type conversion we can only change the lower data types to higher data types means we can change int to float  but not float to int
        Float num=sc.nextFloat();
        System.out.println((num));
        //Type Casting
        //example1:
        System.out.println("Type Casting");//here we can convert float to int
        int num1=(int)(45.67f);
        System.out.println(num1);
        //example2:
        int a=257;
        byte b=(byte)(a); //give answer 1 as byte range is 256 and 257%256=1 it returns reminder as it is more than the range
        System.out.println(b);
        //example3: ******
        byte c=40;
        byte d=50;
        byte e=100;
        int g=(c*d)/e; //here c*d is more than 256 but why it hasn't given us error or returned the reminder because java will convert them into int for convenience
        System.out.println(g);
        //example4: *******
        byte h=42;
        char i='a';
        short s=1024;
        int j=50000;
        float k=5.67f;
        double l=0.1234;
        double result=(k*b)+(j/i)-(l*s);
        System.out.println((k*b)+" "+(j/i)+" "+(l*s));
        System.out.println(result);
        //Formatting
        System.out.println("Formatting:");
        System.out.printf("%d%n",10);//10
        System.out.printf("%8d%n",123);//     123
        System.out.printf("%4d%5d%n",123,456);// 123  456
        System.out.printf("%4d%n",12345);//2345--> this examole shows that it print from backward
        System.out.printf("%-8d%n",123);//123_____
        System.out.printf("%-6s%5d%n","num=",456);//num_=___456
        System.out.printf("%06d%n",-123);//-00123   --> ***here - also takes a place
        //Sign
        System.out.printf("%+d%n",123);//+123
        System.out.printf("%+d%n",-123);//-123
        System.out.printf("%+.2f%n",123.12);//+123.12
        System.out.printf("%+.2f%n",-123.12);//-123.12
        //Commas
        System.out.printf("%,d%n",123);//123
        System.out.printf("%,d%n",-1234);//-1,234
        System.out.printf("%,.2f%n",1234.12);//1,234.12
        System.out.printf("%,08d%n",12345);//0012,345
        //Brackets
        System.out.printf("%(d%n",123);//123
        System.out.printf("%(d%n",-1234);//(1,234)--> no negative sign
        System.out.printf("%(.2f%n",1234.12);//1,234.12
        System.out.printf("%(08d%n",12345);//0012,
        //Argument Index
        System.out.printf("%s%s%s%n","1","2","3");//123
        System.out.printf("%3$s%2$s%1$s%n","1","2","3");//321
        System.out.printf("%2$s%s%s%n","1","2","3");//*******212
        System.out.printf("%s%<s%<s%n","1","2","3");//***111 --> if the before one is lower than the present then it will print 1 only --> 1<2
        System.out.printf("%s%s%<s%n","1","2","3");//122
        //System.out.printf("%<s%s%s%n","1","2","3");//error
        //System.out.printf("%2$s%s%<s%n","1","2","3");//error
        //Float Points
        System.out.printf("%f%n",10.1);//10.100000 --> will give 6 after point if more it will cut
        System.out.printf("%6.2f%n",4234123.45234);//4234123.45
        System.out.printf("%.0f%n",10.1);//10--> will give nothing after point it will cut it
        System.out.printf("%.1f%n",10.1);//10.1 --> will give one number after point and cut other
        System.out.printf("%.2f%n",10.1);//10.10 --> will give two number after point and if nothing present will give zero or cut if other numbers are present
        //the above three examples is also applicable for other formatting as string and also for %e,%g,%b,......
        //***But not applicable for others like char,decimal and others
        System.out.printf("%c%n",'a');//a
        System.out.printf("%C%n",'a');//A
        System.out.printf("%s%n","hello");//hello
        System.out.printf("%S%n","hello");//Hello
        System.out.printf("%b%n",5<4);//false
        System.out.printf("%B%n",5<4);//FALSE
        System.out.printf("%b%n",null);//false
        System.out.printf("%b%n","cow");//true
        System.out.printf("%e%n",10.123);//10.12300e+01
        System.out.printf("%E%n",10.123);//10.12300E+01
        System.out.printf("%g%n",10.123);//10000.0
        System.out.printf("%G%n",10.123);//1.00000E+06
        System.out.printf("%d%n",123);//change to decimal of four spaces will keep zero in empty spaces
        System.out.printf("%b%n",123);//change to binary
        System.out.printf("%o%n",123);//change to octal
        System.out.printf("%x%n",123);//change to lower case Hexadecimal
        System.out.printf("%X%n",123);//change to upper case Hexadecimal
        System.out.printf("%h%n","hello");//5e918d2 --> print hash code
        System.out.printf("%H%n","hello");//5E91802 --> print hash code in Capital
        System.out.printf("%a%n",10.12);//hexadecimal for floating point --> 0x1.43d70a3d70a3dp3
    }
}
