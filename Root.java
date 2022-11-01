import java.util.*;
public class Root implements GroupInterface {
    Root root = new Root();
    private static int count;
    private ArrayList<User> userList;
    private ArrayList<GroupInterface> groupList;

    private Root(){
        userList = new ArrayList<User>();
        groupList = new ArrayList<GroupInterface>();
    }
    public void add(User user){
        userList.add(user);
    }
    public void add(GroupInterface group){
        groupList.add(group);
    }
    public Root getInstance(){
        return root;
    }
    public static int getCount(){
        return count;
    }
}
