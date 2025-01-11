package com.jit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;



public class About extends JFrame {

    public About() {
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
        Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/jit-photo-c.jpg", 470,20,1000,534);
        
        // rightpanel.add(about);
        rightpanel.setLayout(null);
        Element.mainPanel.add(rightpanel);

        JLabel img = Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/bg.jpg", 2,1,992,577);
        rightpanel.add(img);
        JLabel ab = Element.getLabel("About JIT", 20, 20, 200, 30);
        ab.setFont(new Font("Times New Roman", Font.BOLD, 30));
        img.add(ab);

        JTextArea contn = new JTextArea();
        contn.setBounds(20,60,450,480);
        contn.setFont(new Font("Arial", Font.PLAIN, 17));
        contn.setBackground(new Color(0, 0, 0, 0));
        contn.setText("The institute is promoted by a number of professionally successful Indians who are settled abroad and have come together to promote higher education with leadership skills to give back to the community.\r\n" + //
                        "\r\n" + //
                        "The institute is located in the historic fort of Jahangirabad, in Barabanki District, about 40 km from Lucknow city. Barabanki of eastern UP has been out of the technology race and remains industrially backward. But now the fort has  been transformed into  an  important center for education, learning and research.\r\n" + //
                        "\r\n" + //
                        "JIT has been founded to cherish the great values of transmission of knowledge, passionate pursuit of truth, maintenance of the highest standards of teaching, and enhancing the intellectual, cultural, economic and social well-being of the minority community. JIT will provide facilities for rewarding educational experiences that develops the capabilities for independent thought, critical judgment, problem solving, effective communication and ethical sensitivity, to equip graduates for leadership roles in business, industry, government setup and society.");
        contn.setEditable(false);
        contn.setWrapStyleWord(true);
        contn.setLineWrap(true);
        img.add(contn);


        home = Element.getButton("Home", 25,10,150,35);
        leftpanel.add(home);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AdminHome();
               About.this.dispose();
            }
        });

        about = Element.getButton("About JIT", 25,60,150,35);
        leftpanel.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
                About.this.dispose();
            }
        });

        addteacher = Element.getButton("Add Teacher", 25,110,150,35);
        leftpanel.add(addteacher);
        addteacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTeacher();
                About.this.dispose();
            }
        });

        stl = Element.getButton("Teacher List", 25,160,150,35);
        leftpanel.add(stl);
        stl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowTeacher();
                About.this.dispose();
            }
        });

        addDriver = Element.getButton("Add Driver", 25,210,150,35);
        leftpanel.add(addDriver);
        addDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDriver();
                About.this.dispose();
            }
        });

        dl = Element.getButton("Driver List", 25,260,150,35);
        leftpanel.add(dl);
        dl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowDriver();
                About.this.dispose();
            }
        });

        Showstudent = Element.getButton("Student List", 25,310,150,35);
        leftpanel.add(Showstudent);
        Showstudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowStudent();
                About.this.dispose();
            }
        });

        addBus = Element.getButton("Add Bus", 25,360,150,35);
        leftpanel.add(addBus);
        addBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBus();
                About.this.dispose();
            }
        });

        showBus = Element.getButton("Bus List", 25,410,150,35);
        leftpanel.add(showBus);
        showBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowBus();
                About.this.dispose();
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
                new About();
            }
        });
    }

}
