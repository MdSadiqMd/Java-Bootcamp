import java.util.HashMap;

public class _2_HashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> Data=new HashMap<>();
        //Adding Values
        Data.put("Apple",30);
        Data.put("Mango",10);
        System.out.println(Data);
        Data.put("Banana",20);
        System.out.println(Data);

        //Updating Values
        Data.put("Apple",40);
        System.out.println(Data);

        //Removing Values
        Data.remove("Banana");
        System.out.println(Data);

        //Checking the Values and Keys
        if(Data.containsKey("Mango")){
            System.out.println("Present");
        }
        else{
            System.out.println("Not Present");
        }
    }
}
