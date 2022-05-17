public class checkSalary implements Command{

  private static checkSalary instance = new checkSalary(); 
  private checkSalary() {}
  public static checkSalary getInstance(){return instance;}
  
  public void execute(Employee e){
    e.returnPayment().checkSalary();
  }

  static {
    CommonCommand.getInstance().add("checkSalary", new checkSalary());
  }
}
