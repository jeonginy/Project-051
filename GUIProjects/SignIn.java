import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class SignIn extends JDialog {
	Files file;
	public SignIn() {
		file = new Files();
		//메인 패널
		JPanel mainpnl = new JPanel();
		mainpnl.setLayout(new BoxLayout(mainpnl, BoxLayout.Y_AXIS));
		setModal(true);
		
		// 아이디
		JPanel idpnl = new JPanel();
		JLabel idlbl = new JLabel("ID");
		idlbl.setPreferredSize(new Dimension(100, 30));
		JTextField idtf = new JTextField(15);

		idpnl.add(idlbl);
		idpnl.add(idtf);

		// 비밀번호
		JPanel pwpnl = new JPanel();
		JLabel pwlbl = new JLabel("Password");
		pwlbl.setPreferredSize(new Dimension(100, 30));
		JPasswordField pwtf = new JPasswordField(15);

		pwpnl.add(pwlbl);
		pwpnl.add(pwtf);

		mainpnl.add(idpnl);
		mainpnl.add(pwpnl);

		// 로그인 버튼
		JPanel joinpnl = new JPanel();
		JButton joinbtn = new JButton("로그인");
		JButton btnchk = new JButton("취소");
		JButton btnID = new JButton("ID찾기");
		
		joinbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> infor = new ArrayList<>();
				infor = file.load();
				String[] getInfor = new String[2]; // 아이디 , 비밀번호값
				String[] getId = new String[infor.size()]; // id전부
				String[] getPw = new String[infor.size()]; // pw전부
				
				
				for (int i = 0; i < infor.size(); i++) {
					getInfor = infor.get(i).split(","); //아이디 비밀번호 하나씩
					getId[i] = getInfor[0]; // ID 넣기
					getPw[i] = getInfor[1]; // PW 넣기
				}
				
				int a = 0;
				for (int i = 0; i < getId.length; i++) {
					if(!idtf.getText().equals(getId[i])) {
						a++;
					}else {
						break;
					}
				}
				if(idtf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(SignIn.this, "아이디를 입력하세여");
				}else if(a == getId.length) {
					JOptionPane.showMessageDialog(SignIn.this, "아이디가 존재하지 않습니다.");
				}else if(!new String(pwtf.getPassword()).equals(getPw[a])) {
					JOptionPane.showMessageDialog(SignIn.this, "비밀번호가 틀렸습니다.");
				}else {
					if (idtf.getText().equals("Admin")) {
						Files f = new Files();
						if (!f.ADD_FOLDER.isEmpty()) {
							JOptionPane.showMessageDialog(joinpnl, "관리자님, 어서오세요 *⸌☻ັ⸍*");
							JOptionPane.showMessageDialog(joinpnl, "확인하실 요청사항이 있습니다.");
							dispose();
							Main.main.dispose();
							new AdminKinds(idtf.getText());
						}
					} else {
//						if()
						JOptionPane.showMessageDialog(joinpnl, idtf.getText() + " 님 오늘도 Alco-Holic ( ͡° ͜ʖ ͡° )");
//						JOptionPane.showMessageDialog(joinpnl, "요청하신 사항이 정상적으로 추가되었습니다.");
						dispose();
						Main.main.dispose();
						new UserKinds();
					}
					dispose();
				}
			}
		});
		
		btnchk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnID.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new IdSearch();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		mainpnl.add(idpnl);
		mainpnl.add(pwpnl);
		
		
		
		joinpnl.add(joinbtn);
		joinpnl.add(btnchk);
		joinpnl.add(btnID);
		
		add(mainpnl, "North");
		add(joinpnl, "South");
		
		showGUI();
		
	}
	private void showGUI() {
		pack();
		setLocation(650,350);
		setVisible(true);
	}

}
		
	
//		// 정보 판넬
//		JPanel mainpnl = new JPanel();
//		mainpnl.setLayout(new BoxLayout(mainpnl, BoxLayout.Y_AXIS));
//		setModal(true);
//		
//		// 아이디
//		JPanel idpnl = new JPanel();
//		JLabel idlbl = new JLabel("ID");
//		idlbl.setPreferredSize(new Dimension(100, 30));
//		JTextField idtf = new JTextField(15);
//
//		idpnl.add(idlbl);
//		idpnl.add(idtf);
//
//		// 비밀번호
//		JPanel pwpnl = new JPanel();
//		JLabel pwlbl = new JLabel("Password");
//		pwlbl.setPreferredSize(new Dimension(100, 30));
//		JPasswordField pwtf = new JPasswordField(15);
//
//		pwpnl.add(pwlbl);
//		pwpnl.add(pwtf);
//
//		mainpnl.add(idpnl);
//		mainpnl.add(pwpnl);
//
//		// 로그인 버튼
//		JPanel joinpnl = new JPanel();
//		JButton joinbtn = new JButton("Join");
//		joinbtn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				file = new Files();
//				// information.txt 안에 있는 아이디랑 비밀번호랑 비교해서 맞으면 로그인
//				List<String> list = new ArrayList<>();
//				list = file.load(); // 아이디랑 비밀번호 있음
//
//				String[] line = new String[2];
//				String[] getID = new String[list.size()];
//				String[] getPw = new String[list.size()];
//
//				for (int i = 0; i < list.size(); i++) {
//					line = list.get(i).split(",");
//					getID[i] = line[0];
//					getPw[i] = line[1];
//				}
//
//////				아이디와 비밀번호가 같을 때가지 반복
////				while (idtf.getText().equals(getID) && pwtf.getText().equals(getPw)) {
////					for (int i = 0; i < getID.length; i++) {
////						for (int j = 0; j < getPw.length; j++) {
////							if (idtf.getText().equals(getID[i])) {
////								break;
////							} else if (!idtf.getText().equals(getID[i])) {
////								JOptionPane.showMessageDialog(joinpnl, "아이디가 틀렸습니다.");
////								break;
////							} else if (!pwtf.getText().equals(getPw[j]))
////								JOptionPane.showMessageDialog(joinpnl, "비밀번호가 틀렸습니다.");
////							break;
////						}
////						break;
////					}
//				if (idtf.getText().equals("Admin")) {
//					Files f = new Files();
//					if (!f.ADD_FOLDER.isEmpty()) {
//						JOptionPane.showMessageDialog(joinpnl, "관리자님, 어서오세요 *⸌☻ັ⸍*");
//						JOptionPane.showMessageDialog(joinpnl, "확인하실 요청사항이 있습니다.");
//						dispose();
//						Main.main.dispose();
//						new AdminKinds(idtf.getText());
//					}
//				} else {
////					if()
//					JOptionPane.showMessageDialog(joinpnl, idtf.getText() + " 님 오늘도 Alco-Holic ( ͡° ͜ʖ ͡° )");
////					JOptionPane.showMessageDialog(joinpnl, "요청하신 사항이 정상적으로 추가되었습니다.");
//					dispose();
//					Main.main.dispose();
//					new UserKinds();
//				}
//			}
////			}
//		});
//
//		joinpnl.add(joinbtn);
//
//		add(mainpnl, "North");
//		add(joinpnl, "South");
//
//		showGUI();
//
//	}
//
//	private void showGUI() {
//		pack();
//		setLocation(650, 350);
////		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//	}
//}
