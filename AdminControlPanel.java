import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.FlowLayout;
public class AdminControlPanel implements ActionListener{ 
    private static AdminControlPanel admin = new AdminControlPanel();
    private JSplitPane split;
    private TreeView treeView;
    private JFrame frame;
    private JLabel label;
    private JPanel treeViewPanel;
    private JPanel rightPanel;
    private JTextField userID;
    private JTextField groupID;
    private JButton addUser;
    private JButton addGroup;
    private JButton openUserView;
    private JButton showUserTotal;
    private JButton showGroupTotal;
    private JButton showMessagesTotal;
    private JButton showPositivePercentage;
    private JButton last;
    private JOptionPane popUp;
    private JButton valid;
    private AdminControlPanel(){
        setup();
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
    public void setup(){
        //Initialize all the buttons, frames and panes
        last = new JButton();
        valid = new JButton();
        popUp = new JOptionPane();
        frame = new JFrame();
        addUser= new JButton();
         addGroup= new JButton();
          openUserView= new JButton();
        showUserTotal= new JButton();
        showGroupTotal= new JButton();
         showMessagesTotal= new JButton();
            showPositivePercentage= new JButton();
            userID = new JTextField();
            groupID = new JTextField();
            treeViewPanel = new JPanel();
            rightPanel = new JPanel();
            treeView = new TreeView();
            JPanel bottom = new JPanel();
            JPanel top = new JPanel();
            JSplitPane split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
            JSplitPane split3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
            JSplitPane split4 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
            JSplitPane split5 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
            split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
            //Setup Buttons
            addUser.setText("Add User");
            addUser.setFocusable(false);
            addUser.addActionListener(this);
            addUser.setBounds(0,0, 100, 50);
            addGroup.setText("Add Group");
            addGroup.setFocusable(false);
            addGroup.addActionListener(this);
            addGroup.setBounds(0,0, 100, 50);
            openUserView.setFocusable(false);
            openUserView.addActionListener(this);
            openUserView.setBounds(0,0, 100, 50);
            openUserView.setText("Open User View");
           showUserTotal.setText("Show User Total");
            showUserTotal.setFocusable(false);
            showUserTotal.addActionListener(this);
            showUserTotal.setBounds(0,0, 100, 50);
            showGroupTotal.setText("Show Group Total");
            showGroupTotal.setFocusable(false);
            showGroupTotal.addActionListener(this);
            showGroupTotal.setBounds(0,0, 100, 50);
            showMessagesTotal.setText("Show Message Total");
            showMessagesTotal.setFocusable(false);
            showMessagesTotal.addActionListener(this);
            showMessagesTotal.setBounds(0,0, 100, 50);
           showPositivePercentage.setText("Show Positive Tweet Percentage");
           showPositivePercentage.setFocusable(false);
           showPositivePercentage.addActionListener(this);
           showPositivePercentage.setBounds(0,0, 100, 50);
           valid.addActionListener(this);
           valid.setBounds(0,0, 100, 50);
          valid.setText("Valid");
         last.addActionListener(this);
          last.setBounds(0,0, 100, 50);
         last.setText("Last Updated User");
           //Setup Title and size
            frame.setTitle("MiniTwitter");
            frame.setSize(1000, 1000);
            userID.setPreferredSize(new Dimension(150, 50));
            groupID.setPreferredSize(new Dimension(150, 50));
            //Setting up split panels to have the GUI properly set up
            split2.setLeftComponent(userID);
            split2.setRightComponent(addUser);
            split3.setLeftComponent(groupID);
            split3.setRightComponent(addGroup);
            split4.add(split2);
            split4.add(split3);
            top.add(split4);
            bottom.add(openUserView);
            bottom.add(showUserTotal);
            bottom.add(showGroupTotal);
            bottom.add(showMessagesTotal);
            bottom.add(showPositivePercentage);
            bottom.add(valid);
            bottom.add(last);
            rightPanel.add(split5);
            split5.add(top);
            split5.add(bottom);
            split.setLeftComponent(treeView.getTree());
            split.setRightComponent(rightPanel);
            frame.add(split);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Finishing touches for splitpane
            split.setOneTouchExpandable(true);
            split.setDividerLocation(150);
            frame.setVisible(true);

    }


    public TreeView getTree(){
        //returns the tree for NewWindow to use
        return treeView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //sets up buttons for action
       if(e.getSource()==addUser ){
        //Adds user into treeView if it doesn't exist or is not empty string
            if(userID.getText() != null && !userID.getText().trim().equals("")){
            SysEntry user = new User(userID.getText());
            treeView.addSysEntry(user);
            }
       }
         else if(e.getSource()==addGroup){
              //Adds Group into treeView if it doesn't exist or is not empty string
        if(groupID.getText()!= null &&!groupID.getText().trim().equals("")){
        SysEntry group = new Group(groupID.getText());
        treeView.addSysEntry(group);
        }
        }
        else if(e.getSource()==openUserView){
            //Opens userView with the method passed to TreeView
            treeView.openUser();
        }
        else if(e.getSource()==showUserTotal){
            //Pops up the userTotal
            int total =treeView.getTotalUsers();
            JOptionPane.showMessageDialog(null, "There is " + total + " number of Users", "Number of Groups", JOptionPane.PLAIN_MESSAGE);
        }
        else if(e.getSource()==showGroupTotal){
            //pops up total groups
            int total =treeView.getTotalGroups();
           JOptionPane.showMessageDialog(null, "There is " + total + " number of groups", "Number of Groups", JOptionPane.PLAIN_MESSAGE);
        }
        else if(e.getSource() == showMessagesTotal){
            //pops up total messages
            JOptionPane.showMessageDialog(null, "There is " + User.getTweets() + " number of tweets", "Number of Groups", JOptionPane.PLAIN_MESSAGE);
        }
        else if(e.getSource() == showPositivePercentage){
            //pops up how many of the tweets are positive which just includes the keywords good and nice
            JOptionPane.showMessageDialog(null, "There is " + User.getPositiveTweets() + "% number of tweets were positive", "Number of Groups", JOptionPane.PLAIN_MESSAGE);
        }
        else if (e.getSource() == valid){
            JOptionPane.showMessageDialog(null, "Valid: " + treeView.getValid(), "Number of Groups", JOptionPane.PLAIN_MESSAGE);
        }
        else if (e.getSource() == last){
            JOptionPane.showMessageDialog(null, "Last Updated User: " + treeView.lastUpdatedUser(), "Number of Groups", JOptionPane.PLAIN_MESSAGE);
        }
    
    }
  
}
