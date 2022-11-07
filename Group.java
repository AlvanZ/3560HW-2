import java.util.*;
public class Group extends SysEntry  {
    private ArrayList<SysEntry> list;
    private static int group;
    private String name;
    private static int count;

    public Group(String name){
    this.name = name;
    list = new ArrayList<SysEntry>();
    count++;
    }
    public void add(SysEntry user){
        //Adds any sysEntry
        if(!list.contains(user)){
          list.add(user);
        }
    }
    public static int getCount(){
        //getter method
        return count;
    }
    public String getDisplayName(){
        //Getter method for name
        return name;
    }
    public int accept(Visitor visitor){
        //Visitor Pattern
        return visitor.visit(this);
    }
    public boolean isGroup(){
        //Checks if Group or not
        return true;
    }
    public boolean isUser(){
        //Returns if User or not
        return false;
    }
}   