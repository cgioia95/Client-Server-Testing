import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	// Server has: a serverSocket, a client socket that its serves to and a read/writer 
	public ServerSocket serverSocket;
	public Socket clientSocket;
	public PrintWriter out;
	public BufferedReader in;
	
	
	// Takes a port number to start the server on 
	// Starts the serverSocket
	// Block waits for a client to connect to it
	// Server's out is writing to the clientSocket, sending a message to it 
	// Server's in is reading from the incoming text of the client socket 
	// Read a single line from the client, assign it to greeting 
	// if greeting is 'hello server', feed 'hello client' into out, otherwise unrecognised greeting 
	
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
            if ("hello server".equals(greeting)) {
                out.println("hello client");
            }
            else {
                out.println("unrecognised greeting");
            }
            
           
    }
    
    
    // Shutdown in the in/outs + the client and server sockets 
    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    public static void main(String[] args) throws IOException {
    	
        Server server=new Server();
        server.start(1);
        
        
       
    }

}
