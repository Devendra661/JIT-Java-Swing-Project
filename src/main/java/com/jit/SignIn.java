package com.jit;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.SwingUtilities;

public class SignIn extends JFrame {

    public SignIn() {
        Element.getFrame();
        items();
    }

    private JButton signin;

    public void items() {
        Element.getImagLabel("F:\\BTPS\\Java_Swing\\jit\\src\\images/Login.png", 40, 50, 500, 500);
        JLabel well = Element.getLabel("Wellcome Back User!", 650, 85, 350, 30);
        well.setFont(new Font("Monospaced", Font.BOLD, 30));
        Element.getLabel("Did't Have An Account?", 650, 120, 250, 30);
        JLabel signup = Element.getClickLabel("Sign Up", 870, 120, 100, 30);
        signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new SignUp();
                dispose();
            }

        });
        Element.getLabel("Username", 600, 185, 100, 20);
        Element.getLabel("Password", 600, 255, 100, 20);
        JTextField Username = Element.getTextField(750, 180, 200, 30);
        JTextField password = Element.getPassField(750, 250, 200, 30);

        signin = Element.getButton("Sign In", 730, 310, 150, 40);
        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = Element.getConnection("JIT");
                    String query = "SELECT EMAIL, PASSWORD, STATUS, 'USER' AS TYPE FROM SIGNUP WHERE EMAIL = '" + Username.getText() + "' AND PASSWORD = '" + password.getText() + "' "
                                 + "UNION "
                                 + "SELECT username AS EMAIL, password AS PASSWORD, NULL AS STATUS, 'ADMIN' AS TYPE FROM Login WHERE username = '" + Username.getText() + "' AND password = '" + password.getText() + "'";
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                
                    boolean loginSuccess = false;
                
                    while (rs.next()) {
                        String userType = rs.getString("TYPE");
                        if ("ADMIN".equals(userType)) {
                            new AdminHome();
                            JOptionPane.showMessageDialog(null, "Admin Login Success.....");
                            loginSuccess = true;
                            dispose();
                            break;
                        } else if ("USER".equals(userType) && rs.getInt("STATUS") == 1) {
                            JOptionPane.showMessageDialog(null, "User Login Success.....");
                            loginSuccess = true;
                            new Home();
                            dispose();
                            break;
                        } else if ("USER".equals(userType) && rs.getInt("STATUS") != 1) {
                            JOptionPane.showMessageDialog(null, "Account Not Active. Please Change Your Password.");
                            loginSuccess = true;
                            new ChangePassword();
                            dispose();
                            break;
                        }
                    }
                    if (!loginSuccess) {
                        JOptionPane.showMessageDialog(null, "Login Failed.....");
                    }
                
                    // Close resources
                    rs.close();
                    st.close();
                    con.close();
                
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                
                
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignIn();
            }
        });
    }

}
