public class checkBonus implements Command{
   
   private static checkBonus instance = new checkBonus(); 
   private checkBonus() {}
   public static checkBonus getInstance(){return instance;}
  
   public void execute(Employee e){
     e.returnPayment().getBonus();
   }

   static {
     CommonCommand.getInstance().add("checkBonus", new checkBonus());
   }
}