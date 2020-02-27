
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {

	private static ServerSocket server;

	//socket server port on which it will listen
	private static int port = 8001;
	private static HashMap<String, String> idMap = new HashMap<String, String>();
	private static ArrayList<Course> courses = new ArrayList<Course>();

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		initIDList();
		createCourseList();

		//create the socket server object
		server = new ServerSocket(port);

		System.out.println("[STARTing VCCS SERVER...]");
		while (true) {
			//creating socket and waiting for client connection
			Socket socket = server.accept();

			//read from socket to ObjectInputStream object
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			//convert ObjectInputStream object to String
			String message = (String) input.readObject();
			//System.out.println("Message Received: " + message);

			/* example: how to parse message with new line */
			String[] contents = message.split("_");

			String response = "Course Information";

			if (contents.length != 4) {
				response = "609 Bad Request\r\n";
			} else {
				System.out.println(contents[0]); //id
				System.out.println(contents[1]); //user name
				System.out.println(contents[2]); //course number
				System.out.println(contents[3]); //request type

				if (!checkUser(contents[0], contents[1])) {
					response = "69 Bad User_"+contents[2]+"\r\n";
				}
				else if (checkUser(contents[0], contents[1])) {

					if (!checkCourse(contents[2])) {
						response = "201 Bad Course_"+contents[2]+"\r\n";
					}

					else if (checkCourse(contents[2])) {
						if(!respsonseCheck(contents[3])){ //if false return simple
							response = getSimpleHeader(contents);

						}
						else if(respsonseCheck(contents[3])){
							response = getFullHeader(contents);
						}
					}


				}

			}
			/*
			 * 1. parse String
			 * 2. analyze header
			 * 3. response
			 */
			Haiku haiku = new Haiku();
			//create ObjectOutputStream object
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject("Hi Client " + haiku.getLines());
			//close resources
			input.close();
			output.close();
			socket.close();
			//terminate the server if client sends exit request
			if (message.equalsIgnoreCase("exit")) {
				break;
			}
		}
		System.out.println("Shutting down Socket server!!");
		//close the ServerSocket object
		server.close();
	}

	private static boolean checkUser(String id, String name) {
		if (idMap.get(id) == null) {
			return false;
		} else {
			return idMap.get(id).equals(name);
		}
	}

	private static boolean checkCourse(String course) {

		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).equals(course)) {
				return true;
			}
		}
		return false;
	}

	private static boolean respsonseCheck(String responseType){

		if(responseType.equals("1"))
			return true;
		else
			return false;
	}

	private static String getSimpleHeader(String[] contents){
		return "143 Simple Header_"+contents[2]+"\r\n" ;
	}

	private static String getFullHeader(String[] contents){
		return "243 Full header_"+contents[2]+"\r\n";
	}
	private static void initIDList() {
		idMap.put("1", "Alice");
		idMap.put("2", "Tom");
		idMap.put("3", "Jack");
	}

	private static void createCourseList() {
		Course c = new Course("Networking", "CIS-301", "An intermediate level course discussing the background and history of networking and the Internet, network standards, OSI 7-layer model, TCP/IP, web technologies, and network security.",4);
		courses.add(c);
		c = new Course("Programming I", " CIS-111", "Java Programing ...", 4);
		courses.add(c);
	}

}