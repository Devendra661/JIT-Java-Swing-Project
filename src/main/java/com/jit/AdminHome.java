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
import javax.swing.SwingUtilities;



public class AdminHome extends JFrame {

    public AdminHome() {
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

        JLabel img = Element.getImagLabel("F:/BTPS/Java_Swing/jit/src/images/main.jpg", 2,1,992,577);
        rightpanel.add(img);

        home = Element.getButton("Home", 25,10,150,35);
        leftpanel.add(home);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AdminHome();
                AdminHome.this.dispose();
            }
        });

        about = Element.getButton("About JIT", 25,60,150,35);
        leftpanel.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
                AdminHome.this.dispose();
            }
        });

        addteacher = Element.getButton("Add Teacher", 25,110,150,35);
        leftpanel.add(addteacher);
        addteacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTeacher();
                AdminHome.this.dispose();
            }
        });

        stl = Element.getButton("Teacher List", 25,160,150,35);
        leftpanel.add(stl);
        stl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowTeacher();
                AdminHome.this.dispose();
            }
        });

        addDriver = Element.getButton("Add Driver", 25,210,150,35);
        leftpanel.add(addDriver);
        addDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDriver();
                AdminHome.this.dispose();
            }
        });

        dl = Element.getButton("Driver List", 25,260,150,35);
        leftpanel.add(dl);
        dl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowDriver();
                AdminHome.this.dispose();
            }
        });

        Showstudent = Element.getButton("Student List", 25,310,150,35);
        leftpanel.add(Showstudent);
        Showstudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowStudent();
                AdminHome.this.dispose();
            }
        });

        addBus = Element.getButton("Add Bus", 25,360,150,35);
        leftpanel.add(addBus);
        addBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBus();
                AdminHome.this.dispose();
            }
        });

        showBus = Element.getButton("Bus List", 25,410,150,35);
        leftpanel.add(showBus);
        showBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowBus();
                AdminHome.this.dispose();
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
