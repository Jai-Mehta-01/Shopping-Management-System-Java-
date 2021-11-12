package product;

import java.io.File;

import user.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Books extends Products implements productmanagement
{
    Catalogue viewCatalogue = new Catalogue();
    private String language;
    private String genre;
    private String author;
    private String ratings;
    private String book_name;

    public class preview extends Thread
    {
        public void run()
        {
            System.out.print("********  Showing the preview of " + book_name + "  ***********" + '\n');
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("********  Showing contents from one of the chapters  ********" + "\n");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("A very nice book to read \nRecommended by most critics\nA must buy\n\n");
        }
    }

    public void showBookInfo()
    {
        System.out.print("Language: "+language+'\n');
        System.out.print("Genre: "+genre+'\n');
        System.out.print("Book Name: "+book_name+'\n');
        System.out.print("Author: "+author+'\n');
        System.out.print("Ratings: "+ratings+"/5"+'\n');
        System.out.print("Price: Rs."+price+'\n');
    }


    @Override
    public void showMenu()  {
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.print("Which language book you read\n");
            System.out.print("1. ENGLISH\n");
            System.out.print("2. HINDI\n");
            System.out.print("3. FRENCH\n");
            System.out.print("4. LATIN\n");
            System.out.print("5. SPANISH\n");
            System.out.print("ENTER YOUR CHOICE\n");
            String op1 = sc.nextLine();

            System.out.print("What genre you like\n");
            System.out.print("1. FANTASY\n");
            System.out.print("2. BIOGRAPHY/AUTO-BIOGRAPHY\n");
            System.out.print("3. ACTION and THRILLER\n");
            System.out.print("4. SCIENCE-FICTION\n");
            System.out.print("5. SUSPENSE(MYSTERY)\n");
            System.out.print("ENTER YOUR CHOICE\n");
            String op2 = sc.nextLine();

            String op3="";
            if(Objects.equals(op2, "1"))
            {
                System.out.print("Select the book\n");
                System.out.print("1. Harry Potter and the Half-Blood Prince\n");
                System.out.print("2. Narnia-The Witch The Wizard and the Wardrobe\n");
                System.out.print("3. Alice in Wonderland\n");
                System.out.print("ENTER YOUR CHOICE\n");
                op3 = sc.nextLine();
//                system("clear");
            }
            else if(Objects.equals(op2, "2"))
            {
                System.out.print("Select the book\n");
                System.out.print("1. Playing it My Way\n");
                System.out.print("2. Steve-Jobs\n");
                System.out.print("3. The Story of My Life\n");
                System.out.print("ENTER YOUR CHOICE\n");
                op3 = sc.nextLine();
//                system("clear");
            }
            else if(Objects.equals(op2, "3"))
            {
                System.out.print("Select the book\n");
                System.out.print("1. HUNGER GAMES\n");
                System.out.print("2. BATMAN RISES\n");
                System.out.print("3. Z WARS\n");
                System.out.print("ENTER YOUR CHOICE\n");
                op3 = sc.nextLine();
//                system("clear");
            }
            else if(Objects.equals(op2, "4"))
            {
                System.out.print("Select the book\n");
                System.out.print("1. Transformers\n");
                System.out.print("2. Star Wars\n");
                System.out.print("3. Mandalorian\n");
                System.out.print("ENTER YOUR CHOICE\n");
                op3 = sc.nextLine();
//                system("clear");
            }
            else if(Objects.equals(op2, "5"))
            {
                System.out.print("Select the book\n");
                System.out.print("1. Sherlock\n");
                System.out.print("2. Insidious\n");
                System.out.print("3. lupin\n");
                System.out.print("ENTER YOUR CHOICE\n");
                op3 = sc.nextLine();
//                system("clear");
            }

            String ch1,ch2,ch3,lan,gen,book_nam,aut,rat;
            float pric;
            int data_mismatch=1;
            File book = new File("books.txt");
            Scanner fileRead = null;
            try {
                fileRead = new Scanner(book);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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
                lan = data[3];
                gen = data[4];
                book_nam = data[5];
                aut = data[6];
                rat = data[7];
                pric = Float.parseFloat(data[8]);

                if(Objects.equals(ch1, op1) && Objects.equals(ch2, op2) && Objects.equals(ch3, op3))
                {
                    language=lan;
                    genre=gen;
                    author=aut;
                    book_name=book_nam;
                    ratings=rat;
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
            System.out.print("Showing book info\n");
            showBookInfo();
            System.out.print("Would you like to see the books's preview ?\n");
            System.out.print("Press y for yes and n for no\n");
            char choi = sc.next().charAt(0);
//            system("clear");
            choi = Character.toLowerCase(choi);
            Customer obj = new Customer();
            File file = new File("current_user.txt");
            Scanner filer = null;
            try {
                filer = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String us="";
            assert filer != null;
            if(filer.hasNext())
                us=filer.next();
            obj.setUsername(us);
            if(choi=='y')
            {
                preview model = new preview();
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

            System.out.print("Would you like to buy it\nEnter 1 for Yes  or 2 to go back : ");
            int d = sc.nextInt();
//            system("clear");
            if(d==1)
            {
                System.out.print("Tell the quantity : ");
                setQuantity();
                while(true)
                {
                    System.out.print("Press c to add to cart\n");
                    System.out.print("Press a to choose again\n");
                    System.out.print("Press q to show bill and quit\n");
                    System.out.print("Press t to get the cart total\n");
                    char u;
                    u = sc.next().charAt(0);

                    if (u == 'c')
                    {

                        try {
                            addToCart();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.print("\nTo see your bill press b and to continue shopping Press any other key\n");

                        char x = sc.next().charAt(0);
//                    system("clear");
                        if (x == 'B' || x == 'b')
                        {
                            obj.show_invoice();
                        }
                        else
                        {

                            viewCatalogue.showCatalogue();
                        }
                    }
                    if (u == 'q') {
                        // System.out.print()+"Your total bill is: ";
                        obj.show_invoice();
                        System.exit(1);
                    }
                    if (u == 'a') {
                        showMenu();
                    }
                    if (u == 't') {
//                    System.out.print("Your bill till now is : ");
                        obj.show_the_cart_total();
                        System.out.println();
                    }
                    if(u == 'c')  break;
                }
            }
            break;
        }while(true);
    }

    @Override
    public void addToCart() throws IOException
    {
        System.out.print("Added to cart successfully!!\n");
        File output = new File("current_user.txt");
        FileWriter fwrite = new FileWriter(output,true);
        fwrite.write("\n"+getId()+" "+"book "+book_name+" "+getQuantity()+" "+totalPrice());
        fwrite.close();
    }
}
