package Assestment_3_1;

public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue; // circular array of queue entries and one unused location
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    
    public ArrayQueue() {
	this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor
    
    public ArrayQueue(int initialCapacity) {
	// the cast is safe because the new array contains null entries
	@SuppressWarnings("unchecked")
	    T[] tempQueue = (T[]) new Object[initialCapacity + 1];
	queue = tempQueue;
	frontIndex = 0;
	backIndex = initialCapacity;
    } // end constructor
    
    public void enqueue(T newEntry) {
	ensureCapacity();   
	backIndex = (backIndex + 1) % queue.length;
	queue[backIndex] = newEntry;
    } // end enqueue
    
    public T getFront(){
	T front = null;
	if (!isEmpty())
	    front = queue[frontIndex];
	
	return front;
    } // end getFront
    
    public T dequeue() {
	T front = null;
	if (!isEmpty())  {
	    front = queue[frontIndex];
	    queue[frontIndex] = null;
	    frontIndex = (frontIndex + 1) % queue.length;
	} // end if
	
	return front;
    } // end dequeue
    
    private void ensureCapacity() {
	if (frontIndex == ((backIndex + 2) % queue.length))  { // if array is full,
	    T[] oldQueue = queue;
	    int oldSize = oldQueue.length;
	    @SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[2 * oldSize];
	    queue = tempQueue;
	    for (int index = 0; index < oldSize - 1; index++) {
		queue[index] = oldQueue[frontIndex];
		frontIndex = (frontIndex + 1) % oldSize;
	    } // end for
	    
	    frontIndex = 0;
	    backIndex = oldSize - 2;
	} // end if
    } // end ensureCapacity

    public boolean isEmpty() {
	return frontIndex == ((backIndex + 1) % queue.length);
    } // end isEmpty
    
    public void clear() {
	if(!isEmpty()) {
	    for (int index = frontIndex; index != backIndex; index = (index+1)%queue.length)
		queue[index] = null;
	    queue[backIndex] = null;
	}
	frontIndex = 0;
	backIndex = queue.length - 1;
    }

//	public static boolean check(String s){
//		String s_modified = s.replaceAll("[^A-Za-z]+", "").toUpperCase();
//		String part1 = s_modified.substring(0,s_modified.length()/2);
//		String part2 = s_modified.substring(s_modified.length()/2, s_modified.length());
//		if(part1.compareTo(part2) == 0){
//			return true;
//		}else{
//			return false;
//		}
//	}

	//P1
	public static boolean check(String s) {
		// ignoring blanks and the comma, and case
		s = s.replaceAll("[^A-Za-z]", "").toLowerCase();
		QueueInterface<Character> queue = new ArrayQueue<>();

		// Enqueue the first half of the String
		for (int i = 0; i < s.length() / 2; i++) {
			queue.enqueue(s.charAt(i));
		}

		// Dequeue and compare with the second half of the String
		for (int i = s.length() / 2; i < s.length(); i++) {
			if (queue.isEmpty() || queue.dequeue() != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	//P2 Part 1
	public void splice(QueueInterface<T> anotherQueue) {
		if (anotherQueue == null || anotherQueue.isEmpty()) {
			return;
		}
		while (!anotherQueue.isEmpty()) {
			T item = anotherQueue.dequeue();
			enqueue(item);
		}
	}

	//P2 Part 2
	public boolean enqueueNoDuplicate(T item) {
		if (contains(item)) {
			return false;
		}

		enqueue(item);
		return true;
	}
	private boolean contains(T item) {
		for (int i = frontIndex; i != backIndex; i = (i + 1) % queue.length) {
			if (queue[i] != null && queue[i].equals(item)) {
				return true;
			}
		}
		return queue[backIndex] != null && queue[backIndex].equals(item);
	}
    
} // end ArrayQueue
