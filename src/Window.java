import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;  
  
 
class LoginForm extends JFrame implements ActionListener  
{  
    JButton b1;  
    JPanel newPanel;  
    JLabel usernameLabel, passwordLabel;  
    final JTextField  textField1, textField2;  
      
    LoginForm()  
    {     
          
        usernameLabel = new JLabel();  
        usernameLabel.setText("Username");      
          
        textField1 = new JTextField(5);   
  
        passwordLabel = new JLabel();  
        passwordLabel.setText("Password");     
          
        textField2 = new JPasswordField(5);    
          
        b1 = new JButton("SUBMIT"); 
          
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(usernameLabel);    
        newPanel.add(textField1);   
        newPanel.add(passwordLabel);    
        newPanel.add(textField2);    
        newPanel.add(b1);           
          
        add(newPanel, BorderLayout.CENTER);  
          
        b1.addActionListener(this);    
        setTitle("Login Test");        
    }  
      
    public void actionPerformed(ActionEvent ae)   
    {  
        String userValue = textField1.getText();        
        String passValue = textField2.getText();      
                  
        if (userValue.equals("test") && passValue.equals("test")) {  
              
            MainFrame mf = new MainFrame();  
              
            mf.setVisible(true);  
              
            JLabel wel_label = new JLabel("Test: "+userValue);  
            mf.getContentPane().add(wel_label);  
        }  
        else{  
            System.out.println("Login failed");  
        }  
    }  
}  
class Window 
{  
    public static void main(String arg[])  
    {  
        try  
        {  
            LoginForm form = new LoginForm();  
            form.setSize(500,350);  
            form.setVisible(true);  
        }  
        catch(Exception e)  
        {     
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
}