package Counter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Network{
	InputStream inputStream;
	OutputStream outputStream;
	DataOutputStream dataOutputStream;
	DataInputStream dataInputStream;
	Socket socket = null;
	String ip = "localhost";
	int port = 3307;
	String id ="counter";
	 Vector vector_user_list = new Vector();
	StringTokenizer stringTokenizer;
	public Network() {}
	void network(){
		try {
			socket = new Socket(ip, port);
			if(socket != null){ //socket ok!!
				connection();
			}
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "���� ����", "�˸�", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "���� ����", "�˸�", JOptionPane.ERROR_MESSAGE);
		}
	}
	void connection() {
		try {
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "���� ����", "�˸�", JOptionPane.ERROR_MESSAGE);
		}
		send_message(id); //first connect -> send id
		vector_user_list.add(id); //add my id in user_list
		Thread thread = new Thread(new Socket_thread());
		thread.start();
	}
	void send_message(String message){ //button
		try {
			dataOutputStream.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void InMessage(String str){ //all message from server
		stringTokenizer = new StringTokenizer(str, "/");
		String protocol = stringTokenizer.nextToken();
		String message = stringTokenizer.nextToken();
		System.out.println("�������� : " + protocol);
		if(protocol.equals("NewUser")){
			vector_user_list.add(message);
		}
		else if(protocol.equals("OldUser")){
			vector_user_list.add(message);
		}
		else if(protocol.equals("UserOut")){
			vector_user_list.remove(message);
		}
	}
	public class Socket_thread implements Runnable{
		public void run() {
			while(true){
				try {
					InMessage(dataInputStream.readUTF());
				} catch (IOException e) {
					try{
						outputStream.close();
						inputStream.close();
						dataInputStream.close();
						dataOutputStream.close();
						socket.close();
						
						JOptionPane.showMessageDialog(null, "������ ���� ������", "�˸�", JOptionPane.ERROR_MESSAGE);
					}catch(IOException e1){}
					break;
					
				}
			}
		}
	}
}
