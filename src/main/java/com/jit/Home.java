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



public class Home extends JFrame {

    public Home() {
        Element.getFrame();
        items();
    }

    private JButton signin;

    public void items() {
        Element.getImagLabel("F:\\BTPS\\Java_Swing\\jit\\src\\images/Login.png", 40, 50, 500, 500);
        JLabel well = Element.getLabel("Wellcome User!", 650, 85, 350, 30);
        well.setFont(new Font("Monospaced", Font.BOLD, 30));
        

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home();
            }
        });
    }

}
