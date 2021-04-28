import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Registers extends JFrame {


    private JPanel contentPane;
    private JTextField txtName;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField txtReset;
    private JTextField txtClose;
    private JButton btnSubmit;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Registers Log = new Registers();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registers frame = new Registers();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Registers() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 743, 719);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 0, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtName = new JTextField();
        txtName.setBounds(290, 138, 293, 28);
        contentPane.add(txtName);
        txtName.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(290, 189, 296, 28);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(290, 237, 296, 28);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(290, 337, 293, 28);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(290, 443, 293, 28);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(290, 286, 293, 28);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(290, 390, 293, 28);
        contentPane.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel.setBounds(195, 141, 57, 21);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("UserName:");
        lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(169, 193, 70, 21);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password:");
        lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_2.setBounds(180, 240, 73, 23);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Confirm Password:");
        lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_3.setBounds(130, 287, 118, 24);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Email:");
        lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_4.setBounds(205, 341, 73, 21);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Phone:");
        lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(195, 397, 46, 14);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Address:");
        lblNewLabel_6.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_6.setBounds(191, 446, 61, 21);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Register  Form");
        lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD, 20));
        lblNewLabel_7.setBounds(45, 50, 144, 34);
        contentPane.add(lblNewLabel_7);
//		txtSubmit.addActionListener(e->{
//		    	String name=txtName.getText();
//		    	String username=textField_1.getText();
//		    	String password =textField_2.getText();
//		    	String confirm_password=textField_3.getText();
//		    	String email = textField_4.getText();
//		    	String phone=textField_5.getText();
//		    	String address=textField_6.getText();
//		    	try {
//					conn db=new conn();
//
//					String sql=" Insert into employee values('"+name+"','"+username+"','"+password +"',"+email+"',"+phone+"',"+address+")";
//					int result=db.connection().executeUpdate(sql);
//					System.out.println(result);
//					if(result>0) {
//						JOptionPane.showMessageDialog(txtSubmit,"Registered successfully");
//
//					}
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//	    	System.out.println(name+code+position+salary);
//
//		    });

        txtReset = new JTextField();
        txtReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtReset.setText("Reset");
        txtReset.setHorizontalAlignment(SwingConstants.CENTER);
        txtReset.setBackground(new Color(255, 0, 0));
        txtReset.setForeground(new Color(248, 248, 255));
        txtReset.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        txtReset.setBounds(399, 558, 86, 28);
        contentPane.add(txtReset);
        txtReset.setColumns(10);

        txtClose = new JTextField();
        txtClose.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        txtClose.setHorizontalAlignment(SwingConstants.CENTER);
        txtClose.setText("Close");
        txtClose.setBackground(new Color(175, 238, 238));
        txtClose.setForeground(new Color(248, 248, 255));
        txtClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtClose.setBounds(519, 558, 86, 28);
        contentPane.add(txtClose);
        txtClose.setColumns(10);

        btnSubmit = new JButton("Submit");
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Name = txtName.getText();
                String Username = textField_1.getText();
                String Password = textField_2.getText();
                String Email = textField_4.getText();
                String Phone = textField_5.getText();
                String Address = textField_6.getText();
                try {
                    DatabaseConnection db = new DatabaseConnection();

                    String sql = " Insert into register values('" + Name + "','" + Username + "','" + Password + "','" + Email + "','" + Phone + "','" + Address + "')";

                    int result = db.connection().executeUpdate(sql);
                    System.out.println(result);
                    if (result > 0) {
                        JOptionPane.showMessageDialog(btnSubmit, "Registered successfully");

                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();

                }

                System.out.println(Email);

            }
        });
        btnSubmit.setBounds(290, 558, 99, 28);
        contentPane.add(btnSubmit);
    }

}