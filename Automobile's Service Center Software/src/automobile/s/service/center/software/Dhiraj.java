
package automobile.s.service.center.software;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.ResultSet;


public class Dhiraj extends JFrame implements ActionListener{
    
    String usertype,Chassisno,Vehicleno;  
    
    Dhiraj(String usertype,String Chassisno){
       this.usertype = usertype;
       this.Chassisno = Chassisno;
        
         System.out.println("User Type in Dhiraj: " + usertype);
 
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("iconebs/dhiraj.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(1540,850,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(200,600,500,350);
        add(image);
        
        getContentPane().setBackground(Color.white);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        //code for 1st menu
        JMenu info = new JMenu("Information");
        info.setForeground(Color.black);
        info.setFont(new Font("Tahoma",Font.PLAIN,15));
        info.setBorder(new EmptyBorder(0, 10, 0, 10));
        //mb.add(info); 
        
        JMenuItem updateinfo = new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconebs/info.png"));
        Image i2 = i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(i2));
        updateinfo.addActionListener(this);
       // info.add(updateinfo);
        
        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("iconebs/info2.png"));
        Image i4 = i3.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(i4));
        viewinfo.addActionListener(this);
        info.add(viewinfo);
       
        
        //code for2nd menu
        JMenu appointment = new JMenu("Appointment");
        appointment.setFont(new Font("Tahoma",Font.PLAIN,15));
        appointment.addActionListener(this);
        appointment.setBorder(new EmptyBorder(0, 10, 0, 10));
        //mb.add(appointment);
        
        JMenuItem book = new JMenuItem("Book Appointment");
        ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("iconebs/booking.png"));
        Image image5 = i14.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
        book.setIcon(new ImageIcon(image5));
        book.setFont(new Font("monospaced",Font.PLAIN,12));
        book.setBackground(Color.WHITE);
        book.addActionListener(this);
        appointment.add(book);
        
        JMenuItem view = new JMenuItem("View Appointment");
        ImageIcon i15 = new ImageIcon(ClassLoader.getSystemResource("iconebs/appointment.png"));
        Image image6 = i15.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
        view.setIcon(new ImageIcon(image6));
        view .setFont(new Font("monospaced",Font.PLAIN,12));
        view .setBackground(Color.WHITE);
        view .addActionListener(this);
        appointment.add(view);
        
        //code for 3rd menu
        JMenu report = new JMenu("Report");
        report.setFont(new Font("Tahoma",Font.PLAIN,15));
        report.addActionListener(this);
        report.setBorder(new EmptyBorder(5, 10, 5, 10));
        //mb.add(report);
        
        JMenuItem issue = new JMenuItem("Complain");
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("iconebs/bad.png"));
        Image image4 = i13.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
        issue.setIcon(new ImageIcon(image4));
        issue.setFont(new Font("monospaced",Font.PLAIN,12));
        issue.setBackground(Color.WHITE);
        issue.addActionListener(this);
        report.add(issue);
        
        //code for 4th menu 
        JMenu service = new JMenu("Service");
        service.setForeground(Color.red);
        service.setFont(new Font("Tahoma",Font.PLAIN,15));
        service.addActionListener(this);
        service.setBorder(new EmptyBorder(5, 10, 5, 10));
        //mb.add(service);
        
        
        JMenuItem viewservice = new JMenuItem("Service History");
        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("iconebs/sp2.png"));
        Image image3 = i12.getImage().getScaledInstance(40,30, Image.SCALE_DEFAULT);
        viewservice.setIcon(new ImageIcon(image3));
        viewservice.setFont(new Font("monospaced",Font.PLAIN,12));
        viewservice.setBackground(Color.WHITE);
        viewservice.addActionListener(this);
        service.add(viewservice);
        
        JMenuItem update = new JMenuItem("Update Service Performed");
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("iconebs/sp.png"));
        Image image2 = i11.getImage().getScaledInstance(40,30, Image.SCALE_DEFAULT);
        update.setIcon(new ImageIcon(image2));
        update.setFont(new Font("monospaced",Font.PLAIN,12));
        update.setBackground(Color.WHITE);
        update.addActionListener(this);
        service.add(update);
        
        //code for 5th JMenu
        JMenu inventory = new JMenu("Inventory");
        inventory.setForeground(Color.red);
        inventory.setFont(new Font("Tahoma",Font.PLAIN,15));
        inventory.setBorder(new EmptyBorder(0, 10, 0, 10));
        //mb.add(inventory);
        
        JMenuItem openinventory = new JMenuItem("Open Inventory");
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("iconebs/inventory.png"));
        Image image1 = i10.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        openinventory.setIcon(new ImageIcon(image1));
        openinventory.setFont(new Font("monospaced",Font.PLAIN,12));
        openinventory.setBackground(Color.WHITE);
        openinventory.addActionListener(this);
        inventory.add(openinventory);
        
        //code for 6th JMenu
        JMenu bill = new JMenu("Bill");
        bill.setForeground(Color.red);
        bill.setFont(new Font("Tahoma",Font.PLAIN,15));
        bill.setBorder(new EmptyBorder(0, 10, 0, 10));
        
        JMenuItem generate = new JMenuItem("Generate Bill");
        ImageIcon i20 = new ImageIcon(ClassLoader.getSystemResource("iconebs/bill.png"));
        Image imagei17 = i20.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        generate.setIcon(new ImageIcon(imagei17));
        generate.setFont(new Font("monospaced",Font.PLAIN,12));
        generate.setBackground(Color.WHITE);
        generate.addActionListener(this);
        bill.add(generate);
        
        
        //code 
        JMenu viewappointment = new JMenu("Check_Appointments");
        viewappointment.setForeground(Color.red);
        viewappointment.setFont(new Font("Tahoma",Font.PLAIN,15));
        viewappointment.setBorder(new EmptyBorder(0, 10, 0, 10));
        
        JMenuItem va = new JMenuItem("Check Appointments");
        ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("iconebs/va.jpg"));
        Image i22 = i21.getImage().getScaledInstance(50,40, Image.SCALE_DEFAULT);
        va.setIcon(new ImageIcon(i22));
        va.setFont(new Font("monospaced",Font.PLAIN,12));
        va.setBackground(Color.WHITE);
        va.addActionListener(this);
        viewappointment.add(va);
         
        //mb.removeAll();
        
        if(usertype.equals("Customer")){
            System.out.println("Adding to report menu");
          mb.add(info); 
          mb.add(appointment);
          mb.add(report); 
           
       }else{
           
           mb.add(service);
           mb.add(inventory);
           mb.add(bill);
           mb.add(viewappointment);
          
       }
        
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.blue);
        exit.setFont(new Font("Tahoma",Font.PLAIN,15));
        exit.setBorder(new EmptyBorder(5, 10, 5, 10));
        mb.add(exit);
        
        JMenuItem exitframe = new JMenuItem("Exit");
        exitframe.setFont(new Font("monospaced",Font.PLAIN,15));
        exitframe.setBackground(Color.white);
        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("iconebs/cancel.png"));
        Image i17 = i16.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
        exitframe.setIcon(new ImageIcon(i17));
        exitframe.addActionListener(this);
        exit.add(exitframe);
        
        
        
        
        
        setLayout(new FlowLayout());
        
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
       
       
        if(msg.equals("Book Appointment")){
            new BookAppointment();
        }
        
        else if(msg.equals("Complain")){
            new Report();
        }
        else if(msg.equals("View Appointment")){
            new ViewAppointmentC(Chassisno);
        }
        else if(msg.equals("Service History")){
            new ServiceHistory();
        }
        else if(msg.equals("Update Service Performed")){
            new ServicePerformed();
        }
        else if(msg.equals("Open Inventory")){
            new Inventory2();
        }
        else if(msg.equals("View Information")){
            new ViewInformation(Chassisno);
        }
        else if(msg.equals("Exit")){
            setVisible(false);
        }
        else if(msg.equals("Generate Bill")){
            new GenerateBill(Vehicleno);
        }
        else if(msg.equals("Check Appointments")){
            new ViewAppointment();
        }
        
    }
    
    public static void main(String args[]){
        new Dhiraj("","");
    }

    
}

