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
    private int count = 0;
    private int topIndex;
    private int bottomIndex;
    private JButton post;
    private JFrame frame;
    private JTextField textField;
    private TreeView treeView;
    private JButton follow;
    private JList<String> topTextArea;
    private JList<String> bottomTextArea;
    private DefaultMutableTreeNode node;
   public NewWindow(){
    topIndex = 0;
    bottomIndex = 0;
    treeView = AdminControlPanel.getInstance().getTree();
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(1000, 1000);
    frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    textField = new JTextField();
    }
    public void addGroup(){
        frame.setTitle("Prompt");
        submit = new JButton();
        submit.addActionListener(this);
        submit.setText("Submit");
        submit.setFocusable(false);
        submit.setBounds(0,0, 100, 50);
        textField.setPreferredSize(new Dimension(250, 40));
        frame.add(submit);
        frame.add(textField);
        frame.pack();
       frame.setVisible(true);

    }
    public void addUser(){
        frame.setTitle("Prompt");
        submit1 = new JButton();
        submit1.addActionListener(this);
        submit1.setText("Submit");
        submit1.setFocusable(false);
 
        submit1.setBounds(0,0, 100, 50);
        textField.setPreferredSize(new Dimension(250, 40));
        frame.add(submit1);
        frame.add(textField);
        frame.pack();
       frame.setVisible(true);

    }
    public void userView(){
        JSplitPane topPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JPanel bottom1 = new JPanel();
        JSplitPane bottomPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane bottomPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        topTextArea = new JList<>();
        bottomTextArea = new JList<>();
        DefaultListModel<String> following = new DefaultListModel<>();
       following.add(0, "Currently Following");
        topTextArea.setModel(following);
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
        bottom1.add(topTextArea);
        topPane.add(top);
        topPane.add(bottom1);
        JPanel bottom = new JPanel();
        JTextField tweet = new JTextField();
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
        bottomPane2.add(bottomTextArea);
        bottomPane.add(bottom);
        bottomPane.add(bottomPane2);
        split.add(topPane);
        split.add(bottomPane);
        frame.add(split);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            treeView.addSysEntry(new Group(textField.getText()));

        }
        else if(e.getSource()==submit1){
            treeView.addSysEntry(new User(textField.getText()));
        }
        
    }
    
}
