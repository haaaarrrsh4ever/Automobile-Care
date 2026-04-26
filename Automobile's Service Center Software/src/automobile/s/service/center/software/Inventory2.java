
package automobile.s.service.center.software;



import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Inventory2 extends JFrame implements ActionListener,MouseListener{
    
    JTextField product,pricefield,code;
    Choice choice;
    JButton search,add,use;
    JTable table;
    
    private String selectedProductName;
    private String selectedProductCode;
    private String selectedProductPrice;

    
    Inventory2(){
        setTitle("Inventory");
        setSize(650,350);
        setLocation(470,220);
        
        setLayout(new BorderLayout());
        
       JPanel northpanel = new JPanel();
       /*
       northpanel.setLayout(new BoxLayout(northpanel, BoxLayout.X_AXIS));
       */
       
       //1st Jlabel code
       JLabel lblproduct = new JLabel("Product Name");
       /*
       northpanel.add(Box.createRigidArea(new Dimension(10,0 )));
       */
       lblproduct.setFont(new Font("Tahoma",Font.PLAIN,15));
       northpanel.add(lblproduct);     
       product = new JTextField(10);
       northpanel.add(product);
       northpanel.add(Box.createRigidArea(new Dimension(30,0 ))); 
       
       //2nd Jlabel code
       JLabel lblcode = new JLabel("Product Code");
       lblcode.setFont(new Font("Tahoma",Font.PLAIN,15));
       northpanel.add(lblcode);
       choice = new Choice();
       choice.add("AB1");
       choice.add("AB2");
       choice.add("AB3");
       choice.add("AB4");
       choice.add("AB5");
       choice.add("AB6");
       northpanel.add(choice);
       northpanel.add(Box.createRigidArea(new Dimension(30,0 )));
       /*
       code = new JTextField(10);
       northpanel.add(code);
       northpanel.add(Box.createRigidArea(new Dimension(30,0 )));
       */
       
       //3rd Jlabel code
       JLabel price = new JLabel("Product Price");
       price.setFont(new Font("Tahoma",Font.PLAIN,15));
       northpanel.add(price);
       pricefield =  new JTextField(10);
       northpanel.add(pricefield);
       
       add(northpanel,BorderLayout.NORTH);
       
       //buttons code
       JPanel southpanel = new JPanel();
       
       search = new JButton("Search Product");
       search.setForeground(Color.white);
       search.setBackground(Color.black);
       search.addActionListener(this);
       southpanel.add(search);
       
       add = new JButton("Add Product");
       add.setForeground(Color.white);
       add.setBackground(Color.black);
       add.addActionListener(this);
       southpanel.add(add);
       
       use = new JButton("Use Product");
       use.setForeground(Color.white);
       use.setBackground(Color.black);
       use.addActionListener(this);
       southpanel.add(use);
       add(southpanel,BorderLayout.SOUTH);
        
       
       //table code
       JPanel westpanel = new JPanel();
       
      
       table = new JTable(); 
       table.setBackground(Color.cyan);
       
       try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from inventory");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
       
        table.addMouseListener(this);
       
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,500,400);
        sp.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        add(sp);
        add(westpanel,BorderLayout.WEST);
     
        
        
       
        getContentPane().setBackground(Color.pink);
        setVisible(true);
    }
    
    
        
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search) {
            if (ValidateField()) {
                String PN = product.getText();
                String PP = pricefield.getText();

                String query = "select * from inventory where product_name = '" + product.getText() + "' ";

                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                 JOptionPane.showMessageDialog(null, "Please fill in all required fields.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        }
       /*
       else if(ae.getSource()==add){
          String PN = product.getText();
          String PC = choice.getSelectedItem();
          String PP = pricefield.getText();
           
           try{
               Conn c = new Conn();
               
               String query = "insert into inventory values('"+PN+"', '"+PC+"' ,'"+PP+"','"+10+"')";
               
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Products added successfully");
               
           }catch(Exception e){
               e.printStackTrace();
           } 
       }
       
       */
       
        else if (ae.getSource() == add) {
            if(ValidateField()){
            String productName = product.getText();
            String productCode = choice.getSelectedItem();
            String productPrice = pricefield.getText();

            try {
                Conn c = new Conn();

                // Check if the product already exists in the database
                String checkIfExistsQuery = "SELECT * FROM inventory WHERE product_name = '" + productName + "' AND product_code = '" + productCode + "'";
                ResultSet resultSet = c.s.executeQuery(checkIfExistsQuery);

                if (resultSet.next()) {
                    // Product exists, update the quantity
                    int existingQuantity = resultSet.getInt("product_quantity");
                    int newQuantity = existingQuantity + 10;

                    String updateQuantityQuery = "UPDATE inventory SET product_quantity = ? WHERE product_name = ? AND product_code = ?";
                    PreparedStatement updateQuantityStatement = c.c.prepareStatement(updateQuantityQuery);
                    updateQuantityStatement.setInt(1, newQuantity);
                    updateQuantityStatement.setString(2, productName);
                    updateQuantityStatement.setString(3, productCode);

                    updateQuantityStatement.executeUpdate();
                } else {
                    // Product does not exist, insert a new row
                    String insertQuery = "INSERT INTO inventory VALUES (?, ?, ?, ?)";
                    PreparedStatement insertStatement = c.c.prepareStatement(insertQuery);
                    insertStatement.setString(1, productName);
                    insertStatement.setString(2, productCode);
                    insertStatement.setString(3, productPrice);
                    insertStatement.setInt(4, 10); // Initial quantity is 10 for a new product
                    insertStatement.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Product added successfully");
                refreshTable();

            } catch (Exception e) {
                e.printStackTrace();
            }
            }
            else{
                 JOptionPane.showMessageDialog(null, "Please fill in all required fields.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        }

     /*  
       else if(ae.getSource()==use){
         
          int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            try {
                // Retrieve product information from the selected row
                String productName = (String) table.getValueAt(selectedRow, 0);
                String productCode = (String) table.getValueAt(selectedRow, 1);
                String productPrice = (String) table.getValueAt(selectedRow, 2);

                // Check if the product quantity is greater than 0 before using
                ResultSet rs = new Conn().s.executeQuery("SELECT product_quantity FROM inventory WHERE product_name = '"
                        + productName + "' AND product_code = '" + productCode + "'");

                if (rs.next()) {
                    int currentQuantity = rs.getInt("product_quantity");
                    //JOptionPane.showMessageDialog(null,"Do you want to use the selected product");
                    if (currentQuantity > 0) {
                        // Perform the "use" operation (subtract 1 from product quantity)
                        
                         //JOptionPane.showMessageDialog(null,"Use the selected Product...?");
                         int choice = JOptionPane.showConfirmDialog(null, "Do you want to use the selected product?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
                         
                         new ServicePerformed();
                         
                         
                        useProduct(productName, productCode, productPrice);

                        // Refresh the JTable to reflect the updated data
                        refreshTable();
                        
                    } else {
                        // Product is out of stock
                        JOptionPane.showMessageDialog(this, "Sorry, the product is out of stock.");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error handling mouse click event.");
            }
            
            //JOptionPane.showMessageDialog(null,"Use.....?");
        }
    
           
       } 
          
          
          
           
    }
         */    
     
     
     else if (ae.getSource() == use) {
            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1) {
                try {
                    // Retrieve product information from the selected row
                    String productName = (String) table.getValueAt(selectedRow, 0);
                    String productCode = (String) table.getValueAt(selectedRow, 1);
                    String productPrice = (String) table.getValueAt(selectedRow, 2);

                    // Check if the product quantity is greater than 0 before using
                    ResultSet rs = new Conn().s.executeQuery("SELECT product_quantity FROM inventory WHERE product_name = '"
                            + productName + "' AND product_code = '" + productCode + "'");

                    if (rs.next()) {
                        int currentQuantity = rs.getInt("product_quantity");

                        // Show a confirmation dialog
                        int choice = JOptionPane.showConfirmDialog(null, "Do you want to use the selected product?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);

                        if (choice == JOptionPane.OK_OPTION) {
                            if (currentQuantity > 0) {
                                // Perform the "use" operation (subtract 1 from product quantity)
                                useProduct(productName, productCode, productPrice);

                                // Refresh the JTable to reflect the updated data
                                refreshTable();
                                new ServicePerformed();
                            } else {
                                // Product is out of stock
                                JOptionPane.showMessageDialog(this, "Sorry, the product is out of stock.");
                            }
                        } else {
                            // User clicked on "Cancel" or closed the dialog
                            // Handle accordingly (if needed)
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error handling mouse click event.");
                }
            }
        }
    }

           
    private void refreshTable() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM inventory");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == table && e.getClickCount() == 1) {
            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1) {
                // Retrieve product information from the selected row
                selectedProductName = (String) table.getValueAt(selectedRow, 0);
                selectedProductCode = (String) table.getValueAt(selectedRow, 1);
                selectedProductPrice = (String) table.getValueAt(selectedRow, 2);
            }
        }
    }

    
    //useProduct function
    /*
    private void useProduct() {
        System.out.println("Using Product");

        if (selectedProductName != null && selectedProductCode != null && selectedProductPrice != null) {
            try {
                Conn c = new Conn();
                String updateQuery = "UPDATE inventory SET product_quantity = product_quantity - 1 WHERE product_name = '"
                        + selectedProductName + "' AND product_code = '" + selectedProductCode + "'";

                System.out.println("Update Query: " + updateQuery);
                int rowsAffected = c.s.executeUpdate(updateQuery);

                System.out.println("Rows Affected: " + rowsAffected);

                refreshTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No product selected.");
        }
    }

   */
    
    
      
private void useProduct(String productName, String productCode, String productPrice) {
    System.out.println("Using Product");
    try {
        Conn c = new Conn();

        // Check if the product quantity is greater than 0
        String checkQuery = "SELECT product_quantity FROM inventory WHERE product_name = '"
                + productName + "' AND product_code = '" + productCode + "'";
        ResultSet rs = c.s.executeQuery(checkQuery);

        if (rs.next()) {
            int quantity = rs.getInt("product_quantity");
            System.out.println("Retrieved Quantity: " + quantity);

            if (quantity > 0) {
                // Perform the "use" operation (subtract 1 from product quantity)
                String updateQuery = "UPDATE inventory SET product_quantity = product_quantity - 1 WHERE product_name = '"
                        + productName + "' AND product_code = '" + productCode + "'";
                c.s.executeUpdate(updateQuery);

                // You may want to check if the quantity is already 0 before updating
                // to avoid negative quantities.

                System.out.println("Update Query: " + updateQuery);
                System.out.println("Rows Affected: 1");
            } else {
                // Product is out of stock
                JOptionPane.showMessageDialog(this, "Sorry, the product is out of stock.");
            }
        } else {
            // Error in fetching quantity
            JOptionPane.showMessageDialog(this, "Error fetching product quantity.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}




    
    
    @Override
    public void mouseEntered(MouseEvent e) {
        // You can leave this empty or add any necessary implementation.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // You can leave this empty or add any necessary implementation.
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        // You can leave this empty or add any necessary implementation.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // You can leave this empty or add any necessary implementation.
    }


    private boolean ValidateField(){
        return !product.getText().isEmpty() &&
               !pricefield.getText().isEmpty();
    }
    

    
   public static void main(String args[]){
       new Inventory2();
   } 
}


