
import java.util.List;

public class User implements UserInterface{

    private static int users;
    private String userID;
    private List<String> followers;
    private List<String> following;

    public User(String id){
        userID = id;
        users++;
    }
    public List<String> getFollowing(){
        return following;
    }

    public List<String> getFollowers(){
        return followers;
    }
    public void newsFeed(){
        
    }

    public void post(String tweet){
        
    }
}
