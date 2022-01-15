package pacc;

import java.io.Serializable;

public class Send implements Serializable {
	static final long serialVersionUID = 1L;
	private double a1;
	private double a2;
	private String ans;
	private char operation;
	private boolean quit;
	private String error;
	//constructor
	Send() {
		
	}
	//setters and getters
	Send (double d1, double d2, char op, boolean bquit) {
		a1 = d1;
		a2 = d2;
		operation = op;
		quit = bquit;
	}
	public boolean getQuit() {
		return quit;
	}
	Send (String answer) {
		ans = answer;
	}
	public void setZeroError(String x) {
		error = x;
	}
	public String getZeroError() {
		return error;
	}
	public void setQuit(boolean bquit) {
		quit = bquit;
	}
	public double getA1() {
		return a1;
	}
	public double getA2() {
		return a2;
	}
	public char getOp() {
		return operation;
	}
	public String getAnswer() {
		return ans;
	}
	public void setAnswer(String x) {
		ans = x;
	}
}
