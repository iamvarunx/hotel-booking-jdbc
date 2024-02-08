package database;

import java.sql.*;
import utill.getSet;

public class Login extends dbConnect {

    public int login(String email, String password) throws SQLException {
        dbConnect.connect();
        PreparedStatement login_input = conn
                .prepareStatement("Select name,user_id,role from user_details where email= ? AND password= ?;");
        try {
            login_input.setString(1, email);
            login_input.setString(2, password);
            ResultSet rs = login_input.executeQuery();
            rs.next();
            // getter Setter
            getSet.setName(rs.getString(1));
            getSet.setUserId(rs.getInt(2));
            String role = rs.getString(3).toLowerCase();
            getSet.setRole(role);

            if (role.equals("user")) {
                return 1;
            }
            if (role.equals("admin")) {
                return 2;
            }
        } catch (Exception e) {
            System.out.print("user name or password does not match");
        }
        return -1;
    }
}
