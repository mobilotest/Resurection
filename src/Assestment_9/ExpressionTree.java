package Assestment_9;

import java.util.Stack;

public class ExpressionTree extends BinaryTree<String> {
    public ExpressionTree() {
    } // end default constructor

//    public ExpressionTree(String data) {
//		super(data);
//    } // end default constructor

	public ExpressionTree(String infix) {
		root = formTree(infix, 0, infix.length() - 1);
	}

	private BinaryNode<String> formTree(String expr, int first, int last) {
		if (first > last) {
			return null;
		}

		Stack<BinaryNode<String>> nodeStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = first; i <= last; i++) {
			char ch = expr.charAt(i);

			if (isOperand(ch)) {
				nodeStack.push(new BinaryNode<>(String.valueOf(ch)));
			} else if (isOperator(ch) || ch == '(') {
				while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(ch) && ch != '(') {
					char op = operatorStack.pop();
					BinaryNode<String> right = nodeStack.pop();
					BinaryNode<String> left = nodeStack.pop();
					nodeStack.push(new BinaryNode<>(String.valueOf(op), left, right));
				}
				if (ch == '(' || operatorStack.isEmpty() || precedence(operatorStack.peek()) < precedence(ch)) {
					operatorStack.push(ch);
				}
			} else if (ch == ')') {
				while (operatorStack.peek() != '(') {
					char op = operatorStack.pop();
					BinaryNode<String> right = nodeStack.pop();
					BinaryNode<String> left = nodeStack.pop();
					nodeStack.push(new BinaryNode<>(String.valueOf(op), left, right));
				}
				operatorStack.pop();
			}
		}

		while (!operatorStack.isEmpty()) {
			char op = operatorStack.pop();
			BinaryNode<String> right = nodeStack.pop();
			BinaryNode<String> left = nodeStack.pop();
			nodeStack.push(new BinaryNode<>(String.valueOf(op), left, right));
		}

		return nodeStack.pop();
	}

	private boolean isOperand(char ch) {
		return Character.isLetter(ch);
	}

	private boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private int precedence(char ch) {
		switch (ch) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			default:
				return -1;
		}
	}
    
    public double evaluate() {
		return evaluate(root);
    } // end evaluate
    
    private double evaluate(BinaryNode<String> rootNode) {
		double result;
	
		if (rootNode == null)
			result = 0;
		else if (rootNode.isLeaf()) {
			String variable = rootNode.getData();
			result = getValueOf(variable);
		}
		else {
			double firstOperand = evaluate(rootNode.getLeftChild());
			double secondOperand = evaluate(rootNode.getRightChild());
			String operator = rootNode.getData();
			result = compute(operator, firstOperand, secondOperand);
		} // end if

		return result;
    } // end evaluate
    
    private double getValueOf(String variable) { // strings allow multicharacter variables
	
		double result = 0;
	
		if (variable.equals("a"))
			result = 1;
		else if (variable.equals("b"))
			result = 2;
		else if (variable.equals("c"))
			result = 3;
		else if (variable.equals("d"))
			result = 4;
		else if (variable.equals("e"))
			result = 5;
	
		return result;
   } // end getValueOf

   private double compute(String operator, double firstOperand, double secondOperand)
   {
      double result = 0;
      
      if (operator.equals("+"))
	  	result = firstOperand + secondOperand;
      else if (operator.equals("-"))
	  	result = firstOperand - secondOperand;
      else if (operator.equals("*"))
	  	result = firstOperand * secondOperand;
      else if (operator.equals("/"))
	  	result = firstOperand / secondOperand; 
      return result;
   } // end compute
} // end ExpressionTree
