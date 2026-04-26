
package automobile.s.service.center.software;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ViewInformation extends JFrame{
    
    JLabel name,chassis,type,vehicleno;
    
    ViewInformation(String Chassisno){
        setTitle("Your Account Information");
        setSize(500,230);
        setLocation(500,240);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconebs/information3.png"));
        Image image = i1.getImage().getScaledInstance(150, 150, 20);
        ImageIcon i2 = new ImageIcon(image);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(310,20,150,150);
        add(i3);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(10, 20, 100, 20);
        lblname.setFont(new Font("monospaced", Font.PLAIN, 15));
        add(lblname);
        name = new JLabel("");
        name.setBounds(140, 22, 130, 20);
        name.setFont(new Font("Tahoma",Font.PLAIN,15));
        name.setBackground(Color.white);
        add(name);

        JLabel lblchassis = new JLabel("Chassis No");
        lblchassis.setBounds(10, 60, 100, 20);
        lblchassis.setFont(new Font("monospaced", Font.PLAIN, 15));
        add(lblchassis);
        chassis = new JLabel("");
        chassis.setBounds(140, 62, 130, 20);
        chassis.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(chassis);
        //alt+shift+f to align code one below another
       
        JLabel lbltype = new JLabel("Vehicle Type");
        lbltype.setBounds(10, 100, 110, 20);
        lbltype.setFont(new Font("monospaced", Font.PLAIN, 15));
        add(lbltype);
        type = new JLabel("");
        type.setBounds(140, 102, 130, 20);
        type.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(type);
        
        JLabel lblvehicleno = new JLabel("Vehicle number");
        lblvehicleno.setBounds(10,140,125,20);
        lblvehicleno.setFont(new Font("monospaced",Font.PLAIN,15));
        add(lblvehicleno);
        vehicleno = new JLabel("");
        vehicleno.setBounds(140,142,130,20);
        vehicleno.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(vehicleno);
        
      try{
      Conn c = new Conn();
       
      String query = "select * from signup where chassis_no = '"+Chassisno+"'";
      
      ResultSet rs = c.s.executeQuery(query);
      if(rs.next()){
          name.setText(rs.getString("name"));
          chassis.setText(rs.getString("chassis_no"));
          type.setText(rs.getString("vehicle_type"));
          vehicleno.setText(rs.getString("vehicle_no"));
      }
      else{
           System.out.println("No data found for chassis number: " + Chassisno);
      }
      }catch(Exception e){
          e.printStackTrace();
      }

        
      
      getContentPane().setBackground(new Color(243, 247, 223));
      
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new ViewInformation("");
    }
}

