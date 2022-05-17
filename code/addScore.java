import java.util.Scanner;

public class addScore implements Command{
    // private static addScore instance = new addScore();
    // private addScore() {}
    // public static addScore getInstance(){return instance;}

    public void execute(Employee employee) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the employee ID.");
        int id = s.nextInt();
        System.out.println("Please enter the score would be added.");
        int score = s.nextInt();
        s.close();
        Employee e = Organization.getInstance().getEmployee(id);
        if (e != null) {
            e.addScore(score);
        } else {
            System.out.println("Employee not found.");
        }
    }

    static {
        Manager.getInstance().add("addScore", new addScore());
        HR.getInstance().add("addScore", new addScore());
    }

}
