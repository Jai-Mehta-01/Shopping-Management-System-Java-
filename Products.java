package product;

import user.*;
import java.util.Scanner;

abstract public class Products
{
    protected int quantity;
    protected float price;
    protected int id;
    public static int counter=0;
    protected Customer obj = new Customer();


    public void setQuantity()
    {
        Scanner sc = new Scanner(System.in);
        quantity = sc.nextInt();
    }

    public int getQuantity()
    {
        return quantity;
    }

    public float getPrice()
    {
        return price;
    }

    public float totalPrice()
    {
        float total=getQuantity()*getPrice();
        System.out.print("Your total would be => "+total);
        return total;
    }

    public int getId()
    {
        counter+=getQuantity();
        id =counter;
        return id;
    }

}
