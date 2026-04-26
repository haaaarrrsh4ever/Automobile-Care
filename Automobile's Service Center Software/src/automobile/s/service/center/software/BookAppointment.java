
package automobile.s.service.center.software;

import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;


public class BookAppointment extends JFrame implements ActionListener{
   
    JTextField name,chassis,TimeChooser;
    JDateChooser DateChooser;
    Choice vtype;
    JButton book;
    
    
    BookAppointment(){
      setTitle("Appointments");
      setSize(350,390);
      setLocation(600,210);
      
      JLabel heading = new JLabel("Book Your Appointment");
      heading.setBounds(80,5,300,25);
      heading.setFont(new Font("Tahoma",Font.PLAIN,15));
      add(heading);
      
      //1st
      JLabel lblname = new JLabel("Name");
      lblname.setBounds(60,50,100,20);
      lblname.setFont(new Font("monospaced",Font.PLAIN,15));
      add(lblname);
      name = new JTextField();
      name.setBounds(140,52,130,20);
      add(name);
      
      //2nd
      JLabel lbldate = new JLabel("Date");
      lbldate.setBounds(60,100,100,20);
      lbldate.setFont(new Font("monospaced",Font.PLAIN,15));
      add(lbldate);  
      
        DateChooser = new JDateChooser();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateChooser.setDateFormatString("yyyy-MM-dd");
        DateChooser.setBounds(140, 102, 130, 20);
       
      add(DateChooser);
      
      //3rd
      JLabel lbltime = new JLabel("Time");
      lbltime.setBounds(60,150,100,20);
      lbltime.setFont(new Font("monospaced",Font.PLAIN,15));
      add(lbltime);
      TimeChooser = new JTextField();
      TimeChooser.setBounds(140,152,130,20);
      add(TimeChooser);
      
       JLabel text = new JLabel("Vehicle");
       JLabel text1 = new JLabel("Type");
       add(text1);
       text1.setBounds(60,215,50,20);
       text1.setFont(new Font("monospaced",Font.PLAIN,15));
       text.setBounds(60,200,70,20);
       text.setFont(new Font("monospaced",Font.PLAIN,15));
       add(text);
       vtype = new Choice();
       vtype.add("Two Wheeler");
       vtype.add("Four Wheeler");
       vtype.setBounds(140,200,130,20);
       add(vtype); 
      
      JLabel lblchassis = new JLabel("Chassis");
      lblchassis.setBounds(60,250,100,20);
      lblchassis.setFont(new Font("monospaced",Font.PLAIN,15));
      add(lblchassis);
      JLabel lblchassis1 = new JLabel("Number");
      lblchassis1.setBounds(60,265,100,20);
      lblchassis1.setFont(new Font("monospaced",Font.PLAIN,15));
      add(lblchassis1);
      chassis = new JTextField();
      chassis.setBounds(140,255,130,20);
      add(chassis);
       
      book = new JButton("Book");
      book.setBounds(120,320,80,20);
      book.addActionListener(this);
      add(book);
     
     
      
      setLayout(null);
      setVisible(true);
    }
    
    /*
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==book){
            try{
                String Name = name.getText();
                String Date = ((JTextField)DateChooser.getDateEditor().getUiComponent()).getText();
                String Time = TimeChooser.getText();
                String Type = vtype.getSelectedItem();
                String Chassis = chassis.getText();
                
                Conn c = new Conn();
                new Conn();
                
                String query ="INSERT into appointment(name,date,time,type,chassis_no) values('"+Name+"', '"+Date+"', '"+Time+"', '"+Type+"', '"+Chassis+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Appointment Booked successfully");
                
                  JOptionPane.showMessageDialog(null, "Appointment is full on selected date");
                
                        
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
*/
    
   public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == book) {
        if(ValidateFields())
        try {
            String Name = name.getText();
            String Date = ((JTextField) DateChooser.getDateEditor().getUiComponent()).getText();
            String Time = TimeChooser.getText();
            String Type = vtype.getSelectedItem();
            String Chassis = chassis.getText();

            Conn c = new Conn();

            // Check the number of appointments on the selected date
            String countQuery = "SELECT COUNT(*) FROM appointment WHERE date = '" + Date + "'";
            ResultSet resultSet = c.s.executeQuery(countQuery);

            if (resultSet.next()) {
                int appointmentCount = resultSet.getInt(1);

                // Check if the appointment limit is reached
                if (appointmentCount < 3) {
                    // Proceed with booking the appointment
                    String query = "INSERT INTO appointment(name, date, time, type, chassis_no) VALUES('" + Name + "', '"
                            + Date + "', '" + Time + "', '" + Type + "', '" + Chassis + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Appointment Booked successfully");
                } else {
                    // Display a message if the appointment limit is reached
                    JOptionPane.showMessageDialog(null, "Appointment limit reached on selected date. Please select another Date.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
         else {
           JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
       }
    }
    
      
}


private boolean ValidateFields(){
   return !name.getText().isEmpty() &&
          !TimeChooser.getText().isEmpty() &&
          DateChooser.getDate() != null;
 }
    
    
    
    public static void main(String args[]){
        new BookAppointment();
    }
}

