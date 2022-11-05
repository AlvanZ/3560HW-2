import java.util.Enumeration;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
public class TreeView {
    JTree tree;
    DefaultMutableTreeNode root;
    public TreeView(){
         root = new DefaultMutableTreeNode("Root");
        tree = new JTree(root);
        tree.setBounds(0,0,500,500);
    }
 public void addSysEntry(SysEntry component){
    DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
    root = (DefaultMutableTreeNode)model.getRoot();
    root.add(new DefaultMutableTreeNode(component.getDisplayName()));
    model.reload();
 }
   public JTree getTree(){
    return tree;
   }
   public DefaultMutableTreeNode findNode(String e){
    return find(root, e);
   }
   private DefaultMutableTreeNode find(DefaultMutableTreeNode root, String s) {
    @SuppressWarnings("unchecked")
    Enumeration<TreeNode> e = root.depthFirstEnumeration();
    while (e.hasMoreElements()) {
        TreeNode node = e.nextElement();
        if (node.toString().equalsIgnoreCase(s)) {
            return  (DefaultMutableTreeNode) node;
        }
    }
    return null;
}
public DefaultMutableTreeNode jtreeMouseClicked(MouseEvent evt){
    DefaultMutableTreeNode tp = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
    return tp;
}
}
