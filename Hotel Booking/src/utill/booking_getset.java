package utill;

public class booking_getset {
    private static String city;
    private static int noOfDaysStay;
    private static String checkIn;
    private static String checkOut;
    private static int payID;
    public static String getCity() {
        return city;
    }
    public static void setCity(String city) {
        booking_getset.city = city;
    }
    public static int getNoOfDaysStay() {
        return noOfDaysStay;
    }
    public static void setNoOfDaysStay(int noOfDaysStay) {
        booking_getset.noOfDaysStay = noOfDaysStay;
    }
    public static String getCheckIn() {
        return checkIn;
    }
    public static void setCheckIn(String checkIn) {
        booking_getset.checkIn = checkIn;
    }
    public static String getCheckOut() {
        return checkOut;
    }
    public static void setCheckOut(String checkOut) {
        booking_getset.checkOut = checkOut;
    }
    public static int getPayID() {
        return payID;
    }
    public static void setPayID(int payID) {
        booking_getset.payID = payID;
    }
    
}
