package com.jit;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class ChangePassword extends JFrame {

    public ChangePassword() {
        Element.getFrame();
        items();
    }

   

    private JTextField old_pass , new_pass , confirm_pass;
    JButton change_pass;
    public void items() {
        Element.getImagLabel("F:\\BTPS\\Java_Swing\\jit\\src\\images\\changepass.png", 40, 50, 500, 500);
        JLabel well = Element.getLabel("Change Password Here !!!!!!", 650, 85, 550, 40);
        well.setFont(new Font("Monospaced", Font.BOLD, 30));
        Element.getLabel("Old Password", 600, 185, 200, 20);
        Element.getLabel("New Password", 600, 255, 200, 20);
        Element.getLabel("Confirm Password", 600, 325, 200, 20);
        old_pass = Element.getTextField(790, 180, 200, 30);
        new_pass = Element.getPassField(790, 250, 200, 30);
        confirm_pass = Element.getPassField(790, 325, 200, 30);

        change_pass = Element.getButton("Change Password", 700, 380, 200, 40);
        change_pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldpassword = old_pass.getText();
                String newpassword = new_pass.getText();
                String confirmpassword = confirm_pass.getText();

                if(newpassword.equals(confirmpassword)){
                    try {
                        Connection con = Element.getConnection("JIT");
                        Statement stmt = con.createStatement(); 
                        String query = "UPDATE SIGNUP SET PASSWORD = '" + newpassword + "', STATUS = 1 WHERE PASSWORD = '" + oldpassword + "'";
                        int update = stmt.executeUpdate(query);
                        if(update > 0){
                            JOptionPane.showMessageDialog(null,"Password Change Successfully......"); 
                            dispose();
                            new SignIn();
                        }else{
                            JOptionPane.showMessageDialog(null,"Password Change Failed......"); 
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"New And Confirm Password Is Not Match......"); 
                }
            }
        });
       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChangePassword();
            }
        });
    }

}
