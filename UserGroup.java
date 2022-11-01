import java.util.*;
public class UserGroup implements GroupInterface{
    private List<User> list;
    private static int group;
    private String name;
    private static int count;

    public UserGroup(String name){
    this.name = name;
    count++;
    }
    public void add(User user){
        if(!list.contains(user)){
          list.add(user);
        }
    }
    public static int getCount(){
        return count;
    }

}