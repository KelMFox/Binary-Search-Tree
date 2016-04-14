/**
 * Created by Kelly on 4/14/2016.
 */
/**
 * The BinarySearchTree class creates a binary search tree complete
 * with methods that insert, search, calculate height, count the number
 * of leaves and internal nodes, and traverse the list (in-order, pre-order,
 * and post-order).
 *
 */

public class BinarySearchTree {

    // Create a node to act as the root of the tree
    private Node root;

    /**
     *  Default Constructor
     */
    public BinarySearchTree() {

    }

    /**
     * Private inner class for the Nodes (left and right children)
     * and the tree elements (key)
     */
    private class Node {

        Node leftChild = null;
        Node rightChild = null;

        Integer key;


        public Node (int key) {

            this.key = key;
        }
    }

    /**
     * The addNode method uses the private class
     * traverseAndAdd to add elements to the binary tree
     * @param key
     */
    public void addNode(Integer key) {

        // Create a new node to be added to the list
        Node newNode = new Node(key);

        // if the root is null then the new node becomes
        // the root
        if (root == null)

            root = newNode;

        // Call the private method to recursively traverse the
        // tree
        traverseAndAdd(root, newNode);

    }

    /**
     * The traverseInOrder method uses a private method
     * called inOrder to traverse the binary tree in an in-
     * order fashion (traverse left subtree, display the root
     * node, and then traverse the right subtree)
     */
    public void traverseInOrder() {

        if (root != null) {

            // start at the root and move down the tree
            Node traverseNode = root;

            // Check if there are child nodes
            if (traverseNode.leftChild == null && traverseNode.rightChild == null) {

                System.out.println(traverseNode.key);
            }

            else {

                // Call the private method to recursively traverse the
                // tree
                inOrder(traverseNode);
            }
        }
    }

    /**
     * The traversePreOrder method uses a private method
     * called preOrder to traverse the binary tree in a pre-
     * order fashion (display the root node, traverse left
     * subtree, and then traverse the right subtree)
     */
    public void traversePreOrder() {

        if (root != null) {

            // Set traversing node to equal the root
            // start at the root
            Node traverseNode = root;

            // Check if there are child nodes
            if (traverseNode.leftChild == null && traverseNode.rightChild == null) {

                System.out.println(traverseNode.key);
            }

            else {

                // Call the private method to recursively traverse the
                // tree
                preOrder(traverseNode);
            }
        }
    }

    /**
     * The traversePostOrder method uses a private method
     * called postOrder to traverse the binary tree in a post-
     * order fashion (traverse left subtree, traverse the right
     * subtree, and then display the root node)
     */
    public void traversePostOrder() {

        if (root != null) {

            // Set traversing node to equal the root
            // start at the root
            Node traverseNode = root;

            if (traverseNode.leftChild == null && traverseNode.rightChild == null) {

                System.out.println(traverseNode.key);
            }

            else {

                // Call the private method to recursively traverse the
                // tree
                postOrder(traverseNode);
            }
        }
    }

    /**
     * The countNumOfLeaves method uses a private
     * method of the same name to traverse the
     * tree and count each node that does not have
     * child nodes (right, left, or both)
     * @return
     */
    public int countNumOfLeaves() {

        return countNumOfLeaves(root);
    }

    /**
     * The countInternalNodes method uses a private
     * method of the same name to count all of the nodes
     * in the tree that have child nodes
     * @return
     */
    public Integer countInternalNodes() {

        return countInternalNodes(root);
    }

    /**
     * The getTreeHeight uses the private method
     * of the same name to recursively traverse
     * through the tree counting the tree's height
     * @return
     */
    public Integer getTreeHeight() {

        return getTreeHeight(root);
    }

    /**
     * The searchForNode method is used to find
     * a particular node in the tree based on its
     * key
     * @param key
     * @return
     */
    public boolean searchForNode(Integer key) {

        Comparable<Integer> data = key;

        // Make the searching node the root
        // start at the root of the tree
        Node searchNode = root;

        while (searchNode != null) {

            // If the key is found in the tree
            // then output true
            if (data.compareTo(searchNode.key) == 0)

                return true;

            if (data.compareTo(searchNode.key) > 0)

                searchNode = searchNode.rightChild;

            else searchNode = searchNode.leftChild;
        }

        // Key was not found in the tree (output false)
        return false;
    }

    /* The following methods are private methods used for the various operations to be performed on the BST  */

    /**
     * The traverseAndAdd method is a private recursive method that outlines
     * how new nodes should be added to the list. The method is used by the public addNode method.
     * Nodes that are less than the root node are left child nodes and nodes greater than the root
     * are right child nodes.
     * @param node
     * @param newNode
     */
    private void traverseAndAdd(Node node, Node newNode) {

        if (newNode.key < node.key) {

            if (node.leftChild == null) {

                // If there isn't a left child node, then newNode becomes
                // a left child node
                node.leftChild = newNode;
            }

            else {

                // Recurse through the left
                traverseAndAdd(node.leftChild, newNode);
            }
        }

        else if (newNode.key > node.key) {

            // If there isn't a right child node, then new node becomes
            // a right child node
            if (node.rightChild == null) {

                node.rightChild = newNode;
            }

            else {

                // Recurse through the right
                traverseAndAdd(node.rightChild, newNode);
            }
        }
    }

    /**
     * The inOrder private method uses recursion to
     * traverse the tree and output its contents in
     * an in-order fashion
     * @param node
     */
    private void inOrder(Node node) {

        if (node.leftChild != null) {

            // Traverse left side
            inOrder(node.leftChild);
        }

        // Display the root node
        System.out.print(node.key + " ");

        if (node.rightChild != null) {

            // Traverse right side
            inOrder(node.rightChild);
        }
    }

    /**
     * The preOrder private method uses recursion
     * to traverse the tree and output its contents
     * in a pre-order fashion
     * @param node
     */
    private void preOrder(Node node) {

        // Display the root node
        System.out.print(node.key + " ");

        if (node.leftChild != null) {

            // Traverse left side
            preOrder(node.leftChild);
        }

        if (node.rightChild != null) {

            // Traverse right side
            preOrder(node.rightChild);
        }
    }

    /**
     * The postOrder private method uses recursion
     * to traverse the tree and output its contents in
     * a post-order fashion
     * @param node
     */
    private void postOrder(Node node) {

        if (node.leftChild != null) {

            // Traverse left side
            postOrder(node.leftChild);
        }

        if (node.rightChild != null) {

            // Traverse right side
            postOrder(node.rightChild);
        }

        // Display the root node
        System.out.print(node.key + " ");
    }

    /**
     * The isALeaf private method checks to if a node
     * has any child nodes. If it does not, then
     * it is a leaf node (true)
     * @param key
     * @return
     */
    private boolean isALeaf(Node key) {

        return key.leftChild == null && key.rightChild == null;
    }

    /**
     * The countNumOfLeaves private method
     * uses recursion to count the number of leaves in the
     * tree.
     * @param key
     * @return
     */
    private Integer countNumOfLeaves(Node key) {

        if (key != null) {

            // Check to see if the node is a leaf
            if (isALeaf(key)) {

                return 1;
            }

            else

                // recursively call the countNumOfLeaves method
                // for both right and left subtrees
                return countNumOfLeaves(key.leftChild) +
                        countNumOfLeaves(key.rightChild);
        }

        return 0;
    }

    /**
     * The countInternalNodes private method uses
     * recursion to determine if a node has children. If it does,
     * each internal node is counted.
     * @param key
     * @return
     */
    private Integer countInternalNodes(Node key) {

        // Check if the node is not null and that the node
        // is not a leaf
        if (key != null && !isALeaf(key)) {

            return 1 + countInternalNodes(key.leftChild) + countInternalNodes(key.rightChild);
        }

        return 0;
    }

    /**
     * The getTreeHeight private method
     * @param key
     * @return
     */
    private Integer getTreeHeight(Node key) {

        // If the node is equal to null than count it as
        // root or -1
        if (key == null)

            return -1;

        return 1 + Math.max(getTreeHeight(key.leftChild), getTreeHeight(key.rightChild));
    }
}