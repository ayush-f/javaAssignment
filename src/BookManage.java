import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class BookManage {


    public static void main(String[] args) {
        Dash log = new Dash();
    }
}

class Dash {
    Dash() {
        JFrame f = new JFrame(" Book Store");
        JButton btnAdd, btnView, btnViewS,btnBack;
        JLabel lZean;
        ImageIcon imageA;
        ImageIcon imageB;

        lZean = new JLabel();
        f.add(lZean);
        lZean.setBounds(225, 10, 3000, 100);
        lZean.setFont(new Font("Calibri",Font.BOLD,20));

        btnAdd = new JButton("ADD BOOKS");
        f.add(btnAdd);
        btnAdd.setBounds(0, 500, 170, 50);
        btnAdd.setForeground(Color.black);
        btnAdd.setBackground(Color.GREEN);
        btnAdd.setToolTipText("click here to add books");

        btnView = new JButton("BOOKS IN STOCK");
        f.add(btnView);
        btnView.setBounds(200, 500, 170, 50);
        btnView.setForeground(Color.black);
        btnView.setBackground(Color.BLUE);
        btnView.setToolTipText("click here to view books");

        btnViewS = new JButton("BOOKS SOLD SECTION");
        f.add(btnViewS);
        btnViewS.setBounds(420, 500, 170, 50);
        btnViewS.setForeground(Color.black);
        btnViewS.setBackground(Color.red);
        btnViewS.setToolTipText("click here to view sold books");


        btnBack = new JButton();
        f.add(btnBack);
        imageB = new ImageIcon("red4.png");
        btnBack.setIcon(imageB);
        btnBack.setBounds(0, 0, 50, 42);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();



                f.dispose();
            }
        });



        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new bookSt();
                f.dispose();

            }
        });
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new View();
                f.dispose();

            }
        });






        btnViewS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SoldBooks();
                f.dispose();

            }
        });



  

        f.setLayout(null);


        f.setSize(600, 600);

        //Adding background image

        JLabel background;
        imageA =new ImageIcon("login.jpg");
        background=new JLabel("",imageA,JLabel.CENTER);
        background.setBounds(0,0,600,600);
        f.add(background);
        
        f.setVisible(true);





        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }

}
