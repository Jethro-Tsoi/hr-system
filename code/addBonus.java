import java.util.*;
public class addBonus implements Command {

  private Scanner s = new Scanner(System.in);

    // private static addBonus instance = new addBonus();
    // private addBonus() {}
    // public static addBonus getInstance(){return instance;}

    public void execute(Employee e){
      System.out.println("Please enter the bonus amount.");
      int bonus =  s.nextInt(); 
      e.returnPayment().addBonus(bonus);
      System.out.println("Still have to perform adding bonus for other employee? [True/False].");
      boolean notFinish = s.nextBoolean();

      while(notFinish){
        //Query employeeID, bonus and perform action
        System.out.println("Enter the employee id.");
        int query_id = s.nextInt();
        String string = String.format("Enter the bonus amount for %d",query_id);
        System.out.print(string);
        bonus = s.nextInt();
        e = Organization.getInstance().getEmployee(query_id);
        e.returnPayment().addBonus(bonus);

        //keep or break loop
        System.out.println("Still have to perform adding bonus for other employee? [True/False].");
        notFinish = s.nextBoolean();
      }

      s.close();
   }

    static {
        Manager.getInstance().add("addBonus", new addBonus());
    }
}

