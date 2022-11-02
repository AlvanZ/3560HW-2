
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class ShowUserTotalButton extends JButton implements ActionListener {
    private JButton button;
    public ShowUserTotalButton(){
        button = new JButton();
        button.setText("Show User Total");
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
            System.out.println("Test");
        }
        
    }

}