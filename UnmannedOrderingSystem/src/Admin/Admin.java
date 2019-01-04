package Admin;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultTextUI;

public class Admin extends JFrame implements ActionListener {
	public static final int SCREEN_WIDTH = 550;
	public static final int SCREEN_HEIGHT = 740;
	ManagerDB db = new ManagerDB();
	AdminData add = new AdminData();
	static JFrame ad;
	JPanel upper,bottom;
	static JRadioButton today = new JRadioButton("���� �Ǹŷ�");
	static JRadioButton day = new JRadioButton("���� ���");
	static JRadioButton month = new JRadioButton("���� ���");
	static JRadioButton year = new JRadioButton("���� ���");
	JButton back = new JButton("����");
	JButton save = new JButton("��� ����");
	ButtonGroup group = new ButtonGroup();
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	static String days;
	static JLabel date = new JLabel();
	static String sum,amountsum;
	static Calendar cal = Calendar.getInstance(); //���� ��¥
	static Calendar cals = new GregorianCalendar();
	Image icon;
	static Vector c,v,v1,v2,v3,cols,cols1,cols2,cols3;
	static DefaultTableModel model,model1,model2,model3;
	static JTable jTable,jTable1,jTable2,jTable3; static JScrollPane pane,pane1,pane2,pane3;
	public Admin() {
		ad = new JFrame();
		ad.setTitle("��� ����");
		ad.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		ad.setResizable(false);
		ad.setLocation(30, 250);
		ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Upper();
		Center();
		Bottom();
		ad.setVisible(true);
	}
	public void Upper() {
		icon = new ImageIcon(Admin.class.getResource("../images/adminlogo.png")).getImage();
		upper = new JPanel()
		{
			public void paintComponent(Graphics g) {
				g.drawImage(icon,0,0,null);
			}};
		
		upper.setLayout(null);
		upper.setBounds(0, 0, SCREEN_WIDTH, 120);
		today.setBounds(30,0,130,20);
		group.add(today);
		today.setOpaque(false);
		today.addItemListener(new MyItemListener());
		upper.add(today);
		day.setBounds(30, 30, 90, 20);
		group.add(day);
		day.setOpaque(false);
		day.addItemListener(new MyItemListener());
		upper.add(day);
		month.setBounds(30, 60, 90, 20);
		month.addItemListener(new MyItemListener());
		group.add(month);
		month.setOpaque(false);
		month.setBackground(null);
		upper.add(month);
		year.setBounds(30, 90, 90, 20);
		year.addItemListener(new MyItemListener());
		group.add(year);
		year.setOpaque(false);
		year.setBackground(null);
		upper.add(year);
		save.setBounds(410,10,140,20);
		save.addActionListener(this);
		save.setOpaque(false);
		upper.add(save);
		days = ""+cal.get(Calendar.YEAR)+"��" + (cal.get(Calendar.MONTH)+1)+"��"+cal.get(Calendar.DAY_OF_MONTH)+"��";
		date.setText(days);
		date.setBounds(410,40,140,20);
		date.setOpaque(false);
		upper.add(date);
		ad.add(upper);
	}
	public void Center() { 
		
		cols = getColumn();
		model = new DefaultTableModel(c,cols) {
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		jTable = new JTable(model);
		jTable.getTableHeader().setReorderingAllowed(false); // �̵� �Ұ� 
		jTable.getTableHeader().setResizingAllowed(false); // ������Ұ�
		pane = new JScrollPane(jTable);
		pane.setBounds(0, 120, SCREEN_WIDTH, 530);
		pane.setBackground(Color.white);
		ad.add(pane);
	}
	public void Bottom() {
		bottom = new JPanel();
		bottom.setLayout(null);
		bottom.setBounds(0, 650, SCREEN_WIDTH, 90);
		bottom.setBackground(Color.white);
		back.setBounds(220, 660, 80, 40);
		bottom.add(back);
		back.addActionListener(this);
		ad.add(bottom);
	}
	public Vector getColumn() {
		Vector col = new Vector();
			col.add("�޴�");
			col.add("����");
			col.add("����");	
		return col;
	}
	public Vector getDays() {
		Vector col = new Vector();
		col.add("����");
		col.add("����");
		col.add("�Ǹŷ�");
		return col;
	}
	public Vector getMonth() {
		Vector col = new Vector();
		col.add("��");
		col.add("����");
		col.add("�Ǹŷ�");
		return col;
	}
	public Vector getYear() {
		Vector col = new Vector();
		col.add("����");
		col.add("����");
		col.add("�Ǹŷ�");
		return col;
	}
	public void getSum() {  // ���� ���� �޼ҵ�
		int sum = 0;
		int amount = 0; int gamount = 0;
		int gsum = 0;
		int asum = 0;
		if(today.isSelected()) {
		for(int i = 0; i < jTable.getRowCount(); i++) {
			sum = Integer.parseInt(jTable.getValueAt(i, 1).toString());
			amount = Integer.parseInt(jTable.getValueAt(i, 2).toString());
			gsum = sum * amount;
			asum = asum + gsum;
			gamount = gamount + amount;
		}	
		}else if(day.isSelected()) {
			for(int i = 0; i < jTable1.getRowCount(); i++) {
				sum = sum + Integer.parseInt(jTable1.getValueAt(i, 1).toString());
				amount = amount + Integer.parseInt(jTable1.getValueAt(i, 2).toString());
				asum = sum;
				gamount = amount;
			}
		}else if(month.isSelected()) {
			for(int i = 0; i < jTable2.getRowCount(); i++) {
				sum = sum + Integer.parseInt(jTable2.getValueAt(i, 1).toString());
				amount = amount + Integer.parseInt(jTable2.getValueAt(i, 2).toString());
				asum = sum;
				gamount = amount;
			}
		}
		this.sum = Integer.toString((asum));
		this.amountsum = Integer.toString(gamount);
	}
	void GetModel() {  // �Ϸ����
		v = db.AlList();
		cols = getColumn();
		model = new DefaultTableModel(v,cols) {
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		jTable = new JTable(model);
		jTable.getTableHeader().setReorderingAllowed(false); // �̵� �Ұ� 
		jTable.getTableHeader().setResizingAllowed(false); // ������Ұ�
		pane = new JScrollPane(jTable);
		pane.setBounds(0, 120, SCREEN_WIDTH, 530);
		pane.setBackground(Color.white);
		ad.add(pane);
	}
	void GetModel1() {  // �ϸ���
			v1 = db.DayList();
			cols1 = getDays();
			model1 = new DefaultTableModel(v1, cols1) {
				public boolean isCellEditable(int row,int column) {
					return false;
				}
			};
			jTable1 = new JTable(model1);
			jTable1.getTableHeader().setReorderingAllowed(false); // �̵� �Ұ� 
			jTable1.getTableHeader().setResizingAllowed(false); // ������Ұ�
			pane = new JScrollPane(jTable1);
			pane.setBounds(0, 120, SCREEN_WIDTH, 530);
			pane.setBackground(Color.white);
			ad.add(pane);
	}
	void GetModel2() {  // ������
		v2 = db.MonthList();
		cols2 = getMonth();
		model2 = new DefaultTableModel(v2, cols2) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jTable2 = new JTable(model2);
		jTable2.getTableHeader().setReorderingAllowed(false); // �̵� �Ұ� 
		jTable2.getTableHeader().setResizingAllowed(false); // ������Ұ�
		pane = new JScrollPane(jTable2);
		pane.setBounds(0, 120, SCREEN_WIDTH, 530);
		pane.setBackground(Color.white);
		ad.add(pane);
	}
	void GetModel3() {  //  ������
		v3 = db.YearList();
		cols3 = getYear();
		model3 = new DefaultTableModel(v3, cols3) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jTable3 = new JTable(model3);
		jTable3.getTableHeader().setReorderingAllowed(false); // �̵� �Ұ� 
		jTable3.getTableHeader().setResizingAllowed(false); // ������Ұ�
		pane = new JScrollPane(jTable3);
		pane.setBounds(0, 120, SCREEN_WIDTH, 530);
		pane.setBackground(Color.white);
		ad.add(pane);
	
	}
	
	class MyItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
		if(today.isSelected()) {
			GetModel();
		}else if(day.isSelected()) {
				GetModel1();
		}else if(month.isSelected()) {
			GetModel2();
		}else if(year.isSelected()) {
			GetModel3();
		}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			ad.setVisible(false);
		}else if(e.getSource() == save) {
			if(day.isSelected()) {
				if(cal.get(Calendar.DAY_OF_MONTH) == cal.getActualMaximum(Calendar.DATE)) {
					getSum();
					db.InsertMonth();
					db.DeleteSettle("dsale");
					db.AlterAI("dsale");
					JOptionPane.showMessageDialog(null, "���� ����� ����Ǿ����ϴ�.", "�˸�!", JOptionPane.INFORMATION_MESSAGE);
					day.setSelected(false);
					Center();
				}else {
					JOptionPane.showMessageDialog(null, "���� ���� ��� �Ⱓ�� �ƴմϴ�.", "���!", JOptionPane.ERROR_MESSAGE);
					getSum();
					db.InsertMonth();
					db.DeleteSettle("dsale");
					db.AlterAI("dsale");
					day.setSelected(false);
					Center();
					sum = Integer.toString(0); amountsum = Integer.toString(0);
				}
			}else if(month.isSelected()) {
				if(cal.get(Calendar.YEAR) == 12) {
					getSum();
					db.InsertYear();
					db.DeleteSettle("msale");
					db.AlterAI("msale");
					JOptionPane.showMessageDialog(null, "���� ����� �Ϸ�Ǿ����ϴ�.", "�˸�!", JOptionPane.INFORMATION_MESSAGE);
					month.setSelected(false);
					Center();
					sum = Integer.toString(0); amountsum = Integer.toString(0);
				}else {
					JOptionPane.showMessageDialog(null, "���� ���� ��� �Ⱓ�� �ƴմϴ�.", "���!", JOptionPane.ERROR_MESSAGE);
					month.setSelected(false);
				}
			}else if(year.isSelected()) {
				JOptionPane.showMessageDialog(null,"�������� �ʴ� ����Դϴ�.", "Error!",JOptionPane.ERROR_MESSAGE);
				year.setSelected(false);
			}else if(today.isSelected()) {
			getSum();
			db.InsertDay();
			db.ResetOrders();
			model.fireTableDataChanged();
			jTable.repaint();
			JOptionPane.showMessageDialog(null, "���� ���� ���� ����� ����Ǿ����ϴ�. \n ���̻� ������ �Ұ��� �մϴ�.", "�˸�!", JOptionPane.INFORMATION_MESSAGE);
			cals.add(Calendar.DATE, 1);
			today.setEnabled(false);
			today.setSelected(false);
			Center();
			sum = Integer.toString(0); amountsum = Integer.toString(0);
		}
			}

	}
}
