// input1, input 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JavaCalculator implements ActionListener {

    JFrame frame;
    JTextField txtfield;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[10];
    JButton addButton,suButton,mulButton,divButton,decButton,clrButton,delButton,eqButton,perButton,negButton;
    JPanel panel;

    Font mFont =new Font("italic",Font.ITALIC,20);

    double num1=0,num2=0,res=0;
    char op;

    JavaCalculator(){

        frame= new JFrame(" JAGRITI CALCULATOR ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.darkGray);
        frame.setSize(380,600);
        frame.setLayout(null);

        txtfield = new JTextField();
        txtfield.setBounds(30,50,300,100);
        txtfield.setFont(mFont);
        txtfield.setBackground(Color.lightGray);
        txtfield.setEditable(false);

        addButton=new JButton("+");
        suButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        clrButton=new JButton("AC");
        delButton=new JButton("DEL");
        eqButton=new JButton("=");
        perButton=new JButton("%");
        negButton=new JButton("-ve");

        funcButtons[0]= addButton;
        funcButtons[1]= suButton;
        funcButtons[2]= mulButton;
        funcButtons[3]= divButton;
        funcButtons[4]= decButton;
        funcButtons[5]= clrButton;
        funcButtons[6]= delButton;
        funcButtons[7]= eqButton;
        funcButtons[8]= perButton;
        funcButtons[9]= negButton;

        for(int i=0;i<10;i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(mFont);
            funcButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numButtons[i]=new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(mFont);
            numButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(30,200,300,300);
        panel.setLayout(new GridLayout(5,5,3,3));

       panel.add(numButtons[7]);
       panel.add(numButtons[8]);
       panel.add(numButtons[9]);
       panel.add(addButton);

       panel.add(numButtons[4]);
       panel.add(numButtons[5]);
       panel.add(numButtons[6]);
       panel.add(suButton);

       panel.add(numButtons[1]);
       panel.add(numButtons[2]);
       panel.add(numButtons[3]);
       panel.add(mulButton);
       
       panel.add(decButton); 
       panel.add(numButtons[0]); 
       panel.add(perButton);
       panel.add(divButton); 
       
       panel.add(delButton); 
       panel.add(clrButton);
       panel.add(negButton); 
       panel.add(eqButton);   

        frame.add(txtfield);
        frame.add(panel);
        frame.setVisible(true);

    }
    public static void main(String[] args) {

        JavaCalculator cal= new JavaCalculator();
        
    }

    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++){
            if(e.getSource() == numButtons[i]){
                txtfield.setText(txtfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            txtfield.setText(txtfield.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1=Double.parseDouble(txtfield.getText());
            op='+';
            txtfield.setText("");
        }
        if(e.getSource() == suButton){
            num1=Double.parseDouble(txtfield.getText());
            op='-';
            txtfield.setText("");
        }
        if(e.getSource() == mulButton){
            num1=Double.parseDouble(txtfield.getText());
            op='*';
            txtfield.setText("");
        }
        if(e.getSource() == divButton){
            num1=Double.parseDouble(txtfield.getText());
            op='/';
            txtfield.setText("");
        }
        if(e.getSource() == perButton){
            num1=Double.parseDouble(txtfield.getText());
            txtfield.setText(String.valueOf(num1));
            op='%';
            res=num1/100;
            txtfield.setText(String.valueOf(res));
        }
        if(e.getSource() == eqButton){
            num2=Double.parseDouble(txtfield.getText());
            switch(op)
            {
                case'+' : res=num1+num2; 
                          break;
                case'-' : res=num1-num2; 
                          break;
                case'*' : res=num1*num2; 
                          break;
                case'/' : res=num1/num2; 
                          break;
            }
            txtfield.setText(String.valueOf(num1));
            txtfield.setText(String.valueOf(num2));
            txtfield.setText(String.valueOf(res));

        }
        if(e.getSource() == delButton){
            String str=txtfield.getText();
            txtfield.setText("");
            for(int i=0;i<str.length()-1;i++){
                txtfield.setText(txtfield.getText()+str.charAt(i));
            }
        }
        if(e.getSource() == clrButton){
            txtfield.setText("");
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(txtfield.getText());
            temp*=-1;
            txtfield.setText(String.valueOf(temp));
        }
}
}