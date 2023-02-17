
import java.util.LinkedList;
import java.util.Queue;
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
public class AVLTree {

    Node root;

    AVLTree() {
        root = null;
    }
    boolean isEmpty() {
        return (root == null);
    }
    public Phone input(AVLTree tree) {
        Scanner sc = new Scanner(System.in);
        int id;
        do {
            System.out.print("\nEnter Phone id: ");
            id = sc.nextInt();
            sc.nextLine();
            if (tree.searchID(id) != null) {
                System.out.println("This id already exists. Please enter another id.");
            }
        } while (tree.searchID(id) != null);
        System.out.print("\nEnter name: ");
        String name = sc.nextLine();
        System.out.print("\nEnter price: ");
        int price = sc.nextInt();
        System.out.print("\nEnter year: ");
        int year = sc.nextInt();
        System.out.print("\nEnter amount: ");
        int amount = sc.nextInt();
        Phone phone = new Phone(id, name, price, year, amount);
        return phone;
    }
    private Phone searchID(int id) {
        Node node = root;
        while (node != null) {
            if (id == node.info.getID()) {
                return node.info;
            } else if (id < node.info.getID()) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
    public void insert(Phone x) {
        Node newNode = new Node(x);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;

            if (x.ID < current.info.ID) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    private Node findMin(Node p) {
        if (p == null) {
            System.out.println("Not found");
            return null;
        }
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.info + " ");
    }
    int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);
            int rDepth = height(p.right);
            if (lDepth > rDepth) {
                return lDepth + 1;
            } else {
                return rDepth + 1;
            }
        }
    }

    int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    void breadth() {
        Queue<Node> q = new LinkedList<Node>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            Node p = q.remove();
            visit(p);
            if (p.left != null) {
                q.add(p.left);
            }
            if (p.right != null) {
                q.add(p.right);
            }
        }
    }

    void preOrder(Node p) {
        if (p != null) {
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public void inOrder(Node p) {
        if (p != null) {
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }

    public void postOrder(Node p) {
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            visit(p);
        }
    }

    public Node search(Phone x){
        return searchByID(root,x);
    }
    private Node searchByID(Node root, Phone key) {
        if(root == null){
            return null;
        }if(root.info.getID() == key.getID()){
            return root;
        }if(root.info.getID() < key.getID()){
            return searchByID(root.left,key);
        }else{
            return searchByID(root.right,key);
        }
    }

    public Phone find_Min_price() {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.info;
    }

    public Phone find_Newest_Phone() {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current.info;
    }

    Phone find_Max_Value() {
        Node p = root;
        Phone max = null;
        while (p != null) {
            if (max == null || p.info.price * p.info.amount > max.price * max.amount) {
                max = p.info;
            }
            if (p.left != null && max.price * max.amount < p.left.info.price * p.left.info.amount) {
                p = p.left;
            } else if (p.right != null && max.price * max.amount < p.right.info.price * p.right.info.amount) {
                p = p.right;
            } else {
                break;
            }
        }
        return max;
    }
    public void deleteByCopying(int x) {
        root = deleteByCopying(root, x);
    }

    private Node deleteByCopying(Node node, int x) {
        if (node == null) {
            return null;
        }

        if (x < node.info.ID) {
            node.left = deleteByCopying(node.left, x);
        } else if (x > node.info.ID) {
            node.right = deleteByCopying(node.right, x);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node temp = findMin(node.right);
            node.info = temp.info;
            node.right = deleteByCopying(node.right, temp.info.ID);
        }

        return node;
    }
    public void deleteByMerging(int x) {
        root = deleteByMerging(root, x);
    }

    private Node deleteByMerging(Node node, int x) {
        if (node == null) {
            return null;
        }

        if (x < node.info.ID) {
            node.left = deleteByMerging(node.left, x);
        } else if (x > node.info.ID) {
            node.right = deleteByMerging(node.right, x);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node temp = node.left;
            while (temp.right != null) {
                temp = temp.right;
            }

            temp.right = node.right;
            node = node.left;
        }

        return node;
    }
    public void deleteNode(int x) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("1.Delete By Copy \n2.Delete By Merging \nEnter your choice : ");
        num = Integer.parseInt(sc.nextLine());
        try {
            if (num == 1) {
                deleteByCopying(x);
            }
            if (num == 2) {
                deleteByMerging(x);
            }
        } catch (NumberFormatException ex) {
            System.out.println("PLEASE ENTER THE NUMBER 1-2 !!! ");
        }
    }
    
    //These are AVL Tree necessary methods, if you want to reBalance the AVL TREE
    
    public void reBalance() {
        root = balance(root);
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }

        int bf = balanceFactor(node);

        if (bf > 1) {
            if (balanceFactor(node.left) >= 0) {
                node = rotateLL(node);
            } else {
                node = rotateLR(node);
            }
        } else if (bf < -1) {
            if (balanceFactor(node.right) <= 0) {
                node = rotateRR(node);
            } else {
                node = rotateRL(node);
            }
        }

        node.left = balance(node.left);
        node.right = balance(node.right);
        return node;
    }

    private Node rotateLL(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        return leftChild;
    }

    private Node rotateRR(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        return rightChild;
    }

    private Node rotateLR(Node node) {
        Node leftChild = node.left;
        node.left = rotateRR(leftChild);
        return rotateLL(node);
    }

    private Node rotateRL(Node node) {
        Node rightChild = node.right;
        node.right = rotateLL(rightChild);
        return rotateRR(node);
    }
}
