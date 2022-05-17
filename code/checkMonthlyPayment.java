public class checkMonthlyPayment implements Command{

  private static checkMonthlyPayment instance = new checkMonthlyPayment(); 
  private checkMonthlyPayment() {}
  public static checkMonthlyPayment getInstance(){return instance;}
  
  public void execute(Employee e){
    e.returnPayment().getMonthlyPayment();
  }
  
  static {
    CommonCommand.getInstance().add("checkMonthlyPayment", new checkMonthlyPayment());
  }
}

