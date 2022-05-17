import java.util.*;
public class addSalary implements Command {

  private Scanner s = new Scanner(System.in);

  // private static addSalary instance = new addSalary();
  // private addSalary() {}
  // public static addSalary getInstance(){return instance;}

    public void execute(Employee e){
      System.out.println("Please enter the increment amount.");
      int increment =  s.nextInt(); 
      e.returnPayment().addSalary(increment);
      System.out.println("Still have to perform a salary raise for other employee? [True/False].");
      boolean notFinish = s.nextBoolean();

      while(notFinish){
        //Query employeeID, increment and perform action
        System.out.println("Enter the employee id.");
        int query_id = s.nextInt();
        String string = String.format("Enter the increment amount for %d",query_id);
        System.out.print(string);
        increment = s.nextInt();
        e = Organization.getInstance().getEmployee(query_id);
        e.returnPayment().addSalary(increment);

        //keep or break loop
        System.out.println("Still have to perform a salary raise for other employee? [True/False].");
        notFinish = s.nextBoolean();
      }
      s.close();
   }

    static {
        HR.getInstance().add("addSalary", new addSalary());
    }
}