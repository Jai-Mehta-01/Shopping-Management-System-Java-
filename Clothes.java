package product;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import user.*;
public class Clothes extends Products implements productmanagement
{
    private String type;
    private String size;
    private String cloth_material;

    public static class trial extends Thread
    {
        public void run()
        {
            System.out.print("Showing the model wearing your desired dress :)\n");
            for(int i = 0;i<10;i++)
            {
                System.out.print("******* Showing TRIAL *******\n");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void showMenu()  {
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.print("Which gender's product would you like to buy\n");
            System.out.print("Male\n");
            System.out.print("Female\n");
            String gen = sc.nextLine();
            gen = gen.toLowerCase();
            if(!gen.equals("male") && !gen.equals("female"))
            {
                System.out.print("Could not recognize gender \n");
                System.out.print("choose again.....\n");
                showMenu();
            }
            System.out.print("Choose a product\nInput the number indicated before the product\n\n");
            System.out.print("1. Trousers\n");
            System.out.print("2. Jeans\n");
            System.out.print("3. Shirt\n");
            System.out.print("4. T-Shirt\n");
            String op1 = sc.nextLine();


            System.out.print("What size you wear\n");
            System.out.print("1. S -> Small\n");
            System.out.print("2. M -> Medium\n");
            System.out.print("3. L -> Large\n");
            System.out.print("4. XL -> Extra Large\n");
            System.out.print("ENTER YOUR CHOICE : ");
            String op2 = sc.nextLine();
            System.out.print("What material Would you like to wear\n");
            System.out.print("1. Denim\n");
            System.out.print("2. Cotton\n");
            System.out.print("3. Synthetic\n");
            System.out.print("ENTER YOUR CHOICE : ");
            String op3 = sc.nextLine();

            int data_mismatch=1;
            File cloth =  new File("clothes.txt");
            Scanner fileRead = null;
            try {
                fileRead = new Scanner(cloth);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String ch1,ch2,ch3,typ,siz,mat;
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
                ch3 = data[2];
                typ = data[3];
                siz = data[4];
                mat = data[5];
                pric = Float.parseFloat(data[6]);

                if(Objects.equals(ch1, op1) && Objects.equals(ch2, op2) && Objects.equals(ch3, op3))
                {
                    type=typ;
                    size=siz;
                    price=pric;
                    cloth_material=mat;
                    data_mismatch=0;
                    break;
                }
            }
            fileRead.close();


            if(data_mismatch==1)
            {
                System.out.print("Wrong size or type selection\nRetrieving to the menu\nTry again\n");
                continue;
            }
            System.out.print("Would you like to see a model wearing this dress??\n");
            System.out.print("Press y for yes and n for no\n");
            char cho = sc.next().charAt(0);
            if(cho=='y')
            {
                trial model = new trial();
                model.start();
                try
                {
                    model.join();
                }
                catch (Exception e)
                {
                    System.out.println("Error in model trial");
                }
            }
            System.out.print(type+" "+size+" "+cloth_material+" "+"Rs."+price+'\n');
            System.out.print("Would you like to buy it\nEnter 1 for Yes or 2 to go back : ");
            int d = sc.nextInt();
            Customer obj = new Customer();
            File file= new File("current_user.txt");
            Scanner filer = null;
            try
            {
                filer = new Scanner(file);
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            String us="";
            assert filer != null;
            if(filer.hasNext())
            us=filer.next();
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
                            Catalogue show1 = new Catalogue();
                            show1.showCatalogue();
                        }
                    }
                    if (u == 'q') {
                        obj.show_invoice();
                        System.exit(1);
                    }
                    if (u == 'a') {
                        showMenu();
                    }
                    if (u == 't') {
                        obj.show_the_cart_total();
                        System.out.print('\n' + '\n');
                    }
                    if(u == 'c')    break;
                }
                break;
            }
            else if(d==2)
            {
                showMenu();
            }
            break;


        }while(true);
    }

    @Override
    public void addToCart() throws IOException {
        System.out.print("Added to cart successfully!!\n");
        File output = new File("current_user.txt");
        FileWriter fwrite = new FileWriter(output,true);
        fwrite.write("\n"+getId()+" "+"cloth "+type+"("+size+")"+"("+cloth_material+")"+" "+getQuantity()+" "+totalPrice());
        fwrite.close();
    }
}
