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
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

class JTextFieldLimit extends PlainDocument {
	private int limit;
	private boolean toUppercase = false;

	JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}

	JTextFieldLimit(int limit, boolean upper) {
		super();
		this.limit = limit;
		this.toUppercase = upper;
	}

	public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException {
		if (str == null) {
			return;
		}
		if ((getLength() + str.length()) <= limit) {
			if (toUppercase) {
				str = str.toUpperCase();
			}
			super.insertString(offset, str, attr);
		}
	}
}

public class SignUp extends JDialog {

	// 아이디 특수문자 불포함 메소드
	public int checkIDMethod(String id) {
		int check = 0;
		char alpha;
		int code;
		for (int i = 0; i < id.length(); i++) {
			alpha = id.charAt(i);
			code = (int) alpha;
			if (code >= 0 && code <= 47 || code >= 58 && code <= 63 || code >= 91 && code <= 96
					|| code >= 123 && code <= 127) {
				check = 1;
			}
		}
		return check;
	}
	// 비밀번호 특수문자 포함 메소드
//	public int checkPWDMethod(String pwd) {
//		int check= 0;
//		char alpha;
//		int code;
//		for(int i=0; i<pwd.length(); i++) {
//			alpha = pwd.charAt(i);
//			code = (int)alpha;
//			if(code>=0 && code<=32 || code>=36 && code<=47 || code>=58 && code<=63 || code>=91 && code <=96 || code>=123 && code <= 127) {
//				check = 1;
//				
//			}
//		}
//		return check;
//	}

	public int checkPWDMethod(String pwd) {
		int check = 0;
		char alpha;
		int code;
		for (int i = 0; i < pwd.length(); i++) {
			alpha = pwd.charAt(i);
			code = (int) alpha;
			if (code >= 0 && code <= 32 || code >= 36 && code <= 47 || code >= 58 && code <= 63
					|| code >= 91 && code <= 96 || code >= 123 && code <= 127) {
				check = 1;
			}
		}
		return check;
	}

	private Files io;

	public SignUp() throws ParseException {
		io = new Files();
		List<JTextField> listInfor = new ArrayList<>();
		setTitle("회원가입");

		// 타이틀
		JLabel title = new JLabel("회원가입", JLabel.CENTER);
		title.setForeground(Color.GRAY);
		title.setFont(new Font("휴먼편지체", Font.BOLD, 30));

		// 빈칸넣기
		JLabel bk = new JLabel();
		bk.setPreferredSize(new Dimension(85, 30));

		JLabel bk1 = new JLabel();
		bk1.setPreferredSize(new Dimension(85, 30));

		JLabel bk2 = new JLabel();
		bk2.setPreferredSize(new Dimension(85, 30));

		// 메인 패널
		JPanel mainpnl = new JPanel();
		mainpnl.setLayout(new BoxLayout(mainpnl, BoxLayout.Y_AXIS));
		mainpnl.setOpaque(true);
		mainpnl.setBackground(Color.magenta);

		// 아이디
		JPanel pnlID = new JPanel();
		JLabel lblID = new JLabel("아이디");
		JTextField tfID = new JTextField(15);
		tfID.setDocument((new JTextFieldLimit(12)));
		pnlID.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlID.add(lblID);
		pnlID.add(tfID);

		// 비밀번호
		JPanel pnlPW = new JPanel();
		JLabel lblPW = new JLabel("비밀번호");
		JPasswordField pfPW = new JPasswordField(15);
		pnlPW.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlPW.add(lblPW);
		pnlPW.add(pfPW);

		// 비밀번호 확인
		JPanel pnlPH = new JPanel();
		JLabel lblPH = new JLabel("비밀번호 확인");
		JPasswordField pfPH = new JPasswordField(15);
		pnlPH.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlPH.add(lblPH);
		pnlPH.add(pfPH);

		// 연락처
		JPanel pnlPN = new JPanel();
		MaskFormatter formatterPhone = new MaskFormatter("010-####-####");
		formatterPhone.setPlaceholderCharacter('*');
		JLabel lblPN = new JLabel("연락처");
//		JTextField tfPN = new JTextField(15);
		JFormattedTextField tfPN = new JFormattedTextField(formatterPhone);
		pnlPN.setLayout(new FlowLayout(FlowLayout.RIGHT));
		tfPN.setColumns(15);
		pnlPN.add(lblPN);
		pnlPN.add(tfPN);

		// 가입,취소,중복
		JPanel joinpnl = new JPanel();
		JButton joinbtn = new JButton("가입");
		JButton joincel = new JButton("취소");
		JButton joinchk = new JButton("중복확인");

		joinbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력한값 받아두는 변수
				int length = listInfor.size();
				String[] infs = new String[length];
				for (int i = 0; i < length; i++) {
					infs[i] = listInfor.get(i).getText();
				}
				// 중복 걸러내는 용도
				List<String> infor = new ArrayList<>();
				infor = io.load();
				String[] getInfor = new String[3]; // 아이디
				String[] getId = new String[infor.size()]; // id받아오기
				String[] getPw = new String[infor.size()]; // 비밀번호 받아오기
				String[] getPN = new String[infor.size()];

				for (int i = 0; i < infor.size(); i++) {
					getInfor = infor.get(i).split(","); // 하나씩
					getId[i] = getInfor[0]; // 아이디넣기
					getPw[i] = getInfor[1]; // 비밀번호 넣기
					getPN[i] = getInfor[2]; // 폰번호
				}
				int a = 0;
				for (int i = 0; i < getId.length; i++) {
					if (tfID.getText().equals(getId[i])) {
						JOptionPane.showMessageDialog(SignUp.this, "같은 아이디가 있습니다.");
						a++;
						break;
					}
				}
				for (int i = 0; i < getPw.length; i++) {
					if (infs[1].length() < 4 || infs[1].length() > 12) {
						JOptionPane.showMessageDialog(SignUp.this, "비밀번호는 4자리 이상, 12자리 이하만 입력 가능합니다.");
						a++;
						break;
					} else if (checkPWDMethod(infs[1]) == 1) {
						JOptionPane.showMessageDialog(SignUp.this, "특수문자는 !@#만 포함 가능합니다.");
					}
//					else if(checkPWDMethod(infs[1])!= 1) {
//						JOptionPane.showMessageDialog(TSignUp.this, "특수문자 !@#를 입력하세요.");
//						break;
//					}
				}

				// 중복 있을시 실행 안되도록
				if (a == 1) {
				} else {
					if (infs[0].isEmpty()) {
						JOptionPane.showMessageDialog(SignUp.this, "아이디를 입력하세요");
					} else if (infs[1].isEmpty()) {
						JOptionPane.showMessageDialog(SignUp.this, "비밀번호를 입력하세요");
					} else if (!infs[1].equals(infs[2])) {
						JOptionPane.showMessageDialog(SignUp.this, "비밀번호가 일치하지 않습니다.");
					} else {
						JOptionPane.showMessageDialog(SignUp.this, "가입되었습니다.");
						io.save(infs[0], infs[1], infs[3]);
						tfID.setText("");
						pfPW.setText("");
						pfPH.setText("");
						tfPN.setText("");
						dispose();
					}
				}

			}
		});

		joinchk.addActionListener(new ActionListener() { // 중복버튼을 눌렀을때
			@Override
			public void actionPerformed(ActionEvent e) {
				int length = listInfor.size();
				String[] infs = new String[length];
				for (int i = 0; i < length; i++) {
					infs[i] = listInfor.get(i).getText();
				}
				// 중복 아이디만
				List<String> infor = new ArrayList<>();
				infor = io.load();
				String[] getInfor = new String[1];
				String[] getId = new String[infor.size()];

				for (int i = 0; i < infor.size(); i++) {
					getInfor = infor.get(i).split(",");
					getId[i] = getInfor[0];
				}

				int a = 0;
				for (int i = 0; i < getId.length; i++) {
					if (tfID.getText().equals(getId[i])) {
						JOptionPane.showMessageDialog(SignUp.this, "이미 등록되어 있는 아이디입니다.");
						joinchk.setEnabled(true);
						a++;
						break;
					}
				} // for문 끝

				for (int i = 0; i < getId.length; i++) {
					if (a == 1) {
					} else {
						if (infs[0].isEmpty()) {
							JOptionPane.showMessageDialog(SignUp.this, "아이디를 입력하세요.");
							break;
						} else if (checkIDMethod(infs[0]) == 1) {
							JOptionPane.showMessageDialog(SignUp.this, "아이디는 특수문자 포함이 불가합니다");
							break;
						} else if (infs[0].length() < 4 || infs[0].length() > 12) {
							JOptionPane.showMessageDialog(SignUp.this, "아이디는 4자리 이상 , 12자리 이하만 입력 가능합니다.");
							break;
						} else {
							JOptionPane.showMessageDialog(SignUp.this, "사용가능한 아이디 입니다.");
							joinchk.setEnabled(false);
							joinbtn.setEnabled(true);
							break;
						}
					}
				}
			}

		});

		joincel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		listInfor.add(tfID);
		listInfor.add(pfPW);
		listInfor.add(pfPH);
		listInfor.add(tfPN);

		mainpnl.add(pnlID);
		mainpnl.add(pnlPW);
		mainpnl.add(pnlPH);
		mainpnl.add(pnlPN);

		pnlID.add(joinchk);
		pnlPW.add(bk);
		pnlPH.add(bk1);
		pnlPN.add(bk2);

		joinpnl.add(joinbtn);
		joinpnl.add(joincel);
		joinbtn.setEnabled(false);

		add(title, BorderLayout.NORTH);
		add(mainpnl, BorderLayout.CENTER);
		add(joinpnl, BorderLayout.SOUTH);

		showGUI();

	}

	private void showGUI() {
		setModal(true);
		pack();
		setVisible(true);
		setLocation(650, 350);

//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
