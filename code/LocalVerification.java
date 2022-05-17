import java.util.*;

public class LocalVerification implements Verification {

    private static LocalVerification instance = new LocalVerification();

    private HashMap<Integer, String> allEntry;

    private LocalVerification() {allEntry = new HashMap<Integer, String>();}
    
    public static Verification getInstance() {return instance;}
    
    public boolean verify(int id, String password) {
        String recordPassword = allEntry.get(id);
        if (recordPassword != null && recordPassword.equals(password)) {
            return true;
        }
        return false;
    }
    
    public boolean changePassword(int id, String oldPassword, String newPassword) {
        if (verify(id, oldPassword)) {
            allEntry.replace(id, newPassword);
            return true;
        }
        return false;
    }
    
    public boolean newEntry(int id, String password) {
        if (allEntry.get(id) != null) {
            allEntry.put(id, password);
            return true;
        }
        return false;
    }

    public boolean removeEntry(int id) {
        if (allEntry.get(id) != null) {
            allEntry.remove(id);
            return true;
        }
        return false;
    }
    
}