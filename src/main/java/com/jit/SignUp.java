package com.jit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SignUp extends Element {

    public SignUp() {
        Element.getFrame();
        items();
    }

    public JButton signup, reset;
    public JTextField Enrollment, name, mobile_no, email;
    JPasswordField pass;
    JComboBox<String> state, city;

    public void items() {
        Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/signup2.png", 10, 50, 500, 500);
        JLabel well = Element.getLabel("Wellcome User Sign Up Here!", 550, 5, 550, 40);
        well.setFont(new Font("Monospaced", Font.BOLD, 30));

        Element.getLabel("Enrollment ", 600, 60, 120, 30);
        Enrollment = Element.getTextField(750, 60, 250, 30);
        Element.getLabel("Name", 600, 100, 120, 30);
        name = Element.getTextField(750, 100, 250, 30);
        Element.getLabel("Mobile No ", 600, 140, 120, 30);
        mobile_no = Element.getTextField(750, 140, 250, 30);
        Element.getLabel("Email", 600, 180, 120, 30);
        email = Element.getTextField(750, 180, 250, 30);
        Element.getLabel("Gender", 600, 220, 120, 30);
        JRadioButton male = Element.getRadioButton("Male", 750, 220, 70, 30);
        JRadioButton female = Element.getRadioButton("Female", 830, 220, 80, 30);
        JRadioButton other = Element.getRadioButton("Other", 930, 220, 70, 30);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
        buttonGroup.add(other);

        Element.getLabel("Year", 600, 260, 120, 30);
        JComboBox<String> year = Element.getComboBox(750, 260, 250, 30);
        year.addItem("<------- Select Year ------->");

        Element.getLabel("Course", 600, 300, 120, 30);
        JComboBox<String> course = Element.getComboBox(750, 300, 250, 30);
        course.addItem("<------- Select Course ------->");

        // Code to add course and year from database
        try {
            Connection conn = Element.getConnection("JIT");
            Statement st = conn.createStatement();
            String query = "SELECT * FROM yc";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                year.addItem(rs.getString(1));
                course.addItem(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Element.getLabel("State", 600, 340, 120, 30);
        state = Element.getComboBox(750, 340, 250, 30);
        state.addItem("<------- Select State ------->");

        Element.getLabel("City", 600, 380, 120, 30);
        city = Element.getComboBox(750, 380, 250, 30);
        city.addItem("<------- Select City ------->");

        // Code to add state from database
        try {
            Connection conn = Element.getConnection("JIT");
            Statement st = conn.createStatement();
            String query = "SELECT STATE_ID, STATE_NAME FROM STATE";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                state.addItem(rs.getString("STATE_NAME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Code to add city based on state selection
        state.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.removeAllItems();
                city.addItem("<------- Select City ------->");
                String selectedState = (String) state.getSelectedItem();
                try {
                    Connection conn = Element.getConnection("JIT");
                    Statement st = conn.createStatement();
                    String query = "SELECT CITY_NAME FROM CITY WHERE STATE_ID = "
                            + "(SELECT STATE_ID FROM STATE WHERE STATE_NAME = '" + selectedState + "')";
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        city.addItem(rs.getString(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        Element.getLabel("Password", 600, 420, 120, 30);
        pass = Element.getPassField(750, 420, 250, 30);

        signup = Element.getButton("Sign Up", 630, 470, 150, 40);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String radiobtm = null;
                if (male.isSelected()) {
                    radiobtm = "Male";
                } else if (female.isSelected()) {
                    radiobtm = "Female";
                } else if (other.isSelected()) {
                    radiobtm = "Other";
                }
                String gender = radiobtm;
                String cour = (String) course.getSelectedItem();
                String yea = (String) year.getSelectedItem();
                String st = (String) state.getSelectedItem();
                String cit = (String) city.getSelectedItem();
                if (Enrollment.getText().isEmpty() || name.getText().isEmpty() || mobile_no.getText().isEmpty()
                        || email.getText().isEmpty() || gender.isEmpty() || pass.getText().isEmpty() || cour.isEmpty() || yea.isEmpty() || st.isEmpty() || cit.isEmpty()) {
                            Enrollment.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                            name.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                            mobile_no.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                            email.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                            pass.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                            course.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                            year.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                            state.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                            city.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                    return;
                } // Sign-up action code here
                else {
                    try {
                        Connection con = Element.getConnection("JIT");
                        String query = "INSERT INTO SIGNUP (ENROLLMENT, NAME, MOBILE_NUMBER, EMAIL, GENDER, YEAR, COURSE, STATE, CITY, PASSWORD,STATUS) VALUES ('" + Enrollment.getText() + "','" + name.getText() + "','" + mobile_no.getText() + "','" + email.getText() + "','" + gender + "','" + yea + "','" + cour + "','" + st + "','" + cit + "','" + pass.getText() + "','" + 0 + "')";
                        Statement statement = con.createStatement();
                        if (statement.executeUpdate(query) == 1) {
                            JOptionPane.showMessageDialog(null, "Sign Up Successfully");
                            Enrollment.setText("");
                            name.setText("");
                            mobile_no.setText("");
                            email.setText("");
                            pass.setText("");
                            buttonGroup.clearSelection();
                            year.setSelectedIndex(0);
                            course.setSelectedIndex(0);
                            state.setSelectedIndex(0);
                            city.setSelectedIndex(0);
                        } else {
                            JOptionPane.showMessageDialog(null, "Sign Up Failed");
                            Enrollment.setText("");
                            name.setText("");
                            mobile_no.setText("");
                            email.setText("");
                            pass.setText("");
                            buttonGroup.clearSelection();
                            year.setSelectedIndex(0);
                            course.setSelectedIndex(0);
                            state.setSelectedIndex(0);
                            city.setSelectedIndex(0);
                        }
                    } catch (Exception e1) {

                        e1.printStackTrace();
                    }
                }

            }
        });

        Element.getLabel("Already Have An Account?", 600, 520, 400, 30);
        JLabel signin = Element.getClickLabel("Sign In", 845, 520, 100, 30);
        signin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new SignIn();
            }
        });

        reset = Element.getButton("Reset", 800, 470, 150, 40);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Enrollment.setText("");
                name.setText("");
                mobile_no.setText("");
                email.setText("");
                pass.setText("");
                buttonGroup.clearSelection();
                year.setSelectedIndex(0);
                course.setSelectedIndex(0);
                state.setSelectedIndex(0);
                city.setSelectedIndex(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUp();
            }
        });
    }
}
