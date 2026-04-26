
package automobile.s.service.center.software;



import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class ViewAppointment extends JFrame implements ActionListener{
    
    JLabel lblchassisnumber;
    JTable table; 
    Choice chassisnumber;
    JButton search,print;
    
    ViewAppointment(){
        setTitle("Your Appointment");
        setSize(710,390);
        setLocation(400,150);
        setLayout(null);
        
        //getContentPane().setBackground(Color.cyan);
        getContentPane().setBackground(new Color(158, 240, 215));
        
        
        lblchassisnumber = new JLabel("Search By Chassis Number");
        lblchassisnumber.setBounds(185,10,185,20);
        lblchassisnumber.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblchassisnumber);
        
        chassisnumber = new Choice();
        chassisnumber.setBounds(370,12,130,20);
        add(chassisnumber);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from appointment where chassis_no");
            while(rs.next()){
            chassisnumber.add(rs.getString("chassis_no"));  
            
            }
        }catch(Exception e){
          e.printStackTrace();
        }
        
        
        search = new JButton("Search");
        search.setBounds(215,50,80,20);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print appointment");
        print.setBounds(315,50,150,20);
        print.setBackground(Color.black);
        print.setForeground(Color.white);
        print.addActionListener(this);
        add(print);
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT a.*\n"
                    + "FROM appointment a\n"
                    + "JOIN (\n"
                    + "    SELECT chassis_no, MAX(date) AS latest_date\n"
                    + "    FROM appointment\n"
                    + "    GROUP BY chassis_no\n"
                    + ") AS latest_appointments\n"
                    + "ON a.chassis_no = latest_appointments.chassis_no\n"
                    + "AND a.date = latest_appointments.latest_date;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setBackground(Color.cyan);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,700,600);
        add(sp);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            
            
            //String query = "select * from appointment where chassis_no = '"+chassisnumber.getSelectedItem()+"'  ";
            
          //  int selectedChassisNo = (int) chassisnumber.getSelectedItem();
            int selectedChassisNo = Integer.parseInt(chassisnumber.getSelectedItem());


            String query = "SELECT a.* "
                    + "FROM appointment a "
                    + "JOIN ( "
                    + "    SELECT chassis_no, MAX(date) AS latest_date "
                    + "    FROM appointment "
                    + "    GROUP BY chassis_no "
                    + ") AS latest_appointments "
                    + "ON a.chassis_no = latest_appointments.chassis_no "
                    + "AND a.date = latest_appointments.latest_date "
                    + "WHERE a.chassis_no = " + selectedChassisNo;

            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            } 
    }
    
    public static void main(String args[]){
        new ViewAppointment();
    }
}

