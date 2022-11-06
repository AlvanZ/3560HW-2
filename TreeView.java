import java.util.Enumeration;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.*;
public class TreeView {
    private HashMap<String, SysEntry> users;
    private HashMap<String, SysEntry> groups;
    private ArrayList<String> groupsID;
    private ArrayList<String> usersID;
    private String temp;
    private JTree tree;
    private DefaultMutableTreeNode curr;
    private DefaultMutableTreeNode root;
    public TreeView(){
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
 public void addSysEntry(SysEntry component){
    if(!usersID.contains(component.getDisplayName()) && !groupsID.contains(component.getDisplayName())){
        if(component.isGroup() && groupsID.contains(curr.toString()) && curr != null){
                  groups.put(component.getDisplayName(), component);
            groupsID.add(component.getDisplayName());
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
            root = (DefaultMutableTreeNode)model.getRoot();
            curr.add(new DefaultMutableTreeNode(component.getDisplayName()));
            model.reload();
        }
        else if(component.isGroup() && curr==null || curr==root){
            groups.put(component.getDisplayName(), component);
            groupsID.add(component.getDisplayName());
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
            root = (DefaultMutableTreeNode)model.getRoot();
            root.add(new DefaultMutableTreeNode(component.getDisplayName()));
            model.reload();
        }
        else if (!component.isGroup() && curr == null || curr==root){
            users.put(component.getDisplayName(), component);
            usersID.add(component.getDisplayName());
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
            root = (DefaultMutableTreeNode)model.getRoot();
            root.add(new DefaultMutableTreeNode(component.getDisplayName()));
            model.reload();
        }
        else if (!component.isGroup() && groupsID.contains(curr.toString())){
            users.put(component.getDisplayName(), component);
            usersID.add(component.getDisplayName());
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
            root = (DefaultMutableTreeNode)model.getRoot();
            curr.add(new DefaultMutableTreeNode(component.getDisplayName()));
            model.reload();
        }
    }
 }
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
   public void openUser(){
    if(temp!=null && users.get(temp)!= null){
        NewWindow window = new NewWindow(users.get(temp));
    }
   }
}
