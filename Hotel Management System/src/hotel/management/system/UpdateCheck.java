
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
        JButton b1,b2,b3;
        Choice c1;
        JTextField t1,t2,t3,t4,t5;
        
         UpdateCheck(){
        
         JLabel l1 = new JLabel("Check-In Details");
         l1.setFont(new Font("Tahoma",Font.PLAIN,20));
         l1.setBounds(90,30,200,30);
         l1.setForeground(Color.BLUE);
         add(l1);
         
         
         JLabel l2 = new JLabel("Customer-ID ");
         l2.setFont(new Font("Tahoma",Font.PLAIN,13));
         l2.setBounds(30,80,100,20);
         l2.setForeground(Color.BLACK);
         add(l2);
         
         c1 = new Choice();
         try{
               conn c = new conn();
              String str  = "select * from customer";
              ResultSet rs = c.s.executeQuery(str);
              while(rs.next()){
                  c1.add(rs.getString("number"));
              }
                  
              
         }catch(Exception e){}
         c1.setBounds(200,80,150,25);
         add(c1);
         
         JLabel l3 = new JLabel("Room Number");
         l3.setFont(new Font("Tahoma",Font.PLAIN,13));
         l3.setBounds(30,120,100,20);
         l3.setForeground(Color.BLACK);
         add(l3);
         
         t1 = new JTextField();
         t1.setBounds(200,120,150,25);
         add(t1);
         
         JLabel l4 = new JLabel("Name");
         l4.setFont(new Font("Tahoma",Font.PLAIN,13));
         l4.setBounds(30,160,100,20);
         l4.setForeground(Color.BLACK);
         add(l4);
         
         t2 = new JTextField();
         t2.setBounds(200,160,150,25);
         add(t2);
         
         JLabel l5 = new JLabel("Check-in");
         l5.setFont(new Font("Tahoma",Font.PLAIN,13));
         l5.setBounds(30,200,100,20);
         l5.setForeground(Color.BLACK);
         add(l5);
         
         t3 = new JTextField();
         t3.setBounds(200,200,150,25);
         add(t3);
         
         JLabel l6 = new JLabel("Amount paid");
         l6.setFont(new Font("Tahoma",Font.PLAIN,13));
         l6.setBounds(30,240,100,20);
         l6.setForeground(Color.BLACK);
         add(l6);
         
         t4 = new JTextField();
         t4.setBounds(200,240,150,25);
         add(t4);
         
         JLabel l7 = new JLabel("pending Amount");
         l7.setFont(new Font("Tahoma",Font.PLAIN,13));
         l7.setBounds(30,280,100,20);
         l7.setForeground(Color.BLACK);
         add(l7);
         
         t5 = new JTextField();
         t5.setBounds(200,280,150,25);
         add(t5);
         
         b1 = new JButton("Check");
         b1.addActionListener(this);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(30,340,100,30);
         add(b1);
         
         b2 = new JButton("Update");
         b2.addActionListener(this);
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(150,340,100,30);
         add(b2);
         
         b3 = new JButton("Back");
         b3.addActionListener(this);
         b3.setBackground(Color.BLACK);
         b3.setForeground(Color.WHITE);
         b3.setBounds(270,340,100,30);
         add(b3);
         
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/checkinout.png")); 
            Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel icon = new JLabel(i3);
            icon.setBounds(400, 50,500,300);
            add(icon);

            getContentPane().setBackground(Color.WHITE);
            
         setBounds(500,200,980,500);
         setLayout(null);
         setVisible(true);
    }
         public void actionPerformed(ActionEvent ae){
             if(ae.getSource() == b1){
                 try{
                     String room = null;
                     String deposit  = null;
                     int amountPaid;  
                     String price  = null;
                     conn c = new conn();
                     String id = c1.getSelectedItem();
                     String str = "select * from customer where number = '"+id+"'"; 
                     ResultSet rs = c.s.executeQuery(str);
                     while(rs.next()){
                         t1.setText(rs.getString("room"));
                         t2.setText(rs.getString("name"));
                         t3.setText(rs.getString("Status"));
                         t4.setText(rs.getString("deposit"));
                         room = rs.getString("room");
                         deposit  = rs.getString("deposit");
                     }
                     
                     ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                     while(rs2.next()){
                         price = rs2.getString("price");
                         amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                         t5.setText(Integer.toString(amountPaid));
                     }
                     
                 }catch(Exception e){
                     e.printStackTrace();
                 }
                 
             }else if(ae.getSource() == b2){
                    
             }else if(ae.getSource() == b3){
                  new Reception().setVisible(true);
                  this.setVisible(false);   
         }
                  
             }
           
    
    public static void main(String[] args){
        new UpdateCheck().setVisible(true);
    }
                   
}
