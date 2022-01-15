package pacc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static ObjectInputStream in;
	static ObjectOutputStream out;
	static ServerSocket ss;
	
	//server code that takes in the inputs and gives the answer (thru send class)
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Send sent = null;
		ss = new ServerSocket(1111);
		System.out.println("Server Waiting...");
		Socket s = ss.accept();
		
		
		in = new ObjectInputStream(s.getInputStream());
		out = new ObjectOutputStream(s.getOutputStream());
		
		boolean bquit = false;
		while(bquit==false) {
			sent = (Send)in.readObject();
			bquit = sent.getQuit();
			
			double c1 = sent.getA1();
			double c2 = sent.getA2();
			char operant = sent.getOp();
			System.out.println(c1);
			System.out.println(c2);
			System.out.println(operant);
			double answer = 0;
			switch(operant) {
			case '+':
				answer = c1 + c2;
				break;
			case '-':
				answer = c1 - c2;
				break;
			case '*':
				answer = c1 * c2;
				break;
			case '/':
				if (c2 == 0) {
					sent.setZeroError("DIVIDE BY ZERO ERROR");
				} else {
					answer = c1 / c2;
				}
				break;
			case 'S':
				answer = Math.asin(Math.toRadians(c2));
				break;
			default: 
				answer = 0.0;
				break;	
			}
			
			System.out.println(answer);
			Send info2 = new Send(String.valueOf(answer));
			
			out.writeObject(info2);
			
		}
		in.close();
		out.close();
		System.out.println("System exited");
		System.exit(0);
	}
}