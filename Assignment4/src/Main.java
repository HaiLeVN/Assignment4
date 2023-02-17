
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
        Phone obj = new Phone();
        int choice;
        do {
            System.out.println("1. Method: insert(Phone x) ");
            System.out.println("2. Method: visit(Node p) ");
            System.out.println("3. Method: height (Node p)");
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
            System.out.println("14. Load Phone (for test case)");
            System.out.println("Others. Quit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    obj = tree.input();
                    tree.insert(obj);
                    break;
                case 2:
                    Node p = new Node(obj);
                    System.out.println("Phone ID to visit: ");
                    p.info.ID = Integer.parseInt(sc.nextLine());
                    tree.visit(p);
                    break;
                case 3:
                    int height = tree.height(tree.root);
                    System.out.println("Height: " + height);
                    break;
                case 4:
                    p = new Node(obj);
                    int balanceFactor = tree.balanceFactor(p);
                    System.out.println("Balance factor: " + balanceFactor);
                    break;
                case 5:
                    tree.breadth();
                    break;
                case 6:
                    p = new Node(obj);
                    tree.preOrder(p);
                    break;
                case 7:
                    p = new Node(obj);
                    tree.inOrder(p);
                    break;
                case 8:
                    p = new Node(obj);
                    tree.postOrder(p);
                    break;
                case 9:
                    Node search = tree.search(obj);
                    System.out.println(search.info);
                    break;
                case 10:
                    obj = tree.find_Min_price();
                    System.out.println(obj.toString());
                    break;
                case 11:
                    obj = tree.find_Newest_Phone();
                    System.out.println(obj.toString());
                    break;
                case 12:
                    obj = tree.find_Max_Value();
                    System.out.println(obj.toString());
                    break;
                case 13:
                    System.out.println("Enter Phone ID to delete: ");
                    int code = Integer.parseInt(sc.nextLine());
                    tree.deleteNode(code);
                    break;
                case 14:
                    tree.insert(new Phone(125, "Samsung", 10050, 2019, 150));
                    tree.insert(new Phone(332, "iPhone", 14250, 2021, 175));
                    tree.insert(new Phone(452, "Vivo", 7050, 2022, 95));
                    tree.insert(new Phone(99, "Oppo", 9050, 2017, 155));
                    tree.insert(new Phone(678, "Vertue", 4055, 2020, 205));
                    System.out.println("Loaded successfully");
                    break;
            }
        } while (choice > 0 && choice < 15);
    }
}
