package take;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Takefood extends Network implements ActionListener {
	TakeDB	takedb = new TakeDB();
	JFrame jf;
	JLabel jl1, jl2;
	static int no;
	static JTextField jtf1, jtf2;
	JButton jb;
	JPanel p1, p2;
	
	public Takefood() {
		jf = new JFrame();
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setLayout(null);
		jf.setLocation(550, 300);
		jf.setSize(400, 250);
		Panel1();
		Panel2();
		super.network();
		jf.setVisible(true);
	}
	public void Panel1() {
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 550, 110);
		
		jl1 = new JLabel("�ֹ� ���");
		jl1.setBounds(20, 0, 100, 30);
		
		jtf1 = new JTextField();
		jtf1.setBounds(20, 30, 150, 50);
		jtf1.addActionListener(this);
		
		p1.add(jl1);
		p1.add(jtf1);
		jf.add(p1);
	}
	public void Panel2() {
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(0, 110, 550, 150);
		
		jl2 = new JLabel("��ǰ �ϼ�");
		jl2.setBounds(20, 5, 100, 30);
		
		jtf2 = new JTextField();
		jtf2.setBounds(20, 30, 150, 50);
		jtf2.addActionListener(this);
		
		jb = new JButton("Ȯ��");
		jb.setBounds(250, 30, 100, 50);
		jb.addActionListener(this);
		
		p2.add(jl2);
		p2.add(jtf2);
		p2.add(jb);
		jf.add(p2);
	}
	public static void main(String[] args) {
		new Takefood();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb || e.getSource() == jtf1 || e.getSource() == jtf2) {
			if(jtf1.getText().equals("") && jtf2.getText().equals("")) {
			}else if(jtf1.getText().isEmpty() == false && jtf2.getText().isEmpty() == false){
				JOptionPane.showMessageDialog(null, "�ϳ��� �Է��� �ּ���","���",JOptionPane.ERROR_MESSAGE);
			}
			else if(jtf1.getText().isEmpty() == false) { // �ֹ� ���
				JOptionPane.showMessageDialog(null,"�ֹ� ��Ұ� �Ϸ�Ǿ����ϴ�","��� �Ϸ�",JOptionPane.INFORMATION_MESSAGE );
				int num = Integer.parseInt(jtf1.getText().trim());
				takedb.SelNo(num);
				takedb.ordercancel(Integer.parseInt(jtf1.getText().trim()));
				takedb.ReSetNum(no);
				super.send_message("reset/reset");
				jtf1.setText("");
			} 
			else if(jtf2.getText().isEmpty() == false) { // ��ǰ�ϼ�
				takedb.orderfinish(Integer.parseInt(jtf2.getText().trim()));
				takedb.UpdateSetting("finish");
				super.send_message("last/last");
				jtf2.setText("");
			}
		}
	}

}
