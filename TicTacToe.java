package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;


public class TicTacToe extends JFrame implements ActionListener
{
    JButton[][] jbtn;
    JOptionPane jpn;
    int player = 1;
    String s1,s2;
    Thread th;

  public TicTacToe(String s1,String s2)
  {
    super("TICTACTOE");
    
    System.out.println(".....Description of this Object is.... : "+toString());

    setSize(300,300);
    setLayout(new GridLayout(3,3));
    setResizable(false);
    jbtn = new JButton[3][3];
    this.s1 = s1;
    this.s2 = s2;
    int i = 0,j = 0;

    
    for(i=0;i<3;i++)
    {
        for(j=0;j<3;j++)
       {
         add(jbtn[i][j] = new JButton());
         jbtn[i][j].addActionListener(this);
       }  
    }

      addWindowListener(new WindowAdapter()
      {
         public void windowClosing(WindowEvent e)
         {
            System.exit(0);
            
         }
      });  
      setVisible(true);
  }

public void actionPerformed(ActionEvent e)
{  
   JButton jbtn1 = (JButton)e.getSource();
    
        jbtn1.setEnabled(false);
        if(player == 1)
          jbtn1.setLabel(s1);// this line has potential to give java's unchecked exception.
                             // jbtn1 can be null if not instantiated.
        else 
         jbtn1.setLabel(s2);
        String s5 = CheckWinner(s1,s2);
        boolean tie = matchTie(jbtn);
        if(s5.equals("No Winner") && tie == false)
         { 
            if(player == 1)
              player = 2;
            else 
              player = 1;
         }
                      
        else 
         {
           if(tie == true)
           jpn.showMessageDialog(this,"Match Tie","Results",jpn.PLAIN_MESSAGE);
           else 
           {
            if(player == 1)
               jpn.showMessageDialog(this,"Player1 Wins","Results",jpn.PLAIN_MESSAGE);
            else 
                jpn.showMessageDialog(this,"Player2 Wins","Results",jpn.PLAIN_MESSAGE);   
           }
            try
           {

             int i = jpn.showConfirmDialog(this,"Play Again","TicTacToe",jpn.YES_NO_OPTION,jpn.PLAIN_MESSAGE);
             
             if(i == 1)
              System.exit(0);
           }
           catch(Exception e1)
           {
              System.out.println(e1);
           }
            this.dispose();
            new TicTacToe(s1,s2);
         }
}

 public static void main(String args[])throws InterruptedException
  {
    System.out.println("The main thread running in this application is: "+Thread.currentThread());

    // Usage of Thread.
    Thread th = new Thread();
    th.setName("NEW Thread"); // setting a name for the new thread.
    th.start(); // started the new thread in our application.
    
    System.out.println("Name of the newly started thread is : "+th.getName());
    System.out.println("Number of threads running : "+Thread.activeCount());

    System.out.println(" ");

     System.out.println("!!!!! The Game will be starting in !!!!!");

    for(int i=5;i>=0;i--)
    {
      System.out.println(i);
      th.sleep(1000);
    } 

    System.out.println("Lets GO !!!!");
    System.out.println(" ");

    
    System.out.println("Welcome to the Game");
    System.out.println("Choose your Player");
    System.out.println("Player 1 :"+ args[0]);
    System.out.println("Player 2 :"+ args[1]); 

     new TicTacToe(args[0],args[1]);
     //Instead of Scanner, Command Line arguments are used.
    

  }

public String CheckWinner(String s1,String s2)
{
  String sj1,sj2,sj3,sj4;
  String d1,d2,d3,d4;
  String s5 = "";
  int i = 0,j = 0,c = 0;

    for(i=0;i<3;i++) 
            { 
                for(j=0;j<3;j++)
                { 
                    s5 = s5 + jbtn[i][j].getLabel(); 
                } 
                if(s5.equals("XXX"))
                { 
                    return "X";
                }
                else if(s5.equals("OOO"))
                { 
                    return "O"; 
                } 
                s5=""; 
            }
            for(i=0;i<3;i++) 
            { 
                for(j=0;j<3;j++)
                { 
                    s5 = s5 + jbtn[j][i].getLabel(); 
                } 
                if(s5.equals("XXX"))
                { 
                    return "X";
                }
                else if(s5.equals("OOO"))
                { 
                    return "O"; 
                } 
                s5=""; 
            }
         sj1 = jbtn[0][0].getLabel();
         sj2 = jbtn[1][1].getLabel();
         sj3 = jbtn[2][2].getLabel();
         sj4 = sj1+sj2+sj3;
       
         if(sj4.equals("XXX"))
          return "X";
         if(sj4.equals("OOO"))
          return "O"; 
          
         d1 = jbtn[0][2].getLabel();
         d2 = jbtn[1][1].getLabel();
         d3 = jbtn[2][0].getLabel();
         d4 = d1+d2+d3;
       
         if(d4.equals("XXX"))
          return "X";
         if(d4.equals("OOO"))
          return "O";

  return "No Winner";
}

public boolean matchTie(JButton[][] jbtn)
{
  String label = "";
    for(int i=0;i<3;i++)
    {
        for(int j=0;j<3;j++)
        {
            label = jbtn[i][j].getLabel();
            if(!(label.equals("X") || label.equals("O")))
                 return false;       
        }
    }
  return true;
}

 public String toString()
 {
   return "TicTacToe Game";
 }

};

 