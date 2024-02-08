package database;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

import utill.booking_getset;
public class dbInsert extends dbConnect {
    
    public void createUser(String name,String email,String phone,String password,String role) throws SQLException
    {
        Statement stmt = conn.createStatement();
        ResultSet user_check=stmt.executeQuery("SELECT user_id FROM user_details WHERE email='"+email+"'");
        if(user_check.next())
        {
            System.out.println("user already exists");
            return;
        }

        PreparedStatement user_insert = conn.prepareStatement("Insert into user_details(name,email,password,role,phone_no) values(?,?,?,?,?)");
        user_insert.setString(1, name);
        user_insert.setString(2, email);
        user_insert.setString(3, password);
        user_insert.setString(4, role);
        user_insert.setString(5, phone);
        user_insert.executeUpdate();
        System.out.println("User added !!!");

    }

    public void createNewBranch(String address,String city,String phoneNo,LinkedHashMap<Integer,Integer> roomsmap) throws SQLException
    {
        PreparedStatement branch_insert1 = conn.prepareStatement("Insert into hotel_details(Hotel_address,Hotel_city,Hotel_contact) values(?,?,?)");
        branch_insert1.setString(1, address);
        branch_insert1.setString(2, city);
        branch_insert1.setString(3, phoneNo);
        branch_insert1.executeUpdate();
        
        //to get hotel_id
        Statement stmt = conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT Hotel_id FROM hotel_details WHERE Hotel_city='"+city+"' AND Hotel_address='"+address+"';");
        rs.next();
        int Hotel_id=rs.getInt(1);
        
        //number if different rooms
         for (Map.Entry<Integer,Integer> map : roomsmap.entrySet()) 
         {
            if(map.getValue()!=0){
             PreparedStatement branch_insert2 = conn.prepareStatement("Insert into hotel_rooms(Room_id,Hotel_id,no_of_rooms) values(?,?,?)");
             branch_insert2.setInt(1, map.getKey());
             branch_insert2.setInt(2, Hotel_id);
             branch_insert2.setInt(3, map.getValue());
             branch_insert2.executeUpdate();}
         }
        
        System.out.println("Hotel Added !!!");
    }
    public void insert_booking(int hotel_id,int room_id,int no_room,String checkIn,String checkOut,int pay_id) throws SQLException
    {
        PreparedStatement booking_insert = conn.prepareStatement("Insert into booking_table(Hotel_id,Room_id,no_of_rooms,check_in,check_out,payment_id) values(?,?,?,?,?,?)");
        booking_insert.setInt(1, hotel_id);
        booking_insert.setInt(2, room_id);
        booking_insert.setInt(3, no_room);
        booking_insert.setString(4, checkIn);
        booking_insert.setString(5, checkOut);
        booking_insert.setInt(6, pay_id);
        booking_insert.executeUpdate();

        System.out.println("Booking is sucessfull");
    }

    public void insert_payment(int user_id,String mode,String pay_date,int amount) throws SQLException
   {
    PreparedStatement pay_insert = conn.prepareStatement("Insert into payment_table(user_id,payment_mode,payment_date,Amount) values(?,?,?,?)");
      pay_insert.setInt(1, user_id);
      pay_insert.setString(2, mode);
      pay_insert.setString(3, pay_date);
      pay_insert.setInt(4, amount);
      pay_insert.executeUpdate();

      //select pay_id
      Statement stmt = conn.createStatement();
      ResultSet rs=stmt.executeQuery("SELECT payment_id FROM payment_table WHERE user_id='"+user_id+"' AND payment_date='"+pay_date+"';");
      rs.next();
      int pay_id=rs.getInt(1);

      booking_getset.setPayID(pay_id);
      System.out.println("Payment SucessFull....!!");
   }
}