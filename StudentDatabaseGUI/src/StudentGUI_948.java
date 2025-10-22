import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StudentGUI_948 extends JFrame {
    // Input fields
    private JTextField idField_948, nameField_948, deptField_948, marksField_948, searchField_948;
    private JButton insertBtn_948, searchBtn_948;

    public StudentGUI_948() {
        setTitle("Student Database GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Labels and fields
        add(new JLabel("ID:"));
        idField_948 = new JTextField();
        add(idField_948);

        add(new JLabel("Name:"));
        nameField_948 = new JTextField();
        add(nameField_948);

        add(new JLabel("Department:"));
        deptField_948 = new JTextField();
        add(deptField_948);

        add(new JLabel("Marks:"));
        marksField_948 = new JTextField();
        add(marksField_948);

        insertBtn_948 = new JButton("Insert");
        add(insertBtn_948);

        searchField_948 = new JTextField();
        add(searchField_948);

        searchBtn_948 = new JButton("Search by Name");
        add(searchBtn_948);

        // Button actions
        insertBtn_948.addActionListener(e -> insertStudent_948());
        searchBtn_948.addActionListener(e -> searchStudent_948());

        setVisible(true);
    }

    private void insertStudent_948() {
        String id_948 = idField_948.getText();
        String name_948 = nameField_948.getText();
        String dept_948 = deptField_948.getText();
        String marks_948 = marksField_948.getText();

        String sql_948 = "INSERT INTO students (id, name, department, marks) VALUES (?, ?, ?, ?)";

        try (Connection con_948 = DBConnection.getConnection();
                PreparedStatement pst_948 = con_948.prepareStatement(sql_948)) {
            System.out.println("Preparing to execute insert for ID: " + id_948);

            pst_948.setInt(1, Integer.parseInt(id_948));
            pst_948.setString(2, name_948);
            pst_948.setString(3, dept_948);
            pst_948.setInt(4, Integer.parseInt(marks_948));

            int rows_948 = pst_948.executeUpdate();
            JOptionPane.showMessageDialog(this, rows_948 + " record inserted.");

        } catch (SQLException ex_948) {
            JOptionPane.showMessageDialog(this, "Error: " + ex_948.getMessage());
            ex_948.printStackTrace();
        }
    }

    private void searchStudent_948() {
        String searchName_948 = searchField_948.getText();
        String sql_948 = "SELECT * FROM students WHERE name = ?";

        try (Connection con_948 = DBConnection.getConnection();
                PreparedStatement pst_948 = con_948.prepareStatement(sql_948)) {

            // System.out.println("Preparing to execute query for name: " + searchName_948);

            pst_948.setString(1, searchName_948);
            ResultSet rs_948 = pst_948.executeQuery();

            if (rs_948.next()) {
                String details_948 = "ID: " + rs_948.getInt("id") +
                        "\nName: " + rs_948.getString("name") +
                        "\nDepartment: " + rs_948.getString("department") +
                        "\nMarks: " + rs_948.getInt("marks");
                JOptionPane.showMessageDialog(this, details_948);
            } else {
                JOptionPane.showMessageDialog(this, "Student not found!");
            }

        } catch (SQLException ex_948) {
            JOptionPane.showMessageDialog(this, "Error: " + ex_948.getMessage());
            ex_948.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGUI_948::new);
    }
}
