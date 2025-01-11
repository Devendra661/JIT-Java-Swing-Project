package com.jit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Index extends JFrame
{
    public Index(){
        Element.getFrame();
        items();
    }

    private JButton signup , signin;
    public void items(){
        Element.getImagLabel("F:\\BTPS\\Java_Swing\\jit\\src\\images/signup.jpg", 300, 100, 200, 200);
        signup  = Element.getButton("Sign Up", 325, 320, 150, 30);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp();
            }
        });
        Element.getImagLabel("F:\\BTPS\\Java_Swing\\jit\\src\\images/signin.jpg", 700, 100, 200, 200);
        signin = Element.getButton("Sign In", 725, 320,  150, 30);
        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignIn();
                Index.this.dispose();
            }
        });
        
       
       

    }
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable() {
      public void run() {
            new Index();
      }
      });
    }
}
