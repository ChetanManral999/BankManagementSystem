package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SignupTwo extends JFrame implements ActionListener {
    JLabel additionalDetails,name,category,income,educational,qualification,occupation,pan,aadhar,seniorcitizen,exist;
    JButton next;
    JTextField panno,aadharno;
    JComboBox<String> relig,categ,inc,edu,occu;
    JRadioButton Yes,No,eYes,eNo;
    ButtonGroup buttonGroup;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE  2");
        additionalDetails=new JLabel("Page 2: Additonal details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        name=new JLabel("Religion");
        name.setFont(new Font("raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        String[] valReligion ={"Hindu","Muslim","Sikh","Christian","Others"};
        relig= new JComboBox<>(valReligion);
        relig.setBounds(300,140,400,30);
        relig.setBackground(Color.white);
        add(relig);
        category =new JLabel("Category");
        category.setFont(new Font("raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        String []valCateogary={"General","OBC","SC","ST","Others"};
        categ=new JComboBox<>(valCateogary);
        categ.setBounds(300,190,400,30);
        categ.setBackground(Color.white);
        add(categ);
        income =new JLabel("Income");
        income.setFont(new Font("raleway",Font.BOLD,20));
        income.setBounds(100,240,400,30);
        add(income);
        String[] valincome={"null","<1,50000","<2,50000","<5,00000","upto 10,00000"};
        inc=new JComboBox<>(valincome);
        inc.setBounds(300,240,400,30);
        inc.setBackground(Color.white);
        add(inc);
        educational =new JLabel("Educational");
        educational.setFont(new Font("raleway", Font.BOLD,20));
        educational.setBounds(100,290,200,30);
        add(educational);
        qualification=new JLabel("Qualifications:");
        qualification.setFont(new Font("raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        String []educationalvalue={"Non-Graduates","Graduates","Post Graduates","Doctorate","Others"};
        edu=new JComboBox<>(educationalvalue);
        edu.setBounds(300,315,400,30);
        edu.setBackground(Color.white);
        add(edu);
        occupation=new JLabel("Occupation");
        occupation.setFont(new Font("raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        String[] occup={"Salaried","Self-Employed","Bussiness","Student","Retierd","Others"};
        occu=new JComboBox<>(occup);
        occu.setBounds(300,390,400,30);
        occu.setBackground(Color.white);
        add(occu);
        pan=new JLabel("Pan Number");
        pan.setFont(new Font("raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        panno =new JTextField();
        panno.setFont(new Font("raleway",Font.BOLD,14));
        panno.setBounds(300,440,400,30);
        add(panno);
        aadhar=new JLabel("Aadhar number");
        aadhar.setFont(new Font("raleway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        aadharno =new JTextField();
        aadharno.setFont(new Font("raleway",Font.BOLD,14));
        aadharno.setBounds(300,490,400,30);
        add(aadharno);
        seniorcitizen=new JLabel("Senior Citizen");
        seniorcitizen.setFont(new Font("raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100,540,200,30);
        add(seniorcitizen);
        Yes=new JRadioButton("Yes");
        Yes.setBounds(450,540,100,30);
        Yes.setBackground(Color.white);
        add(Yes);
        No=new JRadioButton("No");
        No.setBounds(630,540,100,30);
        No.setBackground(Color.white);
        add(No);
        buttonGroup=new ButtonGroup();
        buttonGroup.add(Yes);
        buttonGroup.add(No);
        exist=new JLabel("Existing account");
        exist.setFont(new Font("raleway",Font.BOLD,20));
        exist.setBounds(100,590,200,30);
        add(exist);
        eYes=new JRadioButton("Yes");
        eYes.setBounds(450,590,100,30);
        eYes.setBackground(Color.white);
        add(eYes);
        eNo=new JRadioButton("No");
        eNo.setBounds(630,590,100,30);
        eNo.setBackground(Color.white);
        add(eNo);
        buttonGroup=new ButtonGroup();
        buttonGroup.add(eYes);
        buttonGroup.add(eNo);
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("raleway", Font.BOLD, 14));
        next.setBounds(400, 660, 80, 30);
        add(next);
        next.addActionListener(this);
        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion=(String)relig.getSelectedItem();
        String scategory=(String)categ.getSelectedItem();
        String sincome=(String)inc.getSelectedItem();
        String seducation=(String)edu.getSelectedItem();
        String soccupation=(String)occu.getSelectedItem();
        String seniorcitizen=null;
        if(Yes.isSelected()){
            seniorcitizen="Yes";
        }
        else if(No.isSelected()){
            seniorcitizen="No";
        }
        String exist=null;
        if(eYes.isSelected()){
            exist="Yes";
        }
        else if(eNo.isSelected()){
            exist="No";
        }
        String span=panno.getText();
        String saadhar=aadharno.getText();
        try{
            conn c=new conn();
            String query= "insert into signuptwo values('" + formno + "','" +sreligion+ "','" +scategory+ "','" +sincome+ "','" +seducation+ "'," +soccupation+ "','" +span+ "','" +saadhar+ "','" +seniorcitizen+ "','" +exist+ "')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new SignupTwo("");
    }
}
