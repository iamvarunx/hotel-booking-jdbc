package admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import database.dbDisplay;
import database.dbInsert;
import database.dbUpdate;
import utill.roomsType;
import utill.scanCon;

public class Admin extends scanCon {

    public static void start() throws SQLException {
        while (true) {
            System.out.println();
            System.out.println("__________Welcome Admin!!!__________");
            System.out.println("          1.To add new Branch: ");
            System.out.println("          2.To edit number of rooms: ");
            System.out.println("          3.To Change Price/Advance price of the room: ");
            System.out.println("          4.Display");
            System.out.println("          5.EXIT ");

            System.out.println("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Hotel Address: ");
                String address = sc.nextLine();
                System.out.println("Enter City: ");
                String city = sc.nextLine();
                System.out.println("Enter Contact Number: ");
                String contact_no = sc.nextLine();
                ArrayList<String> rooms = roomsType.rooms();
                LinkedHashMap<Integer, Integer> roomsmap = new LinkedHashMap<>();
                for (int i = 0; i < rooms.size(); i++) {
                    System.out.print("How many " + rooms.get(i) + " rooms are there :");
                    int numberOfRooms = sc.nextInt();
                    if(numberOfRooms<=0)
                    continue;
                    else{
                        // i+1 == room_id;
                        roomsmap.put(i + 1, numberOfRooms);
                    }
                }

                try {
                    dbInsert insert = new dbInsert();
                    insert.createNewBranch(address, city, contact_no, roomsmap);
                } catch (Exception e) {
                    System.out.print(e);

                }
            } else if (choice == 2) {
                dbUpdate  up = new dbUpdate();
                dbDisplay dis = new dbDisplay();
                System.out.print("Enter hotel city:");
                String city = sc.nextLine();
                dis.display_city_query(city);
                System.out.print("Enter the Hotel ID: ");
                int hotelID =sc.nextInt();
                System.out.print("Enter the Room ID: ");
                int roomID = sc.nextInt();
                System.out.print("Enter the total number of rooms :");
                int totl_rooms =sc.nextInt();
                up.update_rooms(roomID,totl_rooms,hotelID);


            }else if (choice==3) {
                System.out.println("        1.To Change per day price");
                System.out.println("        2.To Change advance price");
                System.out.print("Enter choice: ");
                int chc =sc.nextInt();

                ArrayList<String> rType = roomsType.rooms();
                for(int i=0;i<rType.size();i++)
                {
                    System.out.println("Enter "+(i+1)+": "+rType.get(i));
                }
                System.out.println("Enter your choice: ");
                int c =sc.nextInt();
                if(chc==1)
                {
                    System.out.print("Enter the price to be changed: ");
                    int price =sc.nextInt();
                    dbUpdate  up = new dbUpdate();
                    up.update_room_price(c,price);   
                }
                else if(chc==2)
                {
                    System.out.print("Enter the price to be changed: ");
                    int price =sc.nextInt();
                    dbUpdate  up = new dbUpdate();
                    up.update_room_advprice(c,price);   

                }
                else
                {
                    System.out.println("Something Went Wrong!! Try again");
                    start();
                }

            }
            else if (choice == 4) {

                while(true){
                System.out.println("What to Display");
                System.out.println("          1.View All Branch Details ");
                System.out.println("          2.View Hotel Details ");
                System.out.println("          3.View All Booking Details");
                System.out.println("          4.Exit  ");
                int c = sc.nextInt();
                sc.nextLine();
                dbDisplay dis = new dbDisplay();
                switch (c) {
                    case 1:
                        dis.display_all_branch();
                        break;
                    case 2:
                        System.out.println("Enter City Name: ");
                        String city = sc.nextLine();
                        dis.display_city_query(city);
                        break;
                    case 3:
                        System.out.println("Enter the Date to see the Booking details(yyyy-mm-dd): ");
                        String date = sc.nextLine();
                        dis.display_all_bookingDetails(date);
                        break;
                    case 4:
                        Admin.start();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }

                }
            } else if (choice == 5) {
                break;
            } else {
                System.err.println("Please enter valid choice..!!");
                Admin.start();
            }
        }
    }
}
