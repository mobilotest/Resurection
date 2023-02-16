package Assestment_1_3;

class ArrayStack2Test{

    public static void main(String[] args) {
        ArrayStack2<Integer> myTestStack = new ArrayStack2<>();

        System.out.println("### Testing the Display method ###");
        System.out.println("Stack before Display method: ");
        myTestStack.display();

        myTestStack.push(1);
        myTestStack.push(-2);
        myTestStack.push(3);
        myTestStack.push(456);
        myTestStack.push(5);
        myTestStack.push(6);
        myTestStack.push(7);

        System.out.println("Stack after Display method: ");
        myTestStack.display();

        myTestStack.push(8);
        myTestStack.push(9);
        myTestStack.push(10);
        myTestStack.push(11);
        myTestStack.push(12);
        myTestStack.push(13);
        myTestStack.push(14);

        System.out.println("");
        System.out.println("### Testing the Remove method ###");
        System.out.println("The top element Before Remove is: " + myTestStack.peek());
        System.out.println(myTestStack.remove(2) + " Elements were removed");
        System.out.println("The top element After Remove is: " + myTestStack.peek());

        System.out.println("");
        System.out.println("### Testing the Reduce method ###");
        ArrayStack2 stackHolder = new ArrayStack2();
        System.out.println("Initial Array size: " + myTestStack.getArraySize());

        int increaseArraySize = myTestStack.getArraySize() * 5;
        int decreaseArraySize = myTestStack.getArraySize() * 4;
        for(int i=0; i<increaseArraySize; i++){
            myTestStack.push(i);
        }
        System.out.println("Array size Before of New big array: " + myTestStack.getArraySize());

        for(int i=0; i<decreaseArraySize; i++){
            myTestStack.pop();
        }
        System.out.println("Array size Before of Reduced array: " + myTestStack.getArraySize());

    }
}

//TEST CASES RESULTS:
//
//### Testing the Display method ###
//        Stack before Display method:
//        The stack is empty
//        Stack after Display method:
//        7
//        6
//        5
//        456
//        3
//        -2
//        1
//
//        ### Testing the Remove method ###
//        The top element Before Remove is: 14
//        2 Elements were removed
//        The top element After Remove is: 12
//
//        ### Testing the Reduce method ###
//        Initial Array size: 27
//        Array size Before of New big array: 216
//        Array size Before of Reduced array: 67
//
//        Process finished with exit code 0
