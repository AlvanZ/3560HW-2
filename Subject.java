import java.util.*;
public abstract class Subject extends SysEntry {
    public static int getUsers(){
        return -1;
    }
    public ArrayList<Observer> getFollowing(){
        return null;
    }

    public ArrayList<Observer> getFollowers(){
        return null;
    }
    public void newsFeed(){
        
    }
    public void receive(String str){
        
    }
    public void post(String tweet){
    }
    public static int getTweets(){
        return -1;
    }
    public static int getPositiveTweets(){
        return -1;
    }
    public String getDisplayName(){
        return "";
    }
}
