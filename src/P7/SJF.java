package P7;

public class SJF {

	private static BinaryHeap heap;

	public SJF(){
		heap = new BinaryHeap();
	}

	public void addProcess(int burstTime){
		heap.insert(burstTime);
	}

	public static void startCPU(){
		for (int i=0;!heap.isEmpty();i++){
			int burstTime = heap.deleteMin();
			for (int j=0;j < burstTime;j++){
				System.out.println("Process: "+i+" at step "+(j+1)+" of "+burstTime);
			}
		}
	}

	public static void main(String[] args){
		SJF sjf = new SJF();

		sjf.addProcess(3);
		sjf.addProcess(2);
		sjf.addProcess(5);

		startCPU();
	}
}
