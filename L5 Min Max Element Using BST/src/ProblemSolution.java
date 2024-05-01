
import java.util.Scanner;

public class ProblemSolution {

 public static void main(String []args) {
  Scanner sc = new Scanner(System.in); 
  BST tree = new BST(); 
  String passage = sc.nextLine(); 
  String delims = "\\s+";
  String [] words = passage.split(delims);
  
  for(String str: words) {
   int value = Integer.parseInt(str); 
   
   if(value == 0) { 
    break; 
   }
   else {
    tree.insert(value); 
   }
  }

  System.out.print("Preorder : "); 
  tree.preorder(); 
  System.out.println(); 
  System.out.print("Inorder : "); 
  tree.inorder(); 
  System.out.println(); 
  System.out.print("Postorder : "); 
  tree.postorder(); 
  System.out.println(); 
  System.out.print("Minimum Element in tree is : "); 
  tree.findMin();
  System.out.print("Maximum Element in tree is : "); 
  tree.findMax();
 }
}
