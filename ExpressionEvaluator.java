package calculator;

import java.util.StringTokenizer;
import data_structures.Queue;
import data_structures.Stack;

public class ExpressionEvaluator {

	private Stack<String> stack;
	private Queue<String> queue;
	String infix;
	String postfix;
	String answer;
	String[] operators = {"+","-","*","/","^"};
	String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
	boolean within = false; 

	public ExpressionEvaluator() {
		stack = new Stack<String>();
		queue = new Queue<String>();
	}

	/**
	 * Checking if token is a number or an operator, if any matches token then
	 * it is either a number or an operator
	 * @param s
	 * @return answer
	 */
	
	public String processInput(String s) {
		something(s);
		answer = calculate();
		
		return answer;
	}
	
	/**
	 * converts the infix expression into a postfix expression.
	 * evaluates postfix and returns value of input expression.
	 * @param infix
	 * @return
	 */
	
	public void something(String infix) {
		queue.makeEmpty();
		stack.makeEmpty();

		/**
		 * Constructs a string tokenizer for the specified string.
		 * Tokenizer uses the default delimiter set.
		 * int operator and int operand are set to 0, used to count operator and operand number
		 */
		
		StringTokenizer str = new StringTokenizer(infix);
		String token;
		int operator = 0; // count operator number
		int operand = 0; // count operand number
		
		/**
		 * Tests if there are more tokens available from this tokenizer's string.
		 * If method returns true, then a subsequent call to nextToken with no argument
		 * will successfully return a token.
		 */
		
		while (str.hasMoreTokens()) {
			token = str.nextToken();
			if (token.equals("(")) {
				stack.push(token);
			} else if (token.equals(")")) {
				while (!stack.peek().equals("("))
					queue.enqueue(stack.pop());
				stack.pop();
				}
			
			/**
			 * Compares isOperator to the specified object.
			 * @return true if and only if the argument is not null
			 */
			
			for (String isOperator : operators) {
				within = token.equals(isOperator);
				if (within) {
					++operator;
					while (!stack.isEmpty() && !stack.peek().equals("(")) {
						String token2 = stack.pop();
						queue.enqueue(token2);
					}
					stack.push(token);
				}
			}

			for (String isNumber : numbers) {
				within = token.startsWith(isNumber);
				if (within) {
					++operand;
					queue.enqueue(token);
				}
			}

		}
		
		/**
		 * Tests to see if list is empty
		 */
		
		while (!stack.isEmpty()) {
			token = stack.pop();
			queue.enqueue(token);
		}
	}
	/**
	 * Checking if token is a number or operator, if any matches token then it is
	 * either a number or an operator
	 * @return
	 */
	public String calculate() {
		double value = 0;
		if (queue == null) {
			return "0";
		}
		String token;
		String token1;
		String token2;
		stack.makeEmpty();

		/**
		 *Tests to see if list is empty.
		 *Removes first object in list and returns it.
		 *Tests if string starts with isNumber
		 *@param isNumber
		 *@return true if the character sequence represented by the argument is a prefix of the character sequence.
		 */
		
		while (!queue.isEmpty()) {
			token = queue.peek();
			queue.dequeue();
			System.out.println(token);
			for (String isNumber : numbers) {
				within = token.startsWith(isNumber);
				if (within) {
					stack.push(token);
				}
			}
			
			/**
			 * Compares isOperator to the specified object.
			 * @return true if and only if the argument is not null
			 */
			
			for (String isOperator : operators) {
				within = token.equals(isOperator);
				if (within) {
					token1 = stack.pop();
					token2 = stack.pop();
					value = calc(token1, token2, token);
					stack.push("" + value);
				}
			}
		}
		return stack.pop();
	}
	
	/**
	 * Gives operators an order of operations; a precedence
	 * @param opr
	 * @return
	 */
	
	public double order(String opr) {   
		if ((opr.equals("+")) || (opr.equals("-")))
			return 1;
		else if ((opr.equals("*")) || (opr.equals("/")))
			return 2;
		else if ((opr.equals("(")) || (opr.equals(")")))
			return 4;
		else if ((opr.equals("^")))
			return 3;
		else
			return 0;
	}
	
	/**
	 * Methods to do calculations for +,-,*,/,^. Otherwise return 0.
	 * @param token1
	 * @param token2
	 * @param opr
	 * @return Answer to (value of token2 [+,-,*,\,^] value of token1)
	 */
	
	private double calc(String token1, String token2, String opr) { //methods to do calculations
		if (opr.equals("+")) {
			return Double.valueOf(token2) + Double.valueOf(token1);
		}
		if (opr.equals("-")) {
			return Double.valueOf(token2) - Double.valueOf(token1);
		}
		if (opr.equals("*")) {
			return Double.valueOf(token2) * Double.valueOf(token1);
		}
		if (opr.equals("/")) {
			return Double.valueOf(token2) / Double.valueOf(token1);
		}
		if (opr.equals("^")) {
			return Math.pow(Double.valueOf(token2) , Double.valueOf(token1));
		}
		return 0;
	}
	/**
	 * Tester line, prints the string infix
	 * @param infix
	 */
	private static void print(String infix) {
		System.out.println(infix);
	}
}


