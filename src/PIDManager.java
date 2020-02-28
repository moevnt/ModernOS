import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PIDManager {

	private Map<Integer, Integer> map;
	private Stack<Integer> stack;

	public PIDManager(){
		allocateMap();
	}

	private int allocateMap(){
		map = new HashMap<>(4700);
		for (int i=0;i<4700;i++){
			map.put(i+300,0);
		}
		return 1;

	}

	private int allocatePID(){

	}

	private void releasePID(int PID){

	}

	public static void main(String [] args)
}
