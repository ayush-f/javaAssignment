import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class SignUp {

    public static void main(String[] args) {
        Reg Log = new Reg();

    }
}

class Reg {
    Reg() {
        JFrame j = new JFrame("Sign Up");

        JLabel lname, lpsw, lUser, lemail;
        JTextField tfuser, tfname, tfemail;
        JPasswordField tfpsw, tfcpass;
        JButton btnreg, btnBack;
        ImageIcon imageA;
        ImageIcon imageB;
        ImageIcon imageC;


        // LABEL
        lname = new JLabel("Name : ");
        j.add(lname);
        lname.setBounds(100, 30, 100, 30);
        lname.setFont(new Font("Calibri",Font.BOLD,18));

        lUser = new JLabel("Username : ");
        j.add(lUser);
        lUser.setBounds(100, 70, 100, 30);
        lUser.setFont(new Font("Calibri",Font.BOLD,18));



        lemail = new JLabel("Email : ");
        j.add(lemail);
        lemail.setBounds(100, 110, 100, 30);

        lemail.setFont(new Font("Calibri",Font.BOLD,18));

        lpsw = new JLabel("Password :");
        j.add(lpsw);
        lpsw.setBounds(100, 150, 200, 30);
        lpsw.setFont(new Font("Calibri",Font.BOLD,18));

        lpsw = new JLabel("Confirm Password:");
        j.add(lpsw);
        lpsw.setBounds(100, 190, 200, 30);

        lpsw.setFont(new Font("Calibri",Font.BOLD,18));


        /// text fields

        tfname = new JTextField(30);
        j.add(tfname);
        tfname.setBounds(260, 30, 160, 20);

        tfuser = new JTextField(10);
        j.add(tfuser);
        tfuser.setBounds(260, 70, 160, 20);


        tfemail = new JTextField(30);
        j.add(tfemail);
        tfemail.setBounds(260, 110, 160, 20);


        tfpsw = new JPasswordField(30);
        j.add(tfpsw);
        tfpsw.setBounds(260, 150, 160, 20);

        tfcpass = new JPasswordField(30);
        j.add(tfcpass);
        tfcpass.setBounds(260, 190, 160, 20);

        btnBack = new JButton();
        j.add(btnBack);
        imageB = new ImageIcon("red4.png");
        btnBack.setIcon(imageB);
        btnBack.setBounds(0, 0, 50, 42);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();



                j.dispose();
            }
        });

        btnreg = new JButton();
        j.add(btnreg);
        imageC = new ImageIcon("sign4.png");
        btnreg.setIcon(imageC);
        btnreg.setBounds(260, 250, 160, 42);
        btnreg.setToolTipText("click here to register now");
//        btnreg.setForeground(Color.black);
//        btnreg.setBackground(Color.yellow);

        // save action
        btnreg.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {


                String name = tfname.getText();
                String user = tfuser.getText();
                String email = tfemail.getText();
                String psw = tfpsw.getText();


                int value = userSignup(name,user,email,psw);

                if (value == 1){
                    JOptionPane.showMessageDialog(j, " Congratulations!! you have successfully Signed up.");
                    new Login();
                    j.dispose();

                }else{
                    JOptionPane.showMessageDialog(j, "Username Already Exist!");
                }
            }
        });

        j.setLayout(null);
        j.setSize(600, 600);
        j.setVisible(true);
        //Adding background image

        JLabel background;
        imageA =new ImageIcon("third.png");
        background=new JLabel("",imageA,JLabel.CENTER);
        background.setBounds(0,0,600,1000);
        j.add(background);
        j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);

    }
    DatabaseConnection db = new DatabaseConnection();
    public int userSignup(String name, String user, String email,String psw) {
        String query = "insert into signup values('" + name + "','" + user + "','" + email + "','"
                + psw + "')";


        try {
            int result = db.connection().executeUpdate(query);

            if(result>0)  {
                return 1;
            }
        } catch (SQLException e1) {

            e1.printStackTrace();
        }
        return 0;

    }

}
