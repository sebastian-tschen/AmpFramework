package guiButtons;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MainFrame extends JFrame implements ActionListener, Runnable{
	
	private BoolPool pool;
	private JButton one, two , three, four, five, six, seven, eight;
	private JLabel bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight;
	private JLabel countOne, countTwo;
	//char[] bin;
	private ButtonListener myListener;
	//private JMenuBar menu;
	private JPanel panelOne;
	private JPanel panelTwo;
	private JPanel panelThree;
	private boolean cOne, cTwo, cThree, cFour, cFive, cSix, cSeven, cEight;

	public MainFrame(BoolPool boolPool){
		super("Knopf");
		pool = boolPool;
		panelOne = new JPanel();
		panelOne.setBackground(Color.WHITE);
		panelTwo = new JPanel();
		panelTwo.setBackground(Color.WHITE);
		panelThree = new JPanel();
		panelThree.setBackground(Color.WHITE);
		setSize(700, 150);
		cOne = false;
		cTwo = false;
		cThree = false;
		cFour = false;
		cFive = false;
		cSix = false;
		cSeven = false;
		cEight = false;
		createUI();
		getContentPane().add("North", panelOne);
		getContentPane().add("Center", panelTwo);
		getContentPane().add("South", panelThree);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

		private void createUI() {
			//Knoepfe
			eight = new JButton(new ImageIcon("LED_RED.jpg", "eight"));
			eight.setActionCommand("eight");
			eight.setBorderPainted(false);
			eight.setBackground(Color.WHITE);
			eight.setSize(40, 40);
			eight.addActionListener(this);
			panelOne.add(eight);
			
			seven = new JButton(new ImageIcon("LED_RED.jpg", "seven"));
			seven.setActionCommand("seven");
			seven.setBorderPainted(false);
			seven.setBackground(Color.WHITE);
			seven.setSize(40, 40);
			seven.addActionListener(this);
			panelOne.add(seven);
			
			six = new JButton(new ImageIcon("LED_RED.jpg", "six"));
			six.setActionCommand("six");
			six.setBorderPainted(false);
			six.setBackground(Color.WHITE);
			six.setSize(40, 40);
			six.addActionListener(this);
			panelOne.add(six);
			
			five = new JButton(new ImageIcon("LED_RED.jpg", "five"));
			five.setActionCommand("five");
			five.setBorderPainted(false);
			five.setBackground(Color.WHITE);
			five.addActionListener(this);
			panelOne.add(five);
			
			four = new JButton(new ImageIcon("LED_RED.jpg", "four"));
			four.setActionCommand("four");
			four.setBorderPainted(false);
			four.setBackground(Color.WHITE);
			four.addActionListener(this);
			panelOne.add(four);
			
			three = new JButton(new ImageIcon("LED_RED.jpg", "three"));
			three.setActionCommand("three");
			three.setBorderPainted(false);
			three.setBackground(Color.WHITE);
			three.addActionListener(this);
			panelOne.add(three);
			
			two = new JButton(new ImageIcon("LED_RED.jpg", "two"));
			two.setActionCommand("two");
			two.setBorderPainted(false);
			two.setBackground(Color.WHITE);
			two.addActionListener(this);
			panelOne.add(two);
			
			one = new JButton(new ImageIcon("LED_RED.jpg", "one"));
			one.setActionCommand("one");
			one.setBorderPainted(false);
			one.setBackground(Color.WHITE);
			one.addActionListener(this);
			panelOne.add(one);
		
			//Binaer-Ausgabe
			JLabel name = new JLabel("Binaer:   ");
			panelTwo.add(name);
		
			bEight = new JLabel("0");
			panelTwo.add(bEight);
		
			bSeven = new JLabel("0");
			panelTwo.add(bSeven);
		
			bSix = new JLabel("0");
			panelTwo.add(bSix);
		
			bFive = new JLabel("0");
			panelTwo.add(bFive);
		
			bFour = new JLabel("0");
			panelTwo.add(bFour);
		
			bThree = new JLabel("0");
			panelTwo.add(bThree);
		
			bTwo = new JLabel("0");
			panelTwo.add(bTwo);
		
			bOne = new JLabel("0");
			panelTwo.add(bOne);

			//Hex-Ausgabe
			JLabel hex = new JLabel("HEX:   ");
			panelThree.add(hex);
		
			countTwo = new JLabel("0");
			countTwo.setFont(new Font("New Times Roman",20, 20));
			panelThree.add(countTwo);
		
			countOne = new JLabel("0");
			countOne.setFont(new Font("New Times Roman",20, 20));
			panelThree.add(countOne);


		
		
		
		}
	
		public void actionPerformed(ActionEvent event) {
			String buttonNo = event.getActionCommand();
			System.out.println(buttonNo);
			if(buttonNo.equals("one")){
				cOne = changeButton(one, cOne, bOne);
			}
			else if(buttonNo.equals("two")){
				cTwo = changeButton(two, cTwo, bTwo);
			}
			else if(buttonNo.equals("three")){
				cThree = changeButton(three, cThree, bThree);
			}
			else if(buttonNo.equals("four")){
				cFour = changeButton(four, cFour, bFour);
			}
			else if(buttonNo.equals("five")){
				cFive = changeButton(five, cFive, bFive);
			}
			else if(buttonNo.equals("six")){
				cSix = changeButton(six, cSix, bSix);
			}
			else if(buttonNo.equals("seven")){
				cSeven = changeButton(seven, cSeven, bSeven);
			}
			else if(buttonNo.equals("eight")){
				cEight = changeButton(eight, cEight, bEight);
			}
			setHexCount();
		}

		private boolean changeButton(JButton button, boolean pressed, JLabel buttonLabel) {
			if(!pressed){
				button.setIcon(new ImageIcon("LED_GREEN.jpg", "one"));
				buttonLabel.setText("1");
				return true;
			}
			else{
				button.setIcon(new ImageIcon("LED_RED.jpg", "one"));
				buttonLabel.setText("0");
				return false;
			}
		}

		private void setHexCount() {

			Integer first = 0;
			if(cOne){
				first += 1;
			}
			if(cTwo){
				first += 2;
			}
			if(cThree){
				first += 4;
			}
			if(cFour){
				first += 8;
			}
			countOne.setText(getHexCount(first));
		
			Integer second = 0;
			if(cFive){
				second += 1;
			}
			if(cSix){
				second += 2;
			}
			if(cSeven){
				second += 4;
			}
			if(cEight){
				second += 8;
			}
			countTwo.setText(getHexCount(second));
		}

		private String getHexCount(Integer first) {
			if(first < 10){
				return first.toString();
			}
			else{
				Integer tempI = first - 10;
				Character tempC = 'a';
				tempC += tempI;
				return tempC.toString();
			}
		}
	
		public void setBools(){
			pool.setBool(cOne, 0);
			pool.setBool(cTwo, 1);
			pool.setBool(cThree, 2);
			pool.setBool(cFour, 3);
			pool.setBool(cFive, 4);
			pool.setBool(cSix, 5);
			pool.setBool(cSeven, 6);
			pool.setBool(cEight, 7);
		}

		@Override
		public void run() {
			synchronized (pool){
				try{
					setBools();
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
}
