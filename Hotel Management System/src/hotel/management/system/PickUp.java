
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class PickUp extends JFrame implements ActionListener{
    
    Choice c1;
    JButton b1,b2;
    JTable t1;
    
              
              
    PickUp(){
        
         JLabel l1 = new JLabel("PickUp Service");
         l1.setFont(new Font("Tahoma",Font.PLAIN,20));
         l1.setBounds(400,20,200,30);
         l1.setForeground(Color.BLUE);
         add(l1);
         
         JLabel l2 = new JLabel("Type Of Car");
         l2.setFont(new Font("Tahoma",Font.PLAIN,16));
         l2.setBounds(50,100,100,20);
         l2.setForeground(Color.BLACK);
         add(l2);
         
         
         
         c1 = new Choice();
         try{
             
             conn c = new conn();
             ResultSet rs = c.s.executeQuery("select * from  driver");
             while(rs.next()){
             c1.add(rs.getString("brand"));
                 
             }
         }catch(Exception e){
            
         } c1.setBounds(170,100,200,25);
           add(c1);
         
         t1 = new JTable();
         t1.setBounds(0,200,1000,300);
         add(t1);
        
         
         b1 = new JButton("Submit");
         b1.addActionListener(this);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(300,520,120,30);
         add(b1);
         
         b2 = new JButton("Back");
         b2.addActionListener(this);
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(500,520,120,30);
         add(b2);
         
         JLabel l3 = new JLabel("Name");
         l3.setFont(new Font("Tahoma",Font.PLAIN,16));
         l3.setBounds(30,160,100,20);
         l3.setForeground(Color.BLACK);
         add(l3);
         
         JLabel l4 = new JLabel("Age");
         l4.setFont(new Font("Tahoma",Font.PLAIN,16));
         l4.setBounds(200,160,100,20);
         l4.setForeground(Color.BLACK);
         add(l4);
         
         JLabel l5 = new JLabel("Gender");
         l5.setFont(new Font("Tahoma",Font.PLAIN,16));
         l5.setBounds(330,160,130,20);
         l5.setForeground(Color.BLACK);
         add(l5);
         
         JLabel l6 = new JLabel("Company");
         l6.setFont(new Font("Tahoma",Font.PLAIN,16));
         l6.setBounds(460,160,130,20);
         l6.setForeground(Color.BLACK);
         add(l6);
         
         JLabel l7 = new JLabel("Brand");
         l7.setFont(new Font("Tahoma",Font.PLAIN,16));
         l7.setBounds(630,160,130,20);
         l7.setForeground(Color.BLACK);
         add(l7);
         
         
         JLabel l8 = new JLabel("Availibility");
         l8.setFont(new Font("Tahoma",Font.PLAIN,16));
         l8.setBounds(740,160,130,20);
         l8.setForeground(Color.BLACK);
         add(l8);
         
         JLabel l9 = new JLabel("Location");
         l9.setFont(new Font("Tahoma",Font.PLAIN,16));
         l9.setBounds(890,160,130,20);
         l9.setForeground(Color.BLACK);
         add(l9);
         
        
         
         getContentPane().setBackground(Color.WHITE);
         
          setBounds(500,200,1000,650);
          setLayout(null);
          setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                try{
                    
                    String str = "select * from driver where brand = '"+c1.getSelectedItem()+"'";
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(ae.getSource() == b2){
                new Reception().setVisible(true);
                this.setVisible(false);
            }
            
        }
        public static void main(String[] args){
        new PickUp().setVisible(true);
    }
        
}
