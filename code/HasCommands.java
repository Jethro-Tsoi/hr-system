import java.util.*;

interface HasCommands {
    HashMap<String,Command> getCommand();
    void add(String name, Command command);
}