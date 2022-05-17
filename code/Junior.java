import java.util.*;
public class Junior implements Role {
  private HashMap<String, Command> CommandMap = new HashMap<>();
  

  private static Junior instance = new Junior();
  private Junior() {}
  public static Junior getInstance() {return instance;}

  // @Override
  // public void checkRating(Rating rating, int score){
  //   System.out.println("Please contact manager to confirm  your score.");
  // }

  public HashMap<String,Command> getCommand(){
      return CommandMap;
  }

  public void add(String name, Command command) {
    CommandMap.put(name, command);
  }

  public int getWealthfare() {return 9000;}


  static {
    Organization.getInstance().addRole("Junior", instance);
  }
}