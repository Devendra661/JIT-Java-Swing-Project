package com.jit;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Element extends JFrame {
    static JPanel mainPanel;

    public static JFrame getFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Jahangirabad Institute of Technology");       
        frame.setBounds(100, 50, 1220, 740); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setLayout(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1200, 700);
        panel.setLayout(null);
        frame.add(panel);

        JPanel header = new JPanel();
        header.setBounds(0, 0, 1195, 110);
        header.setBackground(Color.gray);
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        header.setLayout(null);
        panel.add(header);

        mainPanel = new JPanel(); // Initialize mainPanel as an instance variable
        mainPanel.setBounds(0, 115, 1195, 580);
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        mainPanel.setLayout(null);
        panel.add(mainPanel);

        ImageIcon logo = new ImageIcon("F:/BTPS/Java_Swing/jit/src/images/logo1.jpg"); // Corrected path separator
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(100, 5, 230, 100);
        header.add(logoLabel);

        JLabel headerText = new JLabel("Jahangirabad Institute of Technology", JLabel.CENTER); 
        headerText.setBounds(400, 25, 700, 60);
        headerText.setForeground(Color.yellow);
        headerText.setFont(new Font("Monospaced", Font.BOLD, 32));
        header.add(headerText);
        
        return frame;
    }
    
    public static JLabel getLabel( String title, int x, int y, int width, int height) {
        JLabel label = new JLabel(title);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Courier" , Font.BOLD,18));
        mainPanel.add(label); // Add label to mainPanel
        return label;
    }
    public static JLabel getClickLabel( String title, int x, int y, int width, int height) {
        JLabel label = new JLabel(title);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Courier" , Font.BOLD,17));
        label.setForeground(Color.BLUE);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mainPanel.add(label); // Add label to mainPanel
        return label;
    }

    public static JLabel getImagLabel( String title, int x, int y, int width, int height) {
        JLabel label = new JLabel(new ImageIcon(title));
        label.setBounds(x, y, width, height);
        mainPanel.add(label); // Add label to mainPanel
        return label;
    }
    public static JButton getButton(String title, int x, int y, int width, int height) {
        JButton button = new JButton(title);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("tahoma" , Font.PLAIN,17));
        button.setBackground(new Color(0, 0, 128));
        button.setForeground(new Color(255, 215, 0));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(button); // Add label to mainPanel
        return button;
    }

    public static JTextField getTextField( int x, int y, int width, int height){
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(textField); // Add textField to mainPanel
        return textField;
    }
    public static JPasswordField getPassField( int x, int y, int width, int height){
        JPasswordField textField = new JPasswordField();
        textField.setBounds(x, y, width, height);
        textField.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(textField); // Add textField to mainPanel
        return textField;
    }

    public static JRadioButton getRadioButton(String title , int x ,int y , int width , int height ) {
      JRadioButton radioButton = new JRadioButton(title);
      radioButton.setBounds(x, y, width, height);
      radioButton.setBackground(Color.LIGHT_GRAY);
      radioButton.setFont(new Font("Courier" , Font.BOLD,16));
      mainPanel.add(radioButton);
      return radioButton;
    }

    public static JComboBox getComboBox(int x ,int y , int width , int height){
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(x, y, width, height);
        comboBox.setFont(new Font("Courier" , Font.BOLD,14));
        mainPanel.add(comboBox);
        return comboBox;
    }

    public static Connection getConnection(String DbName){
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName="+DbName+";user=username;password=password;encrypt=false;");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
