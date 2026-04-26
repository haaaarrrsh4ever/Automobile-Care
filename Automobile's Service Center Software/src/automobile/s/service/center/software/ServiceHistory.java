
package automobile.s.service.center.software;



import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class ServiceHistory extends JFrame implements ActionListener{
    
    JLabel lblchassisnumber;
    Choice chassisnumber;
    JButton search;
    JTable table;
    
    ServiceHistory(){
        setTitle("Service History");
        setSize(710,350);
        setLocation(400,220);
        setLayout(null);
        
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
            ResultSet rs = c.s.executeQuery("select * from service_history where chassis_no");
            while(rs.next()){
            chassisnumber.add(rs.getString("chassis_no"));   
            }
        }catch(Exception e){
          e.printStackTrace();
        }
        
        
        search = new JButton("Search");
        search.setBounds(295,50,80,20);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);
        
        table = new JTable();
        table.setBackground(Color.cyan);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from service_history");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,700,150);
        add(sp);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            
            String query = "select * from service_history where chassis_no = '"+chassisnumber.getSelectedItem()+"'  ";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                 
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String args[]){
        new ServiceHistory();
    }
}



