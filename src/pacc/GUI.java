package pacc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField answerField;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero, decimal, neg, add, sub, multiply, div, equals, clear, arcsin, disconnect;
	private String stemp1, stemp2, sanswer;
	private double answer;
	private JPanel contentPanel;
	private boolean equalsClicked = false, opChosen = false;
	static char operation = ' ';
	static double d1, d2;
	static boolean serviceCheck = false;
	static ObjectOutputStream out;
	static ObjectInputStream in;
	static Socket s;
	static boolean bquit = false;
	
	//credit for base calculator: https://www.youtube.com/user/GamesAndCodeVX/videos
	//everything else is original work
	
	//creating the graphical user interface thru the constructor
	public GUI() {
		super("Calculator"); 
		
		//creating the answer field
		answerField = new JTextField(null,20);
		answerField.setEditable(false);
		
		//all the JButtons
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		decimal = new JButton(".");
		neg = new JButton("+/-");
		equals = new JButton("=");
		add = new JButton("+");
		sub = new JButton("-");
		multiply = new JButton("*");
		div = new JButton("/");
		clear = new JButton("C");
		arcsin = new JButton("arcsin");
		disconnect = new JButton("disc.");
		
		//setting dim for each button
		Dimension dim = new Dimension(75,25);
		one.setPreferredSize(dim);
		two.setPreferredSize(dim);
		three.setPreferredSize(dim);
		four.setPreferredSize(dim);
		five.setPreferredSize(dim);
		six.setPreferredSize(dim);
		seven.setPreferredSize(dim);
		eight.setPreferredSize(dim);
		nine.setPreferredSize(dim);
		zero.setPreferredSize(new Dimension(155,25));
		neg.setPreferredSize(dim);
		equals.setPreferredSize(new Dimension(235,25));
		decimal.setPreferredSize(dim);
		add.setPreferredSize(dim);
		sub.setPreferredSize(dim);
		multiply.setPreferredSize(dim);
		div.setPreferredSize(dim);
		clear.setPreferredSize(dim);
		arcsin.setPreferredSize(dim);
		disconnect.setPreferredSize(dim);
		
		//calc and numbers objects
		Numbers n = new Numbers();
		Calc c = new Calc();
		
		//action listener attachment for 'n' & 'c'
		one.addActionListener(n); two.addActionListener(n); three.addActionListener(n);
		four.addActionListener(n); five.addActionListener(n); six.addActionListener(n);
		seven.addActionListener(n); eight.addActionListener(n); nine.addActionListener(n);
		zero.addActionListener(n); decimal.addActionListener(n); neg.addActionListener(n);
		
		add.addActionListener(c); sub.addActionListener(c); multiply.addActionListener(c);
		div.addActionListener(c); equals.addActionListener(c); clear.addActionListener(c);
		arcsin.addActionListener(c); disconnect.addActionListener(c);
		
		//adding components and properties to JPanel
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.white);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.add(answerField, BorderLayout.NORTH);
		contentPanel.add(one); contentPanel.add(two); contentPanel.add(three); contentPanel.add(four);
		contentPanel.add(five); contentPanel.add(six); contentPanel.add(seven); contentPanel.add(eight);
		contentPanel.add(nine); contentPanel.add(zero); contentPanel.add(decimal); contentPanel.add(neg); 
		contentPanel.add(add); contentPanel.add(sub); contentPanel.add(multiply); contentPanel.add(div); 
		contentPanel.add(equals); contentPanel.add(clear); contentPanel.add(arcsin); contentPanel.add(disconnect);
		
		this.setContentPane(contentPanel);
	}
	//data handling
	public static void data() throws IOException, ClassNotFoundException {
		if(!serviceCheck) {
			Send send = new Send(d1, d2, operation, bquit);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
			send.setQuit(bquit);
			out.writeObject(send);
			send = (Send)in.readObject();
			d1 = (Double.valueOf(send.getAnswer()));
			System.out.println(d1);
			serviceCheck = true;
			d2 = 0;
		} else {
			Send send = new Send(d1, d2, operation, bquit);
			send.setQuit(bquit);
			out.writeObject(send);
			send = (Send)in.readObject();
			d1 = (Double.valueOf(send.getAnswer()));
			
			d2 = 0;
		}
	}
	//takes in number inputs
	private class Numbers implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton src = (JButton) e.getSource();
			if(src.equals(one)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "1";
					} else {
						stemp1 = stemp1 + "1";
					}
				} else { 
					if(stemp2==null) {
						stemp2 = "1";
					} else {
						stemp2 = stemp2 + "1";
					}
				}
			}
			
			if(src.equals(two)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "2";
					} else {
						stemp1 = stemp1 + "2";
					}
				} else { 
					if(stemp2==null) {
						stemp2 = "2";
					} else {
						stemp2 = stemp2 + "2";
					}
				}
			}
			
			if(src.equals(three)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "3";
					} else {
						stemp1 = stemp1 + "3";
					}
				} else { 
					if(stemp2==null) {
						stemp2 = "3";
					} else {
						stemp2 = stemp2 + "3";
					}
				}
			}
			
			if(src.equals(four)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "4";
					} else {
						stemp1 = stemp1 + "4";
					}
				} else { 
					if(stemp2==null) {
						stemp2 = "4";
					} else {
						stemp2 = stemp2 + "4";
					}
				}
			}
			
			if(src.equals(five)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "5";
					} else {
						stemp1 = stemp1 + "5";
					}
				} else { 
					if(stemp2==null) {
						stemp2 = "5";
					} else {
						stemp2 = stemp2 + "5";
					}
				}
			}
			
			if(src.equals(six)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "6";
					} else {
						stemp1 = stemp1 + "6";
					}
				} else { 
					if(stemp2==null) {
						stemp2 = "6";
					} else {
						stemp2 = stemp2 + "6";
					}
				}
			}
			
			if(src.equals(seven)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "7";
					} else {
						stemp1 = stemp1 + "7";
					}
				} else { 
					if(stemp2==null) {
						stemp2 = "7";
					} else {
						stemp2 = stemp2 + "7";
					}
				}
			}
			
			if(src.equals(eight)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "8";
					} else {
						stemp1 = stemp1 + "8";
					}
				} else { 
					if(stemp2==null) {
						stemp2 = "8";
					} else {
						stemp2 = stemp2 + "8";
					}
				}
			}
			
			if(src.equals(nine)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "9";
					} else {
						stemp1 = stemp1 + "9";
					}
				} else { 
					if(stemp2==null) {
						stemp2 = "9";
					} else {
						stemp2 = stemp2 + "9";
					}
				}
			}
			
			if(src.equals(zero)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "0";
					} else {
						stemp1 = stemp1 + "0";
					}
				} else { 
					if(stemp2==null) {
						stemp2 = "0";
					} else {
						stemp2 = stemp2 + "0";
					}
				}
			}
			
			if(src.equals(decimal)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "0.";
					} else if (stemp1 != null) {
						if(stemp1.contains(".")) {
							System.out.println("You already have a decimal!");
						} else {
							stemp1 += ".";
						}
					}
				} else if (stemp2 == null) {
					stemp2 = "0.";
				} else if (stemp2!=null) {
					if(stemp2.contains(".")) {
						System.out.println("You already have a decimal");
					} else {
						stemp2 += ".";
					}
				}
			}
			
			if(src.equals(neg)) {
				if(opChosen == false) {
					if(stemp1==null) {
						stemp1 = "-";
					} else if (stemp1 != null && stemp1.startsWith("-")) {
						stemp1 = stemp1.substring(1);
					} else {
						stemp1 = "-" + stemp1;
					}
				} else if (stemp2 == null) { 
					stemp2 = "-";
				} else if (stemp2 != null && stemp2.startsWith("-")) {
					stemp2 = stemp2.substring(1);
				} else {
					stemp2 = "-" + stemp2;
				}

			}
			
			if(equalsClicked==false) {
				if(opChosen==false) {
					answerField.setText(stemp1);
				} else {
					answerField.setText(stemp2);
				}
			}
		}
		
	}
	//takes in operator
	private class Calc implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton src = (JButton) e.getSource();	
			
			if(src.equals(add)) {
				if(stemp1==null) {
					System.out.println("Choose your numbers first!");
				} else if (stemp1 != null && stemp2 == null) {
					opChosen = true;
					operation = '+';
				} else if (stemp1 != null && stemp2 == null) {
					System.out.println("Two operations only");
				}
			}
			if(src.equals(sub)) {
				if(stemp1==null) {
					System.out.println("Choose your numbers first!");
				} else if (stemp1 != null && stemp2 == null) {
					opChosen = true;
					operation = '-';
				} else if (stemp1 != null && stemp2 != null) {
					System.out.println("Two operations only");
				}
			}
			if(src.equals(multiply)) {
				if(stemp1==null) {
					System.out.println("Choose your numbers first!");
				} else if (stemp1 != null && stemp2 == null) {
					opChosen = true;
					operation = '*';
				} else if (stemp1 != null && stemp2 != null) {
					System.out.println("Two operations only");
				}
			}
			if(src.equals(div)) {
				if(stemp1==null) {
					System.out.println("Choose your numbers first!");
				} else if (stemp1 != null && stemp2 == null) {
					opChosen = true;
					operation = '/';
				} else if (stemp1 != null && stemp2 != null) {
					System.out.println("Two operations only");
				}
			}
			if(src.equals(arcsin)) {
				if(stemp1==null) {
					stemp1 = "1";
					opChosen = true;
					operation = 'S';
				} else {
					if(stemp1 != null && stemp2 != null) {
						System.out.println("two operations only");
					}
				}
			}
			if(src.equals(equals)) {
				if(stemp1 == null) {
					System.out.println("Choose your numbers first!");
				} else if (stemp1 != null && stemp2 == null) {
					System.out.println("Choose TWO numbers");
				}
				if(stemp1 != null && stemp2 != null) {
					
					d1 = Double.parseDouble(stemp1);
					d2 = Double.parseDouble(stemp2);
					
					try {
						data();
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
					answerField.setText(Double.toString(d1));
					
					if(operation == '/' && d2 == 0.0) {
						answerField.setText("DIVIDE BY ZERO ERROR");
					}
				}
			}
			if(src.equals(clear)) {
				stemp1 = null;
				stemp2 = null;
				opChosen = false;
				equalsClicked = false;
				operation = ' ';
				answerField.setText(null);
				sanswer = null;
			}
			if(src.equals(disconnect)) {
				bquit = true;
			}
		}
	}
	//main function
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		GUI g = new GUI();
		g.setSize(300,400);
		g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		g.setVisible(true);
		g.setResizable(false);
		
		s = new Socket("localhost", 1111);
	}
	//quit function
	public void quit() throws IOException {
		System.exit(0);
		s.close();
		out.close();
		in.close();
		Server.ss.close();
		Server.in.close();
		Server.out.close();
	}
}
