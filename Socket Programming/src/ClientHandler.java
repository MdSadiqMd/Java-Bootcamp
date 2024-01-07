import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final Socket socket;
    public ClientHandler(Socket socket){
        this.socket=socket;
    }

    public void run(int count) throws IOException {
        String text="Some text : From Client "+count;
        int counter=0;
        do{
            counter++;
            System.out.println("Received from Client: "+text);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException err){
                System.out.println("Interrupted Exception "+err.getMessage());
            }
        } while (counter<5);
        socket.close();
    }
}
