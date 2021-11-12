package product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Watches extends Products implements productmanagement
{
    Catalogue viewCatalogue = new Catalogue();
    private String type_of_watch;
    private String material_of_watch;

    @Override
    public void showMenu()
    {
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.print("1. Clocks\n");
            System.out.print("2. Wrist product.Watches for men\n");
            System.out.print("3. Wrist product.Watches for Women\n");
            System.out.print("4. product.Watches for kids\n");
            System.out.print("ENTER YOUR CHOICE : ");
            String op1 = sc.nextLine();
            System.out.print("What material would you like to wear\n");
            System.out.print("1. Steel\n");
            System.out.print("2. Gold\n");
            System.out.print("3. Silver\n");
            String op2 = sc.nextLine();


            int data_mismatch=1;
            File watches = new File("watches.txt");
            Scanner fileRead = null;
            try {
                fileRead = new Scanner(watches);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String ch1,ch2,typ,mat;
            float pric;
            String[] data;
            while(true)
            {
                assert fileRead != null;
                if (!fileRead.hasNextLine()) break;
                String s = fileRead.nextLine();
                data = s.split(" ");
                ch1 = data[0];
                ch2 = data[1];
                typ = data[2];
                mat = data[3];
                pric = Float.parseFloat(data[4]);
                if(Objects.equals(ch1, op1) && Objects.equals(ch2, op2))
                {
                    type_of_watch=typ;
                    material_of_watch=mat;
                    price=pric;
                    data_mismatch=0;
                    break;
                }
            }
            fileRead.close();
            if(data_mismatch==1)
            {
                System.out.print("Wrong type selection\nRetrieving to the menu\nTry again\n");
                continue;
            }
            System.out.println();
            System.out.print(type_of_watch+" "+material_of_watch+" "+"Rs."+price+'\n');
            System.out.println();
            System.out.print("Would you like to buy it\nEnter 1 for Yes  or 2 to go back : ");
            int d = sc.nextInt();
            File file = new File("current_user.txt");
            Scanner f1 = null;
            try {
                f1 = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String us="";
            assert f1 != null;
            if(f1.hasNext())
            us=f1.next();
            obj.setUsername(us);
            if(d==1)
            {
                System.out.print("Tell the quantity : ");
                setQuantity();
                while(true)
                {
                    System.out.print("Press c to add to cart\n");
                    System.out.print("Press a to choose again\n");
                    System.out.print("Press q to show bill and quit\n");
                    System.out.print("Press t to get cart total\n");
                    char u = sc.next().charAt(0);
                    if (u == 'c') {

                        try {
                            addToCart();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.print("\nTo see your bill press b and to continue shopping Press any other key\n");

                        char x = sc.next().charAt(0);
                        if (x == 'B' || x == 'b') {
                            obj.show_invoice();
                        } else {

                            viewCatalogue.showCatalogue();
                        }
                    }
                    if (u == 'q') {
                        obj.show_the_cart_total();
                        System.exit(1);
                    }
                    if (u == 'a') {
                        showMenu();
                    }
                    if (u == 't') {
                        obj.show_the_cart_total();
                        System.out.println();
                    }
                    if(u == 'c')    break;
                }

            }
            break;
        }while(true);
    }

    @Override
    public void addToCart() throws IOException
    {
        System.out.print("Added to cart successfully\n");
        File output = new File("current_user.txt");
        FileWriter fwrite = new FileWriter(output,true);
        fwrite.write("\n"+getId()+" "+"watch "+type_of_watch+"("+material_of_watch+") "+getQuantity()+" "+totalPrice());
        fwrite.close();
    }
}
