
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

    public Phone input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Phone id: ");
        int id = sc.nextInt();
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

    public void insert(Phone x) {
        Node node = new Node(x);
        if (root == null) {
            root = node;
        } else {
            Node cur = root;
            Node f = null;
            while (cur != null) {
                if (cur.info.ID == x.ID) {
                    System.out.println("Key " + x.ID + " is existed");
                    return;
                }
                f = cur;
                if (cur.info.ID > x.ID) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            if (f.info.ID > x.ID) {
                f.left = node;
            } else {
                f.right = node;
            }
        }
    }

    public void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.info + " ");
    }

    public int height(Node p) {
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

    public int balanceFactor(Node p) {
        if (p == null) {
            return 0;
        }
        return height(p.left) - height(p.right);
    }

    public void breadth() {
        if (root == null) {
            System.out.println("AVL Tree is empty");
            return;
        }
        System.out.println(root.info.getID() + " ");
        breathTraversalHelper(root);
    }

    private void breathTraversalHelper(Node root) {
        Queue<Node> NodeQueue = new LinkedList<Node>();
        NodeQueue.add(root);
        while (!NodeQueue.isEmpty()) {
            Node frontNode = NodeQueue.peek();
            visit(frontNode);
            if (frontNode.left != null) {
                NodeQueue.add(frontNode.right);
            }
            NodeQueue.remove();
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
            System.out.print(p.info.ID + " ");
            inOrder(p.right);
        }
    }

    public void postOrder(Node p) {
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.info.ID + " ");
        }
    }

    public Node search(Phone x) {
        Node t = root;
        while (t != null) {
            if (x.ID < t.info.ID) {
                t = t.left;
            } else if (x.ID > t.info.ID) {
                t = t.right;
            } else {
                return t;
            }
        }
        return null;
    }

    public Node search(Node p, int x) {
        if (p == null) {
            return null;
        }
        if (p.info.ID == x) {
            return p;
        } else if (p.info.ID > x) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
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

    public Phone find_Max_Value() {
        if (root == null) {
            return null;
        }

        Node current = root;
        Phone maxPhone = null;
        int maxPriceAmount = Integer.MIN_VALUE;

        while (current != null) {
            int priceAmount = current.info.price * current.info.amount;
            if (priceAmount > maxPriceAmount) {
                maxPriceAmount = priceAmount;
                maxPhone = current.info;
            }

            if (current.left != null) {
                priceAmount = current.left.info.price * current.left.info.amount;
                if (priceAmount > maxPriceAmount) {
                    maxPriceAmount = priceAmount;
                    maxPhone = current.left.info;
                }
            }

            current = current.right;
        }

        return maxPhone;

    }

    public void deleteByMerging(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exist, deletion failed");
            return;
        }
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info.ID > p.info.ID) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left != null && p.right != null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2. p has left child only
        else if (p.left != null && p.right != null) {
            if (f == null) {
                p.left = root;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3. p has right child only
        else if (p.left != null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4. p has both child
        else if (p.left != null && p.right != null) {
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            Node rp = p.right;
            q.right = rp;
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
    }

    public void deleteByCopy(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exist, deletion failed");
            return;
        }
        Node f = null;
        Node q = root;
        while (q != p) {
            f = q;
            if (p.info.ID > q.info.ID) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1. p has no child 
        if (p.left != null && p.right != null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2. p has left child only
        else if (p.left != null && p.right != null) {
            if (f == null) {
                p.left = root;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3. p has right child only
        else if (p.left != null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4. p has both child
        else if (p.left != null && p.right != null) {
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            p.info = q.info;
            if (f == null) {
                q.left = p.left;
            } else {
                f.right = q.left;
            }
        }
    }

    public void deleteNode(int x) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("1.Delete By Copy \n2.Delete By Merging \nEnter your choice : ");
        num = Integer.parseInt(sc.nextLine());
        try {
            if (num == 1) {
                deleteByCopy(x);
            }
            if (num == 2) {
                deleteByMerging(x);
            }
        } catch (NumberFormatException ex) {
            System.out.println("PLEASE ENTER THE NUMBER 1-2 !!! ");
        }
    }
}
