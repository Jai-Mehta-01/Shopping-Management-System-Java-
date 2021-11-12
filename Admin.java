package user;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class Admin extends user {
        public int login()
        {
            int cnt=0;
            String us,pass;
            File admin =  new File("admin.txt");
            Scanner fileRead = null;
            try {
                fileRead = new Scanner(admin);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(true) {
                assert fileRead != null;
                if (!fileRead.hasNext()) break;
                us = fileRead.next();
                pass = fileRead.next();
                if(Objects.equals(us, accessUsername()) && Objects.equals(pass, accessPassword())) {
                    System.out.println("Hello Sir");
                    System.out.println("What privileges would you like ?");
                    fileRead.close();
                    cnt=1;
                    break;
                }
            }
            if(cnt==0)
            {
                System.out.println("Sorry incorrect user-name or access_password()");
                return 0;
            }
            return 1;
        }

        public void privileges() throws IOException {
            System.out.println("Press 1 for checking total income till now");
            System.out.println("Press 2 for checking total income on a each product available");
            System.out.println("Press 3 to see user feedback");
            System.out.println("Press 4 to exit");
            int ch;
            Scanner sc = new Scanner(System.in);
            ch = sc.nextInt();
            if(ch==1)
            {
                total_inc();
            }
            else if(ch==2)
            {
                total_on_each();
            }
            else if(ch==3)
            {
                show_user_feedback();
            }
            else if(ch==4)
            {
                System.out.println("Have a great day ahead :)");
                System.exit(1);
            }
            else
            {
                System.out.println("Wrong option detected\nTry Again....");
                privileges();
            }
            System.out.println("Press 1 to choose again and q to quit");
            char ci;
            ci = sc.next().charAt(0);
            if(ci=='1')
            {
                privileges();
            }
            else
            {
                System.out.println("Have a great day ahead :)");

                System.exit(1);
            }
        }

        public void total_inc() throws IOException {
            double total;
            File income =  new File("total_income.txt");
            Scanner fileRead = new Scanner(income);
            total = fileRead.nextDouble();
            System.out.println("Your total income till now is : Rs. "+total);
            fileRead.close();
        }

        public void total_on_each(){
            System.out.println("This feature will be added soon :p");
        }

        public void show_user_feedback() throws IOException {
            File admin =  new File("feedback.txt");
            Scanner fileRead = new Scanner(admin);
            int i=1;
            while(fileRead.hasNext())
            {
                System.out.println(i+". "+ fileRead.nextLine());
                i++;
            }
            fileRead.close();
        }
    }


