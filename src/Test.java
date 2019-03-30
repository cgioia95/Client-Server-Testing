import java.io.IOException;

public class Test {
	
	public static void givenClient1_whenServerResponds_thenCorrect() throws IOException {
	    Client client1 = new Client();
	    client1.startConnection("127.0.0.1", 50);
	    String msg1 = client1.sendMessage("hello");
	    System.out.println(msg1);
	    String msg2 = client1.sendMessage("world");
	    System.out.println(msg2);
	    client1.sendMessage(".");


	}
	 
	public static void givenClient2_whenServerResponds_thenCorrect() throws IOException {
	    Client client2 = new Client();
	    client2.startConnection("127.0.0.1", 50);
	    String msg1 = client2.sendMessage("hello");
	    System.out.println(msg1);
	    String msg2 = client2.sendMessage("world");
	    System.out.println(msg2);
	    client2.sendMessage(".");

	}

	public static void main(String[] args) throws IOException {
				
		givenClient1_whenServerResponds_thenCorrect();
		
		givenClient2_whenServerResponds_thenCorrect();
		
		// TODO Auto-generated method stub

	}

}
