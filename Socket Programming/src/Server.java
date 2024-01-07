import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// test : Run Server and then Run Client "Parallelly" as they are on the Same Port, so they get Connected
public class Server {
    public static void main(String[] args) {
        int PORT=8000;
        try(ServerSocket serverSocket=new ServerSocket(PORT)){
            System.out.println("Server Started at :"+ PORT);
            // Accepting all Socket connections
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("New Client connected");

                try(BufferedReader in=new BufferedReader((new InputStreamReader((socket.getInputStream()))))){
                    PrintWriter out=new PrintWriter((socket.getOutputStream()));
                    String clientMessage=in.readLine();
                    System.out.println("Message from Client "+clientMessage);
                    out.println("Echo from Server "+clientMessage);
                } catch (IOException err){
                    System.out.println(err.getMessage());
                }
            }
        } catch(IOException err){
            System.out.println(err.getMessage());
            err.getStackTrace();
        }
    }
}
