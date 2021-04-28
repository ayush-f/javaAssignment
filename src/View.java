import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class View {
    public static void main(String[] args) {
        View vm = new View();

    }

    public View() {

        JFrame f = new JFrame(" Book Store");
        JButton btnBack, btnDelete, btnUpdate, btnSell, btnSearch;
        JComboBox<String> cbDeviceFrom;
        JLabel lNo, lAbl, lSh;

        ImageIcon imageA;
        ImageIcon imageB;
        String column[] = { "Book Number", "Book Name", "Author Name", "Date Published", "Price",
                "Quantity Available" };



        String query = "Select * from books";
        DatabaseConnection db = new DatabaseConnection();
        ArrayList<Books> book = new ArrayList<Books>();

        try {
            ResultSet result = db.connection().executeQuery(query);

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

        lNo = new JLabel("Total number of books in stock:" + book.size());
        f.add(lNo);
        lNo.setBounds(300, 30, 300, 100);

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
        sp.setBounds(0, 100, 850, 200);

        // button

        btnBack = new JButton("Back");
        f.add(btnBack);
        btnBack.setBounds(600, 550, 150, 30);
        imageB = new ImageIcon("red4.png");
        btnBack.setIcon(imageB);
        btnBack.setBounds(0, 0, 50, 42);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dash();
                f.dispose();
            }
        });

        btnDelete = new JButton("Delete");
        f.add(btnDelete);

        btnDelete.setBounds(0, 298, 150, 49);
        btnDelete.setForeground(Color.black);
        btnDelete.setBackground(Color.red);

        btnDelete.addActionListener(e -> {
            int row = jt.getSelectedRow();
            if (row >= 0) {

                TableModel model = jt.getModel();

                String code = Integer.toString((int) model.getValueAt(row, 0));

                String dquery = "Delete from books WHERE `bcode` = '" + code + "'";
                try {
                    int dresult = db.connection().executeUpdate(dquery);
                    if (dresult >= 1) {
                        JOptionPane.showMessageDialog(sp, "Deleted Books");
                        new View();
                        f.dispose();
                    }

                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

            } else {
                JOptionPane.showMessageDialog(sp, "Please select a row!!");
            }

        });

        btnUpdate = new JButton("Update");
        f.add(btnUpdate);
        btnUpdate.setBounds(695, 298, 150, 49);
        btnUpdate.setForeground(Color.black);
        btnUpdate.setBackground(Color.green);

        btnUpdate.addActionListener(e -> {
            int row = jt.getSelectedRow();
            if (row >= 0) {

                JLabel lbName = new JLabel("Book Name");
                f.add(lbName);

                lbName.setBounds(0, 500, 900, 30);

                JTextField tfbName = new JTextField();
                f.add(tfbName);
                tfbName.setBounds(0, 535, 120, 30);

                TableModel model = jt.getModel();
                String BookName = (String) model.getValueAt(row, 1);

                tfbName.setText(BookName);

                JLabel laName = new JLabel("Publisher Name");
                f.add(laName);

                laName.setBounds(740, 580, 900, 30);

                JTextField tfaName = new JTextField();
                f.add(tfaName);
                tfaName.setBounds(740, 610, 120, 30);

                TableModel model1 = jt.getModel();
                String AuthorName = (String) model1.getValueAt(row, 2);

                tfaName.setText(AuthorName);

                JLabel lpDate = new JLabel("Date");
                f.add(lpDate);

                lpDate.setBounds(0, 580, 900, 30);



                JTextField tfpDate = new JTextField();
                f.add(tfpDate);
                tfpDate.setBounds(0, 610, 120, 30);

                TableModel model2 = jt.getModel();

                String date = (String) model2.getValueAt(row, 3);
                tfpDate.setText(date);


                JLabel laddBy = new JLabel("Quantity");
                f.add(laddBy);

                laddBy.setBounds(740, 500, 300, 30);


                JTextField tfaddBy = new JTextField();
                f.add(tfaddBy);
                tfaddBy.setBounds(740, 535, 150, 30);

                TableModel model3 = jt.getModel();

                String price1 = Integer.toString((int) model3.getValueAt(row, 4));
                tfaddBy.setText(price1);

                JButton btnChange = new JButton("Update");
                f.add(btnChange);
                btnChange.setBounds(0, 660, 120, 35);
                btnChange.setForeground(Color.black);
                btnChange.setBackground(Color.green);
                btnChange.setToolTipText("click here to check books");

                JButton btnCancel = new JButton("Cancel");
                f.add(btnCancel);
                btnCancel.setBounds(740, 660, 150, 35);
                btnCancel.setForeground(Color.black);
                btnCancel.setBackground(Color.orange);
                btnCancel.setToolTipText("cancel request");

                // update action

                btnChange.addActionListener(e3 -> {

                    String tbName = tfbName.getText();
                    String taName = tfaName.getText();
                    String tpDate = tfpDate.getText();
                    String price = tfaddBy.getText();

                    TableModel model4 = jt.getModel();
                    String Code = Integer.toString((int) model4.getValueAt(row, 0));
                    String BookName1 = (String) model4.getValueAt(row, 1);
                    String uquery = "update `books` set `b_name` = '" + tbName + "',`a_name` = '" + taName
                            + "', `price` = '" + price + "',  `p_date` = '" + tpDate + "' WHERE `bcode` = '" + Code
                            + "'";
                    String squery = "update `soldb` set `b_name` = '" + tbName + "',`a_name` = '" + taName
                            + "', `price` = '" + price + "',  `p_date` = '" + tpDate + "' WHERE `b_name` = '"
                            + BookName1 + "'";

                    try {
                        int uresult = db.connection().executeUpdate(uquery);
                        int sresult = db.connection().executeUpdate(squery);
                        JOptionPane.showMessageDialog(sp, "Book Updated");
                        new View();
                        f.dispose();


                    } catch (SQLException e1) {

                        e1.printStackTrace();
                    }

                });

                // cancel action

                btnCancel.addActionListener(e2 -> {

                    new View();
                    f.dispose();

                });

            } else {
                JOptionPane.showMessageDialog(sp, "Selected Row");
            }

        });


//		cbDeviceFrom = new JComboBox<String>();
//        cbDeviceFrom.setEditable(false);
//        cbDeviceFrom.setBounds(100, 60, 150, 30);


        btnSearch = new JButton("Search Book Details");
        f.add(btnSearch);
        btnSearch.setBounds(695, 398, 150, 49);
        btnSearch.setForeground(Color.black);
        btnSearch.setBackground(Color.magenta);


        btnSearch.addActionListener(e3 -> {
            new Search();

            f.dispose();


        });

        btnSell = new JButton("Sell");
        f.add(btnSell);
        btnSell.setBounds(0, 398, 150, 49);
        btnSell.setForeground(Color.black);
        btnSell.setBackground(Color.CYAN);

        btnSell.addActionListener(e -> {
            int row = jt.getSelectedRow();

            if (row >= 0) {

                TableModel model = jt.getModel();

                String code = Integer.toString((int) model.getValueAt(row, 0));

                String BookName = (String) model.getValueAt(row, 1);
                String AuthorName = (String) model.getValueAt(row, 2);
                String date = (String) model.getValueAt(row, 3);

                String price = Integer.toString((int) model.getValueAt(row, 4));
                int Quan = 1;
                int Quantity = ((int) model.getValueAt(row, 5) - 1);

                String query1 = "Select * from soldb where b_name='" + BookName + "'";
                try {
                    ResultSet result3 = db.connection().executeQuery(query1);

                    if (result3.next()) {
                        int prevQuan = Integer.parseInt(result3.getString("quantity"));

                        String uquery = "update `books` set `quantity` = '" + Quantity + "' WHERE `bcode` = '" + code
                                + "'";
                        String urquery = "update `soldb` set `quantity` = '" + prevQuan++ + "' WHERE `b_name` = '"
                                + BookName + "'";
                        int uresult = db.connection().executeUpdate(uquery);
                        int uaresult = db.connection().executeUpdate(urquery);
                        if (uresult >= 1 && uaresult >= 1) {
                            JOptionPane.showMessageDialog(sp, "Book Sold");
                            new View();
                            f.dispose();
                        }
                    } else {
                        String dquery = "update `books` set `quantity` = '" + Quantity + "' WHERE `bcode` = '" + code
                                + "'";
                        String aquery = "insert into soldb(b_name,a_name,p_date,price,quantity) values('" + BookName
                                + "','" + AuthorName + "','" + date + "','" + price + "','" + Quan + "') ";
                        try {
                            int dresult = db.connection().executeUpdate(dquery);
                            int aresult = db.connection().executeUpdate(aquery);
                            if (aresult >= 1 && dresult >= 1) {
                                JOptionPane.showMessageDialog(sp, "Book Sold");
                                new View();
                                f.dispose();
                            }

                        } catch (SQLException e1) {

                            e1.printStackTrace();
                        }
                    }
                } catch (SQLException e2) {

                    e2.printStackTrace();
                }

            } else {
                JOptionPane.showMessageDialog(sp, "Please select row!!!");
            }

        });

        f.setLayout(null);
        f.setSize(860, 1200);
        f.setVisible(true);
        JLabel background;
        imageA =new ImageIcon("4.png");
        background=new JLabel("",imageA,JLabel.CENTER);
        background.setBounds(0,0,800,1000);
        f.add(background);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

    }
}
