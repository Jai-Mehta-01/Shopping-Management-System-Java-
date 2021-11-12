package billing;
import product.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bill
{
    public void show_bill()
    {
        String us = "", mob ="", em="";
        File myFile = new File("current_user.txt");
        try
        {
            Scanner sc = new Scanner(myFile);
            int f=0;
            while(f<=2 && sc.hasNext())
            {
                if(f==0)
                {
                    us = sc.next();
                }
                else if(f==1)
                {
                    mob = sc.next();
                }
                else if(f==2)
                {
                    em = sc.next();
                }
                f++;
            }
            f=1;
            System.out.println("Username : "+us);
            System.out.println("Mobile No: "+mob);
            System.out.println("Email Id : "+em);
            System.out.println();
            String prod_type;
            String prod;
            String ids = null;
            String total_price;
            String quantity;
            while(sc.hasNext())
            {
                if(f%5==1)
                {
                    ids = sc.next();
                    System.out.println("Id : "+ids);
                }
                else if(f%5==2)
                {
                    prod_type = sc.next();
                    System.out.println("Product Type : "+prod_type);
                }
                else if(f%5==3)
                {
                    prod = sc.next();
                    System.out.println("Product : "+prod);
                }
                else if(f%5==4)
                {
                    quantity = sc.next();
                    System.out.println("Quantity : "+quantity);
                }
                else if(f%5==0)
                {
                    total_price = sc.next();
                    System.out.println("Total Price : Rs"+total_price);
                    System.out.println();
                }
                f++;
            }
            System.out.println("Total number of items bought : "+ids);
            System.out.println();
            show_cart_total();
            System.out.println();
            char choice;
            while(true)
            {
                System.out.println("Would you like to make payment?");
                System.out.println("Press y for yes or r to return to catalogue or q to quit");

                Scanner sc1 = new Scanner(System.in);
                choice = sc1.next().charAt(0);
                if(choice == 'y' || choice == 'Y')
                {
                    proceed_to_pay();
                    break;
                }
                else if(choice == 'q' || choice == 'Q')
                {
                    System.out.println("You have been logged out!!");
                    System.out.println("Have a nice day :)");
                    System.exit(0);
                }
                else if(choice == 'r' || choice =='R')
                {
                    Catalogue random = new Catalogue() ;
                    random.showCatalogue();
                    break;
                }
                else
                {
                    System.out.print("Invalid Choice....Try Again");
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Err.....cannot find records!!!");
            System.out.println("Please try again after some time!");
        }
    }
    public void proceed_to_pay()
    {
        Payment pay = new Payment();
        System.out.println();
        pay.verify_user();
        System.out.println();
        pay.get_payment_mode();
        System.out.println();
        pay.display_payment_details();
        System.out.println();
    }
    public void show_cart_total()
    {
        File myFile = new File("current_user.txt");
        try
        {
            Scanner sc = new Scanner(myFile);
            double total_price;
            double cart_total=0;
            String temp;
            if(sc.hasNextLine())
            {
                sc.nextLine();
            }
            int f = 1;
            while(sc.hasNext())
            {
                temp = sc.next();
                if(f%5==0)
                {
                    total_price = Double.parseDouble(temp);
                    cart_total += total_price;
                }
                f++;
            }
            System.out.println("Your cart total is : Rs "+cart_total);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Err.....cannot find records!!!");
            System.out.println("Please try again after some time!");
        }
    }
}

