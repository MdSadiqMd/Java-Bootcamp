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

    }

}
