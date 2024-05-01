
import java.util.Scanner;

public class BillApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num=sc.nextInt();		
		switch (num) {		
		case 1: //Internet			
			String itname = sc.next();
			String itty = sc.next();
			double paybillit = sc.nextDouble();				
			Internet it = new Internet(itname, itty, paybillit);			
			String nameIt1 = sc.next();
			double msIt1 = sc.nextDouble();
			User c1 = new User(nameIt1, msIt1);			
			it.getBill(c1);
			break;		
		case 2: //Astro			
			String asname = sc.next();
			String asty = sc.next();
			double paybillas = sc.nextDouble();
			Astro as = new Astro(asname, asty, paybillas);				
			String nameAs = sc.next();
			double msAs = sc.nextDouble();
			User c2 = new User(nameAs, msAs);		
			as.getBill(c2);
			break;			
		case 3:	//electricity			
			String ename = sc.next();
			String ety = sc.next();
			double paybille = sc.nextDouble();
			Electricity e = new Electricity(ename, ety, paybille);			
			String nameE = sc.next();
			double msE = sc.nextDouble();
			User c3 = new User(nameE, msE);		
			e.getBill(c3);
			break;		
		case 4:	//car park		
			String hty = sc.next();
			String loc = sc.next();			
			CarPark cp = new CarPark(hty,loc);			
			String nameCp = sc.next();
			double msCp = sc.nextDouble();
			User c4 =new User(nameCp, msCp);		
			cp.getBill(c4);
			break;
		}
	}

}
