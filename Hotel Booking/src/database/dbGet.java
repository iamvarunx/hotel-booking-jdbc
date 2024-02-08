package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbGet extends dbConnect{

    public static int select_advanceAmount(int roomID) throws SQLException
    {
        Statement stmt = conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT advanceAmount FROM room_types WHERE Room_id='"+roomID+"'");
        rs.next();
        return rs.getInt(1);
    }

    public static int select_perDayPrice(int roomID) throws SQLException
    {
        Statement stmt = conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT pricePerDay FROM room_types WHERE Room_id='"+roomID+"'");
        rs.next();
        return rs.getInt(1);
    }
    public static int getNumberofRoomsAvailable(int hotel_id,int room_id) throws SQLException
    {
        Statement stmt = conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT no_of_rooms FROM hotel_rooms WHERE Room_id="+room_id+" AND Hotel_id="+hotel_id+";");
        rs.next();
        return rs.getInt(1);

    }
}
