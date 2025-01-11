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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;



public class ShowStudent extends JFrame {

    public ShowStudent() {
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
         rightpanel.setLayout(null);
        Element.mainPanel.add(rightpanel);

        /* <------------------ Table -----------------> */
        String [] columns = {"Enrollment","Name","Mobile Number","Email","Gender","Year","Course","State","City"};
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         // Set vertical scroll bar policy 
        sp.setBounds(20, 50, 950, 500);
        rightpanel.add(sp);

        try {
            Connection con  = Element.getConnection("JIT");
            Statement st = con.createStatement();
            String query = "SELECT * FROM SIGNUP";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Object[] rowData = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
                model.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
        }
        /* <------------------ Table -----------------> */
        JLabel img = Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/bg.jpg", 2, 1, 992, 577);
        rightpanel.add(img);
        JLabel adt = Element.getLabel("Student List ", 400, 10,  200, 30);
        adt.setFont(new Font("Times New Roman", Font.BOLD, 30));
        img.add(adt);


        home = Element.getButton("Home", 25,10,150,35);
        leftpanel.add(home);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AdminHome();
               ShowStudent.this.dispose();
            }
        });

        about = Element.getButton("About JIT", 25,60,150,35);
        leftpanel.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
                ShowStudent.this.dispose();
            }
        });

        addteacher = Element.getButton("Add Teacher", 25,110,150,35);
        leftpanel.add(addteacher);
        addteacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTeacher();
                ShowStudent.this.dispose();
            }
        });

        stl = Element.getButton("Teacher List", 25,160,150,35);
        leftpanel.add(stl);
        stl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowTeacher();
                ShowStudent.this.dispose();
            }
        });

        addDriver = Element.getButton("Add Driver", 25,210,150,35);
        leftpanel.add(addDriver);
        addDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDriver();
                ShowStudent.this.dispose();
            }
        });

        dl = Element.getButton("Driver List", 25,260,150,35);
        leftpanel.add(dl);
        dl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowDriver();
                ShowStudent.this.dispose();
            }
        });

        Showstudent = Element.getButton("Student List", 25,310,150,35);
        leftpanel.add(Showstudent);
        Showstudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowStudent();
                ShowStudent.this.dispose();
            }
        });

        addBus = Element.getButton("Add Bus", 25,360,150,35);
        leftpanel.add(addBus);
        addBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBus();
                ShowStudent.this.dispose();
            }
        });

        showBus = Element.getButton("Bus List", 25,410,150,35);
        leftpanel.add(showBus);
        showBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowBus();
                ShowStudent.this.dispose();
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
                new AdminHome();
            }
        });
    }

}
