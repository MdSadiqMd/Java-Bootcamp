public class _63_Scoping_in_java {
    // 1. Method Scope
    /*public static void main(String[] args) {
        int a=5;
    }
    static int integer(){
        System.out.println(a);//Here we cannot access the variable outside the method
        return a;
    }*/

    //2.Block Scope
    //***Anything initialized outside the block can be used inside the block , But anything initialized inside the block cannot be used outside the block
    //***Anything initialized outside the block can be initialized inside the block, but anything initialized inside the block can be initialized outside the block
    public static void main(String[] args) {
        int a=5;
        { //These Brackets are a block
            System.out.println(a);// We can access outer block initialized variables in block
            int b=6;
            a=4; //we can rewrite the values defined outside the block
        }
        //System.out.println(b); //We cannot access variables defined in block from outside the block
        System.out.println(a); // a is updated
    }

    // 3.Loop Scope
    /*public static void main(String[] args) {
        for(int i=0;i<a.length;i++){
            System.out.println(a);
        }
        System.out.println(i); //we cannot access variables defined inside the loop
    }*/
}
