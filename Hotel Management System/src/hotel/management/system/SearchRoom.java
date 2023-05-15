
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
              
              
    SearchRoom(){
        
         JLabel l1 = new JLabel("Search For Room");
         l1.setFont(new Font("Tahoma",Font.PLAIN,20));
         l1.setBounds(400,20,200,30);
         l1.setForeground(Color.BLUE);
         add(l1);
         
         JLabel l2 = new JLabel("Room Bed Type");
         l2.setFont(new Font("Tahoma",Font.PLAIN,16));
         l2.setBounds(50,100,130,20);
         l2.setForeground(Color.BLACK);
         add(l2);
         
         c1 = new JComboBox(new String[]{"Single Bed","Double Bed"});
         c1.setBounds(200,100,150,25);
         c1.setBackground(Color.WHITE);
         add(c1);
         
         c2 = new JCheckBox("only display Avialable");
         c2.setBounds(650,100,150,25);
         c2.setBackground(Color.WHITE);
         add(c2);
         
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
         
         JLabel l3 = new JLabel("Room Number");
         l3.setFont(new Font("Tahoma",Font.PLAIN,16));
         l3.setBounds(50,160,100,20);
         l3.setForeground(Color.BLACK);
         add(l3);
         
         JLabel l4 = new JLabel("Avaibility");
         l4.setFont(new Font("Tahoma",Font.PLAIN,16));
         l4.setBounds(270,160,130,20);
         l4.setForeground(Color.BLACK);
         add(l4);
         
         JLabel l5 = new JLabel("Cleaning status");
         l5.setFont(new Font("Tahoma",Font.PLAIN,16));
         l5.setBounds(450,160,130,20);
         l5.setForeground(Color.BLACK);
         add(l5);
         
         JLabel l6 = new JLabel("Price");
         l6.setFont(new Font("Tahoma",Font.PLAIN,16));
         l6.setBounds(670,160,130,20);
         l6.setForeground(Color.BLACK);
         add(l6);
         
         JLabel l7 = new JLabel("Bed Type");
         l7.setFont(new Font("Tahoma",Font.PLAIN,16));
         l7.setBounds(870,160,130,20);
         l7.setForeground(Color.BLACK);
         add(l7);
         
        
         
         getContentPane().setBackground(Color.WHITE);
         
          setBounds(500,200,1000,650);
          setLayout(null);
          setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                try{
                    String str = "select * from Room where bed_type = '"+c1.getSelectedItem()+"'";
                    String str2 = "select * from Room where available = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
                    conn c = new conn();
                    ResultSet rs;
                    
                    if(c2.isSelected()){
                         rs = c.s.executeQuery(str2);
                        t1.setModel(DbUtils.resultSetToTableModel(rs));
                    
                    }else{
                        
                        rs = c.s.executeQuery(str);
                        t1.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(ae.getSource() == b2){
                new Reception().setVisible(true);
                this.setVisible(false);
            }
            
        }
        public static void main(String[] args){
        new SearchRoom().setVisible(true);
    }
        
}
