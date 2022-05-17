import java.util.*;

public class Senior implements Role {
    
  private static Senior instance = new Senior();
  private Senior() {}
  public static Senior getInstance() {return instance;}
  //   @Override
  // public void addBonus(){
  //   System.out.println("Please contact manager to confirm the bonus.");
  // }

  private HashMap<String, Command> CommandMap = new HashMap<>();

  // @Override
  // public void addBonus(){
  //   System.out.println("Please contact manager to confirm the bonus.");
  // }
  
  // @Override
  // public void checkRating(Rating rating, int score){
  //   System.out.println("Please contact manager to confirm your score.");
  // }

  public HashMap<String,Command> getCommand(){
    return CommandMap;
  }

  public void add(String name, Command command) {
    CommandMap.put(name, command);
  }

  public int getWealthfare() {return 12000;}
  

  static {
    Organization.getInstance().addRole("Senior", instance);
  }
}