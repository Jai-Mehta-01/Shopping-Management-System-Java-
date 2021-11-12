package billing;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Payment extends Thread
{
    private String payment_mode;

    public void verify_user()
    {
        System.out.println("Verification of account.....");
        System.out.println("Please wait for a while....");
        System.out.println();
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("----------------------Verified----------------------");
    }
    public void display_payment_details() {
        System.out.println("Processing Payment details....");
        System.out.println("Please wait...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Payment Successful!!!");
        File myFile = new File("total_income.txt");
        double tot = 0;
        try {
            Scanner sc = new Scanner(myFile);
            if (sc.hasNextLine()) {
                String temp = sc.nextLine();
                tot = Double.parseDouble(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Err.....cannot find records!!!");
            System.out.println("Please try again after some time!");
        }
        File cart = new File("current_user.txt");
        double total_price;
        double cart_total = 0;
        try {
            Scanner sc = new Scanner(cart);
            String temp;
            if (sc.hasNextLine()) {
                temp = sc.nextLine();
            }
            int f = 1;
            while (sc.hasNext()) {
                temp = sc.next();
                if (f % 5 == 0) {
                    total_price = Double.parseDouble(temp);
                    cart_total += total_price;
                }
                f++;
            }
            tot += cart_total;
            FileWriter fout = new FileWriter("total_income.txt");
            temp = String.valueOf(tot);
            fout.write(temp);
            fout.close();
            System.out.println("You made payment through " + payment_mode);

            int rand = (int) (Math.random() * (double) 1000000);

            System.out.println("Your payment id generated is " + rand);
            System.out.println();
            System.out.println("A code has been sent to your registered mobile number");
            System.out.println("Kindly make sure that it matches with the generated id");
            System.out.println("In case of mismatch kindly contact Support at - 8787878787");
            System.out.println();

            new feedbackGUI();
        } catch (IOException e)
        {
            System.out.println("Err.....cannot find records!!!");
            System.out.println("Please try again after some time!");
        }
    }
    public void get_payment_mode()
    {
        System.out.println("Enter your desired mode of payment");
        System.out.println("1. Debit Card");
        System.out.println("2. Credit Card");
        System.out.println("3. UPI");
        System.out.println("4. PAYTM");
        char ch;
        Scanner sc = new Scanner(System.in);
        ch = sc.next().charAt(0);
        //system(clear);
        if(ch=='1')
        {
            payment_mode = "Debit Card";
        }
        else if(ch=='2')
        {
            payment_mode = "Credit Card";
        }
        else if(ch=='3')
        {
            payment_mode = "UPI";
        }
        else if(ch=='4')
        {
            payment_mode = "PAYTM";
        }
        else
        {
            System.out.println("Err....Invalid Input");
            System.out.println("Choose again");
            get_payment_mode();
        }
    }
}
