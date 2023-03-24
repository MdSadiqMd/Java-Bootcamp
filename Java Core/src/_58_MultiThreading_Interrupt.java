//Here we cannot Interrupt the thread while it is running but.. but... but.... we can use interrupt method only when the thread goes under any method such as join(),sleep(),...
class room extends Thread{
    public void run(){
        for (int i=0;i<=3;i++){
            try{
                System.out.println("Room thread");
                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
public class _58_MultiThreading_Interrupt {
    public static void main(String[] args) {
       room ex=new room();
       Thread t1=new Thread(ex); //***here ethe thread is referred by a variable with the name ex
        t1.start();
        t1.interrupt();
    }
}
