package com.jit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;



public class ShowDriver extends JFrame {

    public ShowDriver() {
        Element.getFrame();
        items();
    }

    private JButton home ,about , addteacher ,stl , addDriver , dl , Showstudent, addBus , showBus;

    public void items() {
        JPanel leftpanel = new JPanel();
        leftpanel.setBounds(0,0,200,580);
        leftpanel.setBorder(BorderFactory.createLineBorder(Color.black,2));
        leftpanel.setBackground(Color.gray);
        leftpanel.setLayout(null);
        Element.mainPanel.add(leftpanel);

        JPanel rightpanel = new JPanel();
        rightpanel.setBounds(200,0,995,580);
        rightpanel.setBorder(BorderFactory.createLineBorder(Color.black,2));


        /*--------------- Table ---------------- */

        // Column identifiers 
        String[] columns = { "Id", "Name", "Age", "Gender", "Mobile Number", "Email" }; 
        // Table and model setup 
        DefaultTableModel dtm = new DefaultTableModel(); 
        dtm.setColumnIdentifiers(columns); 
        JTable table = new JTable(dtm); 
        // Scroll pane setup 
        JScrollPane sp = new JScrollPane(table); 
        
        // 
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         // Set vertical scroll bar policy 
        sp.setBounds(20, 50, 950, 500);
        rightpanel.add(sp);


        try {
            Connection con = Element.getConnection("JIT");
            Statement statement = con.createStatement();
            String query = "SELECT * FROM Driver";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Object[] rowData = {rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                dtm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // JOptionPane.showMessageDialog(null, e);
        }
        /*--------------- Table ---------------- */



         rightpanel.setLayout(null);
        Element.mainPanel.add(rightpanel);

        JLabel img = Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/bg.jpg", 2, 1, 992, 577);
        rightpanel.add(img);

        JLabel adt = Element.getLabel("Driver List ", 400, 10, 200, 30);
        adt.setFont(new Font("Times New Roman", Font.BOLD, 30));
        img.add(adt);

        home = Element.getButton("Home", 25,10,150,35);
        leftpanel.add(home);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AdminHome();
               ShowDriver.this.dispose();
            }
        });

        about = Element.getButton("About JIT", 25,60,150,35);
        leftpanel.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
                ShowDriver.this.dispose();
            }
        });

        addteacher = Element.getButton("Add Teacher", 25,110,150,35);
        leftpanel.add(addteacher);
        addteacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTeacher();
                ShowDriver.this.dispose();
            }
        });

        stl = Element.getButton("Teacher List", 25,160,150,35);
        leftpanel.add(stl);
        stl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowDriver();
                ShowDriver.this.dispose();
            }
        });

        addDriver = Element.getButton("Add Driver", 25,210,150,35);
        leftpanel.add(addDriver);
        addDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDriver();
                ShowDriver.this.dispose();
            }
        });

        dl = Element.getButton("Driver List", 25,260,150,35);
        leftpanel.add(dl);
        dl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowDriver();
                ShowDriver.this.dispose();
            }
        });

        Showstudent = Element.getButton("Student List", 25,310,150,35);
        leftpanel.add(Showstudent);
        Showstudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowStudent();
                ShowDriver.this.dispose();
            }
        });

        addBus = Element.getButton("Add Bus", 25,360,150,35);
        leftpanel.add(addBus);
        addBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBus();
                ShowDriver.this.dispose();
            }
        });

        showBus = Element.getButton("Bus List", 25,410,150,35);
        leftpanel.add(showBus);
        showBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowBus();
                ShowDriver.this.dispose();
            }
        });

        ImageIcon logo = new ImageIcon("F:/BTPS/Java_Swing/jit/src/images/logo1.jpg"); // Corrected path separator
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(3, 465, 195, 100);
        leftpanel.add(logoLabel);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShowDriver();
            }
        });
    }

}
