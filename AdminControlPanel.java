import java.awt.Color;
import javax.swing.*;
import java.awt.FlowLayout;
public class AdminControlPanel{ 
    private JFrame frame;
    private JLabel label;
    private JPanel treeViewPanel;
    private JPanel rightPanel;
    private UserIDButton userId;
    private AddUserButton addUser;
    private GroupIDButton groupID;
    private AddGroupButton addGroup;
    private OpenUserView openUserView;
    private ShowUserTotalButton showUserTotal;
    private ShowGroupTotal showGroupTotal;
    private ShowMessagesTotal showMessagesTotal;
    private ShowPositive showPositivePercentage;
    public AdminControlPanel(){
        setupButtons();
        frame = new JFrame();
        frame.setTitle("MiniTwitter");
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        treeViewPanel = new JPanel();
        rightPanel = new JPanel();
 
        rightPanel.setBounds(500,0, 500, 1000);
        frame.add(treeViewPanel);
        frame.add(rightPanel);
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        rightPanel.add(userId.getButton());
        rightPanel.add(addUser.getButton());
        rightPanel.add(groupID.getButton());
        rightPanel.add(addGroup.getButton());
        rightPanel.add(openUserView.getButton());
        rightPanel.add(showUserTotal.getButton());
        rightPanel.add(showGroupTotal.getButton());
        rightPanel.add(showMessagesTotal.getButton());
        rightPanel.add(showPositivePercentage.getButton());
        


       
    }
    public static void totalUser(){
        System.out.println(User.getUsers());
    }
    public static void totalGroups(){
        System.out.println(UserGroup.getCount());
    }
    public static void totalTweets(){
        System.out.println(User.getTweets());
    }
    public static void totalPositiveTweets(){
        System.out.println((double)User.getPositiveTweets()/User.getTweets());
    }
    public void setupButtons(){
        userId = new UserIDButton();
        addUser= new AddUserButton();
         groupID= new GroupIDButton();
         addGroup= new AddGroupButton();
          openUserView= new OpenUserView();
        showUserTotal= new ShowUserTotalButton();
        showGroupTotal= new ShowGroupTotal();
         showMessagesTotal= new ShowMessagesTotal();
            showPositivePercentage= new ShowPositive();
    }

    
  
}
