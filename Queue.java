public class Queue {
	private int [] queue;
	private int pIn, pOut, occupied, queueSize;
	public Queue(int size){
		queue = new int[size];
		occupied = 0; //num of occupied queues
		pIn = 0;
		pOut = 0;
		queueSize = size;
	}
	public boolean empty() {
		return occupied==0;
	}
	public boolean full() {
		return !empty();
	}
	public synchronized void input (int a) {
		try{
			while(full()) wait();
			queue[pIn] = a;
			pIn = (pIn+1)%queueSize;
			occupied++;

			notifyAll();
		}
		catch(InterruptedException e){}
	}
	public synchronized int get() {
		int a = 0;
		try {
			while (empty()) wait();
			a = queue[pOut];
			pOut = (pOut+1)%queueSize;
			occupied--;
			notifyAll();
		}
		catch(InterruptedException e){ }
		return a;
	}
}
