package user;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import database.dbDisplay;
import database.dbGet;
import database.dbInsert;
import utill.booking_getset;
import utill.getSet;
import utill.scanCon;

public class User extends scanCon {
    public static void start() throws SQLException {

        while (true) {
            System.out.println();
            System.out.println("__________Welcome !!!__________");
            System.out.println("          1.Start Booking: ");
            System.out.println("          2.View All Hotels: ");
            System.out.println("          3.Exit: ");
            System.out.println("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                if (booking_getset.getCity() == null)
                    User.bookigDetails();
                dbDisplay dis = new dbDisplay();
                boolean b = dis.display_toBook(booking_getset.getCity(), booking_getset.getCheckIn(),
                        booking_getset.getCheckOut());
                if (b) {
                    System.out.println("             TO BOOK ");
                    System.out.println("Enter Hotel_ID to BOOK: ");
                    int hotel_id = sc.nextInt();
                    System.out.println("Enter ROOM_ID to BOOK: ");
                    int room_id = sc.nextInt();
                    int ROOMS_AVAILABLE = dbGet.getNumberofRoomsAvailable(hotel_id, room_id);
                    int no_room = 0;
                    System.out.println("Enter the NUMBER OF ROOMS FROM AVAILABLE ROOMS: ");
                    while (no_room <= ROOMS_AVAILABLE) {
                        no_room = sc.nextInt();
                        if (no_room != ROOMS_AVAILABLE) {
                            System.out.println("Please..!!");
                            System.out.println("Enter the number of rooms as of the availablities:");
                        } else
                            break;

                    }
                    payment_process(room_id, no_room, booking_getset.getNoOfDaysStay());
                    dbInsert in = new dbInsert();
                    in.insert_booking(hotel_id, room_id, no_room, booking_getset.getCheckIn(),
                            booking_getset.getCheckOut(),
                            booking_getset.getPayID());
                    break;
                } else {
                    booking_getset.setCity(null);
                    User.start();
                }
            } else if (choice == 2) {

                System.out.println("       1.To View All branches: ");
                System.out.println("       2.To View By City: ");
                System.out.println("Enter your choice: ");
                int c = sc.nextInt();
                sc.nextLine();
                if (c == 1) {
                    dbDisplay dis = new dbDisplay();
                    dis.display_all_branch();
                } else if (c == 2) {
                    if (booking_getset.getCity() == null)
                        User.bookigDetails();
                    dbDisplay dis = new dbDisplay();
                    boolean b = dis.display_all(booking_getset.getCity(), booking_getset.getCheckIn(),
                            booking_getset.getCheckOut());
                    if (b == false) {
                        User.start();
                    }
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Enter proper choice ...!!!");
                User.start();
            }
        }
    }

    public static void bookigDetails() {
        System.out.print("Enter the city name: ");
        String city = sc.nextLine().toLowerCase();
        System.out.print("Enter the CHECK IN DATE(YYYY-MM-DD): ");
        String checkIn = sc.nextLine();
        System.out.print("Enter the CHECK OUT DATE(YYYY-MM-DD): ");
        String checkOut = sc.nextLine();
        System.out.println();
        String checkInDay[] = checkIn.split("-");
        String checkOutDay[] = checkOut.split("-");
        int inyear = Integer.valueOf(checkInDay[0]);
        int inmonth = Integer.valueOf(checkInDay[1]);
        int inday = Integer.valueOf(checkInDay[2]);
        int outyear = Integer.valueOf(checkOutDay[0]);
        int outmonth = Integer.valueOf(checkOutDay[1]);
        int outday = Integer.valueOf(checkOutDay[2]);

        LocalDate start = LocalDate.of(inyear, inmonth, inday);
        LocalDate end = LocalDate.of(outyear, outmonth, outday);
        Period period = Period.between(start, end);
        int days = period.getDays()+1;
        int noOfDaysStay = days;
        booking_getset.setCity(city);
        booking_getset.setNoOfDaysStay(noOfDaysStay);
        booking_getset.setCheckIn(checkIn);
        booking_getset.setCheckOut(checkOut);
    }

    public static void payment_process(int room_id, int no_room, int noOfDays) throws SQLException {
        int advanceAmount = dbGet.select_advanceAmount(room_id);
        int perdayprice = dbGet.select_perDayPrice(room_id);
        int total_price = perdayprice * noOfDays;
        System.out.println("-------------------------------------------");
        System.out.println(" PER DAY PRICE                 =     RS." + perdayprice);
        System.out.println(" TOTAL NUMBER OF DAYS STAY     =     " + noOfDays);
        System.out.println("                                  -------------");
        System.out.println(" TOTAL AMOUNT                  =     RS." + total_price);
        System.out.println("                                  -------------");
        System.out.println(" ADVANCE AMOUNT TO BE PAID     =     RS." + advanceAmount);
        System.out.println("-------------------------------------------");

        System.out.println("CHOOSE THE MODE OF PAYMENT ");
        System.out.println("1.UPI");
        System.out.println("2.CREDIT CARD");
        System.out.println("3.DEBIT CARD");
        System.out.println("Enter your choice: ");
        String mode = "";
        int choice = sc.nextInt();
        if (choice == 1)
            mode = "UPI";
        else if (choice == 2)
            mode = "CREDIT CARD";
        else if (choice == 3)
            mode = "DEBIT CARD";
        int amount = 0;
        while (advanceAmount != amount) {
            System.out.println("Enter YOUR Advance amount (" + advanceAmount + ") :");
            amount = sc.nextInt();
            if (advanceAmount != amount) {
                System.out.println("The Entered amount is wrong please..!!");
            }
        }
        sc.nextLine();
        System.out.println("Enter Date Of PayMent (yyyy-mm-dd) : ");
        String date = sc.nextLine();
        dbInsert in = new dbInsert();
        in.insert_payment(getSet.getUserId(), mode, date, amount);
        User.start();
    }
}
