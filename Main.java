import product.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        File ofs = new File("current_user.txt");
        try
        {
             ofs.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Welcome obj1 = new Welcome();
        Catalogue obj2 = new Catalogue();
        obj1.showHomePage();
        obj2.showCatalogue();
    }


}
