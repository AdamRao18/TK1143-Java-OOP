
import java.util.*;

public class Infix2PostfixConverter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String infix = in.nextLine(); // input string
        StringTokenizer st = new StringTokenizer(infix);
        StringBuilder postfix = new StringBuilder();

        boolean semicolonDetected = false; 

        while (st.hasMoreTokens()) {
            String nextT = st.nextToken();
            if (nextT.equals(";")) {
                semicolonDetected = true;
                break; 
            }
            if (isOperator(nextT)) {
                char symT = nextT.charAt(0);
                // Operator encountered
                while (!stack.isEmpty() && stack.peek() != '(' && isHigherThan(stack.peek(), symT)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(symT);
            } else {
                // Operand encountered
                postfix.append(nextT).append(" ");
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        if (semicolonDetected) {
            if (postfix.length() > 0) {
                System.out.println(postfix.toString().trim());
            } else {
                System.out.println("ERROR: Invalid expression");
            }
        } else {
            System.out.println("ERROR: no END OF STRING in the expression");
        }
    }

    static boolean isHigherThan(char op1, char op2) {
        
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return true;
        } else {
            return false;
        }
    }
    static boolean isOperator(String tmp) {
    	return tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/");
    }
}
