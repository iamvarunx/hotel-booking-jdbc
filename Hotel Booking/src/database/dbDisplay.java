package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utill.querys;

public class dbDisplay extends dbConnect {

        public boolean display_all(String city, String checkIn, String checkOut) throws SQLException {
                String query = querys.display_all_query();

                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, checkIn);
                ps.setString(2, checkOut);
                ps.setString(3, city);
                ResultSet rs = ps.executeQuery();
                if (!rs.isBeforeFirst()) {
                        System.out.println();
                        System.out.println("-------- Rooms Not Available -------");
                        System.out.println();
                        return false;
                }
                System.out.printf(
                                "-----------------------------------------------------------------------------------------------------------------%n");

                System.out.printf("|%-14s|%-17s|%-17s|%-15s|%-12s|%-15s|%-15s|%n",
                                "ROOM TYPE", "NUMBER_OF_PERSON", "ROOMS_AVAILABLE", "PER_DAY PRICE", "ADVANCE_AMT",
                                "HOTEL ADDRESS",
                                "CONTACT NO.");
                System.out.printf(
                                "-----------------------------------------------------------------------------------------------------------------%n");
                while (rs.next()) {
                        System.out.printf(
                                        "-----------------------------------------------------------------------------------------------------------------%n");
                        System.out.printf("|%-14s|%-17s|%-17s|%-15s|%-12s|%-15s|%-15s|%n",
                                        rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                                        rs.getString(6),
                                        rs.getString(7));
                        System.out.printf(
                                        "-----------------------------------------------------------------------------------------------------------------%n");
                }
                return true;
        }

        public boolean display_toBook(String city, String checkIn, String checkOut) throws SQLException {

                String query = querys.display_toBook_query();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, checkIn);
                ps.setString(2, checkOut);
                ps.setString(3, city);
                ResultSet rs = ps.executeQuery();
                if (!rs.isBeforeFirst()) {
                        System.out.println();
                        System.out.println("-------- Rooms Not Available -------");
                        System.out.println();

                        return false;
                }
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf("|%-10s|%-10s|%-13s|%-17s|%-17s|%-14s|%-12s|%-15s|%-13s|%n",
                                "HOTEL_ID", "ROOM_ID", "ROOM TYPE", "NUMBER_OF_PERSON", "ROOMS_AVAILABLE",
                                "PER_DAY_PRICE",
                                "ADVANCE_AMT", "HOTEL ADDRESS", "CONTACT NO.");
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------------------------------------%n");

                while (rs.next()) {
                        System.out.printf(
                                        "--------------------------------------------------------------------------------------------------------------------------------%n");
                        System.out.printf("|%-10s|%-10s|%-13s|%-17s|%-17s|%-14s|%-12s|%-15s|%-13s|%n",
                                        rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                                        rs.getInt(6), rs.getInt(7),
                                        rs.getString(8), rs.getString(10));
                        System.out.printf(
                                        "--------------------------------------------------------------------------------------------------------------------------------%n");
                }
                return true;
        }

        public void display_all_bookingDetails(String date) throws SQLException {
                String query = querys.display_Booked_query();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, date);
                ResultSet dis = ps.executeQuery();
                if (!dis.isBeforeFirst()) {
                        System.out.println();
                        System.out.println("-------- There is No Booking Details made on ("+date+") -------");
                        System.out.println();
                        return;
                }
                System.out.printf(
                                "-------------------------------------------------------------------------------------------%n");
                System.out.printf("|%-15s|%-15s|%-10s|%-12s|%-11s|%-10s|%-10s|%n",
                                "USER_NAME", "PHONE_NO", "HOTEL", "ROOM_TYPE", "NO_OF_ROOMS", "CHECK_IN", "CHECK_OUT");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------%n");

                while (dis.next()) {
                        System.out.printf(
                                        "-------------------------------------------------------------------------------------------%n");
                        System.out.printf("|%-15s|%-15s|%-10s|%-12s|%-11s|%-10s|%-10s|%n",
                                        dis.getString(1), dis.getString(2), dis.getString(3), dis.getString(4),
                                        dis.getInt(5),
                                        dis.getString(6), dis.getString(7));
                        System.out.printf(
                                        "-------------------------------------------------------------------------------------------%n");

                }
        }

        public void display_all_branch() throws SQLException {
                String query = "SELECT Hotel_address, Hotel_city, Hotel_contact FROM hotel_details ;";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                System.out.printf(
                                "------------------------------------------------%n");
                System.out.printf("|%-15s|%-15s|%-14s|%n",
                                "Address", "City", "HOTEL_CONTACT");
                System.out.printf(
                                "------------------------------------------------%n");
                while (rs.next()) {
                        System.out.printf(
                                        "------------------------------------------------%n");
                        System.out.printf("|%-15s|%-15s|%-14s|%n",
                                        rs.getString(1), rs.getString(2), rs.getString(3));
                        System.out.printf(
                                        "------------------------------------------------%n");
                }
        }

        public void display_city_query(String city) throws SQLException {
                String query = querys.display_city_query();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, city);
                ResultSet rs = ps.executeQuery();
                if (!rs.isBeforeFirst()) {
                        System.out.println();
                        System.out.println("-------- Hotel Not Available -------");
                        System.out.println();
                        return;
                }
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf("|%-14s|%-17s|%-17s|%-15s|%-15s|%-12s|%-15s|%-15s|%-10s|%n",
                                "HOTEL ADDRESS", "Hotel_city", "Hotel_contact", "Room_ID", "Room_type",
                                "NO_OF_ROOMS", "no_of_person",
                                "pricePerDay", "Hotel_ID");
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------------------------------------------------%n");
                while (rs.next()) {
                        System.out.printf(
                                        "---------------------------------------------------------------------------------------------------------------------------------------------%n");
                        System.out.printf("|%-14s|%-17s|%-17s|%-15s|%-15s|%-12s|%-15s|%-15s|%-10s|%n",
                                        rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                                        rs.getString(5),
                                        rs.getInt(6),
                                        rs.getInt(7), rs.getInt(8), rs.getInt(9));
                        System.out.printf(
                                        "---------------------------------------------------------------------------------------------------------------------------------------------%n");
                }

        }
}
