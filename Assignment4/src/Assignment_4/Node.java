/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_4;

/**
 *
 * @author Admin
 */
public class Node {
    public Phone infor;
    public int height = 1;
    public Node left = null,right = null;

    public Node() {
    }

    public Node(Phone x) {
        this.infor = x;
        this.height = 1;
    }
    
}
