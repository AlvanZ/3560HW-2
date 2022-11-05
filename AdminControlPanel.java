import java.awt.Dimension;
import javax.swing.*;
import java.awt.FlowLayout;
public class AdminControlPanel{ 
    private static AdminControlPanel admin = new AdminControlPanel();
    private JSplitPane split;
    private TreeView treeView;
    private JFrame frame;
    private JLabel label;
    private JPanel treeViewPanel;
    private JPanel rightPanel;

    private AddUserButton addUser;
    private AddGroupButton addGroup;
    private OpenUserView openUserView;
    private ShowUserTotalButton showUserTotal;
    private ShowGroupTotal showGroupTotal;
    private ShowMessagesTotal showMessagesTotal;
    private ShowPositive showPositivePercentage;
    private AdminControlPanel(){
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        setupButtons();
        frame = new JFrame();
        frame.setTitle("MiniTwitter");
        frame.setSize(1000, 1000);
        treeViewPanel = new JPanel();
        rightPanel = new JPanel();
        treeView = new TreeView();
        rightPanel.add(addUser.getButton());
        rightPanel.add(addGroup.getButton());
        rightPanel.add(openUserView.getButton());
        rightPanel.add(showUserTotal.getButton());
        rightPanel.add(showGroupTotal.getButton());
        rightPanel.add(showMessagesTotal.getButton());
        rightPanel.add(showPositivePercentage.getButton());
        split.setLeftComponent(treeView.getTree());
        split.setRightComponent(rightPanel);
        frame.add(split);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        split.setOneTouchExpandable(true);
        split.setDividerLocation(150);
        frame.setVisible(true);
    }
    public static AdminControlPanel getInstance(){
        return admin;
    }
    public static void totalUser(){
        System.out.println(User.getUsers());
    }
    public static void totalGroups(){
        System.out.println(Group.getCount());
    }
    public static void totalTweets(){
        System.out.println(User.getTweets());
    }
    public static void totalPositiveTweets(){
        System.out.println((double)User.getPositiveTweets()/User.getTweets());
    }
    public void setupButtons(){
  
        addUser= new AddUserButton();

         addGroup= new AddGroupButton();
          openUserView= new OpenUserView();
        showUserTotal= new ShowUserTotalButton();
        showGroupTotal= new ShowGroupTotal();
         showMessagesTotal= new ShowMessagesTotal();
            showPositivePercentage= new ShowPositive();
    }

    public TreeView getTree(){
        return treeView;
    }
  
}
