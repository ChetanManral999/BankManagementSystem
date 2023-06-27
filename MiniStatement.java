package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    JLabel mini,bank,card,balance;
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        mini = new JLabel();
        add(mini);

        bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select *from login where pin='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card number"+rs.getString("carnumber").substring(0,4)+"XXXXXXXX"+rs.getString("carnumber").substring(12));//used to put values in labels
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            conn c=new conn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");//settext overrides not append so we have to use getText
                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }//we use html tag for letting space using &nbsp
            balance.setText("Your current account balance is Rs "+bal);
        }catch (Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,140,400,200);
        balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
    }
    public static void main(String []args){
        new MiniStatement("");
    }
}
