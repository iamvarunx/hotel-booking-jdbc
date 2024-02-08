import admin.*;
import database.Login;
import database.dbConnect;
import database.dbInsert;
import user.User;
import utill.scanCon;

public class App extends scanCon {
    public static void main(String[] args) throws Exception {
        try {
            dbConnect.connect();
        } catch (Exception e) {
            System.out.println("DB NOT Connected");
        }

        while (true) {
            System.out.println("        Welcome to Hotel Booking System");
            System.out.println("               1.Login");
            System.out.println("               2.Sign UP");
            System.out.println("               3.Exit");
            System.out.println("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("  Welcome to Sign Up page ");
                System.out.print("         Enter Email: ");
                String email = sc.nextLine();
                System.out.print("         Enter Passward: ");
                String passward = sc.nextLine();
                Login log = new Login();
                int role = log.login(email, passward);
                if (role == 1) {
                    User.start();
                } else if (role == 2) {
                    Admin.start();
                }
            } else if (choice == 2) {
                System.out.println("  Welcome to Sign Up page ");
                System.out.print("         Enter Name: ");
                String name = sc.nextLine();
                System.out.print("         Enter Email: ");
                String email = sc.nextLine();
                System.out.print("         Enter Passward: ");
                String passward = sc.nextLine();
                System.out.print("         Enter Phone no: ");
                String phone = sc.nextLine();

                try {
                    dbInsert insert = new dbInsert();
                    insert.createUser(name, email, phone, passward, "user");
                } catch (Exception e) {
                    System.out.print(e);

                }
            } else if (choice == 3) {
                break;
            }
        }
    }
}
