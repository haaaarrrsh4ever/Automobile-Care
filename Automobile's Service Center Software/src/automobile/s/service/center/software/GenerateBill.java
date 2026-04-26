
package automobile.s.service.center.software;


import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class GenerateBill extends JFrame implements ActionListener{
    JButton bill,print;
    JTextField no,date;
    JTextArea area,area2;
    String chassisno;
    JTable table;
    JDateChooser DateChooser;
    
    
    
     int chassisCount;
    //String vehicleno;
    JLabel name,chassis,type;
    GenerateBill(String chassisno){
        this.chassisno = chassisno;
        setSize(550,700);
        setLocation(510,70);
        
        /*
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        add(panel,NORTH);
        
        JLabel heading = new JLabel("Generate Bill For Chassis Number");
        heading.setFont(new Font("monospaced",Font.PLAIN,20));
        panel.add(heading);
        
        no = new JTextField(10);
        panel.add(no);
        
        JLabel lbldate = new JLabel("For Date");
        lbldate.setFont(new Font("monospaced",Font.PLAIN,20));
        panel.add(lbldate);
        
        date = new JTextField(10);
        panel.add(date);
        
        */
        /*
        JPanel northpanel = new JPanel(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        
        JPanel firstlbl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        firstlbl.add(lbl1);
        */
        
        JPanel northPanel = new JPanel(new BorderLayout());

        // Create two labels
        JLabel label1 = new JLabel("Generate Bill For Chassis Number");
        label1.setFont(new Font("monospaced",Font.PLAIN,20));
        
        
        JLabel label2 = new JLabel("For Date");
        label2.setFont(new Font("monospaced",Font.PLAIN,20));
        
        no = new JTextField(10);
        //JTextField date = new JTextField(10);
        DateChooser = new JDateChooser();
        
        
        // Set the preferred size of the date picker
        DateChooser.setPreferredSize(new Dimension(120, 20));
         

        // Create a panel with FlowLayout for the first line
        JPanel firstLinePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        firstLinePanel.add(label1);
        firstLinePanel.add(no);

        // Create a panel with FlowLayout for the second line
        JPanel secondLinePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       // secondLinePanel.add(label2);
        secondLinePanel.add(DateChooser);

        // Add the panels to the NORTH panel
        northPanel.add(firstLinePanel, BorderLayout.NORTH);
 //       northPanel.add(secondLinePanel, BorderLayout.SOUTH);

        // Add the NORTH panel to the frame
        add(northPanel, BorderLayout.NORTH);

        
        
        area = new JTextArea();
        area.setFont(new Font("Bahnschrift Light",Font.ITALIC,20));
        area.setText("\n\t-----------Click on the----------- \n\t    Generate Bill Button to get\n\tbill of Selected Vehicle Number");
       // area.setText("Click on Generate Bill Button to calculate bill");
        add(area,CENTER);
        
        
        JPanel button = new JPanel();
        add(button,SOUTH);
        
        bill  = new JButton("Generate Bill");
        bill.setFont(new Font("monospaced",Font.PLAIN,17));
        bill.addActionListener(this);
        button.add(bill);
        
        print = new JButton("Print Bill");
        print.setFont(new Font("monospaced",Font.PLAIN,17));
        print.addActionListener(this);
        button.add(print);
        
       
        
        
        setVisible(true);
    }
    
   
   
    
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource()==bill) {
        
        
        chassisno = no.getText();
                System.out.print(chassisno);
                
                area.setText("\n\t-----------Click on the----------- \n\t"
                        + "  Generate Bill Button to get\n"
                        + "                        Bill of Chassis Number" +" " +chassisno);
          
                 area.removeAll();
                
        JLabel lblname = new JLabel("Name");
        setLayout(null);
        lblname.setBounds(30, 150, 100, 20);
        lblname.setFont(new Font("monospaced", Font.ITALIC, 18));
        area.add(lblname);
        name = new JLabel("");
        name.setBounds(180, 150, 130, 23);
        name.setFont(new Font("Tahoma", Font.ITALIC, 18));
        area.add(name);

        JLabel lblchassis = new JLabel("Chassis No");
        lblchassis.setBounds(30, 180, 140, 20);
        lblchassis.setFont(new Font("monospaced", Font.ITALIC, 18));
        area.add(lblchassis);
        chassis = new JLabel("");
        chassis.setBounds(180, 182, 130, 20);
        chassis.setFont(new Font("Tahoma", Font.ITALIC, 18));
        area.add(chassis);
                    
        //alt+shift+f to align code one below another
       
        JLabel lbltype = new JLabel("Vehicle Type");
        lbltype.setBounds(30, 210, 165, 25);
        lbltype.setFont(new Font("monospaced", Font.ITALIC, 18));
        area.add(lbltype);
        type = new JLabel("");
        type.setBounds(180, 212, 130, 23);
        type.setFont(new Font("Tahoma",Font.ITALIC,18));
        area.add(type);
        
                    
                
                try{
                    Conn c = new Conn();
                    String query = "select * from signup where chassis_no = '" + chassisno + "' ";   
                    
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        name.setText(rs.getString("name")); 
                        chassis.setText(rs.getString("chassis_no"));
                        type.setText(rs.getString("vehicle_type"));
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No Data found for Chassis number" +" " +chassisno);
                    } //filling details for chassis no
                    
                    
                   ResultSet rs2 = c.s.executeQuery("SELECT * FROM service_history " +
                                  "WHERE chassis_no = '" + chassisno + "' " +
                                  "AND date = (SELECT MAX(date) FROM service_history " +
                                              "WHERE chassis_no = '" + chassisno + "')");

                    
                    area.append("\n\n\n\n\n\n\n\n Activity Performed"  +"\t"  +"Cost" );
                    area.append("\n-----------------------------------------------------");
                    double Total = 0.0;
                     
                     while (rs2.next()) {
                        String ap = rs2.getString("activity_performed");
                        String ba = rs2.getString("billing_amount");
                        

                        double billingAmount = Double.parseDouble(ba);
                        Total += billingAmount;
                        /*area.append("\n" +"                " +ap +"\t\t" +ba);*/
                        String formattedString = String.format("\n%-10s\t\t%-10s", ap, ba);
                        area.append(formattedString);
                    }
                     
                     area.append("\n-----------------------------------------------------");
                     area.append("\n Total:\t\t" + String.format("%.2f", Total) +"   " +"+"  +"   " +"18% GST");
                     double gst = Total*0.18;
                     double grandTotal = Total+gst;
                     area.append("\n\n Grand Total:\t\t" + String.format("%.2f",  grandTotal));
                    
                }catch(Exception e){
                    e.printStackTrace();
                }

        }//for 1st if statement 
    
        
        else if(ae.getSource()==print){
            /*
            JFrame frame = new JFrame("Printed Bill");
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());
            
            table = new JTable();
           
            String query = "select * from service_history where chassis_no = '"+chassisno+"' ";
            */
            try{
                /*
                Conn c = new Conn();
               ResultSet rs = c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
               
               JScrollPane scrollPane = new JScrollPane(table);
               frame.add(scrollPane, BorderLayout.CENTER);
               //table.print();
               
               frame.setVisible(true);

                 */
            
                printTextArea(area);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
                
    }
    
    
    private void printTextArea(JTextArea textArea) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Bill");

        printerJob.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            // Exclude the instruction text
            int excludedX = 0;
            int excludedY = 0;
            int excludedWidth = textArea.getWidth();
            int excludedHeight = 3*textArea.getFontMetrics(textArea.getFont()).getHeight();

            
            textArea.printAll(g2d);
            
            g2d.setColor(Color.WHITE);
            g2d.fillRect(excludedX, excludedY, excludedWidth, excludedHeight);


            return Printable.PAGE_EXISTS;
        });

        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

  
    
    
    
    public static void main(String args[]){
        new GenerateBill("");
    }
}
