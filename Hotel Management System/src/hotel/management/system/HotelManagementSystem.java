package hotel.management.system;

import javax.swing.*;
import java.awt.*;


public class HotelManagementSystem extends JFrame{

  HotelManagementSystem(){
      setBounds(200,200,1440,600);
      //setSize(400,400);
      //setLocation(300,300);
      
      ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/abc.jpg")); 
      Image i3 = i1.getImage().getScaledInstance(1440,600, Image.SCALE_DEFAULT);
      ImageIcon i2 = new ImageIcon(i3);
      JLabel l1 = new JLabel(i2);
      l1.setBounds(0, 0,1440,600);
      add(l1);
      JLabel l2 = new JLabel("Rajdhani Hotel");
      l2.setBounds(0,0,1000, 80);
      l2.setFont(new Font("sarif", Font.PLAIN,40));
      l2.setForeground(Color.WHITE);
      l1.add(l2);
          
      setLayout(null);
      setVisible(true);   
      try{
        for(int l=1;l<=5;l++){
            l2.setText("Please Wait. Loading "+l);
            if(l==5){
                new Login().setVisible(true);
                this.dispose();
            }
            Thread.sleep(1000);

        }
      }catch(Exception ex){
      }
  }

    public static void main(String[] args) {
      new HotelManagementSystem();
    }

}