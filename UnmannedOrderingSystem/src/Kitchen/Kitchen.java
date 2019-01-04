package Kitchen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Kitchen extends Network implements ActionListener{

	static final int Width = 1920;
	static final int Height = 1080;
	static int ornum,amountdata,no,count;
	private JFrame jframe;
	Font font = new Font("���", Font.BOLD, 18);
	private JPanel jp;
	private JLabel print1,print2,print3,print4,print5,print6,print7,print8; // �ֹ� ��ǰ
	private JButton finish; //���� �Ϸ��ư
	private static JTextField ordernum; // ���� �Ϸ� ��ǰ �ֹ���ȣ �Է�
	static KitDB kdb = new KitDB();
	private static String menudata,passdata;
	static JList ls1;
	static ArrayList<JLabel> printlist = new ArrayList<JLabel>();
	static ArrayList<JLabel> printlist1 = new ArrayList<JLabel>();
	static ArrayList<JLabel> printlist2 = new ArrayList<JLabel>();
	static ArrayList<JList> orderlist = new ArrayList<JList>();
	static ArrayList<JList> orderlist1 = new ArrayList<JList>();
	static DefaultListModel model,model1;
	ArrayList<JPanel> listpanel = new ArrayList<JPanel>();
	public Kitchen() {
		System.out.println("login");
		super.network();
		Kitchen_init();
		super.Reload();
	}
	private void CreateLabel(int num,String name,int x,int y,int wid,int hei) {
		printlist.add(num,new JLabel(name));
		printlist.get(num).setBounds(x, y, wid, hei);
		printlist.get(num).setOpaque(true);
		printlist.get(num).setFont(font);
		printlist.get(num).setBackground(Color.white);
		printlist.get(num).setHorizontalAlignment(JLabel.CENTER);;
		listpanel.get(num).add(printlist.get(num));
	}
	private void CreateLabel1(int num,String name,int x,int y,int wid,int hei) {
		printlist1.add(num,new JLabel(name));
		printlist1.get(num).setBounds(x, y, wid, hei);
		printlist1.get(num).setOpaque(true);
		printlist1.get(num).setFont(font);
		printlist1.get(num).setBackground(Color.black);
		printlist1.get(num).setHorizontalAlignment(JLabel.CENTER);;
		listpanel.get(num).add(printlist1.get(num));
	}
	private void CreateLabel2(int num,String name,int x,int y,int wid,int hei) {
		printlist2.add(num,new JLabel(name));
		printlist2.get(num).setBounds(x, y, wid, hei);
		printlist2.get(num).setOpaque(true);
		printlist2.get(num).setFont(font);
		printlist2.get(num).setBackground(Color.cyan);
		printlist2.get(num).setHorizontalAlignment(JLabel.CENTER);;
		listpanel.get(num).add(printlist2.get(num));
	}
	private void CreatePanel(int num,int x,int y,int wid,int hei) {
		listpanel.add(num,new JPanel());
		listpanel.get(num).setLayout(null);
		listpanel.get(num).setBorder(new TitledBorder(new LineBorder(Color.BLACK,1)));
		listpanel.get(num).setBackground(Color.white);
		listpanel.get(num).setBounds(x, y, wid, hei);
		jframe.add(listpanel.get(num));
	}
	private void CreateList(int num,int x,int y,int wid,int hei) {
		orderlist.add(num,new JList(new DefaultListModel()));
		orderlist.get(num).setBounds(x,y,wid,hei);
		orderlist.get(num).setOpaque(true);
		orderlist.get(num).setBorder(new TitledBorder(new LineBorder(Color.BLACK,1)));
		listpanel.get(num).add(orderlist.get(num));
	}
	private void CreateList1(int num,int x,int y,int wid,int hei) {
		orderlist1.add(num,new JList(new DefaultListModel()));
		orderlist1.get(num).setBounds(x,y,wid,hei);
		orderlist1.get(num).setOpaque(true);
		orderlist1.get(num).setBorder(new TitledBorder(new LineBorder(Color.BLACK,1)));
		listpanel.get(num).add(orderlist1.get(num));
	}
	private void Kitchen_init() {
		jframe = new JFrame();	
		jframe.setSize(Width,Height);
		jframe.setLocation(0, 0);
		jframe.setLayout(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CreatePanel(0,0,0,480,500);
		CreatePanel(1,480,0,480,500);
		CreatePanel(2,960,0,480,500);
		CreatePanel(3,1440,0,480,500);
		CreatePanel(4,0,500,480,500);
		CreatePanel(5,480,500,480,500);
		CreatePanel(6,960,500,480,500);
		CreatePanel(7,1440,500,480,500);
		CreateLabel(0,"�ֹ���ȣ : 0",80,50,300,50);
		CreateLabel(1,"�ֹ���ȣ : 0",80,50,300,50);
		CreateLabel(2,"�ֹ���ȣ : 0",80,50,300,50);
		CreateLabel(3,"�ֹ���ȣ : 0",80,50,300,50);
		CreateLabel(4,"�ֹ���ȣ : 0",80,50,300,50);
		CreateLabel(5,"�ֹ���ȣ : 0",80,50,300,50);
		CreateLabel(6,"�ֹ���ȣ : 0",80,50,300,50);
		CreateLabel(7,"�ֹ���ȣ : 0",80,50,300,50);
		CreateLabel1(0,"�޴�",80,100,220,50);
		CreateLabel1(1,"�޴�",80,100,220,50);
		CreateLabel1(2,"�޴�",80,100,220,50);
		CreateLabel1(3,"�޴�",80,100,220,50);
		CreateLabel1(4,"�޴�",80,100,220,50);
		CreateLabel1(5,"�޴�",80,100,220,50);
		CreateLabel1(6,"�޴�",80,100,220,50);
		CreateLabel1(7,"�޴�",80,100,220,50);
		CreateLabel2(0,"����",300,100,100,50);
		CreateLabel2(1,"����",300,100,100,50);
		CreateLabel2(2,"����",300,100,100,50);
		CreateLabel2(3,"����",300,100,100,50);
		CreateLabel2(4,"����",300,100,100,50);
		CreateLabel2(5,"����",300,100,100,50);
		CreateLabel2(6,"����",300,100,100,50);
		CreateLabel2(7,"����",300,100,100,50);
		CreateList(0,80,150,220,250);
		CreateList(1,80,150,220,250);
		CreateList(2,80,150,220,250);
		CreateList(3,80,150,220,250);
		CreateList(4,80,150,220,250);
		CreateList(5,80,150,220,250);
		CreateList(6,80,150,220,250);
		CreateList(7,80,150,220,250);
		CreateList1(0,300,150,100,250);
		CreateList1(1,300,150,100,250);
		CreateList1(2,300,150,100,250);
		CreateList1(3,300,150,100,250);
		CreateList1(4,300,150,100,250);
		CreateList1(5,300,150,100,250);
		CreateList1(6,300,150,100,250);
		CreateList1(7,300,150,100,250);
		ordernum = new JTextField(10);
		ordernum.setBounds(860, 1000, 100, 50);
		ordernum.addActionListener(this);
		jframe.add(ordernum);
		finish = new JButton("���ۿϷ�");
		finish.setBounds(960,1000,120,50);
		finish.addActionListener(this);
		jframe.add(finish);
		jframe.setVisible(true);
	}
	static void Panel(int num) {
		ornum = 0;
		orderlist.get(num).removeAll();
		model = (DefaultListModel) orderlist.get(num).getModel();
		model1 = (DefaultListModel) orderlist1.get(num).getModel();
		if(model.isEmpty() == false) {
		for(int i=0;i<model.size();i++) {
			model.remove(i);
		}
		Panel(num);
		}else if(model1.isEmpty() == false) {
			for(int i=0;i<model1.size();i++) {
				model1.remove(i);
			}
		Panel(num);
		}
		else {
			kdb.SelNum(num+1);
			printlist.get(num).setText("�ֹ���ȣ : "+ ornum);
			ArrayList arr = kdb.Selmenu(num+1);
			ArrayList arr1 = kdb.SelAmount(num+1);
			for(int i=0;i<arr.size();i++) {
				Data d = (Data) arr.get(i);
				menudata = d.getMenu();
				model.addElement(menudata);
			}
			for(int i =0;i<arr1.size();i++) {
				Data d = (Data) arr1.get(i);
				amountdata = d.getAmount();
				model1.addElement(Integer.toString(amountdata));
		}
	}
}
	static void Stock(int n){
		ArrayList a = kdb.Join(n);
		String str = "����Ƣ��";
		for(int i = 0; i<a.size(); i++) {
			Data d = (Data) a.get(i);
			passdata = d.getMenu();
			kdb.Check(passdata,n);
			kdb.InsertAmount(passdata);
			if(passdata.equals("�Ұ����ż�Ʈ")) {
					passdata = "�Ұ��";
					kdb.UpdateCur(str);
			}else if(passdata.equals("������ż�Ʈ")) {
				passdata = "�������";
				kdb.UpdateCur(str);
			}else if(passdata.equals("ġ����ż�Ʈ")) {
				passdata = "ġ�����";
				kdb.UpdateCur(str);
			}else if(passdata.equals("ġŲ���ż�Ʈ")) {
				passdata = "ġŲ����";
				kdb.UpdateCur(str);
			}else if(passdata.equals("�ݶ�(Set)")) {
				passdata = "�ݶ�";
			}else if(passdata.equals("�ݶ�(SetL)")) {
				passdata = "�ݶ�";
			}else if(passdata.equals("�Ұ�����")) {
				passdata = "�Ұ��";
			}else if(passdata.equals("���̴�(Set)")) {
				passdata = "���̴�";
			}else if(passdata.equals("���̴�(SetL)")) {
				passdata = "���̴�";
			}else if(passdata.equals("ȯŸ(Set)")) {
				passdata = "ȯŸ";
			}else if(passdata.equals("ȯŸ(SetL)")) {
				passdata = "ȯŸ";
			}else if(passdata.equals("Ŀ��(Set)")) {
				passdata = "Ŀ��";
			}else if(passdata.equals("Ŀ��(SetL)")) {
				passdata = "Ŀ��";
			}
			kdb.UpdateCur(passdata);
			kdb.UpdateSetting("orders");
		}	
	}
	public static void main(String[] args) {
		new Kitchen();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == finish || e.getSource() == ordernum) {
			int nu = Integer.parseInt(ordernum.getText());
			if(nu == 0){}else{
			kdb.SelNo(nu);
			Stock(nu);
			kdb.Delete(nu);
			kdb.InsertFin(nu);
			kdb.ReSetNum(no);
			super.send_message("fin/Finish");
			ordernum.setText("");
			}
		}
	}
}

