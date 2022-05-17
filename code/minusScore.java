import java.util.Scanner;

public class minusScore implements Command{

    // private static minusScore instance = new minusScore(); 
    // private minusScore() {}
    // public static minusScore getInstance(){return instance;}

    public void execute(Employee employee) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the employee ID.");
        int id = s.nextInt();
        System.out.println("Please enter the score would be deducted.");
        int score = s.nextInt();
        s.close();
        Employee e = Organization.getInstance().getEmployee(id);
        if (e != null) {
            e.minusScore(score);
        } else {
            System.out.println("Employee not found.");
        }
    }
    
    static {
        HR.getInstance().add("minusScore", new minusScore());
        Manager.getInstance().add("minusScore", new minusScore());
    }


}