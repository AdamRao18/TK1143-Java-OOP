
import java.util.Scanner;

public class ProblemSolution {

	public static void main(String[] args) {
		
		BST bt = new BST();
		Scanner in = new Scanner(System.in);
		
		String passage = in.nextLine();
		String delims = "\\W+";
		String[] words = passage.split(delims);
		
		for(String str : words) {
			str = str.trim();
			bt.insert(str);
		}
		System.out.println();
		int menu =0;
		while (menu!=5) {
			System.out.println("Menu:");
            System.out.println("1. Add new word.");
            System.out.println("2. Delete word.");
            System.out.println("3. Search word.");
            System.out.println("4. Print all words and its frequency.");
            System.out.println("5. Exit.");
            System.out.println();
            System.out.print("Input code: ");
            menu = in.nextInt();
			System.out.println(menu);
			if(menu == 1) {
				System.out.print("Enter new word: ");
				String add = in.next();
				bt.insert(add);
				System.out.println(add+"\nThe word "+add+" has been added successfully.");
                System.out.println();
			}
			else if(menu == 2) {
				System.out.print("Enter word to be deleted: ");
				String dlt = in.next();
				System.out.println(dlt);
				bt.delete(dlt);
			}
			else if(menu == 3) {
				System.out.print("Input Search text: ");
				String srch = in.next();
				System.out.println(srch);
				bt.search(srch);
			}
			else if(menu == 4) {
				bt.inorder();
				System.out.println();
			}
			else if(menu == 5) {
				System.out.println("Bye..");
			}
			else {
				System.out.println("Invalid code, Enter code 1-5.");
                System.out.println();
			}
		}
	}
}
