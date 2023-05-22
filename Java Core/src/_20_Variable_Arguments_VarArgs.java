public class _20_Variable_Arguments_VarArgs {
    /*variable arguments or varArgs are used if we don't know
     how many parameters should we give in the  function, so
     it will store the parameters in the form of an array
     */
    static int sum(int ...arr){  /*if we write **static int sum(int a;int ...arr)
                                 then it will be compulsory to give one argument
                                 otherwise it will return error
                                 refer line 19 for clarity*/
        int result=0;
        for (int a :arr){   //here we use for each loop to add all the parameters given in an array
            result +=a;
        }
        return result;
    }

    static void Multiple(int a, int b,String ...arr){ //we can also with define we different data types

    }

    /*static void Multiple1(int a,String ...arr,int b){ //Varargs should be in the last as we don't know how many inputs we are going to give

    }*/

    public static void main(String[] args) {
        System.out.println(sum()); //it will return zero as no arguments are given
        System.out.println(sum(4,5));
        System.out.println(sum(1,2,3,4,5));

        Multiple(2,3,"4","5","6","6");
    }
}
