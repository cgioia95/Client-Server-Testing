import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	// Client has a socket and an outgoing/incoming writer/readers 
	
	Socket clientSocket; 
	
	public PrintWriter out;
	
	public BufferedReader in; 
	
	
	// Accepts both an ip address and a port number 
	// Initializes the socket to these values and starts the read/writes 
	
	public void startConnection(String ip, int port) throws IOException {
		
		clientSocket = new Socket(ip, port);
		
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
	}
	
	
	// Takes a message string, sends it to outgoing write stream, then accepts a line from 
	// incoming buffered reader 
	public String sendMessage(String msg) throws IOException {
		out.println(msg);
		String resp = in.readLine();
		return resp;
	}
	
	// Ends the connection, terminating the in/out readers as well as the clients socket 
	public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
	
	public static void main(String args[]) throws IOException {
		
		Client client = new Client();
		
		client.startConnection("127.0.0.1", 20);
		
		String r1 = client.sendMessage("fuck you");
		System.out.println(r1);
		String r2 = client.sendMessage("ham");
		System.out.println(r2);
		String r3 = client.sendMessage("cheese you");
		System.out.println(r3);
		
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			String res = client.sendMessage(sc.nextLine());
			System.out.println(res);
		}
		
		
		
		client.stopConnection();
	}
			
	}


