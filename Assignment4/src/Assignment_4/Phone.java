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
public class Phone {
    int Id;
    int price;
    int year;
    int amount;

    public Phone() {
    }

    public Phone(int Id, int price, int year, int amount) {
        this.Id = Id;
        this.price = price;
        this.year = year;
        this.amount = amount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
