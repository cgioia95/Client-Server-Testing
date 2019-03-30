import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


// Just a server that takes more than one input from the client, echoing it back 
public class EchoServer {
	
	public ServerSocket serverSocket;
	public Socket clientSocket;
	public PrintWriter out;
	public BufferedReader in;

    public void start(int port) throws IOException {
    	
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
        if (".".equals(inputLine)) {
            out.println("good bye");
          
            break;
         }
         out.println(inputLine);
    }
}
    
    public static void main(String args[]) throws IOException {
    	
    	EchoServer echo = new EchoServer();
    	
    	echo.start(20);
    	
    	
    }
    
}