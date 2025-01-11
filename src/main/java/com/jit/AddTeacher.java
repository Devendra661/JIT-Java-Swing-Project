package com.jit;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
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

public class AddTeacher extends JFrame {

    public AddTeacher() {
        Element.getFrame();
        items();
    }

    private JButton home, about, addteacher, stl, addDriver, dl, Showstudent, addBus, showBus , submit ,cancle;

    private JLabel name, age, subject, mobile ,email;
    private JTextField nametxt, agetxt, mobiletxt, emailtxt;
    private JComboBox<String> subjectbox;
    

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
        Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/teacher.png", 0, 100, 1000, 534);
        rightpanel.setLayout(null);
        Element.mainPanel.add(rightpanel);

        JLabel img = Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/bg.jpg", 2, 1, 992, 577);
        rightpanel.add(img);

        JLabel adt = Element.getLabel("Add Teacher", 450, 50, 200, 30);
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
        subject = Element.getLabel("Subject", 500, 300, 100, 30);
        img.add(subject);
        subjectbox = Element.getComboBox(600, 300, 230, 30);
        subjectbox.addItem("<---- Select Subject ---->");
        img.add(subjectbox);
        try {
            Connection con = Element.getConnection("JIT");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM SUBJECT";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                // System.out.println(rs.getString(1));
                subjectbox.addItem(rs.getString(2));
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
            e1.printStackTrace();
        } 

        // Mobile Number
        mobile = Element.getLabel("Mobile No", 500, 350, 100, 30);
        img.add(mobile);
        mobiletxt = Element.getTextField(600, 350, 230, 30);
        img.add(mobiletxt);
        // Email Address
        email = Element.getLabel("Email", 500, 400, 100, 30);
        img.add(email);
        emailtxt = Element.getTextField(600, 400, 230, 30);
        img.add(emailtxt);
        // Submit Button
        submit = Element.getButton("Submit", 510, 470, 150, 35);
        img.add(submit);
        submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String radiobtn = null;
            if(male.isSelected()){
                radiobtn = "Male";
            }else if(female.isSelected()){
                radiobtn = "Female";
            }else if(other.isSelected()){
                radiobtn = "Other";
            }
            String g = radiobtn;
            if(nametxt.getText().isEmpty() || agetxt.getText().isEmpty() || subjectbox.getSelectedItem().equals("<---- Select Subject ---->") || mobiletxt.getText().isEmpty() || emailtxt.getText().isEmpty()){
                nametxt.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                agetxt.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                subjectbox.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                mobiletxt.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                emailtxt.setBorder(BorderFactory.createLineBorder(Color.red, 3));
            }else{
            try {
                // Database Connection
                Connection con = Element.getConnection("jit");
                String query = "INSERT INTO TEACHER(NAME , AGE , GENDER , SUBJECT , MOBILE_NUMBER , EMAIL) VALUES('"+nametxt.getText()+"','"+agetxt.getText()+"','"+g+"' ,'"+subjectbox.getSelectedItem()+"','"+mobiletxt.getText()+"','"+emailtxt.getText()+"')";
                Statement st = con.createStatement();
                int i = st.executeUpdate(query);
                if(i>0){
                    JOptionPane.showMessageDialog(null, "Teacher Added Successfully");
                    nametxt.setText("");
                    agetxt.setText("");
                    subjectbox.setSelectedIndex(0);
                    mobiletxt.setText("");
                    emailtxt.setText("");
                    buttonGroup.clearSelection();
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to Add Teacher");
                    nametxt.setText("");
                    agetxt.setText("");
                    subjectbox.setSelectedIndex(0);
                    mobiletxt.setText("");
                    emailtxt.setText("");
                    buttonGroup.clearSelection();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, e1);
            }
           }
        }});


        // Cancle Button
        cancle = Element.getButton("Cancle", 670, 470, 150, 35);
        img.add(cancle);
        cancle.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddTeacher.this.dispose();
            JOptionPane.showMessageDialog(null, "pressed");
        }});








        home = Element.getButton("Home", 25, 10, 150, 35);
        leftpanel.add(home);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminHome();
                AddTeacher.this.dispose();
            }
        });

        about = Element.getButton("About JIT", 25, 60, 150, 35);
        leftpanel.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
                AddTeacher.this.dispose();
            }
        });

        addteacher = Element.getButton("Add Teacher", 25, 110, 150, 35);
        leftpanel.add(addteacher);
        addteacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTeacher();
                AddTeacher.this.dispose();
            }
        });

        stl = Element.getButton("Teacher List", 25, 160, 150, 35);
        leftpanel.add(stl);
        stl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowTeacher();
                AddTeacher.this.dispose();
            }
        });

        addDriver = Element.getButton("Add Driver", 25, 210, 150, 35);
        leftpanel.add(addDriver);
        addDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDriver();
                AddTeacher.this.dispose();
            }
        });

        dl = Element.getButton("Driver List", 25, 260, 150, 35);
        leftpanel.add(dl);
        dl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowDriver();
                AddTeacher.this.dispose();
            }
        });

        Showstudent = Element.getButton("Student List", 25, 310, 150, 35);
        leftpanel.add(Showstudent);
        Showstudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowStudent();
                AddTeacher.this.dispose();
            }
        });

        addBus = Element.getButton("Add Bus", 25, 360, 150, 35);
        leftpanel.add(addBus);
        addBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBus();
                AddTeacher.this.dispose();
            }
        });

        showBus = Element.getButton("Bus List", 25, 410, 150, 35);
        leftpanel.add(showBus);
        showBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowBus();
                AddTeacher.this.dispose();
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
                new AddTeacher();
            }
        });
    }

}
