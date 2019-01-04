package Counter;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Topping implements ActionListener {
	static final int SCREEN_WIDTH = 720;//763
	static final int SCREEN_HEGITH = 960;//190
	static DBDao db;
	static Data data;
	static Menu menu;
	static JFrame toppingselec;
	static JPanel p1;
	static Image bi, ci, hi, ei, exiti;
	static String topm;
	static int topp;
	int i1,i2,i3,i4,i5,i6,i7,i8;
	
	ArrayList<JButton> jb = new ArrayList<JButton>();
	ArrayList<JLabel> jl = new ArrayList<JLabel>();
	
	void CreateButton(int num, ImageIcon name, int x, int y, int wid, int hei, JPanel p) {
		jb.add(num,new JButton(name));
		jb.get(num).setBounds(x, y, wid, hei);
		jb.get(num).addActionListener(this);
		jb.get(num).setBackground(Color.white);
		jb.get(num).setBorderPainted(false);
		p.add(jb.get(num));
	}
	void CreateLabel(int num, String name, int x, int y, int wid, int hei, JPanel p) {
		jl.add(num,new JLabel(name));
		jl.get(num).setBounds(x, y, wid, hei);
		p.add(jl.get(num));	
	}
	public Topping() {
		toppingselec = new JFrame();
		toppingselec.setSize(SCREEN_WIDTH, SCREEN_HEGITH);
		toppingselec.setUndecorated(true); //�޴��� ���ֱ�
		toppingselec.setLayout(null);
		toppingselec.setBackground(new Color(0, 0, 0, 122));
		toppingselec.setLocation(550, 50);
		toppingselec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel1();
		toppingselec.setVisible(true);
	}
	public void Panel1() {
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.white);
		p1.setBounds(0, 300, 763, 190);
		
		exiti = new ImageIcon(Start.class.getResource("../images/����.png")).getImage();
		bi = new ImageIcon(Start.class.getResource("../images/������.png")).getImage();
		ci = new ImageIcon(Start.class.getResource("../images/ġ��.png")).getImage();
		hi = new ImageIcon(Start.class.getResource("../images/��.png")).getImage();
		ei = new ImageIcon(Start.class.getResource("../images/���.png")).getImage();		
		
		CreateButton(0, new ImageIcon(exiti), 0, 0, 150, 150, p1); //���
		CreateButton(1, new ImageIcon(bi), 150, 0, 150, 150, p1); //������
		CreateButton(2, new ImageIcon(ci), 300, 0, 150, 150, p1); //ġ��
		CreateButton(3, new ImageIcon(hi), 450, 0, 150, 150, p1); //��
		CreateButton(4, new ImageIcon(ei), 600, 0, 150, 150, p1); //���
	
		CreateLabel(0, "�ݱ�", 60, 160, 150, 30, p1);
		CreateLabel(1, "������ +500��", 185, 160, 150, 30, p1);
		CreateLabel(2, "ġ�� +500��", 335, 160, 150, 30, p1);
		CreateLabel(3, "�� +500��", 485, 160, 150, 30, p1);
		CreateLabel(4, "��� +500��", 635, 160, 150, 30, p1);
		
		toppingselec.add(p1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb.get(0)) {
			Menu.p6list.add("�߰� ����");
			toppingselec.setVisible(false);
		}
		if(e.getSource() == jb.get(1)) {//������ �߰�
			db = new DBDao();
			db.SelectT("toppingselec", 1);
			Menu.p6list.add("���������� �߰� +500��");
			Menu.sum += topp;
			Menu.sumText();
			Menu.tp1 += 1;
			if(Menu.tp1 >1) {
				db.UpdateTopping();
			}else {
			db.Addtopping();//sale�� ������ �߰�
			}
			toppingselec.setVisible(false);
		}
		if(e.getSource() == jb.get(2)) {//ġ�� �߰�
			db = new DBDao();
			db.SelectT("toppingselec", 2);
			Menu.p6list.add("ġ������ �߰� +500��");
			Menu.sum += topp;
			Menu.sumText();
			Menu.tp2 += 1;
			if(Menu.tp2 >1) {
				db.UpdateTopping();
			}else {
			db.Addtopping();//sale�� ġ�� �߰�
			}
			toppingselec.setVisible(false);
		}
		if(e.getSource() == jb.get(3)) {//�� �߰�
			db = new DBDao();
			db.SelectT("toppingselec", 3);
			Menu.p6list.add("������ �߰� +500��");
			Menu.sum += topp;
			Menu.sumText();
			Menu.tp3 +=1;
			if(Menu.tp3 > 1) {
				db.UpdateTopping();
			}else {
			db.Addtopping();//sale�� �� �߰�
			}
			toppingselec.setVisible(false);
		}
		if(e.getSource() == jb.get(4)) {//��� �߰�
			db = new DBDao();
			db.SelectT("toppingselec", 4);
			Menu.p6list.add("������� �߰� +500��");
			Menu.sum += topp;
			Menu.sumText();
			Menu.tp4 += 1;
			if(Menu.tp4 > 1) {
				db.UpdateTopping();
			}else {
			db.Addtopping();//sale�� ��� �߰�
			}
			toppingselec.setVisible(false);
		}
	}
}
