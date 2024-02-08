package utill;

public class querys {
    public static String display_all_query()
    {
        String Query = "SELECT\n" + //
        "    rt.Room_type,\n" + //
        "    rt.no_of_person,\n" + //
        "       CASE\n" + //
                "        WHEN b.check_in BETWEEN ? AND ? THEN (r.no_of_rooms - b.no_of_rooms)\n" + //
                "        ELSE r.no_of_rooms\n" + //
                "    END AS rooms_available," + //
        "     rt.pricePerDay,\n"+ //
        "     rt.advanceAmount,\n"+ //
        "     hd.Hotel_address,\n" + //
        "    hd.Hotel_city,\n" + //
        "    hd.Hotel_contact\n" + //
        "FROM\n" + //
                "    hotel_rooms r\n" + //
                "LEFT JOIN\n" + //
                "    booking_table b ON r.Hotel_id = b.Hotel_id AND r.Room_id = b.Room_id\n" + //
                "LEFT JOIN\n" + //
                "    Hotel_details hd ON r.Hotel_id = hd.Hotel_id\n" + //
                "LEFT JOIN\n" + //
                "    Room_types rt ON r.Room_id = rt.Room_id\n" + //
                "WHERE\n" + //
                " hd.Hotel_city = ?;" ;
        return Query;
    }
    public static String display_toBook_query()
    {
        String Query = "SELECT\n"+//
        "    hd.Hotel_id,r.Room_id,\n" + //
        "    rt.Room_type,\n" + //
        "    rt.no_of_person,\n" + //
        "       CASE\n" + //
                "        WHEN b.check_in BETWEEN ? AND ? THEN (r.no_of_rooms - b.no_of_rooms)\n" + //
                "        ELSE r.no_of_rooms\n" + //
                "    END AS rooms_available," + //
        "     rt.pricePerDay,\n"+ //
        "     rt.advanceAmount,\n"+ //
        "     hd.Hotel_address,\n" + //
        "    hd.Hotel_city,\n" + //
        "    hd.Hotel_contact\n" + //
        "FROM\n" + //
                "    hotel_rooms r\n" + //
                "LEFT JOIN\n" + //
                "    booking_table b ON r.Hotel_id = b.Hotel_id AND r.Room_id = b.Room_id\n" + //
                "LEFT JOIN\n" + //
                "    Hotel_details hd ON r.Hotel_id = hd.Hotel_id\n" + //
                "LEFT JOIN\n" + //
                "    Room_types rt ON r.Room_id = rt.Room_id\n" + //
                "WHERE\n" + //
                " hd.Hotel_city = ?;" ;
        return Query;
    }
    public static String display_Booked_query()
    {
        String Query = "SELECT\n" + //
                        "   ud.name,\n" + //
                        "    ud.phone_no,\n" + //
                        "    bd.Hotel_city,\n" + //
                        "    rt.Room_type,\n" + //
                        "    bt.no_of_rooms,\n" + //
                        "    bt.check_in,\n" + //
                        "    bt.check_out\n" + //
                        "FROM\n" + //
                        "    booking_table bt\n" + //
                        "JOIN\n" + //
                        "    hotel_details bd ON bt.Hotel_id = bd.Hotel_id\n" + //
                        "JOIN\n" + //
                        "    hotel_rooms hr ON bt.Room_id = hr.Room_id\n" + //
                        "JOIN\n" + //
                        "    room_types rt ON hr.Room_id = rt.Room_id\n" + //
                        "JOIN\n" + //
                        "    payment_table pt ON bt.payment_id = pt.payment_id\n" + //
                        "JOIN\n" + //
                        "    user_details ud ON pt.user_id = ud.user_id\n"+//
                        "WHERE bt.check_in = ? ;" ;
        return Query;
    }
    public static String display_city_query()
    {
        String Query = "SELECT\n" + //
                        "\thd.Hotel_address,\n" + //
                        "    hd.Hotel_city,\n" + //
                        "    hd.Hotel_contact,rt.Room_id,\n" + //
                        "    rt.Room_type,\n" + //
                        "     r.no_of_rooms,\n" + //
                        "    rt.no_of_person,\n" + //
                        "    rt.pricePerDay,\n" + //
                        "    hd.Hotel_id\n" + //
                        "FROM\n" + //
                        "    hotel_rooms r\n" + //
                        "LEFT JOIN\n" + //
                        "    booking_table b ON r.Hotel_id = b.Hotel_id AND r.Room_id = b.Room_id\n" + //
                        "LEFT JOIN\n" + //
                        "    Hotel_details hd ON r.Hotel_id = hd.Hotel_id\n" + //
                        "LEFT JOIN\n" + //
                        "    Room_types rt ON r.Room_id = rt.Room_id\n" + //
                        "WHERE\n" + //
                        "\thd.Hotel_city = ?;" ;
        return Query;
    }
    public static String display_city_update_query()
    {
        String Query = "SELECT\n" + //
                        "\thd.Hotel_address,\n" + //
                        "    hd.Hotel_city,\n" + //
                        "    rt.Room_type,\n" + //
                        "    r.Room_id,\n" + //
                        "     r.no_of_rooms,\n" + //
                        "    hd.Hotel_id\n" + //
                        "FROM\n" + //
                        "    hotel_rooms r\n" + //
                        "LEFT JOIN\n" + //
                        "    booking_table b ON r.Hotel_id = b.Hotel_id AND r.Room_id = b.Room_id\n" + //
                        "LEFT JOIN\n" + //
                        "    Hotel_details hd ON r.Hotel_id = hd.Hotel_id\n" + //
                        "LEFT JOIN\n" + //
                        "    Room_types rt ON r.Room_id = rt.Room_id\n" + //
                        "WHERE\n" + //
                        "\thd.Hotel_city = ?;" ;
        return Query;
    }
}
