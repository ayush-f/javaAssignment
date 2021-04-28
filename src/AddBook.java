import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class AddBook {

    public static void main(String[] args) {
        bookSt Log = new bookSt();
    }
}

class bookSt {
    bookSt() {
        JFrame f = new JFrame("Add Books");

        JLabel lbName, laName, lpDate, lprice;
        JTextField tfbName, tfaName, tfpDate, tfprice;
        JButton btnSave, btnExit, btnView,btnBack;
        ImageIcon imageA;
        ImageIcon imageB;

        lbName = new JLabel("Book Name:");
        f.add(lbName);
        lbName.setBounds(100, 50, 130, 30);
        lbName.setFont(new Font("Calibri",Font.BOLD,18));


        laName = new JLabel("Publisher Name:");
        f.add(laName);
        laName.setBounds(100, 65, 130, 100);
        laName.setFont(new Font("Calibri",Font.BOLD,18));

        lpDate = new JLabel("Publish Date :");
        f.add(lpDate);
        lpDate.setBounds(100, 80, 130, 170);
        lpDate.setFont(new Font("Calibri",Font.BOLD,18));

        lprice = new JLabel("Price");
        f.add(lprice);
        lprice.setBounds(100, 95, 130, 250);
        lprice.setFont(new Font("Calibri",Font.BOLD,18));

        JLabel lQuantity = new JLabel("Quantity");
        f.add(lQuantity);
        lQuantity.setBounds(100, 110, 130, 340);
        lQuantity.setFont(new Font("Calibri",Font.BOLD,18));

        tfbName = new JTextField(30);
        f.add(tfbName);
        tfbName.setBounds(250, 50, 160, 30);

        tfaName = new JTextField(10);
        f.add(tfaName);
        tfaName.setBounds(250, 105, 160, 30);

        tfpDate = new JTextField(30);
        f.add(tfpDate);
        tfpDate.setBounds(250, 155, 160, 30);

        tfprice = new JTextField(30);
        f.add(tfprice);
        tfprice.setBounds(250, 210, 160, 30);

        JTextField tfQuantity = new JTextField(30);
        f.add(tfQuantity);
        tfQuantity.setBounds(250, 260, 160, 30);

        btnSave = new JButton("SUBMIT");
        f.add(btnSave);
        btnSave.setBounds(0, 400, 150, 45);
        btnSave.setForeground(Color.black);
        btnSave.setBackground(Color.green);
        btnSave.setToolTipText("click here to submit book");



        btnView = new JButton("CHECK Books");
        f.add(btnView);
        btnView.setBounds(440, 400, 150, 45);
        btnView.setForeground(Color.black);
        btnView.setBackground(Color.blue);
        btnView.setToolTipText("click here to check books");

        btnBack = new JButton();
        f.add(btnBack);
        imageB = new ImageIcon("red4.png");
        btnBack.setIcon(imageB);
        btnBack.setBounds(0, 0, 50, 42);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dash();



                f.dispose();
            }
        });



        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new View();
                f.dispose();

            }
        });

//        btnExit.addActionListener((ActionListener) new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                int select = JOptionPane.showConfirmDialog(btnExit, "Are you sure you want to Exit");
//
//                if (select == 0) {
//                    new Login();
//                    f.dispose();
//                }
//            }
//        });


        btnSave.addActionListener(e -> {
            String BName = tfbName.getText();
            String PName = tfaName.getText();
            String Date = tfpDate.getText();
            String Price = tfprice.getText();
            String Quantity = tfQuantity.getText();
            try {
                DatabaseConnection db = new DatabaseConnection();
                String query1 = "Select * from books where b_name='" + BName + "'";
                ResultSet result = db.connection().executeQuery(query1);
                if (result.next()) {
                    JOptionPane.showMessageDialog(btnSave, "Alert: This Book already exist in the List");
                } else {

                    String query = "insert into books(b_name,a_name,p_date,price,quantity) values('" + BName + "','"
                            + PName + "','" + Date + "','" + Price + "','" + Quantity + "') ";

                    int result1 = db.connection().executeUpdate(query);
                    if (result1 > 0) {
                        JOptionPane.showMessageDialog(btnSave, "Book Added");

                    }
                }

            } catch (SQLException e1) {

                e1.printStackTrace();
            }

        });

        f.setLayout(null);
        f.setSize(600, 600);
        f.setVisible(true);

        //Adding background image

        JLabel background;
        imageA =new ImageIcon("add.png");
        background=new JLabel("",imageA,JLabel.CENTER);
        background.setBounds(0,0,600,700);
        f.add(background);

        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
}
