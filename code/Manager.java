import java.util.*;
public class Manager implements Role {

  private static Manager instance = new Manager();
  private Manager() {}
  public static Manager getInstance() {return instance;}

  private HashMap<String, Command> CommandMap;

  // public Manager(){
  //   CommandMap.put("addBonus",new addBonus());
  //   CommandMap.put("addScore", new addScore());
  //   CommandMap.put("admit", new admit());
  //   CommandMap.put("resign", new resign());
  // }

  // public void checkRating(Rating rating, int score){
  //   rating.getScore();
  // }
  
  // public void addScore(Rating r , int score){
  //   r.addScore(score);
  // }
  
  // public void minusScore(Rating r , int score){
  //   r.minusScore(score);
  // }

  public HashMap<String,Command> getCommand(){
    return CommandMap;
  }

  public void add(String name, Command command) {
    CommandMap.put(name, command);
  }

  public int getWealthfare() {return 15000;}

  static {
    Organization.getInstance().addRole("Manager", instance);
  }
}