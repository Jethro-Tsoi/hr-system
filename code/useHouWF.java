import java.util.Scanner;

public class useHouWF implements Command{

    public void execute(Employee e) {
        Scanner s = new Scanner(System.in);
        int amount;
        do {
            System.out.print("Amount to use: ");
            amount = s.nextInt();
        } while (amount<1);
        e.useHousing(amount);
        s.close();
    }

    static{
        CommonCommand.getInstance().add("useHouWF", new useHouWF());
    }
}