
import java.util.*;


public class User extends Subject implements Observer {
    private static ArrayList<String> usersList = new ArrayList<>();
    private static int users;
    private String userID;
    private ArrayList<Observer> followers;
    private ArrayList<Observer> following;
    private static int tweets;
    private static int positive;

    public User(String id){
        userID = id;
        users++;
        usersList.add(id);
    }
    public ArrayList<Observer> getFollowing(){
        return following;
    }

    public ArrayList<Observer> getFollowers(){
        return followers;
    }
    public void newsFeed(){
        
    }
    public static int getUsers(){
        return users;
    }

    public void receive(String str){
        
    }
    public void post(String tweet){
        for(int i =0; i<followers.size(); i++){
            followers.get(i).receive(tweet);
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
    public String getDisplayName(){
        return userID;
    }
    public int accept(Visitor visitor){
        return visitor.visit(this);
    }
    public void updateFollower(Observer follower){
        followers.add(follower);
    }
    public void notifyObserver(){

    }
    public void follow(Observer follow){
        following.add(follow);
        follow.updateFollower(this);
    }
    public boolean isGroup(){
        return false;
    }
    public static boolean contains(String userID){
        return usersList.contains(userID);
    }
}
