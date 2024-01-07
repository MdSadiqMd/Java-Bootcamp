import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int PORT=8000;
        try(ServerSocket serverSocket=new ServerSocket(PORT)){
            System.out.println("Server Started at :"+ PORT);
            int count=0;
            // Accepting all Socket connections
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("New Client connected --> "+count);

                new ClientHandler(socket).run(count);
            }
        } catch(IOException err){
            System.out.println(err.getMessage());
            err.getStackTrace();
        }
    }
}
