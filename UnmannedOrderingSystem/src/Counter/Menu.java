package Counter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener {

	static final int SCREEN_WIDTH = 720;
	static final int SCREEN_HEGIHT = 960;
	static DBDao db;
	static Data data;
	static Drinkselec drinkselec;
	static JFrame menu;
	private Image p2i1, p2i2, p2i3, p2i4, p3i1, p3i2, p3i3, p3i4, p4i1, p4i2, p4i3, p4i4, p5i1, p5i2, p5i3, p5i4,p6i1;
	static JLabel p6l1;
	static JButton p6b1, p6b2, p6b3;
	private JPanel chbtn, set, single, sidefd, drink, p6;
	static List p6list;
	static int i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16;
	static int dr1,dr2,dr3,dr4,dr5,dr6,dr7,dr8,tp1,tp2,tp3,tp4;  // ���ắ�� �� �����߰� ī��Ʈ
	Font btfn = new Font("���", Font.BOLD, 28);
	Font lstfn = new Font("���", Font.BOLD, 17);
	static String dm, am;
	static int dp, p6l1s1, p6l1s2, ab;
	static int sum = 0;
	Topping topping;
	static Image isets = new ImageIcon(Start.class.getResource("../images/set.png")).getImage();
	static Image isingle = new ImageIcon(Start.class.getResource("../images/burger.png")).getImage();
	static Image iside = new ImageIcon(Start.class.getResource("../images/side.png")).getImage();
	static Image idrink = new ImageIcon(Start.class.getResource("../images/drink.png")).getImage();
	static Image ihome = new ImageIcon(Start.class.getResource("../images/Ȩ.png")).getImage();
	
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
	public Menu() {
		menu = new JFrame();
//		menu.setUndecorated(true); //�޴��� ���ֱ�
		menu.setTitle("Menu");
		menu.setResizable(false);
		menu.setSize(SCREEN_WIDTH, SCREEN_HEGIHT);
		menu.setLocation(550, 50);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel1();
		Panel2();
		Panel3();
		Panel4();
		Panel5();
		Panel6();
		menu.setVisible(true);
	}
	public void Panel1() { // �޴� ���ù�ư
		chbtn = new JPanel();
		chbtn.setLayout(null);
		chbtn.setBounds(0, 0, 720, 120);
		chbtn.setBackground(Color.white);
		CreateButton(0, new ImageIcon(isets), 0, 0, 154, 120, chbtn);
		CreateButton(1, new ImageIcon(isingle), 154, 0, 154, 120, chbtn);
		CreateButton(2, new ImageIcon(iside), 308, 0, 154, 120, chbtn);
		CreateButton(3, new ImageIcon(idrink), 462, 0, 154, 120, chbtn);
		CreateButton(4, new ImageIcon(ihome), 615, 0, 103, 120, chbtn);
		
		menu.add(chbtn);
	}

	public void Panel2() { //��Ʈ �г�
		set = new JPanel();
		set.setLayout(null);
		set.setBounds(0, 120, 720, 645);
		set.setBackground(Color.white);
		p2i1 = new ImageIcon(Start.class.getResource("../images/�Ұ�⼼Ʈ.png")).getImage();
		p2i2 = new ImageIcon(Start.class.getResource("../images/���켼Ʈ.png")).getImage();
		p2i3 = new ImageIcon(Start.class.getResource("../images/ġ�Ʈ.png")).getImage();
		p2i4 = new ImageIcon(Start.class.getResource("../images/ġŲ��Ʈ.png")).getImage();
		
		CreateButton(5, new ImageIcon(p2i1), 20, 30, 320, 250, set);
		CreateButton(6, new ImageIcon(p2i2), 370, 30, 320, 250, set);
		CreateButton(7, new ImageIcon(p2i3), 20, 335, 320, 250, set);
		CreateButton(8, new ImageIcon(p2i4), 370, 335, 320, 250, set);
		
		CreateLabel(0, "<html>�Ұ����ż�Ʈ<br> 5000��</html>", 130, 280, 150, 40, set);
		CreateLabel(1, "<html>������ż�Ʈ<br> 5500��</html>", 485, 280, 150, 40, set);
		CreateLabel(2, "<html>ġ����ż�Ʈ<br> 5000��</html>", 130, 585, 150, 40, set);
		CreateLabel(3, "<html>ġŲ���ż�Ʈ<br> 5500��</html>", 485, 585, 150, 40, set);
		
		menu.add(set);
	}
	public void Panel3() { // ��ǰ �г�
		single = new JPanel();
		single.setLayout(null);
		single.setBounds(0, 120, 720, 645);
		single.setBackground(Color.white);
		p3i1 = new ImageIcon(Start.class.getResource("../images/�Ұ�����.png")).getImage();
		p3i2 = new ImageIcon(Start.class.getResource("../images/�������.jpg")).getImage();
		p3i3 = new ImageIcon(Start.class.getResource("../images/ġ�����.png")).getImage();
		p3i4 = new ImageIcon(Start.class.getResource("../images/ġŲ����.png")).getImage();
		
		CreateButton(9, new ImageIcon(p3i1), 20, 30, 320, 250, single);
		CreateButton(10, new ImageIcon(p3i2), 370, 30, 320, 250, single);
		CreateButton(11, new ImageIcon(p3i3), 20, 335, 320, 250, single);
		CreateButton(12, new ImageIcon(p3i4), 370, 335, 320, 250, single);
		
		CreateLabel(4, "<html>�Ұ�����<br>3000��</html>", 130, 280, 150, 40, single);
		CreateLabel(5, "<html>�������<br>3500��</html>", 485, 280, 150, 40, single);
		CreateLabel(6, "<html>ġ�����<br>3000��</html>", 130, 585, 150, 40, single);
		CreateLabel(7, "<html>ġŲ����<br>3500��</html>", 485, 585, 150, 40, single);
		
		single.setVisible(false);
		menu.add(single);
	}
	public void Panel4() { // ���̵� �г�
		sidefd = new JPanel();
		sidefd.setLayout(null);
		sidefd.setBounds(0, 120, 720, 645);
		sidefd.setBackground(Color.white);
		p4i1 = new ImageIcon(Start.class.getResource("../images/ġ�ƽ.jpg")).getImage();
		p4i2 = new ImageIcon(Start.class.getResource("../images/ġŲ��.jpg")).getImage();
		p4i3 = new ImageIcon(Start.class.getResource("../images/������.jpg")).getImage();
		p4i4 = new ImageIcon(Start.class.getResource("../images/����Ƣ��.jpg")).getImage();
		
		CreateButton(13, new ImageIcon(p4i1), 20, 30, 320, 250, sidefd);
		CreateButton(14, new ImageIcon(p4i2), 370, 30, 320, 250, sidefd);
		CreateButton(15, new ImageIcon(p4i3), 20, 335, 320, 250, sidefd);
		CreateButton(16, new ImageIcon(p4i4), 370, 335, 320, 250, sidefd);
		
		CreateLabel(8, "<html>ġ�ƽ<br>1500��</html>", 130, 280, 150, 40, sidefd);
		CreateLabel(9, "<html>ġŲ ��<br>2500��</html>", 485, 280, 150, 40, sidefd);
		CreateLabel(10, "<html>������<br>2000��</html>", 130, 585, 150, 40, sidefd);
		CreateLabel(11, "<html>����Ƣ��<br>1000��</html>", 485, 585, 150, 40, sidefd);
	
		sidefd.setVisible(false);
		menu.add(sidefd);
	}
	public void Panel5() { //���� �г�
		drink = new JPanel();
		drink.setLayout(null);
		drink.setBounds(0, 120, 720, 645);
		drink.setBackground(Color.white);
		p5i1 = new ImageIcon(Start.class.getResource("../images/�ݶ�.jpg")).getImage();
		p5i2 = new ImageIcon(Start.class.getResource("../images/��������Ʈ.jpg")).getImage();
		p5i3 = new ImageIcon(Start.class.getResource("../images/ȯŸ.png")).getImage();
		p5i4 = new ImageIcon(Start.class.getResource("../images/�Ƹ޸�ī��.jpg")).getImage();
		
		CreateButton(17, new ImageIcon(p5i1), 20, 30, 320, 250, drink);
		CreateButton(18, new ImageIcon(p5i2), 370, 30, 320, 250, drink);
		CreateButton(19, new ImageIcon(p5i3), 20, 335, 320, 250, drink);
		CreateButton(20, new ImageIcon(p5i4), 370, 335, 320, 250, drink);
		
		CreateLabel(12, "<html>�ݶ�<br>1000��</html>", 130, 280, 150, 40, drink);
		CreateLabel(13, "<html>��������Ʈ<br>1000��</html>", 485, 280, 150, 40, drink);
		CreateLabel(14, "<html>ȯŸ<br>1000��</html>", 130, 585, 150, 40, drink);
		CreateLabel(15, "<html>�Ƹ޸�ī��<br>1000��</html>", 485, 585, 150, 40, drink);
		
		drink.setVisible(false);
		menu.add(drink);
	}
	public void Panel6() { // ��� �г�
		p6 = new JPanel();
		p6.setLayout(null);
		p6.setBounds(0, 775, 720, 400);
		p6i1 = new ImageIcon(Start.class.getResource("../images/����.png")).getImage();
		p6list = new List(6);
		p6list.setBounds(10, 812, 300, 120);
		p6list.setBackground(Color.gray);

		p6b1 = new JButton(new ImageIcon(p6i1));
		p6b1.setBounds(415, 812, 299, 120);
		p6b1.addActionListener(this);
		p6b1.setBackground(Color.LIGHT_GRAY);

		p6l1 = new JLabel("<html> <font size=7><b>���� : 0�� || �ݾ� : 0��</b></font></html>");
		p6l1.setBounds(140, 760, 510, 40);

		p6b2 = new JButton("<html> <font size=3><b> ���� ��� </b></font></html>");
		p6b2.setBounds(310, 812, 105, 60);
		p6b2.setBorderPainted(false);
		p6b2.setEnabled(false);
		p6b2.addActionListener(this);

		p6b3 = new JButton("<html><font size=3><b> ��ü ��� </b></font></html>");
		p6b3.setBounds(310, 872, 105, 60);
		p6b3.setBorderPainted(false);
		p6b3.setEnabled(false);
		p6b3.addActionListener(this);

		p6list.setFont(lstfn);

		p6.add(p6b2);
		p6.add(p6b3);
		p6.add(p6l1);
		p6.add(p6list);
		p6.add(p6b1);

		p6.setBackground(Color.WHITE);
		menu.add(p6);
	}
	static boolean Delete(String a) { // ���� ��� ���� �޼ҵ�
		return p6list.getSelectedItem().indexOf(a) > -1;
	}

	static void DoNotDelete() {
		int lt = p6list.getSelectedIndex();
		String str1 = p6list.getItem(lt);
		if(str1.indexOf("�ݶ�L")>-1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("��������ƮL") >-1){
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("ȯŸL") >-1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("�Ƹ޸�ī��L") >-1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("���� �ݶ�") > -1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("���� ��������Ʈ") > -1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("���� ȯŸ") > -1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("���� �Ƹ޸�ī��") > -1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("����������")>-1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("ġ������")>-1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("������")>-1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("�������")>-1) {
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else if(str1.indexOf("��ä �߰�")>-1){
			JOptionPane.showMessageDialog(null, "�߰� �� ������ ��ǰ�� ���� ����� �� �����ϴ�.","�˸�!",JOptionPane.ERROR_MESSAGE);
		}else{
			Delete();
			p6list.remove(p6list.getSelectedIndex());
		}
	}
	static void DeleteDr() {
		ab = p6list.getSelectedIndex()+1;
		if(ab == p6list.getItemCount()) {
			sum -=0;
		}else {
		String str = p6list.getItem(ab);
		if(str.indexOf("�ݶ�L")>-1) {
			sum = sum -300;	p6list.remove(ab);
			dr2 -=1; am = "�ݶ�(SetL)";
			if(dr2 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("��������ƮL") >-1){
			sum = sum -300;	p6list.remove(ab);
			dr4 -=1; am = "��������Ʈ(SetL)";
			if(dr4 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("ȯŸL") >-1) {
			sum = sum -300;	p6list.remove(ab);
			dr6 -=1; am = "ȯŸ(SetL)";
			if(dr6 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("�Ƹ޸�ī��L") >-1) {
			sum = sum -300;	p6list.remove(ab);
			dr8 -=1; am = "�Ƹ޸�ī��(SetL)";
			if(dr8 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("�ݶ�") > -1) {
			sum = sum -0;	p6list.remove(ab);
			dr1 -=1; am = "�ݶ�(Set)";
			if(dr1 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("��������Ʈ") > -1) {
			sum = sum -0;	p6list.remove(ab);
			dr3 -=1; am = "��������Ʈ(Set)";
			if(dr3 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("ȯŸ") > -1) {
			sum = sum -0;	p6list.remove(ab);
			dr5 -=1; am = "ȯŸ(Set)";
			if(dr5 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("�Ƹ޸�ī��") > -1) {
			sum = sum -0;	p6list.remove(ab);
			dr7 -=1; am = "�Ƹ޸�ī��(Set)";
			if(dr7 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("����������")>-1) {
			sum = sum - 500;	p6list.remove(ab);
			tp1 -=1; am = "������";
			if(tp1 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("ġ������")>-1) {
			sum = sum - 500;	p6list.remove(ab);
			tp2 -=1; am = "ġ��";
			if(tp2 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("������")>-1) {
			sum = sum - 500;	p6list.remove(ab);
			tp3 -=1; am = "��";
			if(tp3 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("�������")>-1) {
			sum = sum - 500;	p6list.remove(ab);
			tp4 -=1; am = "���";
			if(tp4 == 0) {
				db.AddDeleteSelect();
			}else {
			db.AddUpdateSelect();
			}
		}else if(str.indexOf("��ä �߰�")>-1){
			p6list.remove(ab);
		}else{
		
			sum = sum - 0;
		}
	}
}
	static void Delete() { // ���� ���� �޼ҵ�
		db = new DBDao();
		if (Delete("�Ұ����ż�Ʈ")) {
			sum = sum - 5000;
			i1 = i1 - 1;
			dm = "�Ұ����ż�Ʈ"; 
			DeleteDr();
			if(i1 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			sumText();
		} else if (Delete("������ż�Ʈ")) {
			sum = sum - 5500;
			i2 = i2-1;
			dm = "������ż�Ʈ";
			DeleteDr();
			if(i2 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			sumText();
		} else if (Delete("ġ����ż�Ʈ")) {
			sum = sum - 5000;
			i3 = i3-1;
			dm = "ġ����ż�Ʈ";
			DeleteDr();
			if(i3 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			sumText();
		} else if (Delete("ġŲ���ż�Ʈ")) {
			sum = sum - 5500;
			i4 -=1;
			dm = "ġŲ���ż�Ʈ";
			DeleteDr();
			if(i4 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			sumText();
		} else if (Delete("�Ұ�����")) {
			sum = sum - 3000;
			i5 -=1;
			dm = "�Ұ�����";
			DeleteDr();
			if(i5 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			sumText();
		} else if (Delete("�������")) {
			sum = sum - 3500;
			i6 -=1;
			dm = "�������";DeleteDr(); 
			if(i6 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		} else if (Delete("ġ�����")) {
			sum = sum - 3000;
			i7 -= 1;
			dm = "ġ�����";DeleteDr();
			if(i7 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		} else if (Delete("ġŲ����")) {
			sum = sum - 3500;
			i8 -= 1;
			dm = "ġŲ����";DeleteDr();
			if(i8 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		} else if (Delete("ġ�ƽ")) {
			sum = sum - 1500;
			i9 -= 1;
			dm = "ġ�ƽ";
			if(i9 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		} else if (Delete("ġŲ ��")) {
			sum = sum - 2500;
			i10 -= 1;
			dm = "ġŲ ��";
			if(i10 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		} else if (Delete("������")) {
			sum = sum - 2000 ;
			i11 -= 1;
			dm = "������";
			if(i11 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		} else if (Delete("����Ƣ��")) {
			sum = sum - 1000;
			i12 -= 1;
			dm = "����Ƣ��";
			if(i12 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		} else if (Delete("�ݶ�")) {
			sum = sum - 1000;
			i13 -=1;
			dm = "�ݶ�";
			if(i13 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		} else if (Delete("��������Ʈ")) {
			sum = sum - 1000;
			i14 -= 1;
			dm = "��������Ʈ";
			if(i14 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		} else if (Delete("ȯŸ")) {
			sum = sum - 1000;
			i15 -=1;
			dm = "ȯŸ";
			if(i15 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		} else if (Delete("�Ƹ޸�ī��")) {
			sum = sum -1000;
			i16 -= 1;
			dm = "�Ƹ޸�ī��";
			if(i16 == 0) {
				db.DeleteSelec();
			}else {
			db.UpdateSelec();
			}
			 sumText();
		}
	}
	static void DeleteAll() { // ��ü ���� �޼ҵ�
		sum = 0;
		i1 = 0; dr1 = 0;
		i2 = 0; dr2 = 0;
		i3 = 0; dr3 = 0;
		i4 = 0; dr4 = 0;
		i5 = 0; dr5 = 0;
		i6 = 0; dr6 = 0;
		i7 = 0; dr7 = 0;
		i8 = 0; dr8 = 0;
		i9 = 0; tp1 = 0;
		i10 = 0; tp2 = 0;
		i11 = 0; tp3 = 0;
		i12 = 0; tp4 = 0;
		i13 = 0;
		i14 = 0;
		i15 = 0;
		i16 = 0;
		Drinkselec.drip = 0;
	}
	static void allSum() { // �Ѱ� �޼ҵ�
		dm = data.getMenu();
		dp = data.getPrice();
		p6b2.setEnabled(true);
		p6b3.setEnabled(true);
		sum = sum + dp;
	}
	static void sumText() { // ���� �� ���� ��� ��� �޼ҵ�
		p6l1s1 = i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16;
		p6l1s2 = sum;
		p6l1.setText("<html> <font size=7><b>���� : "+p6l1s1+" || �ݾ� : "+sum+"��</b></font></html>");
		dp = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ��� �޴� ��ư �̺�Ʈ
		if (e.getSource() == jb.get(0)) { //��Ʈ
			set.setVisible(true);
			single.setVisible(false);
			sidefd.setVisible(false);
			drink.setVisible(false);
		} else if (e.getSource() == jb.get(1)) { //��ǰ
			set.setVisible(false);
			single.setVisible(true);
			sidefd.setVisible(false);
			drink.setVisible(false);
		} else if (e.getSource() == jb.get(2)) { //���̵�
			set.setVisible(false);
			single.setVisible(false);
			sidefd.setVisible(true);
			drink.setVisible(false);
		} else if (e.getSource() == jb.get(3)) { // ����
			set.setVisible(false);
			single.setVisible(false);
			sidefd.setVisible(false);
			drink.setVisible(true);
		} else if (e.getSource() == jb.get(4)) { // Ȩ
			Start main = new Start();
			menu.setVisible(false);
			DeleteAll();
		} else if (e.getSource() == p6b1) {
			try {
				new Seat();
				Start.ck = 2;
				Seat.back.setVisible(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// ���� ���� ��ư �̺�Ʈ
		if (e.getSource() == jb.get(5)) { // �Ұ����� ��Ʈ
			db = new DBDao();
			drinkselec = new Drinkselec();
			data = db.SelectM("sets", 1);
			allSum();
				++i1;
				p6list.add("" + dm + "      " + dp + "��      1��");

			if(i1 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}			sumText();
		}
		if (e.getSource() == jb.get(6)) { // ������� ��Ʈ
			db = new DBDao();
			drinkselec = new Drinkselec();
			data = db.SelectM("sets", 2);
			allSum();
			++i2;
				p6list.add("" + dm + "          " + dp + "��      1��");
			if(i2 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}			sumText();
		}
		if (e.getSource() == jb.get(7)) { // ġ����� ��Ʈ
			db = new DBDao();
			drinkselec = new Drinkselec();
			data = db.SelectM("sets", 3);
			allSum();
				i3 += 1;
				p6list.add("" + dm + "          " + dp + "��      1��");
			if(i3 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}			sumText();
		}
		if (e.getSource() == jb.get(8)) { // ġŲ���� ��Ʈ
			db = new DBDao();
			drinkselec = new Drinkselec();
			data = db.SelectM("sets", 4);
			allSum();
				i4 += 1;
				p6list.add("" + dm + "          " + dp + "��      1��");
			if(i4 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(9)) { // �Ұ�� ����
			db = new DBDao();
			topping = new Topping();
			data = db.SelectM("single", 1);
			allSum();
				i5 += 1;
				p6list.add("" + dm + "             " + dp + "��      1��");
			if(i5 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(10)) { // ���� ����
			db = new DBDao();
			topping = new Topping();
			data = db.SelectM("single", 2);
			allSum();
				i6 += 1;
				p6list.add("" + dm + "                 " + dp + "��      1��");
			if(i6 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(11)) { // ġ�� ����
			db = new DBDao();
			topping = new Topping();
			data = db.SelectM("single", 3);
			sum = sum + dp;
			allSum();
				i7 += 1;
				p6list.add("" + dm + "                 " + dp + "��      1��");
			if(i7 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(12)) { // ġŲ ����
			db = new DBDao();
			topping = new Topping();
			data = db.SelectM("single", 4);
			sum = sum + dp;
			allSum();
				i8 += 1;
				p6list.add("" + dm + "                 " + dp + "��      1��");
			if(i8 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(13)) { // ġ�ƽ
			db = new DBDao();
			data = db.SelectM("side", 1);
			allSum();
				i9 += 1;
				p6list.add("" + dm + "                 " + dp + "��      1��");
			if(i9 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(14)) { // ġŲ ��
			db = new DBDao();
			data = db.SelectM("side", 2);
			allSum();
				i10 += 1;
				p6list.add("" + dm + "                     " + dp + "��      1��");
			if(i10 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(15)) { // ������
			db = new DBDao();
			data = db.SelectM("side", 3);
			allSum();
				i11 += 1;
				p6list.add("" + dm + "                     " + dp + "��      1��");
			if(i11 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(16)) { // ����Ƣ��
			db = new DBDao();
			data = db.SelectM("side", 4);
			allSum();
				i12 += 1;
				p6list.add("" + dm + "                 " + dp + "��      1��");
			if(i12 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		} // ���̵�
		if (e.getSource() == jb.get(17)) { // �ݶ�
			db = new DBDao();
			data = db.SelectM("drink", 1);
			allSum();
				i13 += 1;
				p6list.add("" + dm + "                        " + dp + "��      1��");
			if(i13 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(18)) { // ��������Ʈ
			db = new DBDao();
			data = db.SelectM("drink", 2);
			allSum();
				i14 += 1;
				p6list.add("" + dm + "             " + dp + "��      1��");
			if(i14 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(19)) { // ȯŸ
			db = new DBDao();
			data = db.SelectM("drink", 3);
			allSum();
				i15 += 1;
				p6list.add("" + dm + "                        " + dp + "��      1��");
			if(i15 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == jb.get(20)) { // �Ƹ޸�ī��
			db = new DBDao();
			data = db.SelectM("drink", 4);
			allSum();
				i16 += 1;
				p6list.add("" + dm + "             " + dp + "��      1��");
			if(i16 > 1) {
				db.UpdateAmount();
			}else {
				db.InsertInto();	
			}sumText();
		}
		if (e.getSource() == p6b2) { // ���� ��� �̺�Ʈ
			try {
				DoNotDelete();
			} catch (Exception e1) {
			}
		} else if (e.getSource() == p6b3) { // ��ü ��� �̺�Ʈ
			try {
				db = new DBDao();
				DeleteAll();
				db.DeleteAll();
				sumText();
				p6list.removeAll();
				p6b2.setEnabled(false);
				p6b3.setEnabled(false);
			} catch (Exception e1) {
			}
		}

	}
}