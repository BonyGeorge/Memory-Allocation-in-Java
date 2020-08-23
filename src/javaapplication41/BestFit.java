/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication41;

import java.awt.Graphics;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication41.JavaApplication40.*;
import javax.swing.*;
/**
 *
 * @author Eslam
 */
public class BestFit extends JPanel {
    //for dimensions of holes rectangles
    protected int y=100;
    //for labels with holes sizes
    protected int y2=117;
    //for allocated processes
    protected int y3;
    //for unallocated processes
    protected int y4=300;
    /*labels with the size of each hole*/
    protected ArrayList<JLabel> Labels;
    protected int HSize;
    /*arraylist of holes sizes will be used later*/
    protected ArrayList<Integer> L1;
    /*arraylist of processes sizes will be used later*/
    protected ArrayList<Integer> L2;
    /*arraylist of holes sizes will be used later*/
    protected ArrayList<Integer> R1;
    /*arraylist of processes sizes will be used later*/
    protected ArrayList<Integer> R2;
    /*arraylist of labels to show which processes were allocated*/
    protected ArrayList<JLabel> Pi;
    protected int Process=0;
    public BestFit(){
     this.setSize(600,600);
     this.setLayout(null);
     this.setVisible(true);
     Labels = new ArrayList<JLabel>();
     Pi = new ArrayList<JLabel>();
     L1=new ArrayList<Integer>();
     /*for loop so we can copy the two arraylists*/
     for (int i : Sizes) 
      L1.add(i);
     
     L2=new ArrayList<Integer>();
     for (int i : Sizes2) 
      L2.add(i);
     
     R1=new ArrayList<Integer>();
     for (int i : Sizes) 
      R1.add(i);
     
     R2=new ArrayList<Integer>();
     for (int i : Sizes2) 
      R2.add(i);
     /* Here we implements threads so the user can see processes being allocated to holes
     one by one  and the for loop is for each process
     */
     Thread thread = new Thread() {
            public void run() {
             for (int i=0;i<PNo-1;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FirstFit.class.getName()).log(Level.SEVERE, null, ex);
                }
              repaint();
             }
            }
        };
        thread.start();
     
    }
    /*This is an algorithm that returns the Bestfit for each process*/
    public int BetterFit(ArrayList<Integer> Hsizes, ArrayList<Integer> Psizes,int n){
        
             int Best = -1;
             for(int r=0;r<HoleNo;r++)
             {
                 /*Checks if there is a compatible hole and if the hole
                 wasn't taken before
                 */
                 if(Hsizes.get(r) >= Psizes.get(n) && R1.get(r) != 0){
                  if(Best==-1){
                      Best=r;
                  }
                  else if(Hsizes.get(Best) > Hsizes.get(r) && R1.get(r) != 0){
                     Best=r;
                     
                 }
                 }
             }
             /*Here we check if the process found a compatible hole and if that happend
             it sets it's location to zero in the corresponding arraylist
             */
             if(Best != -1)
              R1.set(Best,0);
             return Best;
    }
    public void BFit(ArrayList<Integer> Hsizes,int n)
    {
            /*reset position*/
            y3=115;
            Pi.add(new JLabel());
            int Best = BetterFit(L1,L2,n);
            if(Best !=-1){
             for(int r=0;r<HoleNo;r++)
             {
                 if(Hsizes.get(r) == Hsizes.get(Best) )
                  break;
                 else
                  y3=y3+60;
             }
                   Pi.get(n).setBounds(495,y3,15,20);
                   Pi.get(n).setText("P"+n);
                   this.add(Pi.get(n));
        }
                        else
            {
              JLabel Alert =  new JLabel();
                Alert.setText("P"+n+" must wait");
                Alert.setBounds(180,y4,110,20);
                this.add(Alert);
                y4=y4+25;
            }

    }

    public void paintComponent(Graphics g)
    {
        g.clearRect(0,0,600,600);
        
        for (int i=0;i<HoleNo;i++){
         Labels.add(new JLabel());
         g.drawRect(450,y,100,60);
         HSize=L1.get(i);
         Labels.get(i).setText(Integer.toString(HSize));
         Labels.get(i).setBounds(420,y2,30,20);
         this.add(Labels.get(i));
         y=y+60;
         y2=y2+60;
        }
         BFit(Sizes,Process);
         Process++;
        //Resets labels postitions
        y=100;
        y2=117;
    }


}
