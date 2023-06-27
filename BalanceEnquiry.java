package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel image,text;
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);
        conn c=new conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("Select * from bank where pin='" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        text=new JLabel("Your current account balance is "+balance);
        text.setForeground(Color.white);
        text.setBounds(170,300,400,30);
        image.add(text);
        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String [] args){
        new BalanceEnquiry("");
    }
}
