package Assestment_3_1;

public class QueueTest {
	public static void main(String[] args) {
		QueueInterface<String> myQueue = new ArrayQueue<String>();
		myQueue.enqueue("Jim");
		myQueue.enqueue("Jess");
		myQueue.enqueue("Jill");
		myQueue.enqueue("Jane");
		myQueue.enqueue("Joe");

		String front = myQueue.getFront(); // returns “Jim”
		System.out.println(front + " is at the front of the queue.");

		front = myQueue.dequeue(); // removes and returns “Jim”;
		System.out.println(front + " is removed from the queue.");

		myQueue.enqueue("Jerry");
		front = myQueue.getFront(); // returns “Jess”
		System.out.println(front + " is at the front of the queue.");

		front = myQueue.dequeue(); // removes and returns “Jess”;
		System.out.println(front + " is removed from the queue.");

		System.out.println("- - - - - - - - - - - - - - - - -");

		// positive test cases:
		System.out.println("\"booboo\" " + ArrayQueue.check("booboo"));
		System.out.println("\"hello, hello\" " + ArrayQueue.check("hello, hello"));
		System.out.println("\"\" "  + ArrayQueue.check(""));
		System.out.println("\", ,\" " + ArrayQueue.check(", ,"));
		System.out.println("\"tartar\" " + ArrayQueue.check("tartar"));
		System.out.println("\" tar      ,,,    tar  \" " + ArrayQueue.check(" tar      ,,,    tar  "));

		// negative test cases:
		System.out.println("\"rattan\" " + ArrayQueue.check("rattan"));
		System.out.println("\"abcab\" " + ArrayQueue.check("abcab"));
		System.out.println("\"racecar\" " + ArrayQueue.check("racecar"));
		System.out.println("\"a\" " + ArrayQueue.check("a"));
		System.out.println("\"hello, world\" " + ArrayQueue.check("hello, world"));
		System.out.println("\"star, ,tar\" " + ArrayQueue.check("star, ,tar"));
		System.out.println("\"madam, I'm Adam\" " + ArrayQueue.check("madam, I'm Adam"));

		System.out.println("- - - - - - - - - - - - - - - - -");

		//Test the splice method
		ArrayQueue<Integer> queue1 = new ArrayQueue<>(3);
		ArrayQueue<Integer> queue2 = new ArrayQueue<>(3);
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue2.enqueue(3);
		queue2.enqueue(4);
		queue2.enqueue(5);

		queue1.splice(queue2);

		System.out.println(queue1.dequeue());
		System.out.println(queue1.dequeue());
		System.out.println(queue1.dequeue());
		System.out.println(queue1.dequeue());
		System.out.println(queue1.dequeue());

		System.out.println("- - - - - - - - - - - - - - - - -");

// Test the enqueueNoDuplicate method
		assert queue2.enqueueNoDuplicate(5) == false;
		assert queue2.enqueueNoDuplicate(6) == true;
		assert queue2.enqueueNoDuplicate(5) == false;
		assert queue2.getFront() == 6;

// Test the check method
		assert ArrayQueue.check("booboo") == true;
		assert ArrayQueue.check("hello, hello") == true;
		assert ArrayQueue.check("rattan") == false;
		assert ArrayQueue.check("abcab") == false;
	}
}
