
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.regex.*;
import java.text.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;   
    JButton b1,b2;
    
    AddEmployee(){
        
        setUndecorated(true);
        
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tehoma",Font.PLAIN,17));
        name.setBounds(60, 30,120, 30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200,30,150,30);
        add(t1);
        
        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tehoma",Font.PLAIN,17));
        age.setBounds(60, 80,120, 30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);
        
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tehoma",Font.PLAIN,17));
        gender.setBounds(60, 130,120, 30);
        add(gender); 
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tehoma",Font.PLAIN,14));
        r1.setBounds(200, 130,70, 30);
        r1.setBackground(Color.WHITE);
        add(r1);
               
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tehoma",Font.PLAIN,14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(270, 130,80, 30);
        add(r2);
        
        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Tehoma",Font.PLAIN,17));
        job.setBounds(60, 180,120, 30);
        add(job);
        
        String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1 = new JComboBox(str);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 180,150, 30);
        add(c1);
        
        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tehoma",Font.PLAIN,17));
        salary.setBounds(60, 230,120, 30);
        add(salary);
        
        t3 = new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);
        
        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Tehoma",Font.PLAIN,17));
        phone.setBounds(60, 280,120, 30);
        add(phone);
        
        t4 = new JTextField();
        t4.setBounds(200,280,150,30);
        add(t4);
        
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setFont(new Font("Tehoma",Font.PLAIN,17));
        aadhar.setBounds(60, 330,120, 30);
        add(aadhar);
        
        t5 = new JTextField();
        t5.setBounds(200,330,150,30);
        add(t5);
        
        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tehoma",Font.PLAIN,17));
        email.setBounds(60, 380,120, 30);
        add(email);
        
        t6 = new JTextField();
        t6.setBounds(200,380,150,30);
        add(t6);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60,430,130,30);
        b1.addActionListener(this);
        add(b1);
        
         b2 = new JButton("Cancel");
         b2.addActionListener(this);
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(220,430,130,30);
         add(b2);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3); 
        l1.setBounds(380,60,450,450); 
        add(l1);    
        
        JLabel l2 = new JLabel("Add Employee Details");
        l2.setForeground(Color.BLUE);
        l2.setBounds(440,30,400,30);
        l2.setFont(new Font("Tehoma",Font.PLAIN,30));
        add(l2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(580,200,850,540);
        setVisible(true);
        
    }
        
        @Override
       public void actionPerformed(ActionEvent ae){
           if(ae.getSource() == b1){
               
           String name = t1.getText();
           String age = t2.getText();
           String salary = t3.getText();
           String phone = t4.getText();
           String aadhar = t5.getText();
           String email = t6.getText();
           
           String gender = null;
           
               if(r1.isSelected()){
                gender = "Male";
               }
                if(r2.isSelected()){
                   gender = "Female";
                   
               }
           
              Pattern numStr = Pattern.compile(".*[0-9].*");
              Pattern alfaStr = Pattern.compile(".*[A-Za-z].*");
              Matcher name1 = alfaStr.matcher(name);
              Matcher phone1 = numStr.matcher(phone);
              Matcher aadhar1 = numStr.matcher(aadhar);
              Matcher salary1 = numStr.matcher(salary);
              
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(null,"Name field is manditory");   
            }
            else if(name1.matches()==false){
                
                JOptionPane.showMessageDialog(null,"Name Must be Alphabet");
            }
            else if(age.isEmpty()){
                 JOptionPane.showMessageDialog(null,"age field is manditory");
            }
             else if(salary.isEmpty()){
                 JOptionPane.showMessageDialog(null,"salary field is manditory");
            } 
             else if(salary1.matches()==false){
                 JOptionPane.showMessageDialog(null,"salary Must be Numeric"+salary1.matches());
            }
             else if(phone.isEmpty()){
                 JOptionPane.showMessageDialog(null,"phone Must be Numeric");
            } 
             else if(phone.length()!=10){
                 JOptionPane.showMessageDialog(null,"Phone Number Must be Enter only 10 digits");
            }
            else if(phone1.matches()==false){
                 JOptionPane.showMessageDialog(null,"phone Must be Numeric");
            }
             else if(aadhar.isEmpty()){
                 JOptionPane.showMessageDialog(null,"aadhar field is manditory");
            }  
             else if(aadhar.length()!=12){
                 JOptionPane.showMessageDialog(null,"Aadhar number Must be Enter only 12 digits");
            }
            else if(aadhar1.matches()==false){
                 JOptionPane.showMessageDialog(null,"aadhar Must be Numeric");
            }
              else if(email.isEmpty()){
                  JOptionPane.showMessageDialog(null,"email field is manditory");
            }    
             
            else{              
                String job = (String)c1.getSelectedItem();

                conn c = new conn();



                String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";

                try{
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"new Employee Added");
                    this.setVisible(false);

                }catch(Exception e){
                   System.out.println(e);


                }
              }
               
           }else if(ae.getSource() == b2){
               this.setVisible(false);
           }
              
       }
       
    public static void main(String[] args){
        new AddEmployee().setVisible(true);
    }
            
}
