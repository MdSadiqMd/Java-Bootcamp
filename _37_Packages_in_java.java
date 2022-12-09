//import java.util.Scanner; -->this imports the package and take whatever we want
//import java.util.*        -->this imports all the classes in the package
public class _37_Packages_in_java {
    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        java.util.Scanner sc=new java.util.Scanner(System.in); //-->this acts same as importing java.util.Scanner
        int a=sc.nextInt();
        System.out.println("taking input "+a);
    }
}
