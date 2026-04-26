
package automobile.s.service.center.software;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.sql.SQLException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Signup extends JFrame implements ActionListener{
   
    JButton cancel,create;
    JTextField name,chassis,password,vehicleno;
    Choice vtype,atype;
    
    Signup(){
       super("Signup Page");
       setSize(590,350);
       setLocation(500,200);
       getContentPane().setBackground(new Color(98, 99, 91));
     
       
       JPanel panel = new JPanel();
       panel.setBounds(15,15,550,280);
       add(panel);
       panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
       panel.setLayout(null);
       panel.setForeground(new Color(34,139,34)); 
       
       
       JLabel lblaccount = new JLabel("Create Account as");
       
       lblaccount.setBounds(20,30,110,20);
       panel.add(lblaccount);
       atype = new Choice();
       atype.add("Customer");
       atype.setBounds(130,30,100,20);
       panel.add(atype);
       
       JLabel lblname = new JLabel("Name");
       
       lblname.setBounds(20,65,100,20);
       panel.add(lblname);
       name = new JTextField();
       name.setBounds(130,65,100,20);
       panel.add(name);
       /*
       name.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateName();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // This method is now implemented
            }

            private void validateName() {
                String input = name.getText();

                // Add your validation logic here
                // For example, check if it's not empty
                if (!input.isEmpty()) {
                    name.setForeground(UIManager.getColor("TextField.foreground"));
                } else {
                    name.setForeground(Color.RED);
                }
            }
        });
       */
       
       
              
       JLabel heading = new JLabel("Vehicle Type");
       heading.setBounds(20,100,100,20);
       panel.add(heading);
       vtype = new Choice();
       vtype.add("Two Wheeler");
       vtype.add("Four Wheeler");
       vtype.setBounds(130,100,100,20);
       panel.add(vtype);
       
       
       JLabel lblchassis = new JLabel("Chassis No");
       lblchassis.setBounds(20,135,100,20);
       panel.add(lblchassis);
       chassis = new JTextField();
       chassis.setBounds(130,135,100,20);
       panel.add(chassis);
       
       
       JLabel lblvehicleno = new JLabel("Vehicle Number");
       lblvehicleno.setBounds(20,170,100,20);
       panel.add(lblvehicleno);
       vehicleno = new JTextField();
       vehicleno.setBounds(130,170,100,20);
       panel.add(vehicleno);
       
       JLabel lblyear = new JLabel("Password");
       lblyear.setBounds(20,205,100,20);
       panel.add(lblyear);
       password = new JTextField();
       password.setBounds(130,205,100,20);
       panel.add(password);
       
       
       //buttons
       create = new JButton("Create");
       create.setBounds(35,240,80,20);
       create.setBackground(Color.black);
       create.setForeground(Color.white);
       create.addActionListener(this);
       panel.add(create);
       
       cancel = new JButton("Cancel");
       cancel.setBounds(125,240,80,20);
       cancel.setBackground(Color.black);
       cancel.setForeground(Color.white);
       cancel.addActionListener(this);
       panel.add(cancel);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconebs/signupnew.png"));
       Image i2 = i1.getImage().getScaledInstance(220,220,100);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(290,30,220,220);
       panel.add(image);
       
       
       
       //panel.setBackground(Color.white);
       panel.setBackground(new Color(250, 246, 230)); 
       
       
       
       setLayout(null);
       setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
           if (validateFields()) {  
               try {
                   String Atype = atype.getSelectedItem();
                   String Name = name.getText();
                   String Choice = vtype.getSelectedItem();
                   String Chassis_no = chassis.getText();
                   String Vehicleno = vehicleno.getText();
                   String Password = password.getText();
          
          Conn c = new Conn();
          String query = "INSERT into signup values('"+Atype+"','"+Name+"','"+Choice+"','"+Chassis_no+"','"+Vehicleno+"','"+Password+"')";
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null, "Account created successfully");
          setVisible(false);
          new Login();
          }catch(Exception e){
              e.printStackTrace();
          }
         
          } else {
                JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
            setVisible(false);
             //new Login();
    }

    private boolean validateFields() {
        // Add your validation rules here
        // For example, check if the required fields are not empty
        return !name.getText().isEmpty() &&
               !chassis.getText().isEmpty() &&
               !vehicleno.getText().isEmpty() &&
               !password.getText().isEmpty();
    }
  
    
    public static void main(String args[]){
        
        new Signup();
    }
}

