
class BST {
    class Node {
        String word;
        Node left, right;

        public Node(String word) {
            this.word = word;
            left = right = null;
        }
    }

    Node root;

    BST() {
        root = null;
    }

    void insert(String word) {
        root = insertRec(root, word);
    }

    Node insertRec(Node root, String word) {
        if (root == null) {
            root = new Node(word);
            return root;
        }

        int compare = word.compareTo(root.word);

        if (compare < 0) {
            root.left = insertRec(root.left, word);
        } else if (compare > 0) {
            root.right = insertRec(root.right, word);
        }

        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.word);
            inorder(root.right);
        }
    }
}
