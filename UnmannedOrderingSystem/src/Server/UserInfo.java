package Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

public class UserInfo extends Thread{
		static Vector vector_user = new Vector();
		static Vector vector_room = new Vector();
		private InputStream inputStream;
		private OutputStream outputStream;
		private DataOutputStream dataOutputStream;
		private DataInputStream dataInputStream;
		private Socket socket_user;
		private String Nickname = "";
		private String CurrentRoom = null;
		private boolean RoomCheck = true; // �⺻������ ���� �� �ִ� ����
		private StringTokenizer stringTokenizer;
		public UserInfo(Socket socket){
			this.socket_user = socket;
			userNetwork();
		}
		public String getNicname(){
			return Nickname;
		}
		public void userNetwork(){
			try {
				inputStream = socket_user.getInputStream();
				dataInputStream = new DataInputStream(inputStream);
				outputStream = socket_user.getOutputStream();
				dataOutputStream = new DataOutputStream(outputStream);	
				Nickname = dataInputStream.readUTF();
				Server.textArea.append(Nickname + " : ����� ����\n");
				
				//when a new user is connected
				
				BroadCast("NewUser/" + Nickname);
				for(int i = 0; i< vector_user.size(); i++){ // server alert at existing user and send the new user's id
					UserInfo userInfo = (UserInfo) vector_user.elementAt(i);
					this.send_Message("OldUser/" +  userInfo.getNicname());
				}
				vector_user.add(this);
				BroadCast("user_list_update/ ");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Stream���� ����", "�˸�", JOptionPane.ERROR_MESSAGE);
			}
		}
		private void BroadCast(String str){
			for(int i = 0; i< vector_user.size(); i++){ // server alert at existing user and send the new user's id
				UserInfo userInfo = (UserInfo) vector_user.elementAt(i);
				userInfo.send_Message(str);
			}
		}
		@Override
		public void run() {
			super.run();
			while(true){
				try {
					String msg = dataInputStream.readUTF();
					Server.textArea.append(Nickname + " : " + msg + "\n");
					InMessage(msg);
				} catch (IOException e) {
					Server.textArea.append(Nickname + " : ����� ���� ������\n");
					try {
						dataInputStream.close();
						dataOutputStream.close();
						socket_user.close();
						vector_user.remove(this);
						BroadCast("UserOut/"+Nickname);
						BroadCast("user_list_update/ ");
					} catch (IOException e1) {}
					break;
				}
			}
		}
		private void InMessage(String str){ //handle the message from client
			stringTokenizer = new StringTokenizer(str, "/");
			String protocol = stringTokenizer.nextToken();
			String message = stringTokenizer.nextToken();
			System.out.println("protocol : " + protocol);
			if(protocol.equals("cash")){
				BroadCast("cash/����");
			}else if(protocol.equals("fin")){
				BroadCast("fin/fin");
			}else if(protocol.equals("reset")){
				BroadCast("reset/reset");
			}else if(protocol.equals("last")){
				BroadCast("last/last");
			}
		}
		void send_Message(String message){
			try {
				dataOutputStream.writeUTF(message);
			} catch (IOException e) {
				Server.textArea.append("�޼��� ���� ����");
			}
		}
	}