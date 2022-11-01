import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class AdminControlPanel{ //implement ActionEvent {
    private JFrame frame;
    private JLabel label;
    private JPanel treeViewPanel;
    private JPanel rightPanel;
    private JButton userId;
    private JButton addUser;
    private JButton groupID;
    private JButton addGroup;
    private JButton openUserView;
    private JButton showUserTotal;
    private JButton showGroupTotal;
    private JButton showMessagesTotal;
    private JButton showPositivePercentage;

    public AdminControlPanel(){
        userId = new JButton();
    addUser= new JButton();
     groupID= new JButton();
     addGroup= new JButton();
      openUserView= new JButton();
    showUserTotal= new JButton();
    showGroupTotal= new JButton();
     showMessagesTotal= new JButton();
        showPositivePercentage= new JButton();
        frame = new JFrame();
        frame.setTitle("MiniTwitter");
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        label = new JLabel();
        treeViewPanel = new JPanel();
        rightPanel = new JPanel();
        treeViewPanel.setBounds(0,0,500, 1000);
        rightPanel.setBounds(500,0, 500, 1000);
        treeViewPanel.setBackground(Color.red);
        rightPanel.setBackground(Color.blue); 
        frame.add(treeViewPanel);
        frame.add(rightPanel);
        frame.add(userId);
    }
    public void totalUser(){
        System.out.println(User.getUsers());
    }
    public void totalGroups(){
        System.out.println(UserGroup.getCount());
    }
    public void totalTweets(){
        System.out.println(User.getTweets());
    }
    public void totalPositiveTweets(){
        System.out.println((double)User.getPositiveTweets()/User.getTweets());
    }

    
    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     if(e.getSource()==userId){
    //         System.out.println("Hi");
    //     }
        
    // }
}
