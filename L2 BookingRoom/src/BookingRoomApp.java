
import java.util.Scanner;
import java.text.*;

public class BookingRoomApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		BookingRoom room[] = new BookingRoom[1];
		DecimalFormat df = new DecimalFormat("###0.00"); 

		String name;
		int roomType, numOfPart,numOfHour = 0,typeOfStay=0, typeOfPackage = 0, merchandise = 0;
		double totalPaymentM = 0.0, totalPaymentC = 0.0;

		for(int i=0;i<room.length;i++) {
			
			//Input Name
			name= sc.next();
			//Input number of participants
			numOfPart = sc.nextInt();
			//Input room type (1-Meeting Room / 2-Conference Room)
			roomType = sc.nextInt();

			if (roomType == 1){
				
				//Input number of hours to book
				numOfHour = sc.nextInt();
				//Input type of booking (1-One off stay / 2-Regular recurring)
				typeOfStay = sc.nextInt();

				room[i] = new MeetingRoom (name, numOfPart, numOfHour, typeOfStay); 
			}

			else if (roomType == 2){
				
				//Input package type (1-Fullday/2-Halfday)
				typeOfPackage= sc.nextInt();
				//Input merchandise (1-Yes/2-No)
				merchandise = sc.nextInt();

				room[i] = new ConferenceRoom (name, numOfPart, typeOfPackage, merchandise);
			}

			// Output
			if(room[i] instanceof MeetingRoom){
				
				room[i].payment();
				totalPaymentM=+room[i].payment();
				System.out.println("Name: " + name);
				System.out.println("Number of participants: " + numOfPart);
				System.out.println("Number of hours to book: " +  numOfHour);
				System.out.println("Type of booking (1-One off stay / 2-Regular recurring): " + typeOfStay);
				System.out.println("\nTotal payment for the  Meeting Room is RM " + df.format(totalPaymentM));
			}

			else if(room[i] instanceof ConferenceRoom){
				
				room[i].payment();
				totalPaymentC=+room[i].payment();
				System.out.println("Name: " + name);
				System.out.println("Number of participants: " + numOfPart);
				System.out.println("package type (1-Fullday/2-Halfday): " + typeOfPackage);
				System.out.println("Merchandise? (1-Yes/2-No): " + merchandise);
				System.out.println("\nTotal payment for the Conference Room is RM " + df.format(totalPaymentC)); 
			}
		} 
	}
}

