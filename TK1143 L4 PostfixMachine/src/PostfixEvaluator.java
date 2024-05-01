import java.util.*;

public class PostfixEvaluator {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	
		Stack <Integer> myStack = new Stack <Integer> ();
		String InStr;
		int f1, f2;
		int result;
		
		InStr = in.nextLine(); 
		boolean end = false;
		StringTokenizer st = new StringTokenizer(InStr);
		while (st.hasMoreTokens()) {
			String nextT = st.nextToken();
			if(!(nextT.equals(";"))) {
				if (isOperator(nextT)){ //
			
					f1 = (Integer)myStack.pop();
					f2 = (Integer)myStack.pop();
					result= evaluate (f1, f2, nextT);
					Integer data = Integer.valueOf(result);
                    myStack.push(data);
				}
				else {
				
					int a = Integer.parseInt(String.valueOf(nextT)); 
                    Integer iInteger = Integer.valueOf(a);
                    myStack.push(iInteger);
				}
			}
			else{
               
               while (!myStack.empty()) { 
                   System.out.println(myStack.peek());
                   myStack.pop();
               }
               
               end = true;
               break;
           }  
		}
	
		if (!end)
			System.out.print("ERROR: no END OF STRING in the expression");
	} 
	
	static boolean isOperator(String tmp) {
		if ((tmp.equals("+"))||(tmp.equals("-"))||(tmp.equals("*"))||(tmp.equals("/"))) {
			return true;
			
		}else return false;
	}
	
	static int evaluate(Integer op1, Integer op2, String s1) {
		int data1 = op2.intValue();
		int data2 = op1.intValue();
		if (s1.equals("+")) return (data1 + data2);
			else if (s1.equals("-")) return (data1 - data2);
			else if (s1.equals("*")) return (data1 * data2);
			else if (s1.equals("/")) return (data1 / data2);
			else return -1;
	}
}
