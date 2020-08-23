/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication41;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import static javaapplication41.JavaApplication40.Sizes;
import static javaapplication41.JavaApplication40.*;
import javax.swing.JFrame;
import javax.swing.*;


public class Details extends JFrame implements ActionListener {
     //first jframe
     protected JLabel Label;
     protected JTextField Text;
     protected JButton Button;
     //second jframe
     protected JFrame Details2;
     protected int x = 50;
     /* ArrayList of textfields according to no. of holes entered by user*/
     protected ArrayList<JTextField> Fields = new ArrayList<JTextField>();
     /* Labels so the user knows which processes he is entering the size of*/
     protected ArrayList<JLabel> Processes = new ArrayList<JLabel>();
     protected JLabel Label2;
     protected JButton Button2;

     protected JFrame Choice;
     protected JLabel Label3;
     protected JButton Button3;
     protected JButton Button4;
     protected JButton Button5;
     protected JFrame VIZ;
    public Details() {
     this.setSize(450,450);
     this.setTitle("Visualize");
     this.setVisible(true);
     this.setLayout(null);
     
     Details2 = new JFrame(); 
     Details2.setSize(450,450);
     Details2.setTitle("Visualize");
     Details2.setLayout(null);
     
     Label=new JLabel("Enter number of processes : ");
     Text=new JTextField();
     this.add(Text);
     Text.setBounds(220,100,20,20);
     this.add(Label);
     Label.setBounds(60,100,170,20);
     Button=new JButton("Submit");
     Button.setBounds(100,130,100,20);
     Button.addActionListener(this);
     this.add(Button);
     
     Label2 = new JLabel("Enter processes sizes :");
     Details2.add(Label2);
     Label2.setBounds(40,80,170,20);
     Details2.add(Label2);
     Button2 = new JButton("Submit");
     Button2.setBounds(100,140,100,20);
     Button2.addActionListener(this);
     Details2.add(Button2);
     
     Choice=new JFrame();
     Choice.setSize(600,600);
     Choice.setTitle("Visualize");
     Choice.setLayout(null);
     Label3=new JLabel("Choose your method: ");
     Button3=new JButton("First Fit");
     Button4=new JButton("Best Fit");
     Button5=new JButton("Worst Fit");
     Label3.setBounds(190,200,150,20);
     Button3.setBounds(75,230,120,20);
     Button4.setBounds(205,230,120,20);
     Button5.setBounds(335,230,120,20);     
     Choice.add(Label3);
     Choice.add(Button3);
     Choice.add(Button4);
     Choice.add(Button5);
     Button3.addActionListener(this);
     Button4.addActionListener(this);
     Button5.addActionListener(this);
     
     VIZ=new JFrame();
     VIZ.setSize(600,600);
     VIZ.setTitle("Visualize");
     VIZ.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
       Object buttonPressed=ae.getSource(); 
        if(buttonPressed.equals(Button)){
            for (int i=0;i<parseInt(Text.getText());i++){
            Fields.add(new JTextField());
            Fields.get(i).setBounds(x,100,32,20);
            Processes.add(new JLabel());
            Processes.get(i).setBounds(x,120,32,20);
            Processes.get(i).setText("P"+i);
            x=x+50;
            Details2.add(Fields.get(i));
            Details2.add(Processes.get(i));
            PNo=parseInt(Text.getText());
        }
        this.setVisible(false);
        Details2.setVisible(true);
       }
    
        else if(buttonPressed.equals(Button2))
         {
             for (JTextField i : Fields)
               Sizes2.add(parseInt(i.getText()));
             Details2.setVisible(false);
            Choice.setVisible(true);
         }
        else if(buttonPressed.equals(Button3))
        {
            Choice.setVisible(false);
            FirstFit x = new FirstFit();
            VIZ.add(x);
            VIZ.setVisible(true);
            
        }
        else if(buttonPressed.equals(Button4))
        {
            Choice.setVisible(false);
            BestFit x = new BestFit();
            VIZ.add(x);
            VIZ.setVisible(true);
        }
        else if(buttonPressed.equals(Button5))
        {
            Choice.setVisible(false);
            WorstFit x = new WorstFit();
            VIZ.add(x);
            VIZ.setVisible(true);
        }
    }
    
}
