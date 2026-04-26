
package automobile.s.service.center.software;



import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;


public class ServicePerformed extends JFrame implements ActionListener{
    
    JTextField chassis,activity,amount;
    JDateChooser DateChooser; 
    JButton submit;
    
    
    ServicePerformed(){
        setTitle("Service Performed");
        setSize(710,270);
        setLocation(420,250);
        setLayout(null);
        
      JLabel lblchassis = new JLabel("Chassis Number");
      lblchassis.setBounds(20,20,150,20);
      lblchassis.setFont(new Font("monospaced",Font.PLAIN,15));
      add(lblchassis);
      chassis = new JTextField();
      chassis.setBounds(185,22,130,20);
      add(chassis);
      
      JLabel lblactivity = new JLabel("Activity Performed");
      lblactivity.setBounds(20,60,170,20);
      lblactivity.setFont(new Font("monospaced",Font.PLAIN,15));
      add(lblactivity);
      activity = new JTextField();
      activity.setBounds(185,62,130,20);
      add(activity);
      
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(20, 100, 100, 20);
        lbldate.setFont(new Font("monospaced", Font.PLAIN, 15));
        add(lbldate);
        DateChooser = new JDateChooser();
        DateChooser.setBounds(185, 102, 130, 20);
        add(DateChooser);
        
      
      JLabel lblamount= new JLabel("Billing Amount");
      lblamount.setBounds(20,140,150,20);
      lblamount.setFont(new Font("monospaced",Font.PLAIN,15));
      add(lblamount);
      amount = new JTextField();
      amount.setBounds(185,142,130,20);
      add(amount);
      
      submit = new JButton("Submit");
      submit.setBounds(120,190,80,20);
      submit.addActionListener(this);
      add(submit);
      
      
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconebs/serviceperformed2.png"));
      if (i1 != null) {
       Image i2 = i1.getImage().getScaledInstance(280,220,100);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(370,5,280,220);
       add(image);
      }
      else {
      System.out.println("Image not loaded!");
}
      
      getContentPane().setBackground(Color.white);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try {
                String Chassis = chassis.getText();
                String Activity = activity.getText();
                Date selectedDate = DateChooser.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = sdf.format(selectedDate);
                String Amount = amount.getText();
                Conn c = new Conn();
                String query = "Insert into service_history(chassis_no, activity_performed, date, billing_amount) values ('"+Chassis+"', '"+Activity+"', '"+formattedDate+"', '"+Amount+"') ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Service Performed details added successfully");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String args[]){
        new ServicePerformed();
    }
    
}

