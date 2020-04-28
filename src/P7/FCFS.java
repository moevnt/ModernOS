package P7;

import java.util.ArrayList;

public class FCFS {

	private static ArrayList<Integer> queue;

	public FCFS(){
		queue = new ArrayList<>();
		for (int i=0;i<10;i++)
			queue.add(0,0);
	}

	public void addProcess(int enterTime, int burstTime){ //allows user to add a single process
		queue.set(enterTime, burstTime);
	}

	public void startCPU()  { //begins simulating CPU run time
		for (int i=0; i< queue.size();i++){
			for (int j=0;j < queue.get(i);j++){
				System.out.println("Process: "+i+" at step "+(j+1)+" of "+queue.get(i));
			}
		}
	}

	public static void main(String[] args){
		FCFS firstCome = new FCFS();

		firstCome.addProcess(0,5);
		firstCome.addProcess(5,1);
		firstCome.addProcess(2,5);
		firstCome.addProcess(3,5);
		firstCome.addProcess(4,5);

		firstCome.startCPU();
	}
}
