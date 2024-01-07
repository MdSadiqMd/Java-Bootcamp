import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        String hostName="localhost";
        int PORT=8000;
        try(Socket socket=new Socket(hostName,PORT)){
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            out.println("Hello Server");

            BufferedReader in=new BufferedReader(new InputStreamReader((socket.getInputStream())));
            String response=in.readLine();
            System.out.println("Server Response "+response);
        } catch (UnknownHostException err){
            System.out.println("UnknownHostException "+err.getMessage());
            err.printStackTrace();
        } catch (IOException err){
            System.out.println("IOException "+err.getMessage());
            err.getStackTrace();
        }
    }
}
