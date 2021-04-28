import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Search {


    int baseX = 50;
    int baseY = 50;
    int baseWidth = 100;
    int baseHeight = 30;
    int baseTableWidth = baseWidth + 500;
    int baseTableHeight = baseHeight + 370;

    JFrame frame = new JFrame("SEARCH BOOK DETAILS");
    JButton btnSearch, btnBack;
    JTextField tfSearchText;
    JLabel lblStatus, lblNoData;
    JTable bookTable;
    JScrollPane scrollPane;
    ImageIcon imageA;
    ImageIcon imageB;

    DatabaseConnection db = new DatabaseConnection();
    Statement stm = db.connection();

    public Search() {

        tfSearchText = new JTextField();
        tfSearchText.setBounds(baseX + 150, baseY, baseWidth + 180, baseHeight+12);
        btnSearch = new JButton("Search");
        btnSearch.setBounds(baseX +440, baseY, baseWidth+50, baseHeight+10);
        btnSearch.setForeground(Color.black);
        btnSearch.setBackground(Color.magenta);


        frame.add(btnSearch);
        frame.add(tfSearchText);

        btnSearch.addActionListener(e -> {
            String searchtext = tfSearchText.getText();
            String column[] = { "Book Number", "Book Name", "Author Name", "Date Published", "Price", "Quantity Available" };
            String data[][] = searchBook(column.length, searchtext);
            boolean hasData = data.length > 0;
            if (hasData) {
                bookTable = new JTable(data, column);
                scrollPane = new JScrollPane(bookTable);
                scrollPane.setBounds(baseX, baseY + 50, baseTableWidth, baseTableHeight);
                frame.add(scrollPane);
            } else {
                lblNoData = new JLabel("No data in table.", SwingConstants.CENTER);
                lblNoData.setBounds(baseX + 200, baseY + 50, baseWidth + 100, baseHeight);
                frame.add(lblNoData);
            }
        });


        btnBack = new JButton();
        frame.add(btnBack);
        btnBack.setBounds(600, 550, 150, 30);
        imageB = new ImageIcon("red4.png");
        btnBack.setIcon(imageB);
        btnBack.setBounds(0, 0, 50, 42);


        btnBack.addActionListener(e -> {
            new View();
            frame.dispose();
        });

        frame.setLayout(null);
        frame.setSize(700, 700);
        frame.setVisible(true);
        JLabel background;
        imageA =new ImageIcon("6.png");
        background=new JLabel("",imageA,JLabel.CENTER);
        background.setBounds(0,0,800,800);
        frame.add(background);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    Books fetchEachData(ResultSet result) throws SQLException {
        String BookName = result.getString("b_name");
        String AuthorName = result.getString("a_name");
        String date = result.getString("p_date");
        int price = Integer.parseInt(result.getString("price"));
        int bookNumber = Integer.parseInt(result.getString("bcode"));
        int Quantity = Integer.parseInt(result.getString("quantity"));
        return new Books(BookName, AuthorName, date, price, bookNumber, Quantity);
    }

    String[][] generateBookArray(ArrayList<Books> bookList, int totalColumns) {
        String bookArray[][] = new String[bookList.size()][totalColumns];
        for (int i = 0; i < bookArray.length; i++) {
            bookArray[i][0] = Integer.toString(bookList.get(i).bookNumber);
            bookArray[i][1] = bookList.get(i).BookName;
            bookArray[i][2] = bookList.get(i).AuthorName;
            bookArray[i][3] = bookList.get(i).date;
            bookArray[i][4] = Integer.toString(bookList.get(i).price);
            bookArray[i][5] = Integer.toString(bookList.get(i).Quantity);
        }
        return bookArray;
    }

    public String[][] searchBook(int totalColumns, String searchText) {
        String selectQuery = "SELECT * from books WHERE b_name LIKE'%" + searchText + "%' OR a_name LIKE'%" + searchText + "%' OR p_date LIKE'%" + searchText + "%';";
        ArrayList<Books> bookList = new ArrayList<>();
        try {
            ResultSet res = stm.executeQuery(selectQuery);
            while (res.next()) {
                Books book = fetchEachData(res);
                bookList.add(book);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return generateBookArray(bookList, totalColumns);
    }
}
