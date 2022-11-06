import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;
public class NewWindow extends JFrame implements ActionListener{
    private JButton submit;
    private JButton submit1;
    private int topIndex;
    private int bottomIndex;
    private JScrollPane sp;
    private JScrollPane sp2;
    private JButton post;
    private JFrame frame;
    private JTextField textField;
    private JTextField tweet;
    private TreeView treeView;
    private JButton follow;
    private JList<String> topTextArea;
    private JList<String> bottomTextArea;
    private DefaultMutableTreeNode node;
    private SysEntry curr;
    DefaultListModel<String> following;
   public NewWindow(SysEntry user){
    curr = user;
    topIndex = 0;
    bottomIndex = 0;
    treeView = AdminControlPanel.getInstance().getTree();
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(1000, 1000);
    frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    textField = new JTextField();
    JSplitPane topPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    JPanel bottom1 = new JPanel();
    JSplitPane bottomPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    JSplitPane bottomPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    topTextArea = new JList<>();
    bottomTextArea = new JList<>();
     following = new DefaultListModel<>();
   following.addElement("Currently Following");
    topTextArea.setModel(following);
    sp = new JScrollPane(topTextArea);
    JPanel top = new JPanel();
    follow = new JButton();
    follow.addActionListener(this);
    follow.setText("Follow User");
    follow.setFocusable(false);
    follow.setBounds(0,0, 100,50);
    textField.setPreferredSize(new Dimension(250, 40));
    JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    top.add(textField);
    top.add(follow);
    bottom1.add(sp);
    topPane.add(top);
    topPane.add(bottom1);
    JPanel bottom = new JPanel();
    tweet = new JTextField();
    tweet.setPreferredSize(new Dimension(250, 40));
    post = new JButton();
    post.addActionListener(this);
   post.setText("Submit");
    post.setFocusable(false);
    bottom.add(tweet);
    bottom.add(post);   
    DefaultListModel<String> newsFeed = new DefaultListModel<>();
    newsFeed.add(0, "News Feed");
    bottomTextArea.setModel(newsFeed);
    sp2 = new JScrollPane(bottomTextArea);
    bottomPane2.add(sp2);
    bottomPane.add(bottom);
    bottomPane.add(bottomPane2);
    split.add(topPane);
    split.add(bottomPane);
    frame.add(split);
    frame.setVisible(true);
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==follow){
            DefaultListModel list = (DefaultListModel) topTextArea.getModel();
            if(User.contains(textField.getText())&& !list.contains(textField.getText())){
                    following.addElement(textField.getText());
                    topTextArea.setModel(following);


            }
        }
        
    }
    
}
