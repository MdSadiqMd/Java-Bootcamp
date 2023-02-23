//Default Methods - creating some default methods and using them when we want by calling them
interface camera{
    void takesnap();
    void recordvideo();
}

interface wifi{
    String[] getnetworks();
    void connecttonetworks(String network);
}

class mycellphone{
    void callnumber(int phonenumber){
        System.out.println("calling"+phonenumber);
    }
    void takesnap(int phonenumber){
        System.out.println("taking snap"+phonenumber);
    }
}

class smartphone extends mycellphone implements wifi,camera{
    public void takesnap(){
        System.out.println("taking snap - inherited");
    }


    public void recordvideo(){
        System.out.println("taking video - inherited");
    }

    public String[] getnetworks(){
        System.out.println("getting list of networks");
        String[] networklist = {"sadiq","akhil","sushwar"};
        return networklist;
    }

    public void connecttonetworks(String network) {
        System.out.println("connecting...."+network);
    }
}

public class _39_Default_methods {
    public static void main(String[] args) {
        smartphone ms= new smartphone();
        String[] ar=ms.getnetworks();
        for(String item:ar){
            System.out.println(item);
        }
    }
}
