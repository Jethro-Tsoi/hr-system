import java.util.*;

public class Login {

    private final Verification verification;

    private static Login instance = new Login();

    private Login() {verification = LocalVerification.getInstance();}

    public static Login getInstance() {return instance;}

    public Employee start() {
        Scanner s = new Scanner(System.in);
        System.out.println("Login:");
        System.out.print("id:");
        int id = s.nextInt();
        System.out.print("password:");
        String password = s.nextLine();
        s.close();
        if (verification.verify(id, password)) {
            System.out.println("Login successfully.");
            return Organization.getInstance().getEmployee(id);
        } else {
            System.out.println("Fail to login.");
        }
        return null;
    }
    
    public void changePassword(int id) {
        Scanner s = new Scanner(System.in);
        System.out.printf("Change password for %d\n", id);
        System.out.println("Password requirement: at least 8 characters");
        System.out.print("Old password:");
        String oldPassword = s.nextLine();
        System.out.print("New password:");
        String newPassword = s.nextLine();
        s.close();
        if (Verification.requirement(newPassword)) {
            if (verification.changePassword(id, oldPassword, newPassword)) {
                System.out.println("Changed password successfully.");
            } else {
                System.out.println("Fail to change password.");
                System.out.println("Incorrect old password");
            }
        } else {
            System.out.println("Fail to change password.");
            System.out.println("New password does not meet requirement: at least 8 characters.");
        }
        
    }
    
    public boolean newEntry(int id) {
        Scanner s = new Scanner(System.in);
        System.out.println("Adding new entry to the HRMS:");
        System.out.println("Password requirement: at least 8 characters");
        System.out.printf("id: %d\n", id);
        System.out.print("password:");
        String password = s.nextLine();
        s.close();
        if (!Verification.requirement(password)) {
            System.out.println("Fail to add new entry.");
            System.out.println("Password does not meet requirement: at least 8 characters.");
            return false;
        } else if (!verification.newEntry(id, password)) {
            System.out.println("Fail to add new entry.");
            System.out.println("id was reserved.");
            return false;
        } else {
            System.out.println("Added new entry successfully.");
        }
        return true;
    }

    public boolean removeEntry(int id) {
        Verification localv = LocalVerification.getInstance();
        System.out.println("Removing entry to the HRMS:");
        System.out.printf("id: %d\n", id);
        if (!localv.removeEntry(id)) {
            System.out.println("Fail to removed entry.");
            System.out.println("Employee not found.");
            return false;
        } else {
            System.out.println("Removed entry successfully.");
        }
        return true;
    }
    
}