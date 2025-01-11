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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AddBus extends JFrame {

    public AddBus() {
        Element.getFrame();
        items();
    }

    private JButton home, about, AddDriver, AddTeacher, stl,  dl, Showstudent, addBus, showBus , submit ,cancle ;

    private JLabel Busno, DriverName;
    private JTextField Busnotxt;
    private JComboBox<String> driverbox;

    

    public void items() {
        JPanel leftpanel = new JPanel();
        leftpanel.setBounds(0, 0, 200, 580);
        leftpanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        leftpanel.setBackground(Color.gray);
        leftpanel.setLayout(null);
        Element.mainPanel.add(leftpanel);

        JPanel rightpanel = new JPanel();
        rightpanel.setBounds(200, 0, 995, 580);
        rightpanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/bus.png", -50, 100, 1000, 534);
        rightpanel.setLayout(null);
        Element.mainPanel.add(rightpanel);

        JLabel img = Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/bg.jpg", 2, 1, 992, 577);
        rightpanel.add(img);

        JLabel adt = Element.getLabel("Add Bus", 450, 150, 200, 30);
        adt.setFont(new Font("Times New Roman", Font.BOLD, 30));
        img.add(adt);


        // Name
        Busno = Element.getLabel("Bus Number", 500, 250, 200, 30);
        img.add(Busno);
        Busnotxt = Element.getTextField(650, 250, 230, 30);
        img.add(Busnotxt);

        
        // Driver Name 
        DriverName = Element.getLabel("Driver Name", 500, 320, 200, 30); 
        img.add(DriverName); 
        driverbox = Element.getComboBox(650, 320, 230, 30); 
        img.add(driverbox); 
        driverbox.addItem("<---- Driver Name ----->");

        try {
            Connection con = Element.getConnection("JIT");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT *  FROM Driver");
            while (rs.next()) {
                driverbox.addItem(rs.getString("NAME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Submit Button
        submit = Element.getButton("Submit", 510, 380, 150, 35);
        img.add(submit);
        submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           if(Busnotxt.getText().isEmpty() || driverbox.getSelectedItem().equals("<---- Driver Name ----->")){
            Busnotxt.setBorder(BorderFactory.createLineBorder(Color.red, 3));
            driverbox.setBorder(BorderFactory.createLineBorder(Color.red, 3));
           }else{
            try {
                // Database Connection
                Connection con = Element.getConnection("jit");
            
                // Retrieve DRIVER_ID based on the selected DRIVERNAME
                String selectedDriverName = driverbox.getSelectedItem().toString();
                String getDriverIdQuery = "SELECT ID FROM Driver WHERE NAME = '" + selectedDriverName + "'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(getDriverIdQuery);
            
                if (rs.next()) {
                    String driverId = rs.getString("ID");
            
                    // Insert into BUS table
                    String insertQuery = "INSERT INTO BUS (BUSNUMBER, DRIVERNAME, DRIVER_ID) VALUES ('"
                            + Busnotxt.getText() + "', '" + selectedDriverName + "', " + driverId + ")";
                    int i = st.executeUpdate(insertQuery);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "Bus Added Successfully");
                        Busnotxt.setText("");
                        driverbox.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to Add Bus");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Driver not found");
                }
            
                // Close resources
                rs.close();
                st.close();
                con.close();
            
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Already Exist");
                Busnotxt.setText("");
                driverbox.setSelectedIndex(0);
            }
        }     
        }});
  
        // Cancle Button
        cancle = Element.getButton("Cancle", 670, 380, 150, 35);
        img.add(cancle);
        cancle.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddBus.this.dispose();
            JOptionPane.showMessageDialog(null, "pressed");
        }});








        home = Element.getButton("Home", 25, 10, 150, 35);
        leftpanel.add(home);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminHome();
                AddBus.this.dispose();
            }
        });

        about = Element.getButton("About JIT", 25, 60, 150, 35);
        leftpanel.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
                AddBus.this.dispose();
            }
        });

        AddTeacher = Element.getButton("Add Teacher", 25, 110, 150, 35);
        leftpanel.add(AddTeacher);
        AddTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTeacher();
                AddBus.this.dispose();
            }
        });

        stl = Element.getButton("Teacher List", 25, 160, 150, 35);
        leftpanel.add(stl);
        stl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowTeacher();
                AddBus.this.dispose();
            }
        });

        AddDriver = Element.getButton("Add Driver", 25, 210, 150, 35);
        leftpanel.add(AddDriver);
        AddDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDriver();
                AddBus.this.dispose();
            }
        });

        dl = Element.getButton("Driver List", 25, 260, 150, 35);
        leftpanel.add(dl);
        dl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowDriver();
                AddBus.this.dispose();
            }
        });

        Showstudent = Element.getButton("Student List", 25, 310, 150, 35);
        leftpanel.add(Showstudent);
        Showstudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowStudent();
                AddBus.this.dispose();
            }
        });

        addBus = Element.getButton("Add Bus", 25, 360, 150, 35);
        leftpanel.add(addBus);
        addBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBus();
                AddBus.this.dispose();
            }
        });

        showBus = Element.getButton("Bus List", 25, 410, 150, 35);
        leftpanel.add(showBus);
        showBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowBus();
                AddBus.this.dispose();
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
                new AddBus();
            }
        });
    }

        }
