
package automobile.s.service.center.software;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Report extends JFrame implements ActionListener{
    JTextField name,nsc;
    Choice ctype ;
    JButton submit;
    
    Report(){
      setTitle("Report");
      setSize(550,320);
      setLocation(530,230);
      
      
      
      JLabel lblname = new JLabel("Name");
      lblname.setBounds(60,50,100,20);
      lblname.setFont(new Font("monospaced",Font.PLAIN,15));
      add(lblname);
      name = new JTextField();
      name.setBounds(140,52,130,20);
      add(name);
      
      
       JLabel text = new JLabel("Nearest");
       text.setBounds(60,90,100,20);
       text.setFont(new Font("monospaced",Font.PLAIN,15));
       add(text);
       
       JLabel text1 = new JLabel("Service");
       text1.setBounds(60,105,100,20);
       text1.setFont(new Font("monospaced",Font.PLAIN,15));
       add(text1);
       
       JLabel text2 = new JLabel("Centre");
       text2.setBounds(60,120,100,20);
       text2.setFont(new Font("monospaced",Font.PLAIN,15));
       add(text2);
       
       nsc = new JTextField();
       nsc.setBounds(140,105,130,20);
       add(nsc);
       
       JLabel lblcom = new JLabel("Complain");
       JLabel lblcom1 = new JLabel("Type");      
       lblcom.setBounds(60,150,78,20);
       lblcom.setFont(new Font("monospaced",Font.PLAIN,15));
       lblcom1.setBounds(60,165,78,20);
       lblcom1.setFont(new Font("monospaced",Font.PLAIN,15));
       add(lblcom);
       add(lblcom1);
       ctype = new Choice();
       ctype.add("Service related");
       ctype.add("Warranty related");
       ctype.add("Others");
       ctype.setBounds(140,155,130,20);
       add(ctype); 
       
       submit = new JButton("Submit");
       submit.setBounds(110,230,100,20);
       submit.addActionListener(this);
       add(submit);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconebs/complaint.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Using SCALE_SMOOTH for smoother scaling
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(295, 35, 200, 200);
        add(image);

        getContentPane().setBackground(new Color(237, 138, 191)); 

      
      setLayout(null);
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==submit){
           try{
               String Name = name.getText();
               String nearest = nsc.getText();
               String type = ctype.getSelectedItem();
               Conn c = new Conn();
               String query = "insert into report values('"+Name+"', '"+nearest+"', '"+type+"' )";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Your complain has been successfully registered");
               
           }catch(Exception e){
               e.printStackTrace();
           }
       }
      
    }
    
    public static void main(String args[]){
        new Report();
    }
}
