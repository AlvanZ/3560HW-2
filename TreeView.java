import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.*;
public class TreeView {
    //Instance Variables
    private HashMap<String, SysEntry> users;
    private HashMap<String, SysEntry> groups;
    private ArrayList<String> groupsID;
    private ArrayList<String> usersID;
    private String temp;
    private JTree tree;
    private DefaultMutableTreeNode curr;
    private DefaultMutableTreeNode root;
    private boolean valid;
    //Constructor
    public TreeView(){
        valid = true;
        groupsID = new ArrayList<>();
        usersID = new ArrayList<>();
        users = new HashMap<>();
        groups = new HashMap<>();
         root = new DefaultMutableTreeNode("Root");
        tree = new JTree(root);
        tree.setBounds(0,0,500,500);
        tree.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                curr = jtreeMouseClicked(me);   
                if(jtreeMouseClicked(me)!= null){ 
                temp = jtreeMouseClicked(me).toString();
                }
            }
        });
    }
    //Adding SysEntry into the tree with factors like if it's group or not, and the node user clicked on
     public void addSysEntry(SysEntry component){
    if(!usersID.contains(component.getDisplayName()) && !groupsID.contains(component.getDisplayName())){
         if(component.isGroup() && (curr==null || curr==root)){
            groups.put(component.getDisplayName(), component);
            groupsID.add(component.getDisplayName());
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
            root = (DefaultMutableTreeNode)model.getRoot();
            root.add(new DefaultMutableTreeNode(component.getDisplayName()));
            model.reload();
        }
        else if(component.isGroup() && groupsID.contains(curr.toString()) && curr != null){
            groups.put(component.getDisplayName(), component);
         groupsID.add(component.getDisplayName());
        DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
        root = (DefaultMutableTreeNode)model.getRoot();
         curr.add(new DefaultMutableTreeNode(component.getDisplayName()));
         model.reload();
        }
        if (component.isUser() && (curr == null || curr==root)){
            users.put(component.getDisplayName(), component);
            usersID.add(component.getDisplayName());
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
            root = (DefaultMutableTreeNode)model.getRoot();
            root.add(new DefaultMutableTreeNode(component.getDisplayName()));
            model.reload();
        }
        else if (component.isUser() && groupsID.contains(curr.toString())){
            users.put(component.getDisplayName(), component);
            usersID.add(component.getDisplayName());
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
            root = (DefaultMutableTreeNode)model.getRoot();
            curr.add(new DefaultMutableTreeNode(component.getDisplayName()));
            model.reload();
        }
    }
 }
    //Return tree reference
   public JTree getTree(){
    return tree;
   }

   public DefaultMutableTreeNode jtreeMouseClicked(MouseEvent evt){
        TreePath tp = tree.getPathForLocation(evt.getX(), evt.getY());
        if(tp==null){
            return null;
        }
        return (DefaultMutableTreeNode)(tp.getLastPathComponent());
   }
   //Opens User Interface
   public void openUser(){
    if(temp!=null && users.get(temp)!= null){
        NewWindow window = new NewWindow((User)users.get(temp));
    }
   }
   //Find the User within the tree
   public User findUser(String str){
    return (User)users.get(str);
   }
   //Count number of Users
   public int getTotalUsers(){
    SysEntryVisitor visit = new SysEntryVisitor();
    int total = 0;
    for(int i =0; i<usersID.size(); i++){
        User temp = (User)users.get(usersID.get(i));
        total += temp.accept(visit);
    }
    return total;

   }
   //Return the total amount of groups in tree
   public int getTotalGroups(){
    SysEntryVisitor visit = new SysEntryVisitor();
    int total = 0;
    for(int i =0; i<groupsID.size(); i++){
        Group temp = (Group)groups.get(groupsID.get(i));
        total += temp.accept(visit);
    }
    return total;

   }
   public boolean getValid(){
    for(int i =0; i<usersID.size(); i++){
        if(usersID.get(i).contains(" ")){
            return false;
        }
    }
    for(int i =0; i<groupsID.size(); i++){
        if(groupsID.get(i).contains(" ")){
            return false;
        }
    }
    return valid;
   }
   public String lastUpdatedUser(){
    String res = usersID.get(0);
    for(int i =1; i<usersID.size(); i++){
        if(users.get(res).getTime() < users.get(usersID.get(i)).getTime()){
            res = users.get(usersID.get(i)).getDisplayName();
        }
    }
    return res;
   }
}
