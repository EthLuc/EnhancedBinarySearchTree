import java.io.*;
import java.util.*;

public class EnhancedBST extends BinarySearchTree {

    // Method to build the BST from a file
    public void buildFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            
            // Read each line from the file and insert it into the tree
            while ((line = reader.readLine()) != null) {
                try {
                    Comparable value = Integer.parseInt(line.trim()); // assuming the data in file is integers
                    add(value); // Use the add method to insert into the tree
                } catch (NumberFormatException e) {
                    System.out.println("Invalid data in file: " + line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Override the print method to show the tree in multiple traversals
    @Override
    public void print() {
        System.out.print("Inorder: ");
        printInOrder(getRoot());
        System.out.println();
        System.out.print("Preorder: ");
        printPreOrder(getRoot());
        System.out.println();
        System.out.print("Postorder: ");
        printPostOrder(getRoot());
        System.out.println();
    }

    private void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    private void printPreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Method to export the BST to a text file
    public void exportToFile(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            exportInOrder(getRoot(), writer);
            writer.close();
            System.out.println("Tree data has been exported to: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private void exportInOrder(Node node, BufferedWriter writer) throws IOException {
        if (node == null) return;
        exportInOrder(node.left, writer);
        writer.write(node.data.toString());
        writer.newLine();
        exportInOrder(node.right, writer);
    }

    // Method to get the root of the tree (since root is private in BinarySearchTree)
    public Node getRoot() {
        return super.root;
    }

    // Method to get the height of the tree
    public int getHeight() {
        return getHeight(getRoot());
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // Method to calculate the internal path length of the tree
    public int getInternalPathLength() {
        return getInternalPathLength(getRoot(), 0);
    }

    private int getInternalPathLength(Node node, int level) {
        if (node == null) return 0;
        return level + getInternalPathLength(node.left, level + 1) + getInternalPathLength(node.right, level + 1);
    }

    // Method to count the absent children in the tree
    public int countAbsentChildren() {
        return countAbsentChildren(getRoot());
    }

    private int countAbsentChildren(Node node) {
        if (node == null) return 1;
        return countAbsentChildren(node.left) + countAbsentChildren(node.right);
    }

    // Method to check if a path sum exists in the tree
    public boolean hasPathSum(int sum) {
        return hasPathSum(getRoot(), sum);
    }

    private boolean hasPathSum(Node node, int sum) {
        if (node == null) return sum == 0;
        sum -= (int) node.data;
        return hasPathSum(node.left, sum) || hasPathSum(node.right, sum);
    }
}
