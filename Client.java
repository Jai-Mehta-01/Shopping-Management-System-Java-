package support;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    static Scanner sc = new Scanner(System.in);
    public static Socket chat;

    static {
        try
        {
            chat = new Socket("localhost",143);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static private String writ="",read="";
    static DataOutputStream dopt;

    static {
        try {
            dopt = new DataOutputStream(chat.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static DataInputStream dint;

    static {
        try {
            dint = new DataInputStream(chat.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loginSupport()
    {
        try
        {
            read = dint.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Support:- "+read);
        System.out.println("We are looking into your issue");
        System.out.println("To quit press n, to continue press any other key");
        char ch = sc.next().charAt(0);
        if(ch=='n')
        {
            System.exit(1);
        }
    }
    private void productSupport() throws IOException {
        read = dint.readUTF();
        System.out.println("Support:- "+read);
        System.out.println("Press 1 for return request");
        System.out.println("Press 2 for replacement request");
        System.out.println("Press 3 for complaint booking");
        writ = sc.nextLine();
        dopt.writeUTF(writ);
        dopt.flush();
        read = dint.readUTF();
        System.out.println("Server:- "+ read);
        System.out.println("To quit press n, to continue press any other key");
        char ch = sc.next().charAt(0);
        if(ch=='n')
        {
            System.exit(1);
        }
    }
    private void paymentSupport() throws IOException {
        read = dint.readUTF();
        System.out.println("Support:- "+read);
        System.out.println("Press 1 for code issue");
        System.out.println("Press 2 for payment failure");
        System.out.println("Press 3 for complaint booking");
        writ = sc.nextLine();
        dopt.writeUTF(writ);
        dopt.flush();
        read = dint.readUTF();
        System.out.println("Server:- "+ read);
        System.out.println("To quit press n, to continue press any other key");
        char ch = sc.next().charAt(0);
        if(ch=='n')
        {
            System.exit(1);
        }
    }
    private void manualSupport() throws IOException {
        System.out.println("To exit manual support type over in lowercase");
        DataOutputStream dopt = new DataOutputStream(chat.getOutputStream());
        DataInputStream dint = new DataInputStream(chat.getInputStream());
        String writ="",read;
        Scanner sc = new Scanner(System.in);
        while(!writ.equals("over"))
        {
            read = dint.readUTF();
            System.out.println("Server:- "+ read);
            writ = sc.nextLine();
            dopt.writeUTF(writ);
            dopt.flush();
        }
        dopt.close();
        System.out.println("To quit press n, to continue press any other key");
        char choice = sc.next().charAt(0);
        if(choice=='n')
        {
            System.exit(1);
        }
    }

    public void supportMenu() throws IOException {
        System.out.println("Press 1 for login and signup support");
        System.out.println("Press 2 for payment support");
        System.out.println("Press 3 for Product support");
        System.out.println("Press 4 for manual support/chat");
        String choice = sc.nextLine();
        dopt.writeUTF(choice);
        dopt.flush();
        switch (choice) {
            case "1" -> loginSupport();
            case "2" -> paymentSupport();
            case "3" -> productSupport();
            case "4" -> manualSupport();
        }

    }
    public static void clientMain() throws IOException {

        System.out.println("Welcome to  support system:");
        Client cl = new Client();
        cl.supportMenu();
        dopt.close();
        chat.close();
    }
}
