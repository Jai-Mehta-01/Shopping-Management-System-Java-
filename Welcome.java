import java.awt.*;
import java.io.IOException;
import java.util.*;
import support.Client;
import user.*;
import javax.swing.*;

public class Welcome
{
    Scanner sc = new Scanner(System.in);
    public void showHomePage() {
            System.out.print('\n');
            JFrame wel = new JFrame("WELCOME");
            JDialog jd = new JDialog(wel,"WELCOME",true);
            wel.setFocusableWindowState(false);
            wel.setVisible(true);
            wel.setSize(1920,100);

            JLabel label = new JLabel("* * * *   Welcome to the Shopping Center * * * *",JLabel.CENTER);
            label.setFont(new Font("Serif",Font.BOLD,22));
            jd.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            wel.getContentPane().setBackground(Color.black);
            label.setForeground(Color.YELLOW);
            wel.add(label);

            wel.setVisible(true);
            System.out.print("1. LOGIN\n");
            System.out.print("2. SIGN UP\n");
            System.out.print("3. ADMIN LOGIN\n");
            System.out.print("4. EXIT\n");
            System.out.print("5. Support\n");
            System.out.print("Enter your choice as the number indicated before the choices:\n");
            int ch;
            ch = sc.nextInt();

            if(ch==1)
            {
                Customer old_customer = new Customer();
    
                System.out.print("ENTER USERNAME : ");
                old_customer.inputUsername();
                System.out.print("ENTER PASSWORD : ");
                old_customer.inputPassword();

                try {
                    if(old_customer.login()==0)
                    {
                        showHomePage();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    
            else if(ch==2)
            {
    
                Customer new_user = new Customer();
    
                System.out.print("ENTER USERNAME : ");
                new_user.inputUsername();
                System.out.print("ENTER PASSWORD : ");
                new_user.inputPassword();
                try {
                    if(new_user.signup()==0)
                    {

                        showHomePage();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    
            else if(ch==3)
            {
                Admin an_admin = new Admin();
    
                System.out.print("ENTER USERNAME : ");
                an_admin.inputUsername();
                System.out.print("ENTER PASSWORD : ");
                an_admin.inputPassword();
                if(an_admin.login()==0)
                {
                    showHomePage();
                }
    
                else
                {
                    try {
                        an_admin.privileges();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    
    
            else if(ch==4)
            {
                System.out.print("You have been exited out of the shopping menu\nHave a nice day :)\nVisit again...\n");
                System.exit(1);
            }
            else if(ch==5)
            {
                try {
                    Client.clientMain();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    
            else
            {
                System.out.print("Invalid input\n");
                System.out.print("Please choose only from the four options as 1,2,3 or 4 ...\ntry again\n");
                showHomePage();
            }
        }
    }

