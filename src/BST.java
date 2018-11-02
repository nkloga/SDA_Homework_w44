
class BST {
    private Node root;
    BST(Node root) {
        this.root = root;
    }

    public void insert(int value) {
        Node current = this.root;
        while (current.left != null && current.right != null) {
            if (current.data < value) {
                current = current.right;
            } else if (current.data > value) {
                current = current.left;
            } else {
                System.out.println("Adding a value: The value " + value + " is already present in BST");
                return;
            }
        }
        if (current.data < value) {
            current.right = new Node(value);
        } else {
            current.left = new Node(value);
        }
    }

    public void search(int value) {
        Node current = this.root;
        while (true) {
            if (current.left == null && current.right == null && current.data != value) {
                System.out.println("Searching for the value: No such value: " + value);
                return;
            } else if (current.data > value) {
                current = current.left;
            } else if (current.data < value) {
                current = current.right;
            } else if (current.data == value) {
                System.out.println("Searching for the value: Value " + value + " has been found");
                return;
            }
        }
    }

    public void inOrderTreeWalk (Node x) {
        if(x != null) {
            inOrderTreeWalk(x.left);
            System.out.print(x.data + " ");
            inOrderTreeWalk(x.right);
        }
    }

    public void max () {
        Node x = root;
        while (x.right!=null) {
            x = x.right;
        }
        System.out.println("Max value: " + x.data);
    }

    public void min () {
        Node x = root;
        while (x.left!=null) {
            x = x.left;
        }
        System.out.println("Min value: " + x.data);
    }

    public void successor(int value) {
        Node current = this.root;

        // find the node
        while (current.data != value) {
            if (current.data > value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        // if the node has no childs tell that there is no successor
        if (current.right == null && current.left == null) {
            System.out.println("No successor for this node");
            // if the node has no right child, left one is the successor
        } else if (current.right == null) {
            System.out.println("Successor for " + value + " is: " + current.left.data);
            // else go to the right child
        } else {
            current = current.right;
        }
        // if there is no left child the node is successor
        if (current.left == null) {
            System.out.println("Successor for " + value + " is: " + current.data);
        } else {
            while (current.left != null) {
                current = current.left;
            }
            System.out.println("Successor for " + value + " is: " + current.data);
        }
    }

    public void predecessor(int value) {
        Node current = this.root;

        // find the node
        while (current.data != value) {
            if (current.data > value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        // if the node has no childs tell that there is no predecessor
        if (current.right == null && current.left == null) {
            System.out.println("No predecessor for this node");
            // if the node has no left child, right one is the predecessor
        } else if (current.left == null) {
            System.out.println("Successor for " + value + " is: " + current.right.data);
            // else go to the left child
        } else {
            current = current.left;
        }
        // if there is no right child the node is predecessor
        if (current.right == null) {
            System.out.println("Predecessor for " + value + " is: " + current.data);
        } else {
            while (current.right != null) {
                current = current.right;
            }
            System.out.println("Predecessor for " + value + " is: " + current.data);
        }
    }


    public static void main(String[] args) {
        Node root = new Node(5);
        BST newBST = new BST(root);  // not sure if constructor is necessary

        newBST.insert(7);
        newBST.insert(2);
        newBST.insert(8);
        newBST.insert(4);
        newBST.insert(1);
        newBST.insert(3);

        newBST.search(8);

        System.out.print("In order tree walk results: ");
        newBST.inOrderTreeWalk(root);
        System.out.println();

        newBST.max();

        newBST.min();

        newBST.successor(5);

        newBST.predecessor(5);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}