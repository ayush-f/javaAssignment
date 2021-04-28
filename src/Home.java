import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Home {

    public static void main(String[] args) {
        Login log = new Login();

    }
}

class Login {
    DatabaseConnection db = new DatabaseConnection();

    Login() {
        JFrame f = new JFrame("Library");
        JLabel lUser, lpsw, lhead, lneed;
        JTextField tfUser;
        JPasswordField tfpsw;
        JButton btnLogin, btnSignUp;
        ImageIcon imageA;

        // user label
        lUser = new JLabel("Username");
        f.add(lUser);
        lUser.setBounds(125, 114, 100, 100);

        lpsw = new JLabel("Password");
        f.add(lpsw);
        lpsw.setBounds(125, 165, 100, 100);

        lhead = new JLabel(" Login to access book store ");
        f.add(lhead);
        lhead.setBounds(200, 0, 200, 100);


        tfUser = new JTextField(30);
        f.add(tfUser);
        tfUser.setBounds(200, 150, 200, 30);

        tfpsw = new JPasswordField(30);
        f.add(tfpsw);
        tfpsw.setBounds(200, 200, 200, 30);

        btnLogin = new JButton("Login");
        f.add(btnLogin);
        btnLogin.setBounds(153, 310, 100, 40);
        btnLogin.setForeground(Color.black);
        btnLogin.setBackground(Color.yellow);
        btnLogin.setToolTipText("click here to login");

        btnSignUp = new JButton("SignUp");
        f.add(btnSignUp);
        btnSignUp.setBounds(292, 310, 100, 40);
        btnSignUp.setForeground(Color.black);
        btnSignUp.setBackground(Color.green);
        btnSignUp.setToolTipText("click here to Sign up");

        btnLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String user = tfUser.getText();
                String psw = tfpsw.getText();
                int value = userLogin(user, psw);

                if (value == 1) {
                    new Dash();
                    f.dispose();
                } else if (value == 2) {
                    JOptionPane.showMessageDialog(f, "Password does not match!! ");

                } else {
                    JOptionPane.showMessageDialog(f, "Username/Password Not Valid!! ");
                }

            }

        });
//        btnSignUp.addActionListener(e->{
//            new SignUp();
//            f.dispose();
//
//        });


        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new Reg();
                f.dispose();

            }


        });






        f.setLayout(null);
        f.setSize(600, 600);
        f.setVisible(true);
        //Adding background image

        JLabel background;
        imageA =new ImageIcon("second.jpg");
        background=new JLabel("",imageA,JLabel.CENTER);
        background.setBounds(0,0,600,700);
        f.add(background);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }

    public int userLogin(String username, String psw) {
        String query = "Select * from signup where user='" + username + "'";

        try {
            ResultSet result = db.connection().executeQuery(query);


            if (result.next()) {
                if (result.getString(4).equals(psw)) {
                    System.out.println(""+result.getString(4));
                    return 1;
                } else if (!result.getString(4).equals(psw)) {
                    return 2;

                }

            }

        } catch (SQLException e1) {

            e1.printStackTrace();
        }
        return 0;

    }
}
