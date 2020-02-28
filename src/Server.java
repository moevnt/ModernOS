
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static ServerSocket server;

	//socket server port on which it will listen
	private static int port = 5575;

	public static void main(String args[]) throws IOException {

		//create the socket server object
		server = new ServerSocket(port);

		System.out.println("[Starting Haiku SERVER...]");
		while (true) {
			//creating socket and waiting for client connection
			Socket socket = server.accept();
			System.out.println("socket accepted");

			Haiku haiku = new Haiku();

			//create ObjectOutputStream object
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject("\n"+haiku.getLines());

			//close resources
			output.close();
			socket.close();
		}


	}
}