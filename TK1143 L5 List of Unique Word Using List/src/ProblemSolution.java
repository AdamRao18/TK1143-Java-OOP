
import java.util.*;

public class ProblemSolution {
    public static void main(String args[]){
        
       List<String> list1 = new ArrayList <String>();
        
      boolean isDuplicate;
		Scanner in = new Scanner(System.in);

		String passage = in.nextLine(); 
		String delims = "\\W+";
		String[] words = passage.split(delims); 

		for (String str : words) {
			str = str.trim(); 
			isDuplicate = false; 

			isDuplicate = CheckForDuplicates(list1, str); 

			if (!isDuplicate) {
				list1.add(str); 
			} 
		}

		Iterator it = list1.iterator(); 

		while (it.hasNext()) {
			System.out.print(it.next() + "\n"); 
		}
	}

	static boolean CheckForDuplicates(List L1, String word) {
		Iterator it = L1.iterator(); 
		boolean duplicate = false; 

		while (it.hasNext()) { 
			if (word.equalsIgnoreCase((String)it.next())) { 
				duplicate = true;
			}
		}

		return duplicate;

    }
}
