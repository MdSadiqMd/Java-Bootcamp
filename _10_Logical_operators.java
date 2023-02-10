public class _10_Logical_operators {
    public static void main(String[] args) {

        //giving inputs
        boolean a=false;
        boolean b=true;

        // using logical AND operator will return true if the both statements are true

        if (a && b){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

        //using logical OR operator if one of statements is true it will return true

        if (a || b){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

        //using logical NOT operator it will print the reverse value of input

        System.out.println("logical not of a :"+!a);

        
         //Relational operators

            int c=4;
            int d=5;
            int e=6;
            boolean result1=c>d;
            boolean result2=c<d;
            boolean result3=c>=d;
            boolean result4=c<=d;
            boolean result5=c!=d;
            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);
            System.out.println(result4);
            System.out.println(result5);


    }

}
