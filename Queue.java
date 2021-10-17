/*
/ Queue Datastructure
/ By: Serik Czarnecki
*/

public class Queue<T> {

	public T[] array;
	
	private int backIndex = 0;
	private int frontIndex = 0;
	private static int DEFAULT_ARRAY_LENGTH = 50;
	
	public boolean isEmpty() {
		return frontIndex == (backIndex + 1) % array.length;
	}
	
	public boolean isFull() {
		return frontIndex == (backIndex + 2) % array.length;
	}
	
	public Queue(int arrayCapacity) {
		array = (T[]) new Object[arrayCapacity + 1];
		frontIndex = 0;
		backIndex = arrayCapacity;
	}
	
	public Queue() {
		this(DEFAULT_ARRAY_LENGTH);
	}
	
	
	
	private void DoubleSpace() {
		T[] oldQueue = array;
		array = (T[]) new Object[oldQueue.length * 2];
		for(int i = 0; i < oldQueue.length; i++) {
			array[i] = oldQueue[i];
		}
		frontIndex = 0;
		backIndex = array.length - 1;
		
	}
	
	public void Add(T data) {
		if(isFull()) {
			DoubleSpace();
		}
		backIndex = (backIndex + 1) % array.length;
		array[backIndex] = data;
	}
	
	public T Remove() {
		T data = null;
		if(!isEmpty()) {
			data = array[frontIndex];
			frontIndex = (frontIndex + 1) % array.length;
		}
		
		return data;
	}
	
	public int getQueueSize() {
		
		int count = (frontIndex + backIndex) % array.length;
		
		return count;
	}
	
	public T Get() {
		T data = null;
		
		if(!isEmpty()) {
			data = array[frontIndex];
		}
		
		return data;
	}
	
}
