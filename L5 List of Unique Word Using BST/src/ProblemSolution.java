
import java.util.*;

class ProblemSolution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String passage = sc.nextLine();
        sc.close();

        String[] words = passage.split("\\W+");
        BST bst = new BST();
        
        for (String word : words) {
            bst.insert(word);
        }
   bst.inorder(bst.root);
    }
}