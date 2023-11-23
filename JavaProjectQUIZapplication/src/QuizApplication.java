import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class QuizApplication{
    public static void main(String s[])  
    {  
    	String ch;
    	int op;
        ch=JOptionPane.showInputDialog(null,"Enter your choice"+"\n1. Easy"+"\n2. Medium "+"\n3. Hard");
    	op=Integer.parseInt(ch);
    	switch(op)
    	{
    	case 1:{
    		new EasyQuiz("Easy JAVA Quiz");
    		break;
    	}
    	case 2:{
    		new MediumQuiz("Medium JAVA Quiz");
    		break;
    	}
    	case 3:{
    		new HardQuiz("Hard JAVA Quiz");
    		break;
    	}
    	} 
    }
}  
