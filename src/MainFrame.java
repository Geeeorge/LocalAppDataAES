import javax.swing.*;  
  
class MainFrame extends JFrame  
{  

    MainFrame()  
    {  
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  
        setTitle("Test");  
        setSize(500, 350);  
    }  

    AES aes = new AES();
    aes.main(args);
    System.out.println(args);
}  