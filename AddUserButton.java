
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AddUserButton extends JButton implements ActionListener {
    private JButton button;
    public AddUserButton(){
        button = new JButton();
        button.setText("Add User");
        button.setFocusable(false);
        button.addActionListener(this);
        button.setBounds(0,0, 50, 50);
    }
    public JButton getButton(){
        return button;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("Test");
        }
        
    }

}