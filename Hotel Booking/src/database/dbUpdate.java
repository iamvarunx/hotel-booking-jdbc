package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbUpdate extends dbConnect {
    public void update_rooms(int roomID, int noOfRooms, int hotel_id) throws SQLException {
        String query_getRooms = "Select no_of_rooms from hotel_rooms where Room_id =" + roomID + " AND Hotel_id ="
                + hotel_id + ";";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query_getRooms);
        int rooms = 0;
        if (rs.next()) {
            rooms = rs.getInt(1);
        }
        noOfRooms = noOfRooms + rooms;
        String query = "UPDATE hotel_rooms\r\n" + //
                "SET no_of_rooms = ?\r\n" + //
                "WHERE Hotel_id =? AND Room_id =?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, noOfRooms);
        ps.setInt(2, hotel_id);
        ps.setInt(3, roomID);
        ps.executeUpdate();
        System.out.println("UPDATED SUCESS FULLY");
    }

    public void update_room_price(int room_id, int price) throws SQLException {
        String query = "UPDATE room_types SET pricePerDay =? WHERE Room_id=?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, price);
        ps.setInt(2, room_id);
        ps.executeUpdate();
        System.out.println("UPDATED SUCESS FULLY");
    }

    public void update_room_advprice(int room_id, int price) throws SQLException {
        String query = "UPDATE room_types SET advanceAmount =? WHERE Room_id=?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, price);
        ps.setInt(2, room_id);
        ps.executeUpdate();
        System.out.println("UPDATED SUCESS FULLY");
    }
}
