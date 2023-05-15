
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;


public class AddCustomer extends JFrame implements ActionListener{
    
        JTextField t1, t2, t3, t4 ,t5;
        JComboBox c1;
        JButton b1,b2;
        Choice c2;
        JRadioButton r1,r2;
        
        AddCustomer(){
        
         JLabel l1 = new JLabel("NEW CUSTOMER FORM");
         l1.setFont(new Font("Tahoma",Font.PLAIN,20));
         l1.setBounds(100,20,300,30);
         l1.setForeground(Color.BLUE);
         add(l1);
         
         JLabel l2 = new JLabel("ID");
         l2.setFont(new Font("Tahoma",Font.PLAIN,12));
         l2.setBounds(35,80,100,20);
         add(l2);
         
         c1 = new JComboBox(new String[]{"Passport","Voter - id Card","Driving Licence","Aadhar Card"});
         c1.setBounds(200,80,150,25);
         c1.setBackground(Color.WHITE);
         add(c1);
         
         JLabel l3 = new JLabel("Number");
         l3.setFont(new Font("Tahoma",Font.PLAIN,12));
         l3.setBounds(35,120,100,20);
         add(l3);
         
         t1 = new JTextField();
         t1.setBounds(200,120,150,25);
         add(t1);
         
         JLabel l4 = new JLabel("Name");
         l4.setFont(new Font("Tahoma",Font.PLAIN,12));
         l4.setBounds(35,160,100,20);
         add(l4);
         
         t2 = new JTextField();
         t2.setBounds(200,160,150,25);
         add(t2);
         
         JLabel l5 = new JLabel("Gender");
         l5.setFont(new Font("Tahoma",Font.PLAIN,12));
         l5.setBounds(35,200,100,20);
         add(l5);
         
         r1 = new JRadioButton("Male");
         r1.setBounds(200,200,60,25);
         r1.setBackground(Color.WHITE);
         add(r1);
         
         r2 = new JRadioButton("Female");
         r2.setBounds(270,200,80,25);
         r2.setBackground(Color.WHITE);
         add(r2);
         
         JLabel l6 = new JLabel("Country");
         l6.setFont(new Font("Tahoma",Font.PLAIN,12));
         l6.setBounds(35,240,100,20);
         add(l6);
         
         t3 = new JTextField();
         t3.setBounds(200,240,150,25);
         add(t3);
         
         JLabel l7 = new JLabel("Allocated Room Number");
         l7.setFont(new Font("Tahoma",Font.PLAIN,12));
         l7.setBounds(35,280,150,20);
         add(l7);
         
         c2 = new Choice();
         try{
              conn c = new conn();
              String str  = "select * from room";
              ResultSet rs = c.s.executeQuery(str);
              while(rs.next()){
              c2.add(rs.getString("room_number"));
             }
              
         }catch(Exception e){}
            c2.setBounds(200,280,150,25);
            add(c2);
         
         JLabel l8 = new JLabel("Checked In");
         l8.setFont(new Font("Tahoma",Font.PLAIN,12));
         l8.setBounds(35,320,100,20);
         add(l8);
         
         t4 = new JTextField();
         t4.setBounds(200,320,150,25);
         add(t4);
         
         JLabel l9 = new JLabel("Deposit");
         l9.setFont(new Font("Tahoma",Font.PLAIN,12));
         l9.setBounds(35,360,100,20);
         add(l9);
         
         t5 = new JTextField();
         t5.setBounds(200,360,150,25);
         add(t5);
         
         b1 = new JButton("Add Customer");
         b1.addActionListener(this);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(50,410,120,25);
         add(b1);
         
         b2 = new JButton("Back");
         b2.addActionListener(this);
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(200,410,120,25);
         add(b2);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/addcustomer.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(250,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(400, 100,250,300);
        add(icon);
      
         getContentPane().setBackground(Color.WHITE);
         
         setBounds(650,200,700,520);
         setLayout(null);
         setVisible(true);
        } 
    
         public void actionPerformed(ActionEvent ae){
            
        
         if(ae.getSource() == b1){
            
        
        String id = (String)c1.getSelectedItem();
        String number = t1.getText();
        String name = t2.getText();
        String gender = null;
        if(r1.isSelected()){
               gender = "Male";
        }else if(r2.isSelected()){
               gender = "Male"; 
        }
        String country =  t3.getText();
        String room = c2.getSelectedItem();
        String status =  t4.getText();
        String deposit  =  t5.getText();
        
        
        Pattern numStr = Pattern.compile(".*[0-9].*");
        Pattern alfaStr = Pattern.compile(".*[A-Za-z].*");
        Matcher number1 = numStr.matcher(number);
        Matcher name1 = alfaStr.matcher(name);
        Matcher country1 = alfaStr.matcher(country);
        Matcher deposit1 = numStr.matcher(deposit);

        if(number.isEmpty()){
            JOptionPane.showMessageDialog(null,"number field is manditory");   
        }
        else if(number1.matches()==false){
            JOptionPane.showMessageDialog(null,"number Must be Numeric");
        }
        else if(name.isEmpty()){
            JOptionPane.showMessageDialog(null,"name field is manditory");  
        }    
        else if(name1.matches()==false){
            JOptionPane.showMessageDialog(null,"name Must be Alphabet");
        }
        else if(country.isEmpty()){
            JOptionPane.showMessageDialog(null,"country field is manditory");  
        }    
        else if(country1.matches()==false){
            JOptionPane.showMessageDialog(null,"country Name Must be Alphabet");
        }
        else if(deposit.isEmpty()){
            JOptionPane.showMessageDialog(null,"deposit field is manditory");   
        }
        else if(deposit1.matches()==false){
            JOptionPane.showMessageDialog(null,"deposit Amount Must be Numeric");
        } 
                String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
                String str2 = "update room set available = 'occupied' where room_number = '"+room+"'"; 

                try{
                   conn c = new conn();
                   c.s.executeUpdate(str);
                   c.s.executeUpdate(str2);

                   JOptionPane.showMessageDialog(null,"new Customer Added");
                   new Reception().setVisible(true);
                   this.setVisible(false);

                   }catch(Exception e){
                          e.printStackTrace();
                   }
    }else if(ae.getSource() == b2){
        new Reception().setVisible(true);
        this.setVisible(false);    
    }
}    

    
        public static void main(String[] args){
        new AddCustomer().setVisible(true);
               }
                
}
