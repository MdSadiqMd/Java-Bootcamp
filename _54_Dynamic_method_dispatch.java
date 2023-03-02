//dynamic method dispatch means it will decide which to run at run time
class one{
    public void name(){
        System.out.println("class one name");
    }
    public void name2(){
        System.out.println("class one name2");
    }
}
class two extends one{
    public void name(){
        System.out.println("class two name");
    }
    public void name2(){
        System.out.println("class two name2");
    }
}
public class _54_Dynamic_method_dispatch {
    public static void main(String[] args) {
        /* one obj=new one();
        two obj2=new two();
        obj.name();*/
        one obj=new two(); //here the inner class is derived to the main class one
        obj.name(); //here the output of class two will print
        obj.name2();
    }
}
