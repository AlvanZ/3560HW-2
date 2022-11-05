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
        if(!list.contains(user)){
          list.add(user);
        }
    }
    public static int getCount(){
        return count;
    }
    public String getDisplayName(){
        return name;
    }
    public int accept(Visitor visitor){
        return visitor.visit(this);
    }
}