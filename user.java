package user;
import java.util.*;
    abstract public class user
    {
        private String username;
        private String password;
        public String accessUsername() {
            return username;
        }
        public String accessPassword() {
            return password;
        }
        public void inputUsername()
        {
            Scanner s1 = new Scanner(System.in);
            this.username = s1.nextLine();
        }
        public void inputPassword(){
            Scanner s2 = new Scanner(System.in);
            this.password = s2.nextLine();
        }
        public void setUsername(String username) {
            this.username=username;
        }
    }


