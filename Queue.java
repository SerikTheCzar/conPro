/*
/ Queue Datastructure
/ By: Serik Czarnecki
*/

public class Queue<T> {

	//Array of type T, can be used for any object
	public T[] array;
	
	private int backIndex = 0;
	private int frontIndex = 0;
	private static int DEFAULT_ARRAY_LENGTH = 50;
	
	//Check if array is empty
	public boolean isEmpty() {
		return frontIndex == (backIndex + 1) % array.length;
	}
	
	
	//Check if array is full
	public boolean isFull() {
		return frontIndex == (backIndex + 2) % array.length;
	}
	
	//Create array of requested size
	public Queue(int arrayCapacity) {
		array = (T[]) new Object[arrayCapacity + 1];
		frontIndex = 0;
		backIndex = arrayCapacity;
	}
	
	//Create queue of default length 50
	public Queue() {
		this(DEFAULT_ARRAY_LENGTH);
	}
	
	
	//Not enough space? Make some more!
	private void DoubleSpace() {
		T[] oldQueue = array;
		array = (T[]) new Object[oldQueue.length * 2];
		for(int i = 0; i < oldQueue.length; i++) {
			array[i] = oldQueue[i];
		}
		frontIndex = 0;
		backIndex = array.length - 1;
		
	}
	
	//Add object T to Queue
	public void Add(T data) {
		if(isFull()) {
			DoubleSpace();
		}
		backIndex = (backIndex + 1) % array.length;
		array[backIndex] = data;
	}
	
	//Remove from front of Queue
	public T Remove() {
		T data = null;
		if(!isEmpty()) {
			data = array[frontIndex];
			frontIndex = (frontIndex + 1) % array.length;
		}
		
		return data;
	}
	
	//Getter code
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
