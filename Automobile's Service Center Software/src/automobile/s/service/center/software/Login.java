
package automobile.s.service.center.software;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login,cancel,signup;
    JTextField chassis,no,name;
    Choice logginginas;
    
    Login(){
        super("Login Page");
        setSize(640,320);
        setLocation(450,240);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconebs/main.png"));
        Image i2 = i1.getImage().getScaledInstance(190,240,20);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(40,10,200,250);
        add(image);
        
        
        JLabel lblname = new JLabel("Enter your Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblname.setBounds(275,30,200,30);
        add(lblname);
        name = new JTextField();
        name.setBounds(460,35,100,20);
        add(name);
        
        JLabel lblno = new JLabel("Enter Password");
        lblno.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblno.setBounds(275,70,200,30);
        add(lblno);
        no = new JTextField();
        no.setBounds(460,75,100,20);
        add(no);
        
        JLabel lblatype = new JLabel("Login in as");
        lblatype.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblatype.setBounds(275,110,170,30);
        add(lblatype);
        logginginas = new Choice();
        logginginas.add("Customer");
        logginginas.add("Admin");
        logginginas.setBounds(460,115,100,20);
        add(logginginas);
        
        JLabel note = new JLabel("Don't have an account..?");
        note.setFont(new Font("Tahoma",Font.PLAIN,15));
        note.setBounds(277,165,200,20);
        add(note);
        
        //buttons
        
        ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("iconebs/user.png"));
        Image i9 = i8.getImage().getScaledInstance(25,25, 25);
        signup = new JButton("Signup" ,new ImageIcon(i9));
        signup.setBounds(451,165,105,20);
        signup.addActionListener(this);
        add(signup);
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("iconebs/newlogin.png"));
        Image i5 = i4.getImage().getScaledInstance(20,20, 25); 
        
        login = new JButton("Login",new ImageIcon(i5));
        login.setBounds(310,215,95,20);
        login.addActionListener(this);
        add(login);
        
        
        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("iconebs/cancel.png"));
        Image i7 = i6.getImage().getScaledInstance(15, 15, 15);
        cancel = new JButton("Cancel",new ImageIcon(i7));
        cancel.setBounds(420,215,95,20);
       
        cancel.addActionListener(this);
        add(cancel);
        
       
       // getContentPane().setBackground(Color.white);
       getContentPane().setBackground(new Color(252, 245, 220)); 
       
        setLayout(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            if (ValidateFields()) { 
             try{
               String Name  = name.getText();
               String No = no.getText();
               String user = logginginas.getSelectedItem();
               
               Conn c = new Conn();
               String query = "select * from signup where name = '"+Name+"' and password = '"+No+"' and atype ='"+user+"'";
               ResultSet rs = c.s.executeQuery(query);
               
               if(rs.next()){
                   String Chassisno = rs.getString("chassis_no");
                   String Vehicleno = rs.getString("vehicle_no");
                   setVisible(false);
                   new Dhiraj(user,Chassisno); 
               }else{
                   JOptionPane.showMessageDialog(null, "Invalid Login");
                   chassis.setText("");
                   no.setText("");
               }
             }catch(Exception e){
                 e.printStackTrace();
                }
                
          }
            else {
                JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if(ae.getSource()==cancel){
            setVisible(false);   
        }
        
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }
            
    }
    
    private boolean ValidateFields() {
        return !name.getText().isEmpty() &&
               !no.getText().isEmpty() ;
     }
    
    
    public static void main(String args[]){
        new Login();
    }
}

