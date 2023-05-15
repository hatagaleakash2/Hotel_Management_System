
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    
      JMenuBar mb;
      JMenu m1,m2;
      JMenuItem i1,i2,i3,i4;
      
      Dashboard(){
          
          mb = new JMenuBar();
          add(mb);
          
          m1 = new JMenu("Staff");
          m1.setForeground(Color.RED);
          m1.setFont(new Font("Tahoma",Font.PLAIN,20));
          mb.add(m1);
          
          m2 = new JMenu("ADMIN");
          m2.setForeground(Color.BLACK);
          m2.setFont(new Font("Tahoma",Font.PLAIN,20));
          mb.add(m2);
          
          
          i1 = new JMenuItem("RECEPTION");
          i1.addActionListener(this);
          i1.setFont(new Font("Tahoma",Font.PLAIN,20));
          m1.add(i1);
          
          i2 = new JMenuItem("ADD EMPLOYEE");
          i2.setFont(new Font("Tahoma",Font.PLAIN,20));
          i2.addActionListener(this);
          m2.add(i2);
          
          i3 = new JMenuItem("ADD ROOMS");
          i3.addActionListener(this);
          i3.setFont(new Font("Tahoma",Font.PLAIN,20));
          m2.add(i3);
          
          i4 = new JMenuItem("ADD DRIVERS");
          i4.addActionListener(this);
          i4.setFont(new Font("Tahoma",Font.PLAIN,20));
          m2.add(i4);
          
          mb.setBounds(0,0,1980,20);
          
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/homepage.jpg"));
          Image i2 = i1.getImage().getScaledInstance(1980,1000, Image.SCALE_DEFAULT);
          ImageIcon i3 = new ImageIcon(i2);
          JLabel l1 = new JLabel(i3);//i one che not l
          l1.setBounds(0, 0,1980,1000);
          add(l1);
           
          JLabel l2 = new JLabel("THE RAJDHANI GROUP WELCOMES YOU");
          l2.setBounds(600,80,1000,50);
          l2.setForeground(Color.WHITE);
          l2.setFont(new Font("Tahoma",Font.PLAIN,45));
          l1.add(l2);
                   
          setLayout(null); 
          setBounds(0,0,1920,1020);
          setVisible(true);
      
      } 
      
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("RECEPTION")){
                new Reception().setVisible(true);
                
           }else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
                new AddEmployee().setVisible(true);
            }else if(ae.getActionCommand().equals("ADD ROOMS")){
                new AddRooms().setVisible(true);
            }else if(ae.getActionCommand().equals("ADD DRIVERS")){
                new AddDriver().setVisible(true);
            }
                
                              
        }
      public static void main(String[] args){
         new Dashboard().setVisible(true);
          
      }
}
