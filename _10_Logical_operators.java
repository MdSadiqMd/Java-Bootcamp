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
        
         //Ternary operator
        int c=4;
        int d=5;
        int e=5;
        int result=(c>d)?c:d; //here if a>b then it will print a if not it will print b
        String result1=(c>d)?"c is greater":"d is greater"; //*** should give string before it
        System.out.println(result);
        System.out.println(result1);

        //if,else if and else in ternary operator
        int result2=(c<d)?((d<e)?c:e):(d<e)?d:e;
        System.out.println(result2);

    }

}
