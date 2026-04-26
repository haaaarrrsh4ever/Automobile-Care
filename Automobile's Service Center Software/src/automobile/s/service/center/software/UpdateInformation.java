
package automobile.s.service.center.software;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateInformation extends JFrame implements ActionListener{
    String meter;
    JButton update,cancel;
    JTextField address,email,phone;
    
    UpdateInformation(){
        
        setSize(830,380);
        setLocation(350,200);
        setLayout(null);
        
        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(80,20,350,30);
        heading.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,70,100,30);
        add(lblname);
        JLabel name = new JLabel("");
        name.setBounds(150,70,100,30);
        add(name);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,110,100,30);
        add(lbladdress);
        address = new JTextField();
        address.setBounds(150,110,150,20);
        add(address);
              
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50,150,100,30);
        add(lblemail);      
        email = new JTextField();
        email.setBounds(150,150,150,20);
        add(email);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50,190,100,30);
        add(lblphone);      
        phone = new JTextField();
        phone.setBounds(150,190,150,20);
        add(phone);
        
        try{
          Conn c = new Conn();
          
          ResultSet rs = c.s.executeQuery("select * from NewCustomer where meter_no = '"+meter+"'");
         
          while(rs.next()){
              
              name.setText(rs.getString("name"));
              address.setText(rs.getString("address"));
              email.setText(rs.getString("email"));
              phone.setText(rs.getString("Number"));
              
              
          }
          
       }catch(Exception e){
           e.printStackTrace();
       }
        
        
        update = new JButton("Update");
        update.setBounds(75,270,80,20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(175,270,80,20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320,10,500,300);
        add(image);
        
        
       
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== update){
          String updatedaddress = address.getText();
          
          String updatedemail = email.getText();
          String updatedphone = phone.getText();
           
          
          try{
              Conn c = new Conn();
              c.s.executeUpdate("update NewCustomer set Number = '"+updatedphone+"', address = '"+updatedaddress+"',email = '"+updatedemail+"' where meter_no = '"+meter+"'");
              JOptionPane.showMessageDialog(null,"User information updated successfully");
              setVisible(false);
          }catch(Exception e){
              e.printStackTrace();
          }
           
       }
       else{
           setVisible(false);
       }
    }
    
    public static void main(String args[]){
        new UpdateInformation();
    }
}


