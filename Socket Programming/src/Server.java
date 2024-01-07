import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int PORT=8000;
        try(ServerSocket serverSocket=new ServerSocket(PORT)){
            System.out.println("Server Started at :"+ PORT);

            // Accepting all Socket connections
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("New Client connected");

                new ClientHandler(socket).start();
            }
        } catch(IOException err){
            System.out.println(err.getMessage());
            err.getStackTrace();
        }
    }
}
