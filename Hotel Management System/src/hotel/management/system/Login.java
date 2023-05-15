package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    Login(){
        
        setUndecorated(true);
        
        l1 = new JLabel("Username");
        l1.setBounds(40,50,100,30);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,100,100,30);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l2);
              
        t1 = new JTextField();
        t1.setBounds(150,50,150,30);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(t1);
        
        t2 = new JPasswordField();
        t2.setBounds(150,100,150,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(t2);
        
        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);  
        b1.setBounds(40,170,120,30);
        b1.setFont(new Font("Tahoma",Font.PLAIN,16));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancle");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);  
        b2.setBounds(180,170,120,30);
        b2.setFont(new Font("Tahoma",Font.PLAIN,16));
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(310,10,200,200);
        add(l3);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(600,300,540,260); 
        setVisible(true);
        
    }
      public void actionPerformed(ActionEvent ae){ 
        if(ae.getSource()==b1){
            String username = t1.getText();
            String password = t2.getText();

            if(username.isEmpty()){
            JOptionPane.showMessageDialog(null,"username field is manditory");   
            }
            
            if(password.isEmpty()){
            JOptionPane.showMessageDialog(null,"password field is manditory");   
            }
            
            conn c = new conn();
            
            String str = "select * from login where username = '"+username+"' and password = '"+password+"'";
            try{                
                 ResultSet rs = c.s.executeQuery(str);   
                 if(rs.next()){
                     new Dashboard().setVisible(true);
                     this.setVisible(false);                    
                 }else{
                     JOptionPane.showMessageDialog(null,"Invalid username and password ");
                   //  this.setVisible(false);
                 }
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource()==b2){
            System.exit(0);
            
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
    
}