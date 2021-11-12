package user;
import billing.*;
import java.awt.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;


    public class Customer extends user{
        private final Bill invoice = new Bill();
        public int login() throws IOException {
            int cnt=0;
            String us,pass;
            File admin =  new File("database.txt");
            Scanner fileRead = new Scanner(admin);
            while(fileRead.hasNext())
            {
                us = fileRead.next();
                pass = fileRead.next();
                if(Objects.equals(us, accessUsername()) && Objects.equals(pass, accessPassword()))
                {
                    System.out.println("Login successful.\nHello "+us);
                    cnt=1;
                    String names,num,email;
                    File open = new File("contact.txt");
                    Scanner openRead = new Scanner(open);
                    File current = new File("current_user.txt");
                    FileWriter current_write = new FileWriter(current);
                    while(openRead.hasNext())
                    {
                        names = openRead.next();
                        num = openRead.next();
                        email = openRead.next();
                        if(Objects.equals(names, accessUsername()))
                        {
                            System.out.println("Phone number : " + num);
                            System.out.println("Email : " + email);
                            current_write.write(names+" "+num+" "+email);
                            current_write.close();
                            break;
                        }
                    }
                    openRead.close();
                    break;
                }
                else if(Objects.equals(us, accessUsername()))
                {
                    cnt=-1;
                    break;
                }

            }
            fileRead.close();
            if(cnt==-1)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("Sorry :(");
                System.out.println("Password is incorrect\nLogin Failed.");
                return 0;
            }
            else if(cnt==0)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("User could not be found.\nTry again with correct credentials or register as a new user");
                return 0;
            }
            return 1;
        }
        public int signup() throws IOException {
            String us;
            File database = new File("database.txt");
            Scanner databaseRead = new Scanner(database);
            Scanner sc = new Scanner(System.in);
            while(databaseRead.hasNext())
            {
                us = databaseRead.next();
                databaseRead.next();
                if(Objects.equals(us, accessUsername()))
                {
                    System.out.println("Username already taken");
                    System.out.println("Try again with a different username...");
                    return 0;
                }
            }
            databaseRead.close();
            File data = new File("database.txt");
            FileWriter data_write = new FileWriter(data,true);
            data_write.write(accessUsername()+" "+accessPassword()+" "+'\n');
            data_write.close();
            System.out.println("ENTER YOUR PHONE NUMBER : ");
            String number;
            number = sc.nextLine();
            System.out.println("ENTER EMAIL ADDRESS : ");
            String email;
            email = sc.nextLine();
            String name=accessUsername();

            File contact = new File("contact.txt");
            FileWriter UpdateContact = new FileWriter(contact, true);
            UpdateContact.write(name+" "+number+" "+email+'\n');
            UpdateContact.close();

            File current = new File("current_user.txt");
            FileWriter Current_write = new FileWriter(current); //removed append=true
            Current_write.write(name+" "+number+" "+email);
            Current_write.close();
            System.out.println("Successfully registered :)\nContinue shopping");
            return 1;
        }
        public void show_invoice()
        {
            invoice.show_bill();
        }
        public void show_the_cart_total(){
            invoice.show_cart_total();
        }
    }

