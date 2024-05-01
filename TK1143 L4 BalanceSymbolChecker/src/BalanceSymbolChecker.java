
import java.util.*;

public class BalanceSymbolChecker {

	public static void main(String[] args) { 
		Scanner in = new Scanner(System.in); 
		
		Stack<String> myStack = new Stack<String>(); 
		
		String N; 
		int count1 = 0, count2 = 0; 
		
		N = in.nextLine(); 
		
		StringTokenizer st = new StringTokenizer(N); // 
		
		// if string contains semicolon
		if (N.contains(";")) {
			// Iterate through tokens
			while (st.hasMoreTokens()) {
				String nextT = st.nextToken(); // Get the next token
				
				// if token is not semicolon
				if (!(nextT.equals(";"))) {
					// if token is opening symbol
					if (nextT.equals("(") || nextT.equals("{") || nextT.equals("[")){ 
						myStack.push(nextT); 
						count1++; 
					}
					// if token is closing symbol
					else if(nextT.equals(")") || nextT.equals("}") || nextT.equals("]")){
						myStack.pop(); 
						count2++; 
					}
				}
				else
					break;
			}
			
			// if stack is empty
				if(myStack.isEmpty()) {
					System.out.println("Balanced"); // string is balanced
				}
				else {
					System.out.println("Unbalanced"); // string is unbalanced
				}
			}
				else
					System.out.println("ERROR: no END OF STRING in the expression");
					
				}
		}
