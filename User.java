
import java.util.*;


public class User extends SysEntry implements Observer, Observable, Visitable{
    private static ArrayList<String> usersList = new ArrayList<>();
    private static int users;
    private String userID;
    private ArrayList<Observer> followers;
    private ArrayList<Observer> following;
    private static int tweets;
    private static int positive;
    private NewWindow window;
    //Constructor
    public User(String id){
        userID = id;
        users++;
        usersList.add(id);
        followers = new ArrayList<>();
        following = new ArrayList<>();
        tweets = 0;
        positive = 0;
    }

    //Following list Getter
    public ArrayList<Observer> getFollowing(){
        return following;
    }
    //Followers list Getter
    public ArrayList<Observer> getFollowers(){
        return followers;
    }
    //Users getter
    public static int getUsers(){
        return users;
    }
    //Receive the message
    public void receive(String str){
        window.receive( str);
    }
    //Set window for User
    public void setWindow(NewWindow window){
        this.window = window;
    }
    //Post/Tweet method 
    public void post(String tweet){
        for(int i =0; i<followers.size(); i++){
            followers.get(i).receive(this.getDisplayName()+ ": "+ tweet);
        }
        if(tweet.contains("Nice") || tweet.contains("Good")){
            positive++;
        }
        tweets++;
    }
    //Return the number of tweets for users in total
    public static int getTweets(){
        return tweets;
    }
    //Return number of Positive tweets
    public static double getPositiveTweets(){
        if(tweets == 0){
            return 0.0;
        }
        return 100*(double)positive/tweets;
    }
    //DisplayName getter
    public String getDisplayName(){
        return userID;
    }
    //Accepts to count how many Users there are
    public int accept(Visitor visitor){
        return visitor.visit(this);
    }
    //Update number of Followers
    public void updateFollower(Observer follower){
        followers.add(follower);
    }
    //Follow users method
    public void follow(Observer follow){
        following.add(follow);
        follow.updateFollower(this);
    }
    //Return whether or not object is Group object
    public boolean isGroup(){
        return false;
    }
        //Return whether or not object is User object
    public boolean isUser(){
        return true;
    }
        //Return whether or not User is in the userList
    public static boolean contains(String userID){
        return usersList.contains(userID);
    }
}
