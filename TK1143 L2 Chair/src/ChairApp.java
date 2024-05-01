
import java.util.Scanner;

public class ChairApp {

		public static void main(String[] args) {
			
			FixedChair chair1 = new FixedChair(55, "blue", 10, 6);
			FixedChair chair2 = new FixedChair(60, "orange", 6, 5);
			
			Person person1 = new Person("Amina", 50);
			Person person2 = new Person("Wafa", 70);
			
			chair1.occupiedBy(person1);
			chair2.occupiedBy(person2);
		 }
}
