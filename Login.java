package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);//by default the image layout is at center
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//we cannot directly paste icon on jframe
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);// to change height and width
        ImageIcon i3=new ImageIcon(i2);//we cannot put image in jlabel so we have to create its imageicon
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);//distance from frame left hand side, right hand side
        add(label);
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);//we have to set text as we have made setbound null
        add(text);
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,30));
        cardno.setBounds(120,150,150,40);//we have to set text as we have made setbound null
        add(cardno);
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("arial",Font.BOLD,14));
        add(cardTextField);
        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,40);//we have to set text as we have made setbound null
        add(pin);
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);
        login=new JButton("SIGN IN ");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        clear=new JButton("CLEAR ");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        signup=new JButton("SIGN UP ");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        getContentPane().setBackground(Color.white);//to change frame color we use color class
        setSize(800,400);
        setVisible(true);//by default the jframe is invisible for the user
        setLocation(350,200);//from left side , from top side
    }
    public void actionPerformed(ActionEvent ae){//ae is the object of this action class
        if(ae.getSource()==clear){//getsource is used to get which source is clicked or an action is performed at what source
            cardTextField.setText("");//manually to enter text in the textfield
        }
        else if(ae.getSource()==login){
            conn c=new conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();//getText is depricated for password field
            String query="select *from login where carnumber ='"+cardnumber+"'and pin ='"+pinnumber+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);//when this query is fired then it returns values that are stored in resultset rs (resultset is the dtat type )
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or pin");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);//constructor call hote hi signup aa jaega
        }
    }

    public static void main(String[] args){
        new Login();
    }
}
