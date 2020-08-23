/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication41;

import java.awt.HeadlessException;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import static javaapplication41.JavaApplication40.*;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Eslam
 */
public class Show extends JFrame implements ActionListener {
     //first jframe
     protected JLabel Label;
     protected JTextField Text;
     protected JButton Button;
     //second jframe
     protected JFrame Show2;
     protected int x = 50;
     /* ArrayList of textfields according to no. of holes entered by user*/
     protected ArrayList<JTextField> Fields = new ArrayList<JTextField>();
     protected JLabel Label2;
     protected JButton Button2;
    public Show() {
     this.setSize(450,450);
     this.setTitle("Visualize");
     this.setVisible(true);
     this.setLayout(null);
     
     Show2 = new JFrame(); 
     Show2.setSize(450,450);
     Show2.setTitle("Visualize");
     Show2.setLayout(null);
     
     Label=new JLabel("Enter number of holes : ");
     Text=new JTextField();
     this.add(Text);
     Text.setBounds(185,100,20,20);
     this.add(Label);
     Label.setBounds(50,100,150,20);
     Button=new JButton("Submit");
     Button.setBounds(100,130,100,20);
     Button.addActionListener(this);
     this.add(Button);
     
     Label2 = new JLabel("Enter holes sizes :");
     Show2.add(Label2);
     Label2.setBounds(50,80,150,20);
     Show2.add(Label2);
     Button2 = new JButton("Submit");
     Button2.setBounds(100,130,100,20);
     Button2.addActionListener(this);
     Show2.add(Button2);
     
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       Object buttonPressed=ae.getSource(); 
        if(buttonPressed.equals(Button)){
            for (int i=0;i<parseInt(Text.getText());i++){
            Fields.add(new JTextField());
            Fields.get(i).setBounds(x,100,32,20);
            x=x+50;
            Show2.add(Fields.get(i));
            HoleNo=parseInt(Text.getText());
        }
        this.setVisible(false);
        Show2.setVisible(true);
       }
        else if(buttonPressed.equals(Button2))
         {
             this.setVisible(false);
             for (JTextField i : Fields)
               Sizes.add(parseInt(i.getText()));
             Show2.setVisible(false);
             Details x = new Details();
         }
}
}