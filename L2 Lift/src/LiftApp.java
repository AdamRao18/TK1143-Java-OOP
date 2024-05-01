
import java.util.*;

public class LiftApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//create object for LiftPerson and LiftGoods
		LiftPerson liftA = new LiftPerson(200,30,7);
		LiftGoods liftB = new LiftGoods(1050,30);

		//Insert either "LiftA" or "LiftB"
		String lift = sc.next();

		if (lift.equals("LiftA")) {
			//numbers of person waiting infront of lift
			int numP = sc.nextInt();
			Person[] pforLift = new Person[numP];
			//insert data of persons
			for(int i= 0; i<numP; i++) {
				String name = sc.next();
				int weight = sc.nextInt();

				pforLift[i] = new Person(name, weight);
				//set person into PersonLift
				liftA.setPersoninLift(pforLift[i]);
			}
		}
		
		else if(lift.equals("LiftB")) {
			//Number of total boxes to insert into lift
			int numberTOTALofbox = sc.nextInt();
			//Assumtion only 2 staff can enter into LiftGoods
			Person[] pforLift2 = new Person[2];
			Goods[] gforLift2 = new Goods[numberTOTALofbox];
			//Insert data for 2 staff
			for(int i= 0; i<2; i++) {
				String nameP = sc.next();
				int weightP = sc.nextInt();

				pforLift2[i] = new Person(nameP, weightP);
				liftB.setPersoninLift(pforLift2[i]);
			}

			//insert boxes into this GoodsLift
			for(int i= numberTOTALofbox-1; i>0; i--) {
				String nameG = sc.next();
				int weightG = sc.nextInt();
				//Assume the same product with many boxes
				int numberEACHofbox = sc.nextInt();

				gforLift2[i] = new Goods(nameG, weightG);
				liftB.setnumberEACHofbox(numberEACHofbox);
				liftB.setGoodsinLift(gforLift2[i]);
				//reduce the number of boxes
				i -= numberEACHofbox;
			}
		}
		else {
			System.out.println("Wrong Input!");
		}
	}
}

