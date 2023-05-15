
package hotel.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;    
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddDriver extends JFrame implements ActionListener{
    
        JTextField t1, t2, t3, t4 ,t5;
        JComboBox c1, c2;
        JButton b1,b2;
        
        AddDriver(){
            
         setUndecorated(true);
         JLabel title = new JLabel("Add Driver");
         title.setFont(new Font("Tahoma",Font.PLAIN,18));
         title.setBounds(150,10,150,30);
         add(title);
                 
         JLabel name = new JLabel("Name");
         name.setFont(new Font("Tahoma",Font.PLAIN,16));
         name.setBounds(60,70,100,30);
         add(name);
         
         t1 = new JTextField();
         t1.setBounds(200,70,150,30);
         add(t1);
        
         JLabel age = new JLabel("Age");
         age.setFont(new Font("Tahoma",Font.PLAIN,16));
         age.setBounds(60,110,100,30);
         add(age);
                  
         t2 = new JTextField();
         t2.setBounds(200,110,150,30);
         add(t2);
         
         JLabel gender = new JLabel("Gender");
         gender.setFont(new Font("Tahoma",Font.PLAIN,16));
         gender.setBounds(60,150,100,30);
         add(gender);
         
         c1 = new JComboBox(new String[] { "Mail","Femail"});
         c1.setBounds(200,150,150,30);
         c1.setBackground(Color.WHITE);
         add(c1);
         
         JLabel car = new JLabel("Car Company");
         car.setFont(new Font("Tahoma",Font.PLAIN,16));
         car.setBounds(60,190,100,30);
         add(car);
         
         t3 = new JTextField();
         t3.setBounds(200,190,150,30);
         add(t3);
         
         JLabel model = new JLabel("Car Model");
         model.setFont(new Font("Tahoma",Font.PLAIN,16));
         model.setBounds(60,230,100,30);
         add(model);
         
         t4 = new JTextField();
         t4.setBounds(200,230,150,30);
         add(t4);
         
         JLabel avaiabe = new JLabel("Avaiabe");
         avaiabe.setFont(new Font("Tahoma",Font.PLAIN,16));
         avaiabe.setBounds(60,270,100,30);
         add(avaiabe);
         
         c2 = new JComboBox(new String[] { "Avaiabe","Busy"});
         c2.setBounds(200,270,150,30);
         c2.setBackground(Color.WHITE);
         add(c2);
         
         JLabel location = new JLabel("Location");
         location.setFont(new Font("Tahoma",Font.PLAIN,16));
         location.setBounds(60,310,100,30);
         add(location);
         
         t5 = new JTextField();
         t5.setBounds(200,310,150,30);
         add(t5);
         
         b1 = new JButton("Add Driver");
         b1.addActionListener(this);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(60,370,130,30);
         add(b1);
         
         b2 = new JButton("Cancel");
         b2.addActionListener(this);
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(220,370,130,30);
         add(b2);
         
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/driver.jpg"));
            Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT); 
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l1 = new JLabel(i3); 
            l1.setBounds(400,30,500,350); 
            add(l1); 

            getContentPane().setBackground(Color.WHITE);

            setLayout(null);
            setBounds(530,200,950,500);
            setVisible(true);
    }
            public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String)c1.getSelectedItem();
            String company = t3.getText();
            String brand = t4.getText();
            String avilable = (String)c1.getSelectedItem();
            String location = t5.getText();
              
            Pattern numStr = Pattern.compile(".*[0-9].*");
            Pattern alfaStr = Pattern.compile(".*[A-Za-z].*");
            Matcher name1 = alfaStr.matcher(name);
            Matcher age1 = numStr.matcher(age);
            Matcher company1 = alfaStr.matcher(company);
            Matcher brand1 = alfaStr.matcher(brand);
            Matcher location1 = alfaStr.matcher(location);
            
            if(name.isEmpty()){
            JOptionPane.showMessageDialog(null,"name field is manditory");   
            }
            else if(name1.matches()==false){
            JOptionPane.showMessageDialog(null,"name Must be Alphabet");
            }
            else if(age.isEmpty()){
            JOptionPane.showMessageDialog(null,"age field is manditory");  
            }    
            else if(age1.matches()==false){
            JOptionPane.showMessageDialog(null,"age Must be Numeric");
            }
            else if(company.isEmpty()){
            JOptionPane.showMessageDialog(null,"company field is manditory");  
            }    
            else if(company1.matches()==false){
            JOptionPane.showMessageDialog(null,"company Name Must be Alphabet");
            }
            else if(brand.isEmpty()){
            JOptionPane.showMessageDialog(null,"brand field is manditory");  
            }    
            else if(brand1.matches()==false){
            JOptionPane.showMessageDialog(null,"brand Name Must be Alphabet");
            }
            else if(location.isEmpty()){
            JOptionPane.showMessageDialog(null,"location field is manditory");  
            }    
            else if(location1.matches()==false){
            JOptionPane.showMessageDialog(null,"location Name Must be Alphabet");
            }
            
            conn c = new conn();
              try{
                  String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+avilable+"','"+location+"')";
                  c.s.executeUpdate(str);
                  
                  JOptionPane.showMessageDialog(null," Driver Successfully Added");
                  this.setVisible(false);
              }catch(Exception e){
               System.out.println(e);
              }
              }else if (b2 == ae.getSource()){
               this.setVisible(false); 
                      
                      }
              
                    
            }
        
            public static void main(String[] args){
            new AddDriver().setVisible(true); 
          }
        
    }
    

