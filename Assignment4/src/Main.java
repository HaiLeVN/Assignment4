
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
            System.out.println("3. Method: height(Node p)");
            System.out.println("4. Method balanceFactor(Node p)"); //Lỗi không lấy dược balanaceFactor
            System.out.println("5. Method: breadth()");
            System.out.println("6. Method: preOrder(Node p)");
            System.out.println("7. Method: inOrder(Node p)");
            System.out.println("8. Method: postOrder(Node p)");
            System.out.println("9. Method: search(Phone x)"); //Lỗi nullpointer
            System.out.println("10. Method: find_Min_price()");
            System.out.println("11. Method: find_Newest_Phone()");
            System.out.println("12. Method: find_Max_Value()");
            System.out.println("13. Method: deleteNode(int x)"); //Lỗi không thể xóa
            System.out.println("14. Load Phone (for test case)");
            System.out.println("Others. Quit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    obj = tree.input(tree);
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
                    System.out.println("Phone ID to get balanceFactor: ");
                    p.info.ID = Integer.parseInt(sc.nextLine());
                    int balanceFactor = tree.balanceFactor(p);
                    System.out.println("Balance factor: " + balanceFactor);
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
                    System.out.println("Phone ID to search: ");
                    int code = Integer.parseInt(sc.nextLine());
                    Phone ph = new Phone(code);
                    p = tree.search(ph);
                    System.out.println(p.info);
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
                    code = Integer.parseInt(sc.nextLine());
                    tree.deleteNode(code);
                    break;
                case 14:
                    tree.insert(new Phone(20, "iPhone 13", 999, 2021, 10));
                    tree.insert(new Phone(4, "Samsung Galaxy S21", 799, 2021, 5));
                    tree.insert(new Phone(7, "Google Pixel 6", 899, 2021, 8));
                    tree.insert(new Phone(2, "OnePlus 9 Pro", 969, 2021, 3));
                    tree.insert(new Phone(24, "Xiaomi Mi 11", 749, 2021, 6));
                    tree.insert(new Phone(44, "Sony Xperia 1 III", 1299, 2021, 2));
                    tree.insert(new Phone(37, "Huawei P50 Pro", 999, 2022, 7));
                    tree.insert(new Phone(22, "LG G9 ThinQ", 599, 2021, 4));
                    tree.insert(new Phone(40, "Motorola Moto G Power", 249, 2021, 9));
                    obj = new Phone(20, "iPhone 13", 999, 2021, 10);
                    obj = new Phone(4, "Samsung Galaxy S21", 799, 2021, 5);
                    obj = new Phone(7, "Google Pixel 6", 899, 2021, 8);
                    obj = new Phone(2, "OnePlus 9 Pro", 969, 2021, 3);
                    obj = new Phone(24, "Xiaomi Mi 11", 749, 2021, 6);
                    obj = new Phone(44, "Sony Xperia 1 III", 1299, 2021, 2);
                    obj = new Phone(37, "Huawei P50 Pro", 999, 2022, 7);
                    obj = new Phone(22, "LG G9 ThinQ", 599, 2021, 4);
                    obj = new Phone(2, "Motorola Moto G Power", 249, 2021, 9);
                    System.out.println("Loaded successfully");
                    break;
            }
        } while (choice > 0 && choice < 15);
    }
}
