import java.util.Scanner;

public class useAL implements Command{
    public void execute(Employee e) {
        Scanner s = new Scanner(System.in);
        int amount;
        do {
            System.out.print("Day to use: ");
            amount = s.nextInt();
        } while (amount<1);
        e.useAnnualLeave(amount);
        s.close();
    }

    static{
        CommonCommand.getInstance().add("useAL", new useAL());
    }
}