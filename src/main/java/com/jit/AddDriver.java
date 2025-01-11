package com.jit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AddDriver extends JFrame {

    public AddDriver() {
        Element.getFrame();
        items();
    }

    private JButton home, about, AddDriver, stl, addDriver, dl, Showstudent, addBus, showBus , submit ,cancle;

    private JLabel name, age, mobile ,email;
    private JTextField nametxt, agetxt, mobiletxt, emailtxt;

    

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
        Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/DEIVER.png", -50, 100, 1000, 534);
        rightpanel.setLayout(null);
        Element.mainPanel.add(rightpanel);

        JLabel img = Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/bg.jpg", 2, 1, 992, 577);
        rightpanel.add(img);

        JLabel adt = Element.getLabel("Add Driver", 450, 50, 200, 30);
        adt.setFont(new Font("Times New Roman", Font.BOLD, 30));
        img.add(adt);


        // Name
        name = Element.getLabel("Name", 500, 150, 100, 30);
        img.add(name);
        nametxt = Element.getTextField(600, 150, 230, 30);
        img.add(nametxt);
        // Age
        age = Element.getLabel("Age", 500, 200, 100, 30);
        img.add(age);
        agetxt = Element.getTextField(600, 200, 230, 30);
        img.add(agetxt);
        // Gender
        name = Element.getLabel("Gender", 500, 250, 100, 30);
        img.add(name);
        JRadioButton male = Element.getRadioButton("Male", 600, 250, 70, 30);
        JRadioButton female = Element.getRadioButton("Female", 670, 250, 80, 30);
        JRadioButton other = Element.getRadioButton("Other", 750, 250, 70, 30);
        img.add(male);
        img.add(female);
        img.add(other);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
        buttonGroup.add(other);
        
        // subject

        // Mobile Number
        mobile = Element.getLabel("Mobile No", 500, 300, 100, 30);
        img.add(mobile);
        mobiletxt = Element.getTextField(600, 300, 230, 30);
        img.add(mobiletxt);
        // Email Address
        email = Element.getLabel("Email", 500, 350, 100, 30);
        img.add(email);
        emailtxt = Element.getTextField(600, 350, 230, 30);
        img.add(emailtxt);
        // Submit Button
        submit = Element.getButton("Submit", 510, 420, 150, 35);
        img.add(submit);
        submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String radiobtn = null;
            if(male.isSelected()){
                radiobtn = "Male";
            }else if(female.isSelected()){
                radiobtn = "Female";
            }else{
                radiobtn = "Other";
            }
            String g = radiobtn;
            if(nametxt.getText().isEmpty() || agetxt.getText().isEmpty() || mobiletxt.getText().isEmpty() || emailtxt.getText().isEmpty()){
                nametxt.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                agetxt.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                mobiletxt.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                emailtxt.setBorder(BorderFactory.createLineBorder(Color.red, 3));
            }
            try {
                // Database Connection
                Connection con = Element.getConnection("jit");
                String query = "INSERT INTO Driver(NAME , AGE , GENDER , MOBILE_NUMBER , EMAIL) VALUES('"+nametxt.getText()+"','"+agetxt.getText()+"','"+g+"','"+mobiletxt.getText()+"','"+emailtxt.getText()+"')";
                Statement st = con.createStatement();
                int i = st.executeUpdate(query);
                if(i>0){
                    JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                    nametxt.setText("");
                    agetxt.setText("");
                    mobiletxt.setText("");
                    emailtxt.setText("");
                    buttonGroup.clearSelection();
                }else{
                    JOptionPane.showMessageDialog(null, "Driver to Add Teacher");
                    nametxt.setText("");
                    agetxt.setText("");
                    mobiletxt.setText("");
                    emailtxt.setText("");
                    buttonGroup.clearSelection();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                // JOptionPane.showMessageDialog(null, e1);
            }
        }});


        // Cancle Button
        cancle = Element.getButton("Cancle", 670, 420, 150, 35);
        img.add(cancle);
        cancle.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddDriver.this.dispose();
            JOptionPane.showMessageDialog(null, "pressed");
        }});








        home = Element.getButton("Home", 25, 10, 150, 35);
        leftpanel.add(home);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminHome();
                AddDriver.this.dispose();
            }
        });

        about = Element.getButton("About JIT", 25, 60, 150, 35);
        leftpanel.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
                AddDriver.this.dispose();
            }
        });

        AddDriver = Element.getButton("Add Teacher", 25, 110, 150, 35);
        leftpanel.add(AddDriver);
        AddDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDriver();
                AddDriver.this.dispose();
            }
        });

        stl = Element.getButton("Teacher List", 25, 160, 150, 35);
        leftpanel.add(stl);
        stl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowTeacher();
                AddDriver.this.dispose();
            }
        });

        addDriver = Element.getButton("Add Driver", 25, 210, 150, 35);
        leftpanel.add(addDriver);
        addDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDriver();
                AddDriver.this.dispose();
            }
        });

        dl = Element.getButton("Driver List", 25, 260, 150, 35);
        leftpanel.add(dl);
        dl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowDriver();
                AddDriver.this.dispose();
            }
        });

        Showstudent = Element.getButton("Student List", 25, 310, 150, 35);
        leftpanel.add(Showstudent);
        Showstudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowStudent();
                AddDriver.this.dispose();
            }
        });

        addBus = Element.getButton("Add Bus", 25, 360, 150, 35);
        leftpanel.add(addBus);
        addBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBus();
                AddDriver.this.dispose();
            }
        });

        showBus = Element.getButton("Bus List", 25, 410, 150, 35);
        leftpanel.add(showBus);
        showBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowBus();
                AddDriver.this.dispose();
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
                new AddDriver();
            }
        });
    }

}
