package product;
import java.util.Scanner;
public class Catalogue
{
    public void showCatalogue() {
        Scanner sc = new Scanner(System.in);
        char h = 'p';
        do
        {
            System.out.print("******************      LIST OF ITEMS TO BUY     *********************\n");
            System.out.print("1.CLOTHES\n");
            System.out.print("2.BOOKS\n");
            System.out.print("3.WATCHES\n");
            System.out.print("ENTER YOUR CHOICE : ");
            int choice = sc.nextInt();

            if(choice==1)
            {
                Clothes obj = new Clothes();
                obj.showMenu();
            }
            else if(choice==2)
            {
                Books obj = new Books();
                obj.showMenu();
            }
            else if(choice==3)
            {
                Watches obj = new Watches();
                obj.showMenu();
            }
            else
            {
                System.out.print("Sorry Invalid Input :(\n");
                System.out.print("Press d to try again and any other key to quit\n");
                h = sc.next().charAt(0);

            }
        }
        while(h=='d'|| h=='D');
    
    }
}
