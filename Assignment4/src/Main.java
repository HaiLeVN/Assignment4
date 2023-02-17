
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thanh Hai
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLTree tree = new AVLTree();
        Phone phone = new Phone();
        int choice;
        do {
            System.out.println("1. Method: insert(Phone x) ");
            System.out.println("2. Method: visit(Node p) ");
            System.out.println("3. Method: height(Node p)");
            System.out.println("4. Method balanceFactor(Node p)");
            System.out.println("5. Method: breadth()");
            System.out.println("6. Method: preOrder(Node p)");
            System.out.println("7. Method: inOrder(Node p)");
            System.out.println("8. Method: postOrder(Node p)");
            System.out.println("9. Method: search(Phone x)");
            System.out.println("10. Method: find_Min_price()");
            System.out.println("11. Method: find_Newest_Phone()");
            System.out.println("12. Method: find_Max_Value()");
            System.out.println("13. Method: deleteNode(int x)");
            System.out.println("Others. Quit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    phone = tree.input(tree);
                    tree.insert(phone);
                    break;
                case 2:
                    System.out.print("Enter the ID of the phone: ");
                    int id = Integer.parseInt(sc.nextLine());
                    phone = tree.searchID(id);
                    if (phone == null) {
                        System.out.println("The phone with the ID " + id + " is not in the list.");
                    } else {
                        System.out.println(phone);
                    }
                    break;
                case 3:
                    int height = tree.height(tree.root);
                    System.out.println("Height: " + height);
                    break;
                case 4:
                    System.out.print("Enter the ID of the phone: ");
                    id = Integer.parseInt(sc.nextLine());
                    phone = tree.searchID(id);
                    Node a = new Node(phone);
                    if (phone == null) {
                        System.out.println("The phone with the ID " + id + " is not in the list.");
                    } else {
                        System.out.println("The balance factor of the phone with the ID " + id + " is " + tree.balanceFactor(a) + ".");
                    }
                    break;
                case 5:
                    tree.breadth();
                    break;
                case 6:
                    tree.preOrder(tree.root);
                    break;
                case 7:
                    tree.inOrder(tree.root);
                    break;
                case 8:
                    tree.postOrder(tree.root);
                    break;
                case 9:
                    tree.search();
                    break;
                case 10:
                    Phone minPrice = tree.find_Min_price();
                    if(minPrice == null) {
                        System.out.println("No phones in the list.");
                    } else {
                        System.out.println("Phone with minimum price: "+minPrice.toString());
                    }
                    break;
                case 11:
                    Phone newestPhone = tree.find_Newest_Phone();
                    if (newestPhone == null) {
                        System.out.println("No phones in the list.");
                    } else {
                        System.out.println("Newest phone: " + newestPhone.toString());
                    }
                    break;
                case 12:
                    Phone maxValPhone = tree.find_Max_Value();
                    if (maxValPhone == null) {
                        System.out.println("No phones in the list.");
                    } else {
                        System.out.println("Phone with maximum value: " + maxValPhone);
                    }
                    break;
                case 13:
                    System.out.println("Enter Phone ID to delete: ");
                    int code = Integer.parseInt(sc.nextLine());
                    tree.deleteNode(code);
                    break;
            }
        } while (choice > 0 && choice < 14);
    }
}
