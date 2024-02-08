package utill;

public class getSet {
    private static String Name;
    private static int UserId;
    private static String Role;

    public static String getName() {
        return Name;
      }
    
      public static void setName(String newName) {
        Name = newName;
      }
    public static int getUserId() {
        return UserId;
      }
    
      public static void setUserId(int userId) {
        UserId = userId;
      }
    public static String getRole() {
        return Role;
      }
    
      public static void setRole(String role) {
        Role = role;
      }
}
