import java.util.Scanner;

public class UserInterface {
    private EnhancedBST tree;

    public UserInterface() {
        tree = new EnhancedBST();
    }

    public void go() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            // Show menu options
            System.out.println("Welcome to the Enhance BST Tester.");
            System.out.println("Here's the menu of our choices -");
            System.out.println("0) Quit");
            System.out.println("1) Build a BST from a text file");
            System.out.println("2) Print the tree");
            System.out.println("3) Add data");
            System.out.println("4) Remove Data");
            System.out.println("5) Show tree height");
            System.out.println("6) Show internal path length");
            System.out.println("7) Count Absent Children");
            System.out.println("8) Find a path sum");
            System.out.println("9) Export a BST to a text file");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character
            
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.print("Enter the file name: ");
                    String filename = scanner.nextLine();
                    tree.buildFromFile(filename);
                    break;
                case 2:
                    tree.print();
                    break;
                case 3:
                    System.out.print("Enter a number to add: ");
                    int valueToAdd = scanner.nextInt();
                    tree.add(valueToAdd);
                    break;
                case 4:
                    System.out.print("Enter a number to remove: ");
                    int valueToRemove = scanner.nextInt();
                    tree.remove(valueToRemove);
                    break;
                case 5:
                    System.out.println("Tree height: " + tree.getHeight());
                    break;
                case 6:
                    System.out.println("Internal path length: " + tree.getInternalPathLength());
                    break;
                case 7:
                    System.out.println("Absent children count: " + tree.countAbsentChildren());
                    break;
                case 8:
                    System.out.print("Enter a target sum: ");
                    int targetSum = scanner.nextInt();
                    boolean pathSumExists = tree.hasPathSum(targetSum);
                    System.out.println("Path sum " + targetSum + " exists: " + pathSumExists);
                    break;
                case 9:
                    System.out.print("Enter the file name to export: ");
                    String exportFilename = scanner.nextLine();
                    tree.exportToFile(exportFilename);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        
        scanner.close();
        System.out.println("Exiting program.");
    }
}
