import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class EasyQuiz extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3;  
    ButtonGroup bg;  
    int score=0,current=0;
    int x=1,y=1,now=0;  
    int mark[]=new int[10];     
    JFrame fr;
    EasyQuiz(String s)  
    {  
    	fr=new JFrame(s);
        l=new JLabel();  
        fr.add(l); 
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            fr.add(jb[i]);  
            bg.add(jb[i]);            //all radio buttons are added to Group Button
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark"); 
   //     b3=new JButton("Previous"); 
        b1.addActionListener(this);  
        b2.addActionListener(this);  
 //       b3.addActionListener(this);  
        fr.add(b1);
        fr.add(b2); 
//        add(b3); 
        
       
        Font f=new Font("Calibri", Font.BOLD,16);
        l.setFont(f);
        
        set();  
        Container c=fr.getContentPane();
        c.setBackground(Color.PINK);
        
        l.setBounds(30,40,950,20);    
        jb[0].setBounds(50,70,400,30);   jb[0].setBackground(Color.LIGHT_GRAY);
        jb[1].setBounds(50,110,400,30);  jb[1].setBackground(Color.LIGHT_GRAY);
        jb[2].setBounds(50,150,400,30);  jb[2].setBackground(Color.LIGHT_GRAY);
        jb[3].setBounds(50,190,400,30);  jb[3].setBackground(Color.LIGHT_GRAY);
        b1.setBounds(100,240,100,30);    
        b2.setBounds(270,240,100,30);
 //       b3.setBounds(100,240,100,30);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        fr.setLayout(null);  
        fr.setLocation(400,150);  
        fr.setVisible(true);  
        fr.setSize(600,350);  
      
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)          //Next Button
        {  
            if(check())                
                score=score+1;  
            current++;  
            set();                    
/*            if(current==0)  
            {  
            	b3.setEnabled(false);  
            }  
            if(current==1)  
            {  
                b1.setEnabled(true);
                b3.setEnabled(true);  
            }  */
            if(current==9)           //if user is at last question then,
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }
 /*       if(e.getSource()==b3)  
        {
        	current--;
        	count=count-1;
        	set();
        }*/
       
        if(e.getActionCommand().equals("Bookmark")) //Bookmark Button 
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,50*x,100,30);  
            fr.add(bk);  
            bk.addActionListener(this);  
            mark[x]=current;      
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            fr.setVisible(false);  
            fr.setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
            	score=score+1;  
            now=current;           //current question save hoga now me
            current=mark[y];       // mark[x] me saved value will get transfered to current
            set();  
            ((JButton)e.getSource()).setEnabled(false);  //bookmark button will get disabled
            current=now;                   //dobara se pehlay walay question pe aa jae ga
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
            	score=score+1; 
            current++;  
            //System.out.println("Score="+count);  
            JOptionPane.showMessageDialog(this,"Your Score is: "+score);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: What of the following is the default value of a local variable?");  
            jb[0].setText("null");
            jb[1].setText("0");
            jb[2].setText("Depends upon the type of variable");
            jb[3].setText("not Assigned");   //
        }  
        if(current==1)  
        {  
            l.setText("Que2: What happens when thread's sleep() method is called?");	
            jb[0].setText("Thread returns to the ready state");//
            jb[1].setText("Thread returns to the waiting state");
            jb[2].setText("Thread starts running.");
            jb[3].setText("None of the above.");
            
        }  
        if(current==2)  
        {  
            l.setText("Que3: What is the default value of String variable? ?");  
            jb[0].setText("\"\"");
            jb[1].setText("''");//
            jb[2].setText("null");
            jb[3].setText("not defined");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Which of the following is false about String??");  
            jb[0].setText("String is immutable");
            jb[1].setText("String can be created using new operator");
            jb[2].setText("String is a primary datatype");//
            jb[3].setText("none of above");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: which operator is considered to be with highest precedence?");  
            jb[0].setText("(),[]");//
            jb[1].setText("=");
            jb[2].setText("?");
            jb[3].setText("%");  
        }  
        if(current==5)  
        {  
            l.setText("Que6:  Method Overloading is an example of?");  
            jb[0].setText("Static Binding");//
            jb[1].setText("Dynamic Binding");
            jb[2].setText("both of above");
            jb[3].setText("none of above");  
        }  
        if(current==6)  
        {  
            l.setText("Que7:  What is correct syntax for main method of a java class?");  
            jb[0].setText("public static int main(String[] args)");
            jb[1].setText("public int main(String[] args)");     //
            jb[2].setText("public static void main(String[] args");  
            jb[3].setText("None of the above.");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: Which of the following is not a keyword in java?");		  
            jb[0].setText("static");
            jb[1].setText("Boolean");//
            jb[2].setText("void");  
            jb[3].setText("private");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: What of the following is the default value of an instance variable?"); 		
            jb[0].setText("null");
            jb[1].setText("0");
            jb[2].setText("Depends upon the type of variable");//
            jb[3].setText("Not assigned");  
        }  
        if(current==9)  
        {  
            l.setText("Que10:  What is the size of double variable?");
            jb[0].setText("8 bit");
            jb[1].setText(" 16 bit");
            jb[2].setText("32 bit");  
            jb[3].setText("64 bit");  //
        }  
       
 
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[3].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[1].isSelected());  
        if(current==3)  
            return(jb[2].isSelected());  
        if(current==4)  
            return(jb[0].isSelected());  
        if(current==5)  
            return(jb[0].isSelected());  
        if(current==6)  
            return(jb[2].isSelected());  
        if(current==7)  
            return(jb[1].isSelected());  
        if(current==8)  
            return(jb[2].isSelected());  
        if(current==9)  
            return(jb[3].isSelected());  
        return false;  
    }  
/*    public static void main(String s[])  
    {  
        new EasyQuiz("Easy Quiz");  
    }  */
}  
