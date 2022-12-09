//polymorphism - one thing many forms

interface camera1{
    void takesnap1();
    void recordvideo1();
}

interface wifi1{
    String[] getnetworks1();
    void connecttonetworks1(String network);
}

class mycellphone1{
    void callnumber1(int phonenumber){
        System.out.println("calling"+phonenumber);
    }
    void takesnap1(int phonenumber){
        System.out.println("taking snap"+phonenumber);
    }
}

class smartphone1 extends mycellphone1 implements wifi1,camera1{
    public void takesnap1(){
        System.out.println("taking snap - inherited");
    }


    public void recordvideo1(){
        System.out.println("taking video - inherited");
    }

    public String[] getnetworks1(){
        System.out.println("getting list of networks");
        String[] networklist1 = {"sadiq","akhil","sushwar"};
        return networklist1;
    }

    public void connecttonetworks1(String network) {
        System.out.println("connecting...."+network);
    }
}

public class _35_Polymorphism {
    public static void main(String[] args) {
       camera1 cam=new smartphone1();
       //cam.getnetwork1(); -- throws an error as we only initialized camera
        cam.recordvideo1();
        smartphone1 s=new smartphone1();
        s.recordvideo1(); //we can use the inherited class objects
        s.getnetworks1();
    }
}
