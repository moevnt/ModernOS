import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PIDManager {

	private Map<Integer, Integer> map;
	private Stack<Integer> stack;

	private static final int MIN_PID = 300;
	private static final int MAX_PID = 5000;


	public PIDManager(){
		allocateMap();
	}

	private int allocateMap(){
		stack = new Stack<>();
		map = new HashMap<>(4700);
		for (int i=0;i<4700;i++){
			map.put(i+300,0);
			stack.push(i+300);
		}
		return 1;

	}

	private int allocatePID(){

		int PID = stack.pop();
		map.replace(PID, 1);

		return PID;
	}

	private void releasePID(int PID){
		stack.push(PID);

		map.replace(PID,0);
	}

	public  void printMap(){
		for (Integer key : map.keySet()){
			System.out.println(key + " --> " + map.get(key));
		}
		System.out.println();
	}

	public static void main(String [] args){
		PIDManager pm = new PIDManager();

		pm.allocatePID();
		pm.allocatePID();
		pm.allocatePID();

		pm.printMap();
	}
}
