
import java.util.Scanner; 
import java.text.DecimalFormat; 

public class MyPrintCardApp {
	
	public static void main(String[] args) { 
    
		Scanner sc=new Scanner (System.in);
		DecimalFormat df = new DecimalFormat("0.00");

		int N=sc.nextInt();
		double amt;
    
		MyPrintCard card=new MyPrintCard();
		for (int i=1 ; i<=N ; i++) {
			char ch=sc.next().charAt(0);
      
			if (ch == '=') 
				System.out.println(card.toString());
      
      
			else if (ch=='-') 
			{
				amt=sc.nextDouble();
				if
				(card.payService(amt))
					System.out.println(card.toString());
        
				else
					System.out.println("invalid");
			}
        
			else if (ch == '+') {
				amt=sc.nextDouble();
				card.topupCard(amt);
          
				System.out.println(card.toString());
			}
		}
    }
}
