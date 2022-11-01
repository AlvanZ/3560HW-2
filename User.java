
import java.util.*;


public class User implements UserInterface{
    HashMap<User, String> map;
    private static int users;
    private String userID;
    private List<String> followers;
    private List<String> following;
    private static int tweets;
    private static int positive;

    public User(String id){
        userID = id;
        users++;
        map.put(this, id);
    }
    public void following(String id){
        
    }
    public List<String> getFollowing(){
        return following;
    }

    public List<String> getFollowers(){
        return followers;
    }
    public void newsFeed(){
        
    }
    public static int getUsers(){
        return users;
    }

    public void post(String tweet){
        for(int i =0; i<followers.size(); i++){
            //post
        }
        if(tweet.contains("Nice") || tweet.contains("Good")){
            positive++;
        }
        tweets++;
    }
    public static int getTweets(){
        return tweets;
    }
    public static int getPositiveTweets(){
        return positive;
    }
}
