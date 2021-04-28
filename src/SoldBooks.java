import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class SoldBooks {
    public static void main(String[] args) {
        SoldBooks vm = new SoldBooks();

    }

    SoldBooks() {

        JFrame f = new JFrame(" Book Store");
        JButton btnBack;
        JLabel lNo, lAb;

        ImageIcon imageA;
        ImageIcon imageB;
        String column[] = { "Book Number", "Book Name", "Author Name", "Date Published", "Price", "Quantity Sold" };

//        lAb = new JLabel("Sold Books");
//        f.add(lAb);
//        lAb.setBounds(400, -20, 300, 100);

        String query = "Select * from soldb";
        DatabaseConnection db = new DatabaseConnection();
        ArrayList<Books> book = new ArrayList<Books>();

        try {
            ResultSet result = db.connection().executeQuery(query);
            System.out.println(result);

            while (result.next()) {
                String BookName = result.getString("b_name");
                String AuthorName = result.getString("a_name");
                String date = result.getString("p_date");
                int price = Integer.parseInt(result.getString("price"));
                int bookNumber = Integer.parseInt(result.getString("bcode"));
                int Quantity = Integer.parseInt(result.getString("quantity"));
                Books stff = new Books(BookName, AuthorName, date, price, bookNumber, Quantity);
                book.add(stff);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        lNo = new JLabel("Total No. of Books Sold: " + book.size());
        f.add(lNo);
//        lNo.setBounds(50, 410, 300, 100);
        lNo.setBounds(400, -20, 300, 100);

        Object data[][] = new Object[book.size()][column.length];

        for (int i = 0; i < book.size(); i++) {
            data[i][0] = book.get(i).bookNumber;
            data[i][1] = book.get(i).BookName;
            data[i][2] = book.get(i).AuthorName;
            data[i][3] = book.get(i).date;
            data[i][4] = book.get(i).price;
            data[i][5] = book.get(i).Quantity;
        }

        JTable jt = new JTable(data, column);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        sp.setBounds(50, 50, 800, 400);

        // button

        btnBack = new JButton("Back");
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

        f.setLayout(null);
        f.setSize(1000, 600);
        f.setVisible(true);
        JLabel background;
        imageA =new ImageIcon("4.png");
        background=new JLabel("",imageA,JLabel.CENTER);
        background.setBounds(0,0,1500,622);
        f.add(background);
        jt.setForeground(Color.black);
        jt.setBackground(Color.cyan);



        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);


    }
}
