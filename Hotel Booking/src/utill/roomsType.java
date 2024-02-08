package utill;

import java.util.ArrayList;

public class roomsType {
    public static ArrayList<String> rooms()
    {
        ArrayList<String> roomsName = new ArrayList<>();
        roomsName.add("Single Room");
        roomsName.add("Double Room");
        roomsName.add("Twin Room");
        roomsName.add("Deluxe Room");
        roomsName.add("Junior Suite ");
        roomsName.add("Suite");
        return roomsName;
    }
}
