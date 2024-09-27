import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {

    public static int evaluatePostfix(String expression) {
        // Stack to store operands
        Stack<Integer> stack = new Stack<>();

        // Split the expression based on spaces
        String[] tokens = expression.split(" ");

        // Traverse through all elements of the expression
        for (String token : tokens) {
            // Check if the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Pop two operands from stack
                int b = stack.pop();
                int a = stack.pop();

                // Perform the operation based on the operator
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b); // Integer division
                        break;
                }
            } else {
                // If the token is an operand, push it to the stack
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result will be the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        // Create a scanner to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask user for the postfix expression
        System.out.println("Enter a postfix expression:");
        String expression = scanner.nextLine();

        // Evaluate the postfix expression and print the result
        int result = evaluatePostfix(expression);
        System.out.println("Result: " + result);
    }
}
