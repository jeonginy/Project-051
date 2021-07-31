import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Getout extends JDialog{
	private Files io;
	
	public Getout() throws ParseException {
	io = new Files();
	List<JTextField> listInfor = new ArrayList<>();
	
	setTitle("회원탈퇴");
	// 타이틀
	JLabel title = new JLabel("회원탈퇴", JLabel.CENTER);
	title.setForeground(Color.BLACK);
	title.setFont(new Font("Dialog", Font.BOLD, 30));
	
	//빈칸넣기
	JLabel bk = new JLabel();
	bk.setPreferredSize(new Dimension(85, 30));

	JLabel bk1 = new JLabel();
	bk1.setPreferredSize(new Dimension(85, 30));

	JLabel bk2 = new JLabel();
	bk2.setPreferredSize(new Dimension(85, 30));
	//메인패널
	JPanel mainpnl = new JPanel();
	mainpnl.setLayout(new BoxLayout(mainpnl, BoxLayout.Y_AXIS));
	
	//아이디
	JPanel pnlID = new JPanel();
	JLabel lblID = new JLabel("아이디");
	JTextField tfID = new JTextField(15);
	pnlID.setLayout(new FlowLayout(FlowLayout.RIGHT));
	pnlID.add(lblID);
	pnlID.add(tfID);
	
	//비밀번호
	JPanel pnlPW = new JPanel();
	JLabel lblPW = new JLabel("비밀번호");
	JPasswordField pfPW = new JPasswordField(15);
	pnlPW.setLayout(new FlowLayout(FlowLayout.RIGHT));
	pnlPW.add(lblPW);
	pnlPW.add(pfPW);
	
	//핸드폰번호
	JPanel pnlPN = new JPanel();
	MaskFormatter formatterPhone = new MaskFormatter("010-####-####");
	formatterPhone.setPlaceholderCharacter('*');
	JLabel lblPN = new JLabel("연락처");
	JFormattedTextField tfPN = new JFormattedTextField(formatterPhone);
	pnlPN.setLayout(new FlowLayout(FlowLayout.RIGHT));
	tfPN.setColumns(15);
	pnlPN.add(lblPN);
	pnlPN.add(tfPN);
	
	JPanel pnlbtn = new JPanel();
	JButton btnOK = new JButton("확인");
	pnlbtn.add(btnOK);
	
	btnOK.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			List<String> right = new ArrayList<>();
			right = io.load();
			String [] getInf = new String[3];
			String [] getId = new String[right.size()];
			String [] getPw = new String[right.size()];
			String [] getPn = new String[right.size()];
			
			for (int i = 0; i < right.size(); i++) {
				getInf = right.get(i).split(",");
				getId[i] = getInf[0];
				getPw[i] = getInf[1];
				getPn[i] = getInf[2];
				
			}
			int a = 0;
			for (int i = 0; i < getId.length; i++) {
				if(!tfID.getText().equals(getId[i])) {
					a++;
				}else {
					break;
				}
			}
			if(tfID.getText().isEmpty()) {
				JOptionPane.showMessageDialog(Getout.this, "아이디를 입력해주세요 '◡' ");
			}else if(a == getId.length) {
				JOptionPane.showMessageDialog(Getout.this, "존재하지 않는 아이디예요 ,, (꒪⌓꒪)");
			}else if(!new String(pfPW.getPassword()).equals(getPw[a])) {
				JOptionPane.showMessageDialog(Getout.this, "비밀번호 오류입니다 (⍥)");
			}else {
				List<String> list = new ArrayList<>();
				String line = tfID.getText() + "," + pfPW.getText()	 + "," + tfPN.getText();
				list = io.searchbye(line);
				io.infsave(list);
				JOptionPane.showMessageDialog(Getout.this, 
						"우리의 인연에 감사했습니다\n안녕히가세요,,\n༼ ༎ຶ ۝ ༎ຶ༽");
				dispose();
			}
		}
	});
	
	pnlID.add(bk);
	pnlPW.add(bk1);
	pnlPN.add(bk2);
	
	
	mainpnl.add(pnlID);
	mainpnl.add(pnlPW);
	mainpnl.add(pnlPN);
	mainpnl.add(pnlbtn);
	
	add(mainpnl, BorderLayout.CENTER);
	add(title, BorderLayout.NORTH);
	add(pnlbtn, BorderLayout.SOUTH);
	
	
	showGUI();
	}
	
	private void showGUI() {
		pack();
		setVisible(true);
		
	}


}
