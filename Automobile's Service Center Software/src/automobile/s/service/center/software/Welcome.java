
package automobile.s.service.center.software;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;


public class Welcome extends JFrame implements Runnable{
    int i;
    Thread t = new Thread(this);
    
    

    public Welcome() {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconebs/serviceperformed5.png"));
        Image image = i1.getImage().getScaledInstance(490,410,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(5,50,490,410);
        add(i3);
      
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
       for( i = 1; i<=250; i+=3) 
       {
          setSize(2*i,2*i);
          setLocation(750-i,400-i); 
          try{
              Thread.sleep(8);
          }catch(Exception e){
              e.printStackTrace();
          }
       }
       
       
           JLabel heading = new JLabel("Automobile Service Center");
           heading.setFont(new Font("Tahoma", Font.PLAIN, 41));
           heading.setForeground(new Color(237, 174, 97));
           heading.setBounds(2,2,500,35);
           add(heading);
           setVisible(true);
           
          t.start();
           
          while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
               
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
           
        }
          
         
    }
    
    public void run(){
        try{
          Thread.sleep(4000);
          setVisible(false);
          new Login();
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
    
    public static void main(String[] args) {
       new Welcome();
    }
}


