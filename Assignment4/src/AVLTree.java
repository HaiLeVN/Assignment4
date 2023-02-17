
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
    public Phone searchID(int id) {
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

    int balanceFactor(Node p) {
        if (p == null) {
            return 0;
        } else {
            return height(p.left) - height(p.right);
        }
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
            System.out.println("ID: " + p.info.ID + ", Name: " + p.info.name + ", Price: " + p.info.price + ", Year: " + p.info.year + ", Amount: " + p.info.amount);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println("ID: " + root.info.ID + ", Name: " + root.info.name + ", Price: " + root.info.price + ", Year: " + root.info.year + ", Amount: " + root.info.amount);
            inOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println("ID: " + root.info.ID + ", Name: " + root.info.name + ", Price: " + root.info.price + ", Year: " + root.info.year + ", Amount: " + root.info.amount);

        }
    }
    public Node search() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the ID of the phone to search for: ");
        int id = sc.nextInt();
        Node t = root;
        while (t != null) {
            if (id < t.info.ID) {
                t = t.left;
            } else if (id > t.info.ID) {
                t = t.right;
            } else {
        System.out.println("Phone with ID " + t.info );

                return t;
            }
        }
        System.out.println("Phone with ID " + id + " is not found.");
        return null;
    }

    public Phone find_Min_price() {
        if (root == null) {
            return null;
        }
        Node nodeL = root;
        int minPriceL = root.info.getPrice();
        while (nodeL != null) {
            if (nodeL.info.getPrice() < minPriceL) {
                minPriceL = nodeL.info.getPrice();
            }
            nodeL = nodeL.left;
        }

        int minPriceR = root.info.getPrice();
        Node nodeR = root;
        while (nodeR != null) {
            if (nodeR.info.getPrice() < minPriceR) {
                minPriceR = nodeR.info.getPrice();
            }
            nodeR = nodeR.right;
        }

        if (minPriceL <= minPriceR) {
            int min = minPriceL;
            Node node1 = root;
            while (node1 != null) {
                if (node1.info.getPrice() == min) {
                    return node1.info;
                } else if (node1.info.getPrice() < min) {
                    min = node1.info.getPrice();
                }
                node1 = node1.left;
            }
        } else {
            int min = minPriceR;
            Node node2 = root;
            while (node2 != null) {
                if (node2.info.getPrice() == min) {
                    return node2.info;
                } else if (node2.info.getPrice() < min) {
                    min = node2.info.getPrice();
                }
                node2 = node2.right;
            }
        }
        return null;
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
