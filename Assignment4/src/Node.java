/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Hai
 */
public class Node {
    Phone info; //use info.ID as the key value for node
    Node left,right;
    
    Node(Phone x) {
        this.info = x;
    }
}
