//============================================================================
// Name        : Calculator.java
// Author      : Sabal Ranabhat
// Course      : UTDallas CS 2336.501 S19
// Version     : 1.0
// Copyright   : 2019
//
// Description :
//
//    This program implements the functionality of a windows 10 programmer
//	  calculator.
//
//============================================================================

//importing necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Calculator class definition that formats the calculator
public class Calculator extends JFrame implements ActionListener, KeyListener, MouseListener
{

//necessary font declarations
 Font font1 = new Font("Segoe Pro", Font.BOLD, 25);
 Font font2 = new Font("Segoe Pro", Font.ITALIC, 20);
 
 //necessary button declarations
 JButton arrow,ms,mp,ce,c,btn1,btn2,btn3,btn4,btn5;
 JButton btn6,btn7,btn8,btn9,btn0,btndot,btnadd,btnsubtract,btndiv;
 JButton btnmultiply,btnequals,btnpercent,btnpm,btndel,btnr, btnbr1, btnbr2, numpad1, numpad2;
 JRadioButton hex, dec, oct, bin;
 JButton bta, btb, btc, btd, bte, btf, btnMod, word, lsh, rsh, or, xor, not, and;
 
 //necessary text fields declarations
 JTextField display, resultField, textHex, textDec, textOct, display2;
 JTextArea textBin;
 
 //necessary label definitions
 JLabel label1, label2;
 JPanel p1, p2, p3, pHex, pDec, pOct, pBin, p4;
 
 //necessary complementary variables for operation performance and reference
 String s1,s2,s3,s4,s5, preClear;
 char perform;
 String ultimateTemp = "";
 String resultPrint;
 String temp = "";
 long n;
 String result;
 String resultH;
 int operation;
 int operationFlag;
 int counter=0;

 //constructor
public Calculator()
 {
  
	//Word button initialization
	word = new JButton("QWORD");
	word.setForeground(Color.BLUE);
	word.addActionListener(this);
	word.addMouseListener(this);
	
	//lsh button initialization
	lsh = new JButton("Lsh");
	lsh.setBackground(new Color(215, 215, 215));
	
	//rsh button initialization
	rsh = new JButton("Rsh");
	rsh.setBackground(new Color(215, 215, 215));
	
	//or button initializations
	or= new JButton("Or");
	or.setBackground(new Color(215, 215, 215));
	
	//xor button initializations
	xor = new JButton("Xor");
	xor.setBackground(new Color(215, 215, 215));
	
	//not button initialization
	not = new JButton("Not");
	not.setBackground(new Color(215, 215, 215));
	
	//and button initialization
	and = new JButton("And");
	and.setBackground(new Color(215, 215, 215));
	
	//brackets button initialization
	btnbr1 = new JButton("(");
	btnbr2 = new JButton(")");
	
	//mod button initialization
	btnMod = new JButton("MOD");
	
	//arrow button initialization
	arrow=new JButton("↑");
	arrow.setFont(new Font("Segoe Pro", Font.BOLD, 20));

	//ce and c buttons initialization
	ce=new JButton("C");
	ce.setBackground(Color.gray);
	c=new JButton("CE");
	
	//buttons A-F initialization
	bta = new JButton("A");
	btb = new JButton("B");
	btc = new JButton("C");
	btd = new JButton("D");
	bte = new JButton("E");
	btf = new JButton("F");
	
	//buttons 0-9 initialization
	btn1=new JButton("1");
	btn2=new JButton("2");
	btn3=new JButton("3");
	btn4=new JButton("4");
	btn5=new JButton("5");
	btn6=new JButton("6");
	btn7=new JButton("7");
	btn8=new JButton("8");
	btn9=new JButton("9");
	btn0=new JButton("0");
  
	//dot button initialization
	btndot=new JButton(".");
	btndot.setFont(new Font("Segoe Pro", Font.PLAIN, 20));
	btndot.setFont(font1);
	
	//add button initialization
	btnadd=new JButton("+");
	btnadd.setFont(new Font("Segoe Pro", Font.PLAIN, 20));
  
	//set a-f button disabled by default
	bta.setEnabled(false);
	btb.setEnabled(false);
	btc.setEnabled(false);
	btd.setEnabled(false);
	bte.setEnabled(false);
	btf.setEnabled(false);
  
	//initialize some pictrues for selection symbol
	ImageIcon icon = new ImageIcon("rec.png");
	Image img = icon.getImage();
	Image newimg = img.getScaledInstance( 5, 30,  java.awt.Image.SCALE_SMOOTH ) ;  
	icon = new ImageIcon( newimg );
  
	ImageIcon icon2 = new ImageIcon("blue.png");
	Image img2 = icon2.getImage();
	Image newimg2 = img2.getScaledInstance( 5, 30,  java.awt.Image.SCALE_SMOOTH ) ;  
	icon2 = new ImageIcon( newimg2 );
  
	//hex button initialization
	hex = new JRadioButton("HEX");
	hex.setIcon(icon);
	hex.setBackground(this.getBackground());
	hex.setSelectedIcon(icon2);
  
	//dec button initialization
	dec = new JRadioButton("DEC");
	dec.setIcon(icon);
	dec.setSelectedIcon(icon2);
  
	//oct button initialization
	oct = new JRadioButton("OCT");
	oct.setIcon(icon);
	oct.setSelectedIcon(icon2);
  
	//bin button initialization
	bin = new JRadioButton("BIN");
	bin.setIcon(icon);
	bin.setSelectedIcon(icon2);
  
	//initialized a button group and added all the numeric notaion types
	ButtonGroup convertButtons = new ButtonGroup();
	convertButtons.add(hex);
	convertButtons.add(dec);
	convertButtons.add(oct);
	convertButtons.add(bin);
	dec.setSelected(true);
  
	//all operations button initialization
	btnsubtract=new JButton("-");
	btnsubtract.setFont(new Font("Segoe Pro", Font.PLAIN, 20));
	
	btndiv=new JButton("÷");
	btndiv.setFont(new Font("Segoe Pro", Font.PLAIN, 20));
	
	btnequals=new JButton("=");
	btnequals.setFont(new Font("Segoe Pro", Font.PLAIN, 20));
	btnpercent=new JButton("%");
	
	btnmultiply=new JButton("×");
	btnmultiply.setFont(new Font("Segoe Pro", Font.PLAIN, 20));
	
	btnpm=new JButton("±");
	btnpm.setFont(new Font("Segoe Pro", Font.PLAIN, 15));
	
	btndel=new JButton("⌫");
	btndel.setFont(new Font("Segoe Pro", Font.PLAIN, 15));
//	btnr=new JButton("",new ImageIcon("images/sqr.gif"));

	//result text field initialization
	resultField = new JTextField();
	resultField.scrollRectToVisible(getBounds());
	resultField.setBackground(this.getBackground());
	resultField.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	resultField.setHorizontalAlignment(JTextField.RIGHT);
	resultField.setCaretColor(this.getBackground());
	resultField.setFont(new Font("Segoe Pro", Font.PLAIN, 15));
	resultField.setEditable(false);
	
	//add the field to the frame
	add(resultField);
	resultField.setBounds(0,60, 437, 30);
	
	//initialize the mock display for operations
	display =new JTextField("0");
	display.setFont(font1);
	display.setBackground(this.getBackground());
	display.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	setLayout(null);
	display.setBounds(0,95,437,55);
	display.setHorizontalAlignment(JTextField.RIGHT);
	display.setCaretColor(this.getBackground());
	display.addMouseListener(this);
	display.addKeyListener(this);
	
	//initialize the actual display for view
	display2 =new JTextField("0");
	display2.setFont(font1);
	display2.setBackground(this.getBackground());
	display2.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	setLayout(null);
	
	//add the display to the frame
	add(display2);
	display2.setBounds(0,95,437,55);
	display2.setHorizontalAlignment(JTextField.RIGHT);
	display2.setCaretColor(this.getBackground());
	display2.addMouseListener(this);
	display2.addKeyListener(this);
	
	//initialize a panel for hex representation
	pHex = new JPanel();
	pHex.setLayout(new BorderLayout());
	pHex.setBounds(5, 150, 430, 30);
	
	//initialize a text field for the hex panel
	textHex = new JTextField("0");
	textHex.setFont(new Font("Segoe Pro", Font.BOLD, 15));
	textHex.setBackground(this.getBackground());
	textHex.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	
	//add the field to the panel
	pHex.add(textHex, BorderLayout.EAST);
	textHex.setPreferredSize(new Dimension(355, 30));
	textHex.setHorizontalAlignment(JTextField.LEFT);
	textHex.setCaretColor(this.getBackground());
	textHex.addMouseListener(this);
	textHex.setEditable(false);
	
	//initialize a panel for dec representation
	pDec = new JPanel();
	pDec.setLayout(new BorderLayout());
	pDec.setBounds(5, 180, 430, 30);
	
	//initialize a tect field for the dec panel
	textDec = new JTextField("0");
	textDec.setFont(new Font("Segoe Pro", Font.BOLD, 15));
	textDec.setBackground(this.getBackground());
	textDec.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	textDec.setEditable(false);
  
	//add the field to the panel
	pDec.add(textDec, BorderLayout.EAST);
	textDec.setPreferredSize(new Dimension(355, 30));
	textDec.setHorizontalAlignment(JTextField.LEFT);
	textDec.setCaretColor(this.getBackground());
	textDec.addMouseListener(this);
	
	//initialize a panel for oct representation
	pOct = new JPanel();
	pOct.setLayout(new BorderLayout());
	pOct.setBounds(5, 209, 430, 30);
	
	//initialize a text field for the oct panel
  textOct = new JTextField("0");
  textOct.setFont(new Font("Segoe Pro", Font.BOLD, 15));
  textOct.setBackground(this.getBackground());
  textOct.setBorder(BorderFactory.createLineBorder(this.getBackground()));
  textOct.setEditable(false);
  
  //add the field to the panel
  pOct.add(textOct, BorderLayout.EAST);
  textOct.setPreferredSize(new Dimension(355, 30));
  textOct.setHorizontalAlignment(JTextField.LEFT);
  textOct.setCaretColor(this.getBackground());
  textOct.addMouseListener(this);
  
  //initialize a panel for bin representation
  pBin = new JPanel();
  pBin.setLayout(new BorderLayout());
  pBin.setBounds(5, 240, 430, 38);

  //initialize a text field for the panel
  textBin = new JTextArea("0",2,22);
  textBin.setFont(new Font("Segoe Pro", Font.BOLD, 15));
  textBin.setBackground(this.getBackground());
  textBin.setBorder(BorderFactory.createLineBorder(this.getBackground()));
  textBin.setEditable(false);
  
  //add the field to the panel
  pBin.add(textBin, BorderLayout.EAST);
  textBin.setWrapStyleWord(true);
  textBin.setLineWrap(true);
  textBin.setCaretColor(this.getBackground());
  textBin.addMouseListener(this);

  //initialize a panel for the heading
  p1 = new JPanel();
  p1.setLayout(new BorderLayout());
  p1.setBounds(15,20,400,50);
  
  //initialize a panel for all the buttons
  p2 = new JPanel();
  p2.setLayout(new GridLayout(5,6,4,4));
  p2.setBackground(Color.LIGHT_GRAY);
  p2.setBounds(5,374,430,290);
  
  //add all the buttons to the panel
  p2.add(arrow);
  arrow.addActionListener(this);
  arrow.setBackground(new Color(215, 215, 215));
   
  p2.add(btnMod);
  btnMod.addActionListener(this);
  btnMod.setBackground(new Color(215, 215, 215));
  
  p2.add(c);
  c.addActionListener(this);
  c.setBackground(new Color(215, 215, 215));
  
  p2.add(ce);
  ce.addActionListener(this);
  ce.setBackground(new Color(215, 215, 215));
  
  p2.add(btndel);
  btndel.addActionListener(this);
  btndel.setBackground(new Color(215, 215, 215));
  
  p2.add(btndiv);
  btndiv.addActionListener(this);
  btndiv.setBackground(new Color(215, 215, 215));
  
  p2.add(bta);
  bta.addActionListener(this);
  bta.setBackground(new Color(230, 230, 230));
  
  p2.add(btb);
  btb.addActionListener(this);
  btb.setBackground(new Color(230, 230, 230));
  
  p2.add(btn7);
  btn7.addActionListener(this);
  btn7.setBackground(new Color(230, 230, 230));
    
  p2.add(btn8);
  btn8.addActionListener(this);
  btn8.setBackground(new Color(230, 230, 230));
  
  p2.add(btn9);
  btn9.addActionListener(this);
  btn9.setBackground(new Color(230, 230, 230));
  
  p2.add(btnmultiply);
  btnmultiply.addActionListener(this);
  btnmultiply.setBackground(new Color(215, 215, 215));
  
  p2.add(btc);
  btc.addActionListener(this);
  btc.setBackground(new Color(230, 230, 230));
  
  p2.add(btd);
  btd.addActionListener(this);
  btd.setBackground(new Color(230, 230, 230));
  
  p2.add(btn4);
  btn4.addActionListener(this);
  btn4.setBackground(new Color(230, 230, 230));
  
  p2.add(btn5);
  btn5.addActionListener(this);
  btn5.setBackground(new Color(230, 230, 230));
  
  p2.add(btn6);
  btn6.addActionListener(this);
  btn6.setBackground(new Color(230, 230, 230));
  
  p2.add(btnsubtract);
  btnsubtract.addActionListener(this);
  btnsubtract.setBackground(new Color(215, 215, 215));
  
  p2.add(bte);
  bte.addActionListener(this);
  bte.setBackground(new Color(230, 230, 230));
  
  p2.add(btf);
  btf.addActionListener(this);
  btf.setBackground(new Color(230, 230, 230));
  
  p2.add(btn1);
  btn1.addActionListener(this);
  btn1.setBackground(new Color(230, 230, 230));
  
  p2.add(btn2);
  btn2.addActionListener(this);
  btn2.setBackground(new Color(230, 230, 230));
  
  p2.add(btn3);
  btn3.addActionListener(this);
  btn3.setBackground(new Color(230, 230, 230));
  
  p2.add(btnadd);
  btnadd.addActionListener(this);
  btnadd.setBackground(new Color(215, 215, 215));
  
  p2.add(btnbr1);
  btnbr1.addActionListener(this);
  btnbr1.setBackground(new Color(215, 215, 215));
  
  p2.add(btnbr2);
  btnbr2.addActionListener(this);
  btnbr2.setBackground(new Color(215, 215, 215));
  
  p2.add(btnpm);
  btnpm.addActionListener(this);
  btnpm.setBackground(new Color(215, 215, 215));
  
  p2.add(btn0);
  btn0.addActionListener(this);
  btn0.setBackground(new Color(230, 230, 230));
  
  p2.add(btndot);
  btndot.addActionListener(this);
  btndot.setBackground(new Color(215, 215, 215));
  btndot.setEnabled(false);
  
  p2.add(btnequals);
  btnequals.addActionListener(this);
  btnequals.setBackground(new Color(215, 215, 215));
  
  //initialize a new label for the heading panel  
  label1 = new JLabel("≡       Programmer");
  label1.setFont(new Font("Segoe Pro", Font.PLAIN, 20));
  
  //add the label to the panel
  p1.add(label1, BorderLayout.NORTH);
  
  //import an image as an icon for a button
  icon = new ImageIcon("numpad1.PNG");
  img = icon.getImage();
  newimg = img.getScaledInstance(55, 50, java.awt.Image.SCALE_SMOOTH);
  icon = new ImageIcon(newimg);
  
  //add the numpad1 button
  numpad1 = new JButton(icon);
  add(numpad1);
  numpad1.setBackground(this.getBackground());
  numpad1.setContentAreaFilled(false);
  numpad1.setOpaque(false);
  numpad1.setBorderPainted(false);
  numpad1.setBounds(5, 275, 80, 50);
  
//import an image as an icon for a button
  icon2 = new ImageIcon("numpad2.png");
  img2 = icon2.getImage();
  newimg2 = img2.getScaledInstance(55, 50, java.awt.Image.SCALE_SMOOTH);
  icon2 = new ImageIcon(newimg2);
  
  //add the numpad2 button
  numpad2 = new JButton(icon2);
  add(numpad2);
  numpad2.setBackground(this.getBackground());
  numpad2.setContentAreaFilled(false);
  numpad2.setOpaque(false);
  numpad2.setBorderPainted(false);
  numpad2.setBounds(85, 275, 80, 50);
  
  //setup the word button
  word.setBackground(this.getBackground());
  word.setContentAreaFilled(false);
  word.setOpaque(false);
  word.setBorderPainted(false);
  
  //add the button to the frame
  add(word);
  word.setFont((new Font("Segoe Pro", Font.BOLD, 13)));
  word.setBackground(this.getBackground());
  word.setContentAreaFilled(false);
  word.setOpaque(false);
  word.setBorderPainted(false);
  word.setBounds(165, 275, 130, 50);
  
  //initialize and add ms button to the frame
  ms=new JButton("MS");
  add(ms);
  ms.setFont((new Font("Segoe Pro", Font.BOLD, 13)));
  ms.setBackground(this.getBackground());
  ms.setContentAreaFilled(false);
  ms.setOpaque(false);
  ms.setBorderPainted(false);
  ms.setBounds(280, 275, 80, 50);

  //initialize and add mp button to the frame
  mp=new JButton("M+");
  add(mp);
  mp.setFont((new Font("Segoe Pro", Font.BOLD, 13)));
  mp.setBackground(this.getBackground());
  mp.setContentAreaFilled(false);
  mp.setOpaque(false);
  mp.setBorderPainted(false);
  mp.setBounds(360, 275, 80, 50);

  //initialize a panel for dummy buttons
  p4 = new JPanel();
  p4.setLayout(new GridLayout(1,6,4,4));
  p4.setBackground(Color.LIGHT_GRAY);
  p4.setBounds(5,325,430,48);
  
  //add all the dummy buttons
  p4.add(lsh);
  p4.add(rsh);
  p4.add(or);
  p4.add(xor);
  p4.add(not);
  p4.add(and);
  
  //add the hex button to the panel
  pHex.add(hex, BorderLayout.WEST);
  hex.setPreferredSize(new Dimension(70,30));
  hex.setContentAreaFilled(false);
  hex.setOpaque(false);
  hex.setBorderPainted(false);
  hex.setFont(new Font("Segoe Pro", Font.BOLD, 12));
  hex.addActionListener(this);
  
//add the dec button to the panel
  pDec.add(dec, BorderLayout.WEST);
  dec.setPreferredSize(new Dimension(70,30));
  dec.setBounds(0,175,70,30);
  dec.setContentAreaFilled(false);
  dec.setOpaque(false);
  dec.setBorderPainted(false);
  dec.setBackground(this.getBackground());
  dec.setFont(new Font("Segoe Pro", Font.BOLD, 12));
  dec.addActionListener(this);

//add the oct button to the panel
  pOct.add(oct, BorderLayout.WEST);
  oct.setPreferredSize(new Dimension(70,30));
  oct.setBounds(0,205,70,30);
  oct.setContentAreaFilled(false);
  oct.setOpaque(false);
  oct.setBorderPainted(false);
  oct.setBackground(this.getBackground());
  oct.setFont(new Font("Segoe Pro", Font.BOLD, 12));
  oct.addActionListener(this);

//add the bin button to the panel
  pBin.add(bin, BorderLayout.WEST);
  bin.setPreferredSize(new Dimension(70,5));
  bin.setBounds(0,235,70,30);
  bin.setContentAreaFilled(false);
  bin.setOpaque(false);
  bin.setBorderPainted(false);
  bin.setBackground(this.getBackground());
  bin.setFont(new Font("Segoe Pro", Font.BOLD, 12));
  bin.addActionListener(this);
 }


@Override
//mouseListener method
public void mouseExited(MouseEvent event) {
	
	//show border
	if(event.getSource()==display)
		display.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	
	//show border
	if(event.getSource()==display2)
		display2.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	
	//show border
	if(event.getSource()==textHex)
		pHex.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	
	//show border
	if(event.getSource()==textDec)
		pDec.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	
	//show border
	if(event.getSource()==textOct)
		pOct.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	
	//show border
	if(event.getSource()==textBin)
		pBin.setBorder(BorderFactory.createLineBorder(this.getBackground()));
}


@Override
//mouse listener method
public void mouseClicked(MouseEvent event) {
	//show border
	if(event.getSource()==display)
		display.setBorder(BorderFactory.createLineBorder(Color.white));
	
	//show border
	if(event.getSource()==display2)
		display2.setBorder(BorderFactory.createLineBorder(Color.white));
	
	//show border
	if(event.getSource()==textHex) {
		pHex.setBorder(BorderFactory.createLineBorder(Color.white));
		hex.setSelected(true);
	}
	
	//show border
	if(event.getSource()==textDec) {
		pDec.setBorder(BorderFactory.createLineBorder(Color.white));
		dec.setSelected(true);
	}
	
	//show border
	if(event.getSource()==textOct) {
		pOct.setBorder(BorderFactory.createLineBorder(Color.white));
		oct.setSelected(true);
	}
	
	//show border
	if(event.getSource()==textBin) {
		pBin.setBorder(BorderFactory.createLineBorder(Color.white));
		bin.setSelected(true);
	}
	
	//show selection choice for each tyoe
	if(hex.isSelected()) {
		  pHex.setBorder(BorderFactory.createLineBorder(Color.white));
		  hex.setForeground(Color.BLUE);
		  textHex.setForeground(Color.BLUE);
		  pHex.setBackground(new Color(230, 230, 230));
		  textHex.setBackground(new Color(230, 230, 230));  
		  bta.setEnabled(true);
		  btb.setEnabled(true);
		  btc.setEnabled(true);
		  btd.setEnabled(true);
		  bte.setEnabled(true);
		  btf.setEnabled(true);
		  
		  display.setText(textHex.getText().replaceAll(" ",""));
		  display2.setText(textHex.getText());
	  }
	  
	  else {
		  pHex.setBorder(BorderFactory.createLineBorder(this.getBackground()));
		  hex.setForeground(Color.BLACK);
		  textHex.setForeground(Color.BLACK);
		  pHex.setBackground(this.getBackground());
		  textHex.setBackground(this.getBackground());
		  bta.setEnabled(false);
		  btb.setEnabled(false);
		  btc.setEnabled(false);
		  btd.setEnabled(false);
		  bte.setEnabled(false);
		  btf.setEnabled(false);
	  }
	  
	  if(dec.isSelected()) {
		  pDec.setBorder(BorderFactory.createLineBorder(Color.white));
		  dec.setForeground(Color.BLUE);
		  textDec.setForeground(Color.BLUE);
		  pDec.setBackground(new Color(230, 230, 230));
		  textDec.setBackground(new Color(230, 230, 230));
		  
		  display.setText(textDec.getText().replaceAll(",", ""));
		  display2.setText(textDec.getText());
	  }
	  
	  else {
		  pDec.setBorder(BorderFactory.createLineBorder(this.getBackground()));
		  dec.setForeground(Color.BLACK);
		  textDec.setForeground(Color.BLACK);
		  pDec.setBackground(this.getBackground());
		  textDec.setBackground(this.getBackground());
	  }
	  
	  if(bin.isSelected()) {
		  pBin.setBorder(BorderFactory.createLineBorder(Color.white));
		  bin.setForeground(Color.BLUE);
		  textBin.setForeground(Color.BLUE);
		  pBin.setBackground(new Color(230, 230, 230));
		  textBin.setBackground(new Color(230, 230, 230));  
		  btn8.setEnabled(false);
		  btn9.setEnabled(false);
		  btn7.setEnabled(false);
		  btn6.setEnabled(false);
		  btn5.setEnabled(false);
		  btn4.setEnabled(false);
		  btn3.setEnabled(false);
		  btn2.setEnabled(false);
		  
		  display.setText(textBin.getText().replaceAll(" ", ""));
		  display2.setText(textBin.getText());
	  }
	  else {
		  pBin.setBorder(BorderFactory.createLineBorder(this.getBackground()));
		  bin.setForeground(Color.BLACK);
		  textBin.setForeground(Color.BLACK);
		  pBin.setBackground(this.getBackground());
		  textBin.setBackground(this.getBackground());
		  btn8.setEnabled(true);
		  btn9.setEnabled(true);
		  btn7.setEnabled(true);
		  btn6.setEnabled(true);
		  btn5.setEnabled(true);
		  btn4.setEnabled(true);
		  btn3.setEnabled(true);
		  btn2.setEnabled(true);
	  }
	  
	  if(oct.isSelected()) {
		  pOct.setBorder(BorderFactory.createLineBorder(Color.white));
		  oct.setForeground(Color.BLUE);
		  textOct.setForeground(Color.BLUE);
		  pOct.setBackground(new Color(230, 230, 230));
		  textOct.setBackground(new Color(230, 230, 230));  
		  btn8.setEnabled(false);
		  btn9.setEnabled(false);
		  
		  display.setText(textOct.getText().replaceAll(" ", ""));
		  display2.setText(textOct.getText());
	  }
	  
	  else {
		  pOct.setBorder(BorderFactory.createLineBorder(this.getBackground()));
		  oct.setForeground(Color.BLACK);
		  textOct.setForeground(Color.BLACK);
		  pOct.setBackground(this.getBackground());
		  textOct.setBackground(this.getBackground());
		  btn8.setEnabled(true);
		  btn9.setEnabled(true);
	  }
}


@Override
//mouse listener method
public void mouseEntered(MouseEvent event) {
	//show border
	if(event.getSource()==display)
		display.setBorder(BorderFactory.createLineBorder(Color.white));
	
	//show border
	if(event.getSource()==display2)
		display2.setBorder(BorderFactory.createLineBorder(Color.white));
	
	//show border
	if(event.getSource()==textHex)
		pHex.setBorder(BorderFactory.createLineBorder(Color.white));
	
	//show border
	if(event.getSource()==textDec)
		pDec.setBorder(BorderFactory.createLineBorder(Color.white));
	
	//show border
	if(event.getSource()==textOct)
		pOct.setBorder(BorderFactory.createLineBorder(Color.white));
	
	//show border
	if(event.getSource()==textBin)
		pBin.setBorder(BorderFactory.createLineBorder(Color.white));
}

@Override
//mouse listener method
public void mousePressed(MouseEvent arg0) {
}

@Override
//mouse listener method
public void mouseReleased(MouseEvent arg0) {
}

//action listener method
 public void actionPerformed(ActionEvent e)
 {

	 //show selection choice
  if(hex.isSelected()) {
	  pHex.setBorder(BorderFactory.createLineBorder(Color.white));
	  hex.setForeground(Color.BLUE);
	  textHex.setForeground(Color.BLUE);
	  pHex.setBackground(new Color(230, 230, 230));
	  textHex.setBackground(new Color(230, 230, 230));  
	  bta.setEnabled(true);
	  btb.setEnabled(true);
	  btc.setEnabled(true);
	  btd.setEnabled(true);
	  bte.setEnabled(true);
	  btf.setEnabled(true);
	  
	  display.setText(textHex.getText().replaceAll(" ", ""));
	  display2.setText(textHex.getText());
	  operationFlag = 0;
  }
  
  else {
	  pHex.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	  hex.setForeground(Color.BLACK);
	  textHex.setForeground(Color.BLACK);
	  pHex.setBackground(this.getBackground());
	  textHex.setBackground(this.getBackground());
	  bta.setEnabled(false);
	  btb.setEnabled(false);
	  btc.setEnabled(false);
	  btd.setEnabled(false);
	  bte.setEnabled(false);
	  btf.setEnabled(false);
  }
  
  if(dec.isSelected()) {
	  pDec.setBorder(BorderFactory.createLineBorder(Color.white));
	  dec.setForeground(Color.BLUE);
	  textDec.setForeground(Color.BLUE);
	  pDec.setBackground(new Color(230, 230, 230));
	  textDec.setBackground(new Color(230, 230, 230));
	  
	  display.setText(textDec.getText().replaceAll(",",""));
	  display2.setText(textDec.getText());
	  operationFlag = 1;
  }
  
  else {
	  pDec.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	  dec.setForeground(Color.BLACK);
	  textDec.setForeground(Color.BLACK);
	  pDec.setBackground(this.getBackground());
	  textDec.setBackground(this.getBackground());
  }
  
  if(bin.isSelected()) {
	  pBin.setBorder(BorderFactory.createLineBorder(Color.white));
	  bin.setForeground(Color.BLUE);
	  textBin.setForeground(Color.BLUE);
	  pBin.setBackground(new Color(230, 230, 230));
	  textBin.setBackground(new Color(230, 230, 230));  
	  btn8.setEnabled(false);
	  btn9.setEnabled(false);
	  btn7.setEnabled(false);
	  btn6.setEnabled(false);
	  btn5.setEnabled(false);
	  btn4.setEnabled(false);
	  btn3.setEnabled(false);
	  btn2.setEnabled(false);
	  
	  display.setText(textBin.getText().replaceAll(" ", ""));
	  display2.setText(textBin.getText());
	  operationFlag = 2;
  }
  else {
	  pBin.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	  bin.setForeground(Color.BLACK);
	  textBin.setForeground(Color.BLACK);
	  pBin.setBackground(this.getBackground());
	  textBin.setBackground(this.getBackground());
	  btn8.setEnabled(true);
	  btn9.setEnabled(true);
	  btn7.setEnabled(true);
	  btn6.setEnabled(true);
	  btn5.setEnabled(true);
	  btn4.setEnabled(true);
	  btn3.setEnabled(true);
	  btn2.setEnabled(true);
  }
  
  if(oct.isSelected()) {
	  pOct.setBorder(BorderFactory.createLineBorder(Color.white));
	  oct.setForeground(Color.BLUE);
	  textOct.setForeground(Color.BLUE);
	  pOct.setBackground(new Color(230, 230, 230));
	  textOct.setBackground(new Color(230, 230, 230));  
	  btn8.setEnabled(false);
	  btn9.setEnabled(false);
	  
	  display.setText(textOct.getText().replaceAll(" ", ""));
	  display2.setText(textOct.getText());
	  operationFlag = 3;
  }
  
  else {
	  pOct.setBorder(BorderFactory.createLineBorder(this.getBackground()));
	  oct.setForeground(Color.BLACK);
	  textOct.setForeground(Color.BLACK);
	  pOct.setBackground(this.getBackground());
	  textOct.setBackground(this.getBackground());
  }
  
  //if arrow button clicked, change two buttons
  if(e.getSource()==arrow) {
	  if(lsh.getText()=="Lsh") {
		  lsh.setText("RoL");
		  rsh.setText("RoR");
	  }
	  
	  else
	  {
		  lsh.setText("Lsh");
		  rsh.setText("Rsh");
	  }
  }
  
  //ifword button clicked, change content
  if(e.getSource()==word) {
	  if(word.getLabel().equals("QWORD")) {
		  word.setLabel("DWORD");
		  if(textBin.getText().replaceAll(" ", "").length()>32) {
		  textBin.setText(textBin.getText().substring(textBin.getText().length()-33));
		  textHex.setText(hexFormat(Long.toHexString(btoDecimal(Long.parseLong(textBin.getText().replaceAll(" ", ""))))).toUpperCase());
		  textOct.setText(octFormat(Long.toOctalString(btoDecimal(Long.parseLong(textBin.getText().replaceAll(" ", ""))))));
		  textDec.setText(decFormat(Long.toString(208-btoDecimal(Long.parseLong(textBin.getText().replaceAll(" ", ""))))));
		  }
	  }
	  else if(word.getLabel().equals("DWORD")) {
		  word.setLabel("WORD");
		  if(textBin.getText().replaceAll(" ", "").length()>16) {
		  textBin.setText(textBin.getText().substring(textBin.getText().length()-17));
		  textHex.setText(hexFormat(Long.toHexString(btoDecimal(Long.parseLong(textBin.getText().replaceAll(" ", ""))))).toUpperCase());
		  textOct.setText(octFormat(Long.toOctalString(btoDecimal(Long.parseLong(textBin.getText().replaceAll(" ", ""))))));
		  textDec.setText(decFormat(Long.toString(208-btoDecimal(Long.parseLong(textBin.getText().replaceAll(" ", ""))))));
		  }
	}
	  else if(word.getLabel().equals("WORD")) {
		  word.setLabel("BYTE");
		  if(textBin.getText().replaceAll(" ", "").length()>8) {
		  textBin.setText(textBin.getText().substring(textBin.getText().length()-9));
		  textHex.setText(hexFormat(Long.toHexString(btoDecimal(Long.parseLong(textBin.getText().replaceAll(" ", ""))))).toUpperCase());
		  textOct.setText(octFormat(Long.toOctalString(btoDecimal(Long.parseLong(textBin.getText().replaceAll(" ", ""))))));
		  textDec.setText(decFormat(Long.toString(128-btoDecimal(Long.parseLong(textBin.getText().replaceAll(" ", ""))))));
		  }
	}
	  else if(word.getLabel().equals("BYTE")) {
		  word.setLabel("QWORD");
	  
	  }
  }
  
  //if bracket open button clicked, add to the display and expression
  if(e.getSource()==btnbr1) {
		  s2 = "(";
		  resultField.setText(ultimateTemp.replaceAll("/", "÷")+"(");
		  s3 = temp+s2;
		  temp = s3;
		  ultimateTemp+=s2;
	  return;
  }
  
//if bracket close button clicked, add to the display and expression
  if(e.getSource()==btnbr2) {
		  s2 = ")";
		  resultField.setText(ultimateTemp.replaceAll("/", "÷")+")");
		  s3 = temp+s2;
		  temp = s3;
		  ultimateTemp+=s2;
	  return;
  }
  
//if A button clicked, add to the display and expression
  if(e.getSource()==bta) {
	  if(display.getText().equals("0")) {
		  display.setText("A");
		  display2.setText("A");
		  temp = "A";
		  ultimateTemp+=temp;
		counter = 0;
	  }
	  else {
		  s2="A";
		  s3=temp+s2;
		  display.setText(s3);
		  display2.setText(hexFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  //show in the conversion area
	  hexGraph();
	  return;
  }
  
//if B button clicked, add to the display and expression
  if(e.getSource()==btb) {
	  if(display.getText().equals("0")) {
		  display.setText("B");
		  temp = "B";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s2="B";
		  s3=temp+s2;
		  display.setText(s3);
		  display2.setText(hexFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  
	  //show in the conversion area
	  hexGraph();
	  return;
  }
  
//if C button clicked, add to the display and expression
  if(e.getSource()==btc) {
	  if(display.getText().equals("0")) {
		  display.setText("C");
		  display2.setText("C");
		  temp = "C";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s2="C";
		  s3=temp+s2;
		  display.setText(s3);
		  display2.setText(hexFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  
	  hexGraph();
	  return;
  }
  
//if D button clicked, add to the display and expression
  if(e.getSource()==btd) {
	  if(display.getText().equals("0")) {
		  display.setText("D");
		  display2.setText("D");
		  temp = "D";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s2="D";
		  s3=temp+s2;
		  display.setText(s3);
		  display2.setText(hexFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  hexGraph();
	  return;
  }
  
//if E button clicked, add to the display and expression
  if(e.getSource()==bte) {
	  if(display.getText().equals("0")) {
		  display.setText("E");
		  display2.setText("E");
		  temp = "E";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s2="E";
		  s3=temp+s2;
		  display.setText(s3);
		  display2.setText(hexFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  hexGraph();
	  return;
  }
  
//if F button clicked, add to the display and expression
  if(e.getSource()==btf) {
	  if(display.getText().equals("0")) {
		  display.setText("F");
		  display2.setText("F");
		  temp = "F";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s2="F";
		  s3=temp+s2;
		  display.setText(s3);
		  display2.setText(hexFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  hexGraph();
	  return;
  }
  
//if +- button clicked, add to the display and expression
  if(e.getSource()==btnpm) {
	  if(display.getText().equals("0")) {
		  ultimateTemp = "negate(0)";
		  resultField.setText(ultimateTemp.replaceAll("/", "÷"));
	  }
	  
	  else { 
		  resultPrint = replaceLast(ultimateTemp, display.getText(), "-"+display.getText());
		  resultH = replaceLast(ultimateTemp, display.getText(), "("+display.getText());
		  resultH += "-2*"+display.getText()+")";
		  ultimateTemp = resultH;
		  resultField.setText(resultPrint.replaceAll("/", "÷"));
		  display.setText("-"+display.getText());
		  display2.setText("-"+display2.getText());
		  operation = 7;
		  
		  if(hex.isSelected())
			  hexGraph();
		  if(dec.isSelected())
			  decimalGraph();
		  if(oct.isSelected())
			  octGraph();
		  if(bin.isSelected())
			  binGraph();
	  }
  }
  
//if del button clicked, add to the display and expression
  if(e.getSource()==btndel) {
	  String source = display.getText();
	  source = source.substring(0,source.length()-1);
	  if(source.length()==0) {
		  display.setText("0");
		  display2.setText("0");
		  temp = "";
		  ultimateTemp = ultimateTemp.substring(0,ultimateTemp.length()-1);
		  textDec.setText("0");
		  textOct.setText("0");
		  textBin.setText("0");
		  textHex.setText("0");
	  }
	  else {
		  temp = temp.substring(0, temp.length()-1);
		  display.setText(source);
		  display2.setText(source);
		  ultimateTemp = ultimateTemp.substring(0,ultimateTemp.length()-1);
		  
		  if(hex.isSelected())
			  hexGraph();
		  
		  else if(oct.isSelected())
			  octGraph();
		  
		  else if(bin.isSelected())
			  binGraph();
		  
		  else
			  decimalGraph();
	  }
  }
  
//if 1 button clicked, add to the display and expression
  if(e.getSource()==btn1)
  {
	  if(display.getText().equals("0")) {
		  display.setText("1");
		  display2.setText("1");
		  temp = "1";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s2="1";
		  s3=temp+s2;
		  display.setText(s3);
		  if(dec.isSelected())
			  display2.setText(decFormat(s3));
		  if(hex.isSelected())
			  display2.setText(hexFormat(s3));
		  if(oct.isSelected())
			  display2.setText(octFormat(s3));
		  if(bin.isSelected())
			  display2.setText(binFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  
	  //show in the conversion area
	  if(hex.isSelected())
		  hexGraph();
	  if(dec.isSelected())
		  decimalGraph();
	  if(oct.isSelected())
		  octGraph();
	  if(bin.isSelected())
		  binGraph();
	  
	  return;
  }
  
//if 2 button clicked, add to the display and expression
  if(e.getSource()==btn2)
  {
	  if(display.getText().equals("0")) {
		  display.setText("2");
		  display2.setText("2");
		  temp = "2";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s2="2";
		  s3=temp+s2;
		  display.setText(s3);
		  if(dec.isSelected())
			  display2.setText(decFormat(s3));
		  if(hex.isSelected())
			  display2.setText(hexFormat(s3));
		  if(oct.isSelected())
			  display2.setText(octFormat(s3));
		  if(bin.isSelected())
			  display2.setText(binFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  
	  if(hex.isSelected())
		  hexGraph();
	  if(dec.isSelected())
		  decimalGraph();
	  if(oct.isSelected())
		  octGraph();
	  if(bin.isSelected())
		  binGraph();	  
	  return;
  }

//if 3 button clicked, add to the display and expression
  if(e.getSource()==btn3)
  {
	  if(display.getText().equals("0")) {
		  display.setText("3");
		  display2.setText("3");
		  temp = "3";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s1=temp;
		  s2="3";
		  s3=s1+s2;
		  display.setText(s3);
		  if(dec.isSelected())
			  display2.setText(decFormat(s3));
		  if(hex.isSelected())
			  display2.setText(hexFormat(s3));
		  if(oct.isSelected())
			  display2.setText(octFormat(s3));
		  if(bin.isSelected())
			  display2.setText(binFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  if(hex.isSelected())
		  hexGraph();
	  if(dec.isSelected())
		  decimalGraph();
	  if(oct.isSelected())
		  octGraph();
	  if(bin.isSelected())
		  binGraph();	  return;
  }
  
//if 4 button clicked, add to the display and expression
  if(e.getSource()==btn4)
  {
	  if(display.getText().equals("0")) {
		  display.setText("4");
		  display2.setText("4");
		  temp = "4";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s1=temp;
		  s2="4";
		  s3=s1+s2;
		  display.setText(s3);
		  if(dec.isSelected())
			  display2.setText(decFormat(s3));
		  if(hex.isSelected())
			  display2.setText(hexFormat(s3));
		  if(oct.isSelected())
			  display2.setText(octFormat(s3));
		  if(bin.isSelected())
			  display2.setText(binFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  if(hex.isSelected())
		  hexGraph();
	  if(dec.isSelected())
		  decimalGraph();
	  if(oct.isSelected())
		  octGraph();
	  if(bin.isSelected())
		  binGraph();
	  return;
  }
  
//if 5 button clicked, add to the display and expression
  if(e.getSource()==btn5)
  {
	  if(display.getText().equals("0")) {
		  display.setText("5");
		  display2.setText("5");
		  temp = "5";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s1=temp;
		  s2="5";
		  s3=s1+s2;
		  display.setText(s3);
		  if(dec.isSelected())
			  display2.setText(decFormat(s3));
		  if(hex.isSelected())
			  display2.setText(hexFormat(s3));
		  if(oct.isSelected())
			  display2.setText(octFormat(s3));
		  if(bin.isSelected())
			  display2.setText(binFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  if(hex.isSelected())
		  hexGraph();
	  if(dec.isSelected())
		  decimalGraph();
	  if(oct.isSelected())
		  octGraph();
	  if(bin.isSelected())
		  binGraph();
	  return;
  }
  
//if 6 button clicked, add to the display and expression
  if(e.getSource()==btn6)
  {
	  if(display.getText().equals("0")) {
		  display.setText("6");
		  display2.setText("6");
		  temp = "6";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s1=temp;
		  s2="6";
		  s3=s1+s2;
		  display.setText(s3);
		  if(dec.isSelected())
			  display2.setText(decFormat(s3));
		  if(hex.isSelected())
			  display2.setText(hexFormat(s3));
		  if(oct.isSelected())
			  display2.setText(octFormat(s3));
		  if(bin.isSelected())
			  display2.setText(binFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  if(hex.isSelected())
		  hexGraph();
	  if(dec.isSelected())
		  decimalGraph();
	  if(oct.isSelected())
		  octGraph();
	  if(bin.isSelected())
		  binGraph();
	  return;
  }
  
//if 7 button clicked, add to the display and expression
  if(e.getSource()==btn7)
  {
	  if(display.getText().equals("0")) {
		  display.setText("7");
		  display2.setText("7");
		  temp = "7";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s1=temp;
		  s2="7";
		  s3=s1+s2;
		  display.setText(s3);
		  if(dec.isSelected())
			  display2.setText(decFormat(s3));
		  if(hex.isSelected())
			  display2.setText(hexFormat(s3));
		  if(oct.isSelected())
			  display2.setText(octFormat(s3));
		  if(bin.isSelected())
			  display2.setText(binFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  if(hex.isSelected())
		  hexGraph();
	  if(dec.isSelected())
		  decimalGraph();
	  if(oct.isSelected())
		  octGraph();
	  if(bin.isSelected())
		  binGraph();
	  return;
  }
  
//if 8 button clicked, add to the display and expression
  if(e.getSource()==btn8)
  {
	  if(display.getText().equals("0")) {
		  display.setText("8");
		  display2.setText("8");
		  temp = "8";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s1=temp;
		  s2="8";
		  s3=s1+s2;
		  display.setText(s3);
		  if(dec.isSelected())
			  display2.setText(decFormat(s3));
		  if(hex.isSelected())
			  display2.setText(hexFormat(s3));
		  if(oct.isSelected())
			  display2.setText(octFormat(s3));
		  if(bin.isSelected())
			  display2.setText(binFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }	  
	  if(hex.isSelected())
		  hexGraph();
	  if(dec.isSelected())
		  decimalGraph();
	  if(oct.isSelected())
		  octGraph();
	  if(bin.isSelected())
		  binGraph();
	  return;
  }
  
//if 9 button clicked, add to the display and expression
  if(e.getSource()==btn9)
  {
	  if(display.getText().equals("0")) {
		  display.setText("9");
		  display2.setText("9");
		  temp = "9";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s1=temp;
		  s2="9";
		  s3=s1+s2;
		  display.setText(s3);
		  if(dec.isSelected())
			  display2.setText(decFormat(s3));
		  if(hex.isSelected())
			  display2.setText(hexFormat(s3));
		  if(oct.isSelected())
			  display2.setText(octFormat(s3));
		  if(bin.isSelected())
			  display2.setText(binFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  
	  if(hex.isSelected())
		  hexGraph();
	  if(dec.isSelected())
		  decimalGraph();
	  if(oct.isSelected())
		  octGraph();
	  if(bin.isSelected())
		  binGraph();	  return;
  }
  
//if 0 button clicked, add to the display and expression
  if(e.getSource()==btn0)
  {
	  if(display.getText().equals("0")) {
		  display.setText("0");
		  display2.setText("0");
		  temp = "0";
		  ultimateTemp+=temp;
		  counter = 0;
	  }
	  else {
		  s1=temp;
		  s2="0";
		  s3=s1+s2;
		  display.setText(s3);
		  if(dec.isSelected())
			  display2.setText(decFormat(s3));
		  if(hex.isSelected())
			  display2.setText(hexFormat(s3));
		  if(oct.isSelected())
			  display2.setText(octFormat(s3));
		  if(bin.isSelected())
			  display2.setText(binFormat(s3));
		  temp=s3;
		  ultimateTemp+=s2;
		  counter = 0;
	  }
	  if(hex.isSelected())
		  hexGraph();
	  if(dec.isSelected())
		  decimalGraph();
	  if(oct.isSelected())
		  octGraph();
	  if(bin.isSelected())
		  binGraph();
	  return;
  }
  
//if add button clicked, add to the display and expression
  if(e.getSource()==btnadd)
  {
   s4=display.getText();
   ultimateTemp += " + ";
   if(operation!=7)
	   resultField.setText(ultimateTemp.replaceAll("/", "÷"));
   temp="";
   operation=0;
   preClear = ultimateTemp; 
  }
  
//if multiply button clicked, add to the display and expression
  if(e.getSource()==btnmultiply)
  {
   s4=display.getText();
   ultimateTemp += " × ";
   if(operation!=7)
	   resultField.setText(ultimateTemp.replaceAll("/", "÷"));
   temp = "";
   operation=1;
   preClear = ultimateTemp;
  }
  
//if subtract button clicked, add to the display and expression
  if(e.getSource()==btnsubtract)
  {
   s4=display.getText();
   //display.setText("");
   ultimateTemp += " - ";
   if(operation!=7)
	   resultField.setText(ultimateTemp.replaceAll("/", "÷"));
   temp = "";
   operation=2;
   preClear = ultimateTemp;
  }
  
//if divide button clicked, add to the display and expression
  if(e.getSource()==btndiv)
  {
   s4=display.getText();
   //display.setText("");
   ultimateTemp += " / ";
   if(operation!=7)
	   resultField.setText(ultimateTemp.replaceAll("/", "÷"));
   temp = "";
   operation=3;
   preClear = ultimateTemp;
  }

//if mod button clicked, add to the display and expression
  if(e.getSource()==btnMod)
  {
   s4=display.getText();
   //display.setText("");
   ultimateTemp += " MOD ";
   if(operation!=7)
	   resultField.setText(ultimateTemp.replaceAll("/", "÷"));
   temp = "";
   operation=4;
   preClear = ultimateTemp;
  }

//if c button clicked, add to the display and expression
  if(e.getSource()==c)
  {
   display.setText("0");
   display2.setText("0");
   temp = "";
   ultimateTemp = preClear;
   textHex.setText("0");
   textDec.setText("0");
   textOct.setText("0");
   textBin.setText("0");
  }

//if ce button clicked, add to the display and expression
  if(e.getSource()==ce)
   {
    display.setText("0");
    display2.setText("0");
    temp = "";
    ultimateTemp = "";
    preClear = ultimateTemp;
    textHex.setText("0");
    textDec.setText("0");
    textOct.setText("0");
    textBin.setText("0");
    resultField.setText("");
   }
  
//if equals button clicked, add to the display and expression
  if(e.getSource()==btnequals)
  {
	  switch(operation) {
	  
	  //in case of operations
	  case 0:
	  case 1:
	  case 2:
	  case 3:
	  case 7:
	  ultimateTemp = conversionParser(ultimateTemp.replaceAll(" ", ""));
	  
	  try {
	  result = Long.toString(calculate(ultimateTemp));
	  }
	  catch(ArithmeticException error) {
		  display2.setText("Cannot divide by zero!");
		  break;
	  }
	  
	  if(hex.isSelected()) {
		  result = Long.toHexString(Long.valueOf(result)).toUpperCase();
	  }

	  if(oct.isSelected())
		  result = Long.toOctalString(Long.valueOf(result));
	  

	  if(bin.isSelected())
		  result = Long.toBinaryString(Long.valueOf(result));
	  
	  display.setText(result);
	  if(dec.isSelected())
		  display2.setText(decFormat(result));
	  if(hex.isSelected())
		  display2.setText(hexFormat(result));
	  if(oct.isSelected())
		  display2.setText(octFormat(result));
	  if(bin.isSelected())
		  display2.setText(binFormat(result));
	  
	  resultField.setText("");
	  
	  if(hex.isSelected())
		  hexGraph();
	  
	  else if(oct.isSelected())
		  octGraph();
	  
	  else if(bin.isSelected())
		  binGraph();
	  
	  else
		  decimalGraph();
	  
	  ultimateTemp = display.getText();
	  break;
	  
	  //in case of negation
	  case 4:
	   s5=display.getText();
	    
	    if(operationFlag==0) {
	    	s4 = Long.toString(htoDecimal(s4));
	    	s5 = Long.toString(htoDecimal(s5));
	    	n=Long.parseLong(s4)%Long.parseLong(s5);
	    	ultimateTemp = Long.toHexString(Long.valueOf(n)).toUpperCase();
	    }
	    if(operationFlag==1) {
	    	n=Long.parseLong(s4)%Long.parseLong(s5);
	    	ultimateTemp = Long.toString(n);
	    }
	    if(operationFlag==2) {
	    	s4 = Long.toString(btoDecimal(Long.parseLong(s4)));
	    	s5 = Long.toString(btoDecimal(Long.parseLong(s5)));
	    	n=Long.parseLong(s4)%Long.parseLong(s5);
	    	ultimateTemp = Long.toBinaryString(Long.valueOf(n));
	    }
	    if(operationFlag==3) {
	    	s4 = Long.toString(otoDecimal(Long.parseLong(s4)));
	    	s5 = Long.toString(otoDecimal(Long.parseLong(s5)));
	    	n=Long.parseLong(s4)%Long.parseLong(s5);
	    	ultimateTemp = Long.toOctalString(Long.valueOf(n));
	    }
	    display.setText(ultimateTemp);
	    display2.setText(ultimateTemp);
	    ultimateTemp = display.getText();
	    resultH = "";
	    
	    resultField.setText("");
		  
		  if(hex.isSelected())
			  hexGraph();
		  
		  else if(oct.isSelected())
			  octGraph();
		  
		  else if(bin.isSelected())
			  binGraph();
		  
		  else
			  decimalGraph();
  		break;
	    
	  }
 }
}

@Override
public void keyPressed(KeyEvent e) {	

}

@Override
public void keyReleased(KeyEvent e) {
		
}

//keyboard listener
@Override
public void keyTyped(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_1)
	  {
		if(display.getText().equals("0"))
			  display.setText("1");
		  else {
			  s1=display.getText();
			  s2="1";
			  s3=s1+s2;
			  display.setText(s3);
		  }
		  return;
	  }
	  if(e.getKeyCode()==KeyEvent.VK_2)
	  {
	   s1=display.getText();
	   s2="2";
	   s3=s1+s2;
	   display.setText(s3);
	   return;
	  }
	  if(e.getKeyCode()==KeyEvent.VK_3)
	  {
	   s1=display.getText();
	   s2="3";
	   s3=s1+s2;
	   display.setText(s3);
	  }
	  if(e.getKeyCode()==KeyEvent.VK_4)
	  {
	   s1=display.getText();
	   s2="4";
	   s3=s1+s2;
	   display.setText(s3);
	  }
	  if(e.getKeyCode()==KeyEvent.VK_5)
	  {
	   s1=display.getText();
	   s2="5";
	   s3=s1+s2;
	   display.setText(s3);
	  }
	  if(e.getKeyCode()==KeyEvent.VK_6)
	  {
	   s1=display.getText();
	   s2="6";
	   s3=s1+s2;
	   display.setText(s3);
	  }
	  if(e.getKeyCode()==KeyEvent.VK_7)
	  {
	   s1=display.getText();
	   s2="7";
	   s3=s1+s2;
	   display.setText(s3);
	  }
	  if(e.getKeyCode()==KeyEvent.VK_8)
	  {
	   s1=display.getText();
	   s2="8";
	   s3=s1+s2;
	   display.setText(s3);
	  }
	  if(e.getKeyCode()==KeyEvent.VK_9)
	  {
	   s1=display.getText();
	   s2="9";
	   s3=s1+s2;
	   display.setText(s3);
	  }
	  if(e.getKeyCode()==KeyEvent.VK_0)
	  {
	   s1=display.getText();
	   s2="0";
	   s3=s1+s2;
	   display.setText(s3);
	  }

	
}

//convert decimal to hex
public static String dec2Hex(int value) {
	
	//if value==0, return 0
	if(value==0)
		return "0";
	
	//from 10-15, return the corresponding alphabets
	else if(value==10)
		return "A";
	else if(value==11)
		return "B";
	else if(value==12)
		return "C";
	else if(value==13)
		return "D";
	else if(value==14)
		return "E";
	else if(value==15)
		return "F";
	
	//same conversion algorithm as before
	int split = value %16;				//find the remainder
	int newVal = value/16;				//store the quotient
	
	//recursively call the function and concatenate the remainders which will be the conversion
	int result = split + 10 * Integer.parseInt(dec2Hex(newVal));
	
	//return the result as a string
	return Integer.toString(result);
}

//print in the data type field if dec is selected
public void decimalGraph() {
	textHex.setText(hexFormat(Long.toHexString(Long.valueOf(display.getText())).toUpperCase()));
	textDec.setText(decFormat(display.getText()));
	textOct.setText(octFormat(Long.toOctalString(Long.valueOf(display.getText()))));
	textBin.setText(binFormat(Long.toBinaryString(Long.valueOf(display.getText()))));
}

//print in the data type field if hex is selected
public void hexGraph() {
	String decVal = display.getText();
	long answer = htoDecimal(decVal);
	textHex.setText(hexFormat(display.getText()));
	textDec.setText(decFormat(Long.toString(answer)));
	textOct.setText(octFormat(Long.toOctalString(Long.valueOf(answer))));
	textBin.setText(binFormat(Long.toBinaryString(Long.valueOf(answer))));
}

//print in the data type field if oct is selected
public void octGraph() {
	String decVal = display.getText();
	long answer = otoDecimal(Long.parseLong(decVal));
	textHex.setText(hexFormat(Long.toHexString(Long.valueOf(answer)).toUpperCase()));
	textDec.setText(decFormat(Long.toString(answer)));
	textOct.setText(octFormat(display.getText()));
	textBin.setText(binFormat(Long.toBinaryString(Long.valueOf(answer))));
}

//print in the data type field if bin is selected
public void binGraph() {
	String decVal = display.getText();
	long answer = btoDecimal(Long.parseLong(decVal));
	textHex.setText(hexFormat(Long.toHexString(Long.valueOf(answer)).toUpperCase()));
	textDec.setText(decFormat(Long.toString(answer)));
	textOct.setText(octFormat(Long.toOctalString(Long.valueOf(answer))));
	textBin.setText(binFormat(display.getText()));
}

//print in the decimal format adding commas
public static String decFormat(String str) {
	if(str.length()<4)
		return str;
	String tempStr = "";
	int i=0;
	for(int n=str.length()-1;n>=0;n--) {
		if(i % 3==0)
			tempStr+=","+str.charAt(n);
		else
			tempStr+=str.charAt(n);
		i++;
	}
	
	str="";
	for(int n=tempStr.length()-1;n>0;n--) {
		str += tempStr.charAt(n);
	}
	
	return str;
	
	
}

//print in the hex format adding space
public static String hexFormat(String str) {
	if(str.length()<5)
		return str;
	String tempStr = "";
	int i=0;
	for(int n=str.length()-1;n>=0;n--) {
		if(i % 4==0)
			tempStr+=" "+str.charAt(n);
		else
			tempStr+=str.charAt(n);
		i++;
	}
	
	str="";
	for(int n=tempStr.length()-1;n>0;n--) {
		str += tempStr.charAt(n);
	}
	
	return str;
	
	
}

//print in the oct format adding space
public static String octFormat(String str) {
	if(str.length()<4)
		return str;
	String tempStr = "";
	int i=0;
	for(int n=str.length()-1;n>=0;n--) {
		if(i % 3==0)
			tempStr+=" "+str.charAt(n);
		else
			tempStr+=str.charAt(n);
		i++;
	}
	
	str="";
	for(int n=tempStr.length()-1;n>0;n--) {
		str += tempStr.charAt(n);
	}
	
	return str;
}

//print in the bin format adding space
public static String binFormat(String str) {
	if(str.length()<5)
		return str;
	String tempStr = "";
	int i=0;
	for(int n=str.length()-1;n>=0;n--) {
		if(i % 4==0)
			tempStr+=" "+str.charAt(n);
		else
			tempStr+=str.charAt(n);
		i++;
	}
	
	str="";
	for(int n=tempStr.length()-1;n>0;n--) {
		str += tempStr.charAt(n);
	}
	
	return str;
	
	
}

//convert hex to decimal
public long htoDecimal(String hex){  
    String digits = "0123456789ABCDEF";  
             hex = hex.toUpperCase();  
             long val = 0;  
             for (int i = 0; i < hex.length(); i++)  
             {  
                 char c = hex.charAt(i);  
                 long d = digits.indexOf(c);  
                 val = 16*val + d;  
             }  
             return val;  
}  

//convert oct to decimal
public long otoDecimal(long octal){    
    //Declaring variable to store decimal number  
    long decimal = 0;    
    //Declaring variable to use in power  
    int n = 0;    
    //writing logic   
    while(true){    
      if(octal == 0){    
        break;    
      } else {    
          long temp = octal%10;    
          decimal += temp*Math.pow(8, n);    
          octal = octal/10;    
          n++;    
       }    
    }    
    return decimal;    
}    

//convert binary to decimal
public long btoDecimal(long binary){  
    long decimal = 0;  
    int n = 0;  
    while(true){  
      if(binary == 0){  
        break;  
      } else {  
          long temp = binary%10;  
          decimal += temp*Math.pow(2, n);  
          binary = binary/10;  
          n++;  
       }  
    }  
    return decimal;  
}  

//calculate the expresssions
public long calculate(String s) {
    int op1 = 1, op2 = 1;
    long val1 = 0, val2 = 1;
    
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            int num = c - '0';
            while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                num = num * 10 + (s.charAt(i + 1) - '0');
                i++;
            }
            
            val2 = op2 == 1 ? val2 * num : val2 / num;
        }else if (c == '(') {
            int cur = i;
            int count = 0;
            while (i < s.length()) {
                char ch = s.charAt(i);
                if (ch == '(') count++;
                if (ch == ')') count--;
                if (count == 0) break;
                i++;
            }
            
            long num = calculate(s.substring(cur + 1,i));
            val2 = op2 == 1 ? val2 * num : val2 / num;
            
        }else if (c == '+' || c == '-') {
            val1 = val1 + op1 * val2;
            op1 = c == '+' ? 1 : -1;
            op2 = 1;
            val2 = 1;
        }else if (c == '*' || c == '/') {
            op2 = c == '*' ? 1 : -1;
        }
    }
    
    return val1 + op1 * val2;
}

//parse the expression for appropriate calculation
public String conversionParser(String ultimateTemp) {
	
	boolean hexBool = false;
	boolean octBool = false;
	boolean binBool = false;
	
	if(hex.isSelected())
		hexBool = true;
	
	if(oct.isSelected())
		octBool = true;
	
	if(bin.isSelected())
		binBool = true;
	
	String newTemp = "";
	String copy = "";
	String tempTotal = ultimateTemp;
	String result = "";
	  boolean ref = false;
	  int ref1 = 0;
	  int ref2 = 0;
	  int ref3 = 0;
	  int past = 0;
	  int index = 0;
	  for(int n = 0; n<ultimateTemp.length();n++) {
		while(ultimateTemp.charAt(n) != '(' && ultimateTemp.charAt(n) != ')' && ultimateTemp.charAt(n) != '+' && ultimateTemp.charAt(n) != '-' && ultimateTemp.charAt(n) != '*' && ultimateTemp.charAt(n) != '/') {
		if(ref==false) {
			ref1 = n;
		}
		ref2++;
		newTemp+=ultimateTemp.charAt(n);
		n++;
		ref = true;
		if(n>=ultimateTemp.length()) {
			break;
		}	
		}
		
		copy = newTemp;
		if(newTemp!="")
		{
			if(hexBool)
				newTemp = Long.toString(htoDecimal(newTemp));
			else if(octBool) {
				newTemp = Long.toString(otoDecimal(Long.parseLong(newTemp)));
			}
			else if(binBool) {
				newTemp = Long.toString(btoDecimal(Long.parseLong(newTemp)));
			}
		ref3 = ref1+ref2;
		
		if(ref1==0) {
			result = tempTotal.substring(0,ref2).replace(copy, newTemp);
			
		}
		else {
			result+=tempTotal.substring(past,ref1);
			result += tempTotal.substring(ref1, ref1+ref2).replace(copy, newTemp);
			
		}
		past = ref3;

		newTemp = "";
		copy = "";
		}
		ref = false;
		ref2 = 0;
		ref3 = 0;
		index++;
	  }
	  return result;
	
}

//replace the last occurrence of a character
String replaceLast(String string, String substring, String replacement)
{
  int index = string.lastIndexOf(substring);
  if (index == -1)
    return string;
  return string.substring(0, index) + replacement
          + string.substring(index+substring.length());
}

//main method
public static void main(String args[])
{
 Calculator frame=new Calculator();
 frame.setTitle("CALCULATOR");
 frame.setLocation(1450,100);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setSize(440,700);
 frame.setVisible(true);
 frame.add(frame.p1);
 frame.add(frame.p2);
 frame.add(frame.p4);
 frame.add(frame.pHex);
 frame.add(frame.pDec);
 frame.add(frame.pOct);
 frame.add(frame.pBin);
}

}