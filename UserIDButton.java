
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class UserIDButton extends JButton implements ActionListener {
    private JButton button;
    public UserIDButton(){
        button = new JButton();
        button.setText("User ID");
        button.setFocusable(false);
        button.addActionListener(this);
        button.setBounds(0,0, 100, 50);
    }
    public JButton getButton(){
        return button;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            frame.dispose();
            System.out.println("Test");
        }
        
    }

}