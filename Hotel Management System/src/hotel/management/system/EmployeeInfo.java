
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.*;

public class EmployeeInfo extends JFrame  implements ActionListener{
    JTable t1;
    JButton b1,b2; 
    
         EmployeeInfo(){
        
        t1 = new JTable();
        t1.setBounds(0,40,1000,500 );
        add(t1);
         
         JLabel l1 = new JLabel("Name");
         l1.setFont(new Font("Tahoma",Font.PLAIN,18));
         l1.setBounds(40,10,70,20);
         add(l1);
         
         JLabel l2 = new JLabel("age");
         l2.setFont(new Font("Tahoma",Font.PLAIN,18));
         l2.setBounds(170,10,70,20);
         add(l2);
         
         JLabel l3= new JLabel("Gender");
         l3.setFont(new Font("Tahoma",Font.PLAIN,18));
         l3.setBounds(280,10,70,20);
         add(l3);
         
          JLabel l4= new JLabel("Department");
         l4.setFont(new Font("Tahoma",Font.PLAIN,18));
         l4.setBounds(390,10,100,20);
         add(l4);
        
          JLabel l5= new JLabel("salary");
         l5.setFont(new Font("Tahoma",Font.PLAIN,18));
         l5.setBounds(530,10,70,20);
         add(l5);
         
         JLabel l6= new JLabel("Phone");
         l6.setFont(new Font("Tahoma",Font.PLAIN,18));
         l6.setBounds(650,10,70,20);
         add(l6);
         
         JLabel l7= new JLabel("Aadhar");
         l7.setFont(new Font("Tahoma",Font.PLAIN,18));
         l7.setBounds(770,10,70,20);
         add(l7);
         
         JLabel l8= new JLabel("Email");
         l8.setFont(new Font("Tahoma",Font.PLAIN,18));
         l8.setBounds(900,10,70,20);
         add(l8);
         
         b1 = new JButton("Load Data");
         b1.addActionListener(this);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(350,560,120,30);
         add(b1);
         
           b2 = new JButton("Back");
           b2.addActionListener(this);
           b2.addActionListener(this);
           b2.setBackground(Color.BLACK);
           b2.setForeground(Color.WHITE);
           b2.setBounds(550,560,120,30);
           add(b2);
         
           getContentPane().setBackground(Color.WHITE);
             
        setBounds(500,200,1000,650);
        setLayout(null);
        setVisible(true);
        
        
            }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                try{
                        conn c = new conn();
                        String str = "select * from employee";
                        ResultSet rs = c.s.executeQuery(str);
                       
                        t1.setModel(DbUtils.resultSetToTableModel(rs));
                        
                        }catch(Exception e){}
                
             
         }else if(ae.getSource() == b2){
                 new Reception().setVisible(true);
                 this.setVisible(false); 
         }
          
      }
        public static void main(String[] args){
            new EmployeeInfo().setVisible(true); 
        }
         
}
