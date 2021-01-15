import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class MediumQuiz extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int score=0,current=0;
    int x=1,y=1,now=0;  
    int mark[]=new int[10];    
    JFrame fr;
    MediumQuiz(String s)  
    {  
        fr=new JFrame(s);  
        l=new JLabel();  
        fr.add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            fr.add(jb[i]);  
            bg.add(jb[i]);  //all radio buttons are added to Group Button
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        fr.add(b1);
        fr.add(b2);  
        set();  
        Container c=fr.getContentPane();
        c.setBackground(Color.PINK);
        l.setBounds(30,40,950,20); 
        Font f=new Font("Calibri", Font.BOLD,16);
        l.setFont(f);
 
        jb[0].setBounds(50,70,400,30);   jb[0].setBackground(Color.LIGHT_GRAY);
        jb[1].setBounds(50,110,400,30);  jb[1].setBackground(Color.LIGHT_GRAY);
        jb[2].setBounds(50,150,400,30);  jb[2].setBackground(Color.LIGHT_GRAY);
        jb[3].setBounds(50,190,400,30);  jb[3].setBackground(Color.LIGHT_GRAY);
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        fr.setLayout(null);  
        fr.setLocation(400,150);  
        fr.setVisible(true);  
        fr.setSize(650,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  //Next Button
        {  
            if(check())  
            	score=score+1; 
          //System.out.println("Score="+count);  
            current++;  
            set();           //brings to next question 
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
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
          //System.out.println("Score="+count);  
            now=current;          //current question save hoga now me
            current=mark[y];         // m[x] me saved value will get transfered to current
            set();  
            ((JButton)e.getSource()).setEnabled(false);  //bookmark button will get disabled
            current=now;                                 //dobara se pehlay walay question pe aa jae ga
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
            l.setText("Que1: Which of these keywords is used to define a package in Java?");            		
            jb[0].setText("pkg");   //
            jb[1].setText("package");
            jb[2].setText("Package");
            jb[3].setText("Pkg");  
        }  
        if(current==1)  
        {  
            l.setText("Que2: Command to execute compiled java program is:");
            jb[0].setText("java");   //
            jb[1].setText("javac");  
            jb[2].setText("run");
            jb[3].setText("javaw");   
        }  
        if(current==2)  
        {  
            l.setText("Que3: In 2nd type, the information written in java after // is ignored by?");
            jb[0].setText("Interpreter");  
            jb[1].setText("Compiler");    //
            jb[2].setText("Programmer");
            jb[3].setText("All of the above");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: All java classes are derived from");   		
            jb[0].setText("java.lang.Class");
            jb[1].setText("java.util.Name?");  //
            jb[2].setText("java.lang.Object");		
            jb[3].setText("java.awt.Window");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: In order to  run JSP ……………… is required"); 
            jb[0].setText("Mail Server");
            jb[1].setText("Applet viewer");
            jb[2].setText("Java Web Server");  //
            jb[3].setText("Database connection");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: specify clause for 'System.in.read()'");  
            jb[0].setText("throws.java.out.IOException");
            jb[1].setText("throws.java.in.IOException");
            jb[2].setText("throws.java.io.IOException");//
            jb[3].setText("throws.java.io.InException");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Choose the appropriate datatype for value: 5.5");            		
            jb[0].setText("int");
            jb[1].setText("boolean");
            jb[2].setText("String");  
            jb[3].setText("double");  //
        }  
        if(current==7)  
        {  
            l.setText("Que8: In JDBC …………… imports all Java classes concerned with database connectivity");           		
            jb[0].setText("javax.sql.*");
            jb[1].setText("java.mysql.*");
            jb[2].setText("java.sql.*");  //
            jb[3].setText("com.*");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: Ingres is a ……………………");
            jb[0].setText("Socket");
            jb[1].setText("Compiler");
            jb[2].setText("Database");//
            jb[3].setText("Web server");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: ………………….is the key to ……………………");  
            jb[0].setText("Serialization, persistence");//
            jb[1].setText(" Persistence, inheritance");
            jb[2].setText("Inheritance, object");       
            jb[3].setText("Persistence, serialization");  
        }  
       
     }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[1].isSelected());  
        if(current==3)  
            return(jb[2].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[3].isSelected());  
        if(current==7)  
            return(jb[2].isSelected());  
        if(current==8)  
            return(jb[2].isSelected());  
        if(current==9)  
            return(jb[0].isSelected());  
        return false;  
    }  
/*    public static void main(String s[])  
    {  
        new MediumQuiz("Medium Java Quiz");  
    }  */
}  