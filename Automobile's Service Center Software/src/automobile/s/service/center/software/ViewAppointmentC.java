
package automobile.s.service.center.software;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import net.proteanit.sql.DbUtils;


public class ViewAppointmentC extends JFrame implements ActionListener{
    JLabel name,vehicle,date,time;
    String c_no;
    JButton button;
    JTable table;
     
    ViewAppointmentC(String Chassis_no){
        super("Your Appointment");
        setSize(450,395);
        setLocation(530,200);
        setLayout(null);
        
        JLabel lblname = new JLabel("Name          : ");
        lblname.setBounds(10,10,100,20);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblname);
        
        name = new JLabel("");
        name.setBounds(110,10,100,20);
        name.setFont(new Font("Tahoma",Font.PLAIN,15));
        
        add(name);
        
        JLabel lblvehicle = new JLabel("Vehicle Type :");
        lblvehicle.setBounds(10,50,100,20);
        lblvehicle.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblvehicle);
        
        vehicle = new JLabel("");
        vehicle.setBounds(110,50,100,20);
        vehicle.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(vehicle);
        
        JLabel lbldate = new JLabel("Date            :");
        lbldate.setBounds(10,90,100,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lbldate);
        
        date = new JLabel("");
        date.setBounds(110,90,100,20);
        date.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(date);
        
        JLabel lbltime = new JLabel("Time            :");
        lbltime.setBounds(10,130,100,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lbltime);
        
        time = new JLabel("");
        time.setBounds(110,130,100,20);
        time.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(time);
        
        
        
        
        
        try{
            Conn c = new Conn();
            String query = "select * from signup where chassis_no = '"+Chassis_no+"' ";
            c_no = Chassis_no;
            System.out.println(c_no);
             
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                name.setText(rs.getString("name"));
               
            }
            
            
            try{
                /*resetGUIComponents();*/
                Conn c2 = new Conn();
                String query2 = "select * from appointment where chassis_no = '"+Chassis_no+"' ORDER BY date DESC, time DESC LIMIT 1 ";
                ResultSet rs2 = c2.s.executeQuery(query2);
                if(rs2.next()){
                   
                   vehicle.setText(rs2.getString("type"));
                   date.setText(rs2.getString("date"));
                   time.setText(rs2.getString("time"));
                   
                }
            
            }catch(Exception e){
                e.printStackTrace();
            }
           
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconebs/a2.png"));
        Image image = i1.getImage().getScaledInstance(300,200,10);
        ImageIcon i2 = new ImageIcon(image);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(70,165,320,190);
        add(i3);
        
        button = new JButton("Print Appointment");
        button.setBounds(280,70,140,25);
        button.setForeground(Color.white);
        button.setBackground(new Color(83, 196, 245));
        button.addActionListener(this);
        add(button);
        
        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from appointment where chassis_no = '" + c_no + "' ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 370, 700, 600);
        add(sp);
        
        getContentPane().setBackground(new Color(250, 250, 222));
        
        setVisible(true);
    }
    
    
   
    
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==button){
           try{
              table.print();
       }catch(Exception e){
           e.printStackTrace();
       }
         // setVisible(false);
       }
      
    } 
      
    
    
    
    /*
    private void resetGUIComponents() {
        name.setText(""); // Clear the name label
        vehicle.setText(""); // Clear the vehicle label
        date.setText(""); // Clear the date label
        time.setText(""); // Clear the time label
    }
    */
    
    
    public static void main(String args[]){
        new ViewAppointmentC("");
    }
}

