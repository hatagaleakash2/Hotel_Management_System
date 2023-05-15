
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

        public class AddRooms  extends JFrame implements ActionListener{
    
        JTextField t1, t2;
        JComboBox c1, c2, c3;
        JButton b1,b2;
        AddRooms()
        {
         setUndecorated(true);
         JLabel l1 = new JLabel("Add Rooms");
         l1.setFont(new Font("Tahoma",Font.BOLD,18));
         l1.setBounds(150,20,100,20);
         add(l1);
         
         JLabel room = new JLabel("Rooms Number");
         room.setFont(new Font("Tahoma",Font.PLAIN,16));
         room.setBounds(60,80,120,30);
         add(room);
         
         t1 = new JTextField();
         t1.setBounds(200,80,150,30);
         add(t1);
         
         JLabel available = new JLabel("Available");
         available.setFont(new Font("Tahoma",Font.PLAIN,16));
         available.setBounds(60,130,120,30);
         add(available);
        
         c1 = new JComboBox(new String[] { "Available","Occupied"});
         c1.setBounds(200,130,150,30);
         c1.setBackground(Color.WHITE);
         add(c1);
         
         JLabel ststus = new JLabel("Cleaning Status");
         ststus.setFont(new Font("Tahoma",Font.PLAIN,16));
         ststus.setBounds(60,180,120,30);
         add(ststus);
         
         c2 = new JComboBox(new String[] { "Cleaned","Dirty"});
         c2.setBounds(200,180,150,30);
         c2.setBackground(Color.WHITE);
         add(c2);
          
         JLabel price = new JLabel("Price");
         price.setFont(new Font("Tahoma",Font.PLAIN,16));
         price.setBounds(60,230,120,30);
         add(price);
         
         t2 = new JTextField();
         t2.setBounds(200,230,150,30);
         add(t2);
         
         JLabel type = new JLabel("Bed Type");
         type.setFont(new Font("Tahoma",Font.PLAIN,16));
         type.setBounds(60,280,120,30);
         add(type);
         
         c3 = new JComboBox(new String[] { "Single Bed ","Double Bed"});
         c3.setBounds(200,280,150,30);
         c3.setBackground(Color.WHITE);
         add(c3);
         
         
         
         b1 = new JButton("Add Room");
         b1.addActionListener(this);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(60,350,130,30);
         add(b1);
         
         b2 = new JButton("Cancel");
         b2.addActionListener(this);
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(220,350,130,30);
         add(b2);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
         JLabel l5 = new JLabel(i1); 
         l5.setBounds(400,30,500,350); 
         add(l5);     
         
         getContentPane().setBackground(Color.WHITE);
         
         setBounds(530,200,940,470);
         setLayout(null);
         setVisible(true);
                 
        }
      
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){

        String room = t1.getText();
        String available = (String)c1.getSelectedItem();
        String status = (String)c2.getSelectedItem();
        String price = t2.getText();
        String type = (String) c3.getSelectedItem();


        Pattern numStr = Pattern.compile(".*[0-9].*");
        Matcher room1 = numStr.matcher(room);
        Matcher price1 = numStr.matcher(price);

        if(room.isEmpty()){
           JOptionPane.showMessageDialog(null,"Room field is manditory");   
        }
        else if(room1.matches()==false){

           JOptionPane.showMessageDialog(null,"Room Number Must be Numeric");
        }
        else if(price.isEmpty()){
            JOptionPane.showMessageDialog(null,"price field is manditory");
        } 
        else if(price1.matches()==false){
            JOptionPane.showMessageDialog(null,"price Must be Numeric");
        }
        
        conn c = new conn();
        
        try{
            String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
            c.s.executeUpdate(str);

            JOptionPane.showMessageDialog(null,"new Room Added");
            this.setVisible(false);
           }
            catch(Exception e){
              System.out.println(e);
        }

        }else if(ae.getSource() == b2){
              this.setVisible(false); 
        }
    }

        public static void main(String[] args){
        new AddRooms().setVisible(true); 
        }
    }

