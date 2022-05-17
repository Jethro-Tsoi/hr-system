import java.util.Scanner;

public class checkScore implements Command{

    private static checkScore instance = new checkScore(); 
    private checkScore() {}
    public static checkScore getInstance(){return instance;}


    public void execute(Employee employee) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the employee ID.");
        int id = s.nextInt();
        s.close();
        Employee e = Organization.getInstance().getEmployee(id);
        if (e != null) {
            e.checkRating();
        } else {
            System.out.println("Employee not found.");
        }
    }

    static {
        CommonCommand.getInstance().add("checkScore", new checkScore());
    }
}
