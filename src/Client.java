import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{

	private static int port = 8001;

	public static void main(String[] args) throws UnknownHostException, IOException,ClassNotFoundException,InterruptedException {

		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		socket = new Socket(host.getHostName(), port);
		oos = new ObjectOutputStream(socket.getOutputStream());
		System.out.println("Sending request to Socket Server");

		ois = new ObjectInputStream(socket.getInputStream());
		String message = (String) ois.readObject();
		System.out.println("Message: "+message);

		ois.close();
		oos.close();
		Thread.sleep(100);

	}
}