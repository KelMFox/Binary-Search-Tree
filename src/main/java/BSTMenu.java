import java.util.Scanner;

/**
 * The BSTMenu creates a menu for a user to select
 * operations to be performed on the binary search tree. This class
 * uses methods from the BinarySearchTree class to perform operations
 * such as insertion, search, traversals, and calculations of tree
 * height, node count, and leaf count
 *
 * @author Kelly
 *
 */

public class BSTMenu {

    public static void main (String[] args) {

        // Create instance of the BinarySearchTree class
        BinarySearchTree treeMenu = new BinarySearchTree();

        // Create an array to hold the initial number of keys
        // used to populate the tree
        int[] rand = {76, 21, 55, 68, 22, 47, 33, 98, 102, 75, 90, 63, 72, 19, 82, 29,
                46, 59, 110, 11};

        // Used to store user's keyboard input
        Scanner userIn = new Scanner(System.in);

        // Holds the user's selection from the menu
        int userSelection;

        // Stores the user's input as an integer
        int number;

        // Add the numbers in the array to the
        // tree via the addNode method
        for (int x : rand)

            treeMenu.addNode(x);

        /**
         * Display the operations menu
         */
        System.out.println("***********Binary Search Tree***********");

        System.out.println();

        // Display the tree's contents before any additional operations
        // are performed
        System.out.println("The tree contains the following numbers: ");

        for (int nums : rand)

            System.out.print(nums + " ");

        do {
            
            System.out.println("\n\n[1] Add Numbers to the Tree");
            System.out.println("[2] Search for a Number");
            System.out.println("[3] Calculate the Height");
            System.out.println("[4] Count the Leaves");
            System.out.println("[5] Count the Internal Nodes");
            System.out.println("[6] Inorder Traversal");
            System.out.println("[7] Preorder Traversal");
            System.out.println("[8] Postorder Traversal");
            System.out.println("[9] Exit\n");
            System.out.println("Enter a Number from the List Above:");

            while (!userIn.hasNextInt()) {

                System.out.println("Please enter a number (1-9): ");
                userIn.next();
            }
            userSelection = userIn.nextInt();
            System.out.println();

            switch (userSelection) {

                case 1:

                    System.out.println("Please enter a number to add to the tree: ");

                    while (!userIn.hasNextInt()) {

                        System.out.println("Invalid Input! Please enter a number: ");
                        userIn.next();
                    }
                    number = userIn.nextInt();
                    treeMenu.addNode(number);
                    System.out.println("\nThe tree now contains the following numbers: ");
                    treeMenu.traversePreOrder();
                    break;

                case 2:

                    treeMenu.traversePreOrder();
                    System.out.println("\nEnter a number to search for: ");
                    while (!userIn.hasNextInt()) {

                        System.out.println("Invalid Input! Please enter a number: ");
                        userIn.next();
                    }
                    number = userIn.nextInt();
                    System.out.println("Does the tree contain the number " + number + "? "
                            + treeMenu.searchForNode(number));
                    break;

                case 3:

                    treeMenu.traversePreOrder();

                    System.out.println("\nTree Height: " + treeMenu.getTreeHeight());
                    break;

                case 4:

                    treeMenu.traversePreOrder();

                    System.out.println("\nNumber of Leaves: " +
                            treeMenu.countNumOfLeaves());
                    break;

                case 5:

                    treeMenu.traversePreOrder();

                    System.out.println("\nNumber of Internal Nodes: " +
                            treeMenu.countInternalNodes());
                    break;

                case 6:

                    System.out.println("\nInorder Traversal: ");
                    treeMenu.traverseInOrder();
                    break;

                case 7:

                    System.out.println("\nPreorder Traversal: ");
                    treeMenu.traversePreOrder();
                    break;

                case 8:

                    System.out.println("\nPostorder Traversal: ");
                    treeMenu.traversePostOrder();
                    break;

                case 9:

                    System.out.println("**** End of the Program ****");
                    break;

                default:

                    System.out.println("Invalid Selection.");
            }
        } while (userSelection != 9);
    }
}

